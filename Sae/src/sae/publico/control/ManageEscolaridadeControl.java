package sae.publico.control;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.publico.application.ManageEscolaridadeService;
import sae.publico.domain.Escolaridade;
import sae.publico.domain.Titulo_Escolaridade;

@Named
@SessionScoped
public class ManageEscolaridadeControl extends CrudController<Escolaridade>{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageEscolaridadeService  manageEscolaridadeService ;
	
	
	
	
	/*   CONSTRUTOR DA CLASSE */
	public ManageEscolaridadeControl(){
		 viewPath = "/public/manageEscolaridade/";
	     bundleName = "msgs";
	}
	
	@Override
	protected CrudService<Escolaridade> getCrudService() {
		return manageEscolaridadeService;
	}

	@Override
	protected Escolaridade createNewEntity() {
		return new Escolaridade();
	}

	@Override
	protected void initFilters() {
		
	}

	
	public Titulo_Escolaridade[] getTitulo_Escolaridade() {
		return Titulo_Escolaridade.values();
	}
	
		
	@Override
	protected void retrieveEntities() {
		
		if (lastEntityIndex > entityCount) lastEntityIndex = (int) entityCount;
		
		entities = manageEscolaridadeService.retrieveAllMine();
		
		lastEntityIndex = firstEntityIndex + entities.size();
				
		
	}
	
	
	
	
	
}
