package sae.core.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.convert.Converter;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.LikeFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;
import sae.core.application.ManageCursoService;
import sae.core.domain.Curso;

@Named
@SessionScoped
public class ManageCursoControl extends CrudController<Curso> {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageCursoService manageCursoService;

	
	
	public Converter getCursoConverter() {
		return manageCursoService.getCursoConverter();
	}
	
	/*   CONSTRUTOR DA CLASSE */
	public ManageCursoControl(){
		 viewPath = "/core/manageCurso/";
	     bundleName = "msgs";
	}
	
	@Override
	protected CrudService<Curso> getCrudService() {
		return manageCursoService;
	}

	@Override
	protected Curso createNewEntity() {
		return new Curso();
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageCurso.filter.byName", "nome", getI18nMessage(bundleName, "manageCurso.text.filter.byName")));
	}

}
