package sae.publico.control;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import br.ufes.inf.nemo.util.ejb3.controller.PrimefacesLazyEntityDataModel;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** Primefaces lazy data model for use with a lazy p:dataTable component. */
	private LazyDataModel<Depoimento> pedentesEntities;
	
	/**
	 * Getter for lazyEntities.
	 * 
	 * @return Primefaces lazy data model for use with a lazy p:dataTable component.
	 */
	public LazyDataModel<Depoimento> getPedentesEntities() {
		if (pedentesEntities == null) {
			count();
			pedentesEntities = new PrimefacesLazyEntityDataModel<Depoimento>(getListingService().getDAO()) {
				/** Serialization id. */
				private static final long serialVersionUID = 1117380513193004406L;

				@Override
				public List<Depoimento> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
					firstEntityIndex = first;
					lastEntityIndex = first + pageSize;
					retrievepedentesEntities() ;
					return entities;
				}
			};
			pedentesEntities.setRowCount((int) entityCount);
		}
		return pedentesEntities;
	}
	
	
	
	protected void retrievepedentesEntities() {		
		if (lastEntityIndex > entityCount) lastEntityIndex = (int) entityCount;
		entities = manageDepoimentoService.retrieveAllAnalisar();
		lastEntityIndex = firstEntityIndex + entities.size();		
	}
	
	
	public String analisarDepoimento(){	
		selectedEntity = null;
		count();
		retrievepedentesEntities();
		return "/core/manageDepoimento/" + "list.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	
	
	public String retrieveAnalisar() {
		logger.log(Level.INFO, "Displaying form for entity retrieval");

		// Sets the data as read-only.
		readOnly = true;

		// Retrieves the existing entity that was selected, if not already done by the JSF component.
		if (selectedEntity == null) return null;
		else {
			// Asks the CRUD service to fetch any lazy collection that possibly exists.
			selectedEntity = getCrudService().fetchLazy(selectedEntity);
			checkSelectedEntity();
		}

		// Goes to the form.
		return "/core/manageDepoimento/"  + "form.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	
	
	public String aprovar(){
		selectedEntity.setStatus(StatusDepoimento.A);	
		save();
		
		return analisarDepoimento();
	}

	public String desaprovar(){
		selectedEntity.setStatus(StatusDepoimento.D);
		save();
		return analisarDepoimento();
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
