package sae.publico.control;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.publico.application.ManageDepoimentoService;
import sae.publico.domain.Depoimento;
import sae.publico.domain.StatusDepoimento;



/**
 * Controller class responsible for mediating the communication between user interface and application service for the
 * use case "Manage Depoimento".
 * 
 * This use case is a CRUD and, thus, the controller also uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Named
@SessionScoped
public class ManageDepoimentoControl extends CrudController<Depoimento>{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(ManageDepoimentoControl.class.getCanonicalName());
	
	
	/** The "Manage Depoimento" service. */
	@EJB
	private ManageDepoimentoService  manageDepoimentoService ;
	
	
	
	
	
	
	/**   CONSTRUTOR DA CLASSE */
	public ManageDepoimentoControl(){
		 viewPath = "/public/manageDepoimento/";
	     bundleName = "msgs";
	}
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#getCrudService() */
	@Override
	protected CrudService<Depoimento> getCrudService() {
		return manageDepoimentoService;
	}

	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#createNewEntity() */
	@Override
	protected Depoimento createNewEntity() {
		logger.log(Level.FINER, "INITIALIZING AN EMPTY Depoimento ......");
		Depoimento depoimento = new Depoimento();
		depoimento.setData_envio(new Date());
		depoimento.setAnonimo(false);
		depoimento.setStatus(StatusDepoimento.P);
		return depoimento;
	}

	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#initFilters() */
	@Override
	protected void initFilters() {
	}

	
	
	
	@Override
	protected void retrieveEntities() {		
		if (lastEntityIndex > entityCount) lastEntityIndex = (int) entityCount;
		entities = manageDepoimentoService.retrieveAllMine();
		lastEntityIndex = firstEntityIndex + entities.size();		
	}
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#delete() */
	@Override
	public String delete() {
		try{
			return super.delete();
		}
		catch(Exception e){
			return getViewPath() + "error.xhtml?faces-redirect=" + getFacesRedirect();
		}
	}
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#save() */
	@Override
	public String save() {
		try{
			return super.save();
		}
		catch(Exception e){
			return getViewPath() + "error.xhtml?faces-redirect=" + getFacesRedirect();
		}
	}
	
	
}
