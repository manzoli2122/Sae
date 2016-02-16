package sae.publico.control;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.publico.application.ManageHistoricoService;
import sae.publico.domain.Historico_Egresso;



/**
 * Controller class responsible for mediating the communication between user interface and application service for the
 * use case "Manage Historico".
 * 
 * This use case is a CRUD and, thus, the controller also uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Named
@SessionScoped
public class ManageHistoricoControl  extends CrudController<Historico_Egresso>{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(ManageHistoricoControl.class.getCanonicalName());
	
	
	/** The "Manage Historico" service. */
	@EJB
	private ManageHistoricoService  manageHistoricoService ;
	
	
	
	
	
	
	/**   CONSTRUTOR DA CLASSE */
	public ManageHistoricoControl(){
		 viewPath = "/public/manageHistorico/";
	     bundleName = "msgs";
	}
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#getCrudService() */
	@Override
	protected CrudService<Historico_Egresso> getCrudService() {
		return manageHistoricoService;
	}

	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#createNewEntity() */
	@Override
	protected Historico_Egresso createNewEntity() {
		logger.log(Level.FINER, "INITIALIZING AN EMPTY Historico_Egresso ......");
		Historico_Egresso historico = new Historico_Egresso();
		historico.setData_envio(new Date());
		historico.setAtua_na_area(true);
		return historico;
	}

	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#initFilters() */
	@Override
	protected void initFilters() {	
	}
	
	
	
	@Override
	protected void retrieveEntities() {		
		if (lastEntityIndex > entityCount) lastEntityIndex = (int) entityCount;
		entities = manageHistoricoService.retrieveAllMine();
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
