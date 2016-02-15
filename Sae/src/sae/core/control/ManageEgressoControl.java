package sae.core.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import br.ufes.inf.nemo.util.ejb3.application.CrudException;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.CrudValidationError;
import br.ufes.inf.nemo.util.ejb3.application.filters.LikeFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.ManageEgressoService;
import sae.core.domain.Egresso;


/**
 * Controller class responsible for mediating the communication between user interface and application service for the
 * use case "Manage Egresso".
 * 
 * This use case is a CRUD and, thus, the controller also uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Named
@SessionScoped
public class ManageEgressoControl extends CrudController<Egresso>{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(CrudController.class.getCanonicalName());

	@Inject
	private ManageCursoRealizadoControl manageCursoRealizadoControl;
	
	
	/** The "Manage Egresso" service. */
	@EJB
	private ManageEgressoService manageEgressoService;
	

	
	
	
	

	
	/*   CONSTRUTOR DA CLASSE */
	public ManageEgressoControl(){
		 viewPath = "/core/manageEgresso/";
	     bundleName = "msgs";
	}
	
	
	@Override
	protected CrudService<Egresso> getCrudService() {
		return manageEgressoService;
	}

	@Override
	protected Egresso createNewEntity() {
		Egresso egresso = new Egresso();
		egresso.setSenha("teste");
		return egresso;
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageEgresso.filter.byName", "nome", getI18nMessage(bundleName, "manageEgresso.text.filter.byName")));
	}
	
	
	
	@Override
	public String save() {
		
		try {
			logger.log(Level.INFO, "Saving entity...");
			prepEntity();
			// Checks if we want to create or update the entity. Validates the operation first and stops in case of errors.
			try {
				//salva e continua o egresso selecionado para cadastrar cursos realizado
				if (selectedEntity.getId() == null) {
					getCrudService().validateCreate(selectedEntity);
					getCrudService().create(selectedEntity);
					addGlobalI18nMessage(getBundleName(), FacesMessage.SEVERITY_INFO, getBundlePrefix() + ".text.createSucceeded", summarizeSelectedEntity());
					Egresso egresso = selectedEntity;
					list();
					selectedEntity = egresso;
					return manageCursoRealizadoControl.create();
				
				}
				
				else {
					getCrudService().validateUpdate(selectedEntity);
					getCrudService().update(selectedEntity);
					addGlobalI18nMessage(getBundleName(), FacesMessage.SEVERITY_INFO, getBundlePrefix() + ".text.updateSucceeded", summarizeSelectedEntity());
					return list();
				}
			}
			
			catch (CrudException crudException) {
				// Adds an error message to each validation error included in the exception.
				for (CrudValidationError error : crudException) {
					logger.log(Level.WARNING, "Exception while saving " + selectedEntity, crudException.getMessage());

					// Checks if the field name was specified. If it was, attach the message to the form field.
					if (error.getFieldName() != null) addFieldI18nMessage(getFieldName(error.getFieldName()), getBundleName(), FacesMessage.SEVERITY_ERROR, error.getMessageKey(), error.getMessageParams());
					else addGlobalI18nMessage(getBundleName(), FacesMessage.SEVERITY_ERROR, error.getMessageKey(), error.getMessageParams());
				}

				// Goes back to the same page, i.e., the form.
				logger.log(Level.INFO, "CRUD EXCEPCIOMN");
				throw new Exception();
			}
			
		} catch (Exception e) {
			logger.log(Level.INFO, "EXCEPCIOMN");
			return getViewPath() + "error.xhtml?faces-redirect=" + getFacesRedirect();
		}
		
	}
	
	
	@Override
	public String delete() {
		try{
			return super.delete();	
		}
		catch(Exception e){
			return getViewPath() + "error.xhtml?faces-redirect=" + getFacesRedirect();
		}
	}
	
	
}
