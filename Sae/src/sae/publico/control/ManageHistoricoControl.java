package sae.publico.control;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.SessionService;
import sae.publico.application.ManageHistoricoService;
import sae.publico.domain.Area_Atuacao;
import sae.publico.domain.Faixa_Salarial;
import sae.publico.domain.Historico_Egresso;

@Named
@SessionScoped
public class ManageHistoricoControl  extends CrudController<Historico_Egresso>{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageHistoricoService  manageHistoricoService ;
	
	
	@EJB
	private SessionService sessionService;
	
	
	
	/*   CONSTRUTOR DA CLASSE */
	public ManageHistoricoControl(){
		 viewPath = "/public/manageHistorico/";
	     bundleName = "msgs";
	}
	
	public Faixa_Salarial[] getFaixa_Salarial() {
		return Faixa_Salarial.values();
	}
	
	public Area_Atuacao[] getArea_Atuacao() {
		return Area_Atuacao.values();
	}
	
	
	@Override
	protected CrudService<Historico_Egresso> getCrudService() {
		return manageHistoricoService;
	}

	@Override
	protected Historico_Egresso createNewEntity() {
		Historico_Egresso historico = new Historico_Egresso();
		historico.setData_envio(new Date());
		historico.setEgresso(sessionService.getEgresso());
		historico.setAtua_na_area(true);
		return historico;
	}

	@Override
	protected void initFilters() {
		
	}

}
