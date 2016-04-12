package sae.publico.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import sae.core.domain.Curso;
import sae.publico.application.ConsultaDepoimentoService;
import sae.publico.domain.Depoimento;

@Named
@SessionScoped
public class ConsultaDepoimentoControl implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Curso curso;
	
	protected String viewPath;
	
	protected String bundleName;
	
	@EJB 
	private ConsultaDepoimentoService consultaDepoimentoService;
	
	
	
	/*   CONSTRUTOR DA CLASSE */
	public ConsultaDepoimentoControl(){
		 viewPath = "/public/consulta/depoimento/";
	     bundleName = "msgs";
	}
	
	
	public boolean getFacesRedirect() { return true; }
	public String getViewPath() {return viewPath;	}
	
	
	
	public String depoimento(){
		return getViewPath()  + "index.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	public String visualizarDepoimentos(){
		return getViewPath()  + "depoimentos.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	
	
	public Curso getCurso() { return curso; }
	public void setCurso(Curso curso) { this.curso = curso; }
	
	
	
	public List<Depoimento> getDepoimentos(){
		return consultaDepoimentoService.getDepoimentos(curso);
	}
	
}
