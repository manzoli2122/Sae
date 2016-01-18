package sae.core.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.convert.Converter;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.LikeFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.ManageAssunto_InteresseSevice;
import sae.core.domain.Assunto_Interesse;

@Named
@SessionScoped
public class ManageAssunto_InteresseControl extends CrudController<Assunto_Interesse>{

	
	private static final long serialVersionUID = 1L;

	@EJB
	private ManageAssunto_InteresseSevice manageAssunto_InteresseService;
	
	
	/*   CONSTRUTOR DA CLASSE */
	public ManageAssunto_InteresseControl(){
		 viewPath = "/core/manageAssunto_Interesse/";
	     bundleName = "msgs";
	}
	
	
	@Override
	protected CrudService<Assunto_Interesse> getCrudService() {
		return manageAssunto_InteresseService;
	}

	@Override
	protected Assunto_Interesse createNewEntity() {
		return new Assunto_Interesse();
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageAssunto_Interesse.filter.byName", "nome", getI18nMessage(bundleName, "manageAssunto_Interesse.text.filter.byName")));
	}
	
	
	
	public Converter getAssuntoConverter() {
		return manageAssunto_InteresseService.getAssuntoConverter();
	}
	

}
