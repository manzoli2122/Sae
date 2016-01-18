package sae.core.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import sae.core.application.ManageCursoRealizadoService;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.domain.CursoRealizado;

@Named
@SessionScoped
public class ManageCursoRealizadoControl extends CrudController<CursoRealizado> {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageCursoRealizadoService manageCursoRealizadoService;

	
	
	/*   CONSTRUTOR DA CLASSE */
	public ManageCursoRealizadoControl(){
		 viewPath = "/core/manageCursoRealizado/";
	     bundleName = "msgs";
	}
	
	@Override
	protected CrudService<CursoRealizado> getCrudService() {
		return manageCursoRealizadoService;
	}

	@Override
	protected CursoRealizado createNewEntity() {
		return new CursoRealizado();
	}

	@Override
	protected void initFilters() {
		
	}

}
