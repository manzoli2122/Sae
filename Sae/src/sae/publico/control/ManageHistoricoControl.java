package sae.publico.control;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.publico.application.ManageHistoricoService;
import sae.publico.domain.HistoricoEgresso;



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
public class ManageHistoricoControl  extends CrudController<HistoricoEgresso>{

	
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
	protected CrudService<HistoricoEgresso> getCrudService() {
		return manageHistoricoService;
	}

	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#createNewEntity() */
	@Override
	protected HistoricoEgresso createNewEntity() {
		logger.log(Level.FINER, "INITIALIZING AN EMPTY Historico_Egresso ......");
		HistoricoEgresso historico = new HistoricoEgresso();
		historico.setData_envio(new Date());
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
			logger.log(Level.INFO, "ERRO AO SALVAR    Historico_Egresso ......");
			addGlobalI18nMessage(getBundleName(), FacesMessage.SEVERITY_ERROR, getBundlePrefix() + ".error.save" , summarizeSelectedEntity()  );
			return null;
		}
	}
	
	
	
	public boolean isAlteravel(){
		
		return manageHistoricoService.isAlteravel(selectedEntity);
		
	}
	
	
}
