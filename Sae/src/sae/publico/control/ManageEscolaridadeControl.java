package sae.publico.control;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.publico.application.ManageEscolaridadeService;
import sae.publico.domain.Escolaridade;



/**
 * Controller class responsible for mediating the communication between user interface and application service for the
 * use case "Manage Escolaridade".
 * 
 * This use case is a CRUD and, thus, the controller also uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Named
@SessionScoped
public class ManageEscolaridadeControl extends CrudController<Escolaridade>{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(ManageEscolaridadeControl.class.getCanonicalName());
	
	
	/** The "Manage Escolaridade" service. */
	@EJB
	private ManageEscolaridadeService  manageEscolaridadeService ;
	
	
	
	
	
	
	/**   CONSTRUTOR DA CLASSE */
	public ManageEscolaridadeControl(){
		 viewPath = "/public/egresso/manageEscolaridade/";
	     bundleName = "msgs";
	}
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#getCrudService() */
	@Override
	protected CrudService<Escolaridade> getCrudService() {
		manageEscolaridadeService.authorize();
		return manageEscolaridadeService;
	}

	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#createNewEntity() */
	@Override
	protected Escolaridade createNewEntity() {
		logger.log(Level.FINER, "INITIALIZING AN EMPTY Depoimento ......");
		return new Escolaridade();
	}

	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#initFilters() */
	@Override
	protected void initFilters() {	
	}

	
		
	@Override
	protected void retrieveEntities() {		
		if (lastEntityIndex > entityCount) lastEntityIndex = (int) entityCount;
		entities = manageEscolaridadeService.retrieveAllMine();
		lastEntityIndex = firstEntityIndex + entities.size();		
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
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#save() */
	@Override
	public String save() {
		try{
			return super.save();
		}
		catch(Exception e){
			addGlobalI18nMessage(getBundleName(), FacesMessage.SEVERITY_ERROR, getBundlePrefix() + ".error.save", summarizeSelectedEntity());
			return null;
		}
	}
	
		
}
