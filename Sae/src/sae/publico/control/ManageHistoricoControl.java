package sae.publico.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.publico.application.ManageHistoricoService;
import sae.publico.domain.Historico_Egresso;

@Named
@SessionScoped
public class ManageHistoricoControl  extends CrudController<Historico_Egresso>{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageHistoricoService  manageHistoricoService ;
	
	
	
	@Override
	protected CrudService<Historico_Egresso> getCrudService() {
		return manageHistoricoService;
	}

	@Override
	protected Historico_Egresso createNewEntity() {
		return new Historico_Egresso();
	}

	@Override
	protected void initFilters() {
		
	}

}
