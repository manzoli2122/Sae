package sae.core.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.convert.Converter;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.LikeFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.ManageAdministradorService;
import sae.core.domain.Administrador;


@Named
@SessionScoped
public class ManageAdministradorControl extends CrudController<Administrador>{

	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageAdministradorService manageAdministradorService;

	
	
	/*   CONSTRUTOR DA CLASSE */
	public ManageAdministradorControl(){
		 viewPath = "/core/manageAdministrador/";
	     bundleName = "msgs";
	}
	
	
	
	@Override
	protected CrudService<Administrador> getCrudService() {
		manageAdministradorService.authorize();
		return manageAdministradorService;
	}

	@Override
	protected Administrador createNewEntity() {
		Administrador newEntity = new Administrador();
		return newEntity;
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageAdministrador.filter.byName", "nome", getI18nMessage(bundleName, "manageAdministrador.text.filter.byName")));
	}

	public Converter getAdministradorConverter() {
		return manageAdministradorService.getAdministradorConverter();
	}
}
