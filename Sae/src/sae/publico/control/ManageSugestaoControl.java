package sae.publico.control;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.SessionService;
import sae.core.domain.CursoRealizado;
import sae.publico.application.ManageSugestaoService;
import sae.publico.domain.Sugestao;
import sae.publico.domain.Titulo_Escolaridade;

@Named
@SessionScoped
public class ManageSugestaoControl extends CrudController<Sugestao> {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageSugestaoService  manageSugestaoService ;
	
	@EJB
	private SessionService sessionService;
	
	
	
	/*   CONSTRUTOR DA CLASSE */
	public ManageSugestaoControl(){
		 viewPath = "/public/manageSugestao/";
	     bundleName = "msgs";
	}
	
	
	
	public List<CursoRealizado> getCursoRealizado() {
		return sessionService.getCursoRealizado();
	}
	
	
	
	
	
	@Override
	protected CrudService<Sugestao> getCrudService() {
		return manageSugestaoService;
	}

	@Override
	protected Sugestao createNewEntity() {
		Sugestao sugestao = new Sugestao();
		sugestao.setData_envio(new Date());
		sugestao.setAutor(sessionService.getEgresso());
		return sugestao;
	}

	@Override
	protected void initFilters() {	}

}
