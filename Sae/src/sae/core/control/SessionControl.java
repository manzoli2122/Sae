package sae.core.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.util.ejb3.controller.JSFController;
import sae.core.application.SessionService;
import sae.core.domain.Administrador;
import sae.core.domain.Egresso;

@Named
@SessionScoped
public class SessionControl extends JSFController{

	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private SessionService sessionService;

	
	
	public String getDecorator() { return sessionService.getDecorator(); }
	
	public boolean isSystemInstalled(){ return sessionService.isSystemInstalled(); }
	
	public boolean isLoggedIn() { return sessionService.isLoggedIn();}
	
	public Administrador getAdmin(){ return sessionService.getAdmin(); }
	
	public Egresso getEgresso(){ return sessionService.getEgresso(); }
	
	public String logout(){
		sessionService.logout();
		return "login.faces?faces-redirect=true";
	}
	

	
}
