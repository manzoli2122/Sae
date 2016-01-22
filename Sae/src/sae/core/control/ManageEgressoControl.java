package sae.core.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.LikeFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.ManageEgressoService;
import sae.core.domain.Egresso;

@Named
@SessionScoped
public class ManageEgressoControl extends CrudController<Egresso>{

	
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private ManageEgressoService manageEgressoService;

	
	/*   CONSTRUTOR DA CLASSE */
	public ManageEgressoControl(){
		 viewPath = "/core/manageEgresso/";
	     bundleName = "msgs";
	}
	
	
	
	@Override
	protected CrudService<Egresso> getCrudService() {
		return manageEgressoService;
	}

	@Override
	protected Egresso createNewEntity() {
		Egresso egresso = new Egresso();
		egresso.setSenha("teste");
		return egresso;
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageEgresso.filter.byName", "nome", getI18nMessage(bundleName, "manageEgresso.text.filter.byName")));
	}
	
	
	
	@Override
	public String save() {
		try {
			return super.save();
		} catch (Exception e) {
			return getViewPath() + "error.xhtml?faces-redirect=" + getFacesRedirect();
		}
		
	}
	
	
	
	
	
	
	

}
