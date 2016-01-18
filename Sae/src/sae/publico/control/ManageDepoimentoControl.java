package sae.publico.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.publico.application.ManageDepoimentoService;
import sae.publico.domain.Depoimento;

@Named
@SessionScoped
public class ManageDepoimentoControl extends CrudController<Depoimento>{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageDepoimentoService  manageDepoimentoService ;
	
	
	@Override
	protected CrudService<Depoimento> getCrudService() {
		return manageDepoimentoService;
	}

	@Override
	protected Depoimento createNewEntity() {
		return new Depoimento();
	}

	@Override
	protected void initFilters() {
		
	}

}
