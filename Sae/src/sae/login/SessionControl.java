package sae.login;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import br.ufes.inf.nemo.util.ejb3.controller.JSFController;
import sae.core.domain.Administrador;
import sae.core.domain.CursoRealizado;
import sae.core.domain.Egresso;



/**
 * Session-scoped managed bean that provides to web pages the login service, indication if the user is logged in.
 * 
 * @author  Bruno Manzoli (manzoli2122@gmail.com)
 */
@Named
@SessionScoped
public class SessionControl extends JSFController{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** Information on the current visitor. */
	@EJB
	private SessionService sessionService;

	
	private String senha;
	
	
	
	
	
	
	
	
	
	
	
	public String formAtualizarSenha() { 
		return "/atualizarSenha.xhtml?faces-redirect=true"; 
	}
	
	
	
	
	public String atualizarSenha() { 
		sessionService.atualizarSenha(senha);
		return "/index.xhtml?faces-redirect=true"; 
	}
	
	
	
	
	
	public List<CursoRealizado> getCursoRealizado() {
		return sessionService.getCursoRealizado();
	}
	
	public boolean isPasswordDefault(){
		return sessionService.isPasswordDefault();
	}
	
	public String getDecorator() { return sessionService.getDecorator(); }
	
	
	
	
	/**
	 * Indicates if the user has already been identified.
	 * 
	 * @return <code>true</code> if the user is logged in, <code>false</code> otherwise.
	 */
	public boolean isLoggedIn() { return sessionService.isLoggedIn();}
	
	
	
	
	/**
	 * Provides the current authenticated user.
	 * 
	 * @return The Administrador object that represents the user that has been authenticated in this session.
	 */
	public Administrador getAdmin(){ return sessionService.getAdmin(); }
	
	
	
	
	/**
	 * Provides the current authenticated user.
	 * 
	 * @return The Egresso object that represents the user that has been authenticated in this session.
	 */
	public Egresso getEgresso(){ return sessionService.getEgresso(); }
	
	
	
	
	
	
	public String logout(){
		sessionService.logout();
		return "login.faces?faces-redirect=true";
	}




	public String getSenha() { 	return senha; }
	public void setSenha(String senha) { this.senha = senha; }
	

	
}
