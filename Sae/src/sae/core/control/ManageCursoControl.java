package sae.core.control;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.LikeFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.ManageCursoService;
import sae.core.domain.Curso;


/**
 * Controller class responsible for mediating the communication between user interface and application service for the
 * use case "Manage Curso".
 * 
 * This use case is a CRUD and, thus, the controller also uses the mini CRUD framework for EJB3.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 */
@Named
@SessionScoped
public class ManageCursoControl extends CrudController<Curso> {

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(ManageCursoControl.class.getCanonicalName());
	
	
	/** The "Manage Curso" service. */
	@EJB
	private ManageCursoService manageCursoService;

	
	
	
	
	
	/**   CONSTRUTOR DA CLASSE */
	public ManageCursoControl(){
		 viewPath = "/core/manageCurso/";
	     bundleName = "msgs";
	}
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#getCrudService() */
	@Override
	protected CrudService<Curso> getCrudService() {
		manageCursoService.authorize();
		return manageCursoService;
	}

	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#createNewEntity() */
	@Override
	protected Curso createNewEntity() {
		logger.log(Level.FINER, "INITIALIZING AN EMPTY CURSO ......");
		return new Curso();
	}

	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.controller.CrudController#initFilters() */
	@Override
	protected void initFilters() {
		//logger.log(Level.FINER, "INITIALIZING FILTER TYPES ......");
		//addFilter(new LikeFilter("manageCurso.filter.byName", "nome", getI18nMessage(bundleName, "manageCurso.text.filter.byName")));
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

}