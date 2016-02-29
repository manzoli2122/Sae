package sae.core.control;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import br.ufes.inf.nemo.util.ejb3.application.CrudException;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.LikeFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.ManageAdministradorService;
import sae.core.domain.Administrador;

/**
 * Controller class responsible for mediating the communication between user interface and application service for the
 * use case "Manage Administrador".
 * 
 * This use case is a CRUD and, thus, the controller also uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Named
@SessionScoped
public class ManageAdministradorControl extends CrudController<Administrador>{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(ManageAdministradorControl.class.getCanonicalName());
	
	
	/** The "Manage Administrador" service. */
	@EJB
	private ManageAdministradorService manageAdministradorService;

	
	
	
	
	
	
	/**   CONSTRUTOR DA CLASSE  */
	public ManageAdministradorControl(){
		 viewPath = "/core/manageAdministrador/";
	     bundleName = "msgs";
	}
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#getCrudService() */
	@Override
	protected CrudService<Administrador> getCrudService() {
		manageAdministradorService.authorize();
		return manageAdministradorService;
	}
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#createNewEntity() */
	@Override
	protected Administrador createNewEntity() {
		logger.log(Level.FINER, "INITIALIZING AN EMPTY ADMINISTRADOR ......");
		Administrador newEntity = new Administrador();
		return newEntity;
	}

	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#initFilters() */
	@Override
	protected void initFilters() {
		logger.log(Level.FINER, "INITIALIZING FILTER TYPES ......");
		addFilter(new LikeFilter("manageAdministrador.filter.byName", "nome", getI18nMessage(bundleName, "manageAdministrador.text.filter.byName")));
	}

	
		
	/**  
	 * Saves (create or update) the entity based on the data sent from the form.
	 * Send email in the case create
	 * 
	 * @return The view path of the listing if no problems occurred. Otherwise, return error page.
	 */
	@Override
	public String save() {
		
		try {
			logger.log(Level.INFO, "Saving entity...");
			// Prepare the entity for saving.
			prepEntity();

			// Checks if we want to create or update the entity. Validates the operation first and stops in case of errors.
			try {
				// if create send email cadastro
				if (selectedEntity.getId() == null) {
					getCrudService().validateCreate(selectedEntity);
					getCrudService().create(selectedEntity);
					manageAdministradorService.sendEmailCadastro(selectedEntity);
					return list();
				}
				else {
					getCrudService().validateUpdate(selectedEntity);
					getCrudService().update(selectedEntity);
					return list();
				}
			}
			
			catch (CrudException crudException) {
				logger.log(Level.INFO, "CRUD EXCEPCIOMN");
				throw new Exception();
			}
			
		} catch (Exception e) {
			logger.log(Level.INFO, "EXCEPCION");
			selectedEntity.setId(null);
			addGlobalI18nMessage(getBundleName(), FacesMessage.SEVERITY_ERROR, getBundlePrefix() + ".error.save" , summarizeSelectedEntity()  );
			return null;
		}
	}
	

	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#delete() */
	@Override
	public String delete() {
		try{
			return super.delete();
		}
		catch(Exception e){
			addGlobalI18nMessage(getBundleName(), FacesMessage.SEVERITY_ERROR, getBundlePrefix() + ".error.delete", summarizeSelectedEntity());
			cancelDeletion();
			return null;
		}
	}
		
}