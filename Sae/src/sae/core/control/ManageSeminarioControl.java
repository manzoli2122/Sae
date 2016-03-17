package sae.core.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.ManageSeminarioService;
import sae.core.domain.Seminario;

@Named
@SessionScoped
public class ManageSeminarioControl extends CrudController<Seminario>{

private static final long serialVersionUID = 1L;
	
	
	@EJB
	private ManageSeminarioService manageSeminarioService;

	/*   CONSTRUTOR DA CLASSE */
	public ManageSeminarioControl(){
		 viewPath = "/core/manageSeminario/";
	     bundleName = "msgs";
	}

	
	@Override
	protected CrudService<Seminario> getCrudService() {
		manageSeminarioService.authorize();
		return manageSeminarioService;
	}


	@Override
	protected Seminario createNewEntity() {
		return new Seminario();
	}


	@Override
	protected void initFilters() {
		
	}
}
