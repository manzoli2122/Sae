package sae.publico.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.publico.application.ManageSugestaoService;
import sae.publico.domain.Sugestao;

@Named
@SessionScoped
public class ManageSugestaoControl extends CrudController<Sugestao> {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageSugestaoService  manageSugestaoService ;
	
	
	/*   CONSTRUTOR DA CLASSE */
	public ManageSugestaoControl(){
		 viewPath = "/public/manageSugestao/";
	     bundleName = "msgs";
	}
	
	
	
	@Override
	protected CrudService<Sugestao> getCrudService() {
		return manageSugestaoService;
	}

	@Override
	protected Sugestao createNewEntity() {
		return new Sugestao();
	}

	@Override
	protected void initFilters() {
		
	}

}
