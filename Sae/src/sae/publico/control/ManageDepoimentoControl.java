package sae.publico.control;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.SessionService;
import sae.publico.application.ManageDepoimentoService;
import sae.publico.domain.Depoimento;

@Named
@SessionScoped
public class ManageDepoimentoControl extends CrudController<Depoimento>{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageDepoimentoService  manageDepoimentoService ;
	
	@EJB
	private SessionService sessionService;
	
	
	/*   CONSTRUTOR DA CLASSE */
	public ManageDepoimentoControl(){
		 viewPath = "/public/manageDepoimento/";
	     bundleName = "msgs";
	}
	
	@Override
	protected CrudService<Depoimento> getCrudService() {
		return manageDepoimentoService;
	}

	@Override
	protected Depoimento createNewEntity() {
		Depoimento depoimento = new Depoimento();
		depoimento.setData_envio(new Date());
		depoimento.setAutor(sessionService.getEgresso());
		depoimento.setAnonimo(false);
		return depoimento;
	}

	@Override
	protected void initFilters() {
		
	}

}
