package sae.core.control;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sae.core.application.ManageCursoRealizadoService;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.domain.CursoRealizado;


/**
 * Controller class responsible for mediating the communication between user interface and application service for the
 * use case "Manage CursoRealizado".
 * 
 * This use case is a CRUD and, thus, the controller also uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Named
@SessionScoped
public class ManageCursoRealizadoControl extends CrudController<CursoRealizado> {

		
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(ManageCursoRealizadoControl.class.getCanonicalName());
	
	
	/** The "Manage CursoRealizado" service. */
	@EJB
	private ManageCursoRealizadoService manageCursoRealizadoService;

	
	/** The controller de Egresso for get selected egresso*/ 
	@Inject
	private ManageEgressoControl manageEgressoControl;
	
	
	
	
	
	
	
	/*   CONSTRUTOR DA CLASSE */
	public ManageCursoRealizadoControl(){
		 viewPath = "/core/manageCursoRealizado/";
	     bundleName = "msgs";
	}
	
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#getCrudService() */
	@Override
	protected CrudService<CursoRealizado> getCrudService() {
		manageCursoRealizadoService.authorize();
		return manageCursoRealizadoService;
	}

	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#createNewEntity() */
	@Override
	protected CursoRealizado createNewEntity() {
		logger.log(Level.FINER, "INITIALIZING AN EMPTY CURSOREALIZADO ......");
		return new CursoRealizado();
	}
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#initFilters() */
	@Override
	protected void initFilters() {
	}
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#create() */
	@Override
	public String create() {
		readOnly = false;
		selectedEntity = createNewEntity();
		if (manageEgressoControl.getSelectedEntity()!=null){
			selectedEntity.setEgresso(manageEgressoControl.getSelectedEntity());
		}
		return manageEgressoControl.getViewPath() + "form.xhtml?faces-redirect=" + getFacesRedirect();
	}

}
