package sae.core.application;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.PersistentObjectNotFoundException;
import sae.core.domain.Administrador;
import sae.core.domain.Curso;
import sae.core.domain.CursoRealizado;
import sae.core.domain.Curso_;
import sae.core.domain.Egresso;
import sae.core.persistence.AdministradorDAO;
import sae.core.persistence.CursoRealizadoDAO;
import sae.core.persistence.EgressoDAO;

@SessionScoped
@Stateful
public class SessionServiceBean implements SessionService{

	
	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_DECORATOR_NAME = "default";
	
	private static final String NO_MENU_DECORATOR_NAME = "nomenu";
	
	private static final String EGRESSO_DECORATOR_NAME = "egresso";

	private static final Logger logger = Logger.getLogger(SessionServiceBean.class.getCanonicalName());
	
	@Resource 	private SessionContext sessionC;
	
	@EJB        
	private CoreInformacao coreInformacao;
	
	@EJB        
	private AdministradorDAO administradorDAO;
	
	@EJB        
	private EgressoDAO egressoDAO;
	
	
	@EJB        
	private CursoRealizadoDAO cursoRealizadoDAO;
	
	
	
	
	private String decorator;
	
	private Administrador admin;
	
	private Egresso egresso;
	
	
	
	
	@Override
	public List<CursoRealizado> getCursoRealizado() {
		
		return cursoRealizadoDAO.retrieveMyCursos(egresso);
		
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public String getDecorator() {
		if(decorator ==  null || decorator ==  NO_MENU_DECORATOR_NAME ){
			getCurrentUser();
			decorator =  NO_MENU_DECORATOR_NAME;
		}
		if(admin != null){
			decorator = DEFAULT_DECORATOR_NAME;
		}
		if(egresso != null){
			decorator =  EGRESSO_DECORATOR_NAME;
		}
		return decorator;
	}
	
	
	
	@Override
	public boolean isLoggedIn(){
		if(admin != null || egresso != null)
			return true;
		return false;
	}
	
	
	@Override
	public Administrador getAdmin() { return admin; }  
	
	@Override
	public Egresso getEgresso() {
		getCurrentUser();
		return egresso; 
	}  
	
	
	
 	public void getCurrentUser1(){	
		Principal principal = sessionC.getCallerPrincipal();
		if(principal != null){
			if(admin==null){
				try { 
					admin = administradorDAO.retrieveByEmail(principal.getName());
					logger.log(Level.INFO, "ADMIN DECOREITO ");
					return;
				} 
				catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
					admin = null ;
					logger.log(Level.INFO, "ADMIN SEM DECOREITO ");
				}
			}
			
			if(egresso == null ){
				try { 
					egresso = egressoDAO.retrieveByEmail(principal.getName());
					logger.log(Level.INFO, "EGRESSO DECOREITO ");
					return;
				} 
				catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
					egresso = null ;
					logger.log(Level.INFO, "EGRESSO SEM DECOREITO ");
				}
			}
			
		}
		
		
	}
	
 	@Override
	public void getCurrentUser(){	
 		logger.log(Level.INFO, "GET CORRENTE USUARIO ");
		if((admin==null) &&  (egresso == null)){
			logger.log(Level.INFO, "PESQUISANDO USUARIO ");
			Principal principal = sessionC.getCallerPrincipal();
			if(principal != null){
			
				try { 
					admin = administradorDAO.retrieveByEmail(principal.getName());
					logger.log(Level.INFO, "ADMIN DECOREITO ");
					return;
				} 
				catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
					admin = null ;
					logger.log(Level.INFO, "ADMIN SEM DECOREITO ");
				}
			
				try { 
					egresso = egressoDAO.retrieveByEmail(principal.getName());
					logger.log(Level.INFO, "EGRESSO DECOREITO ");
					return;
				} 
				catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
					egresso = null ;
					logger.log(Level.INFO, "EGRESSO SEM DECOREITO ");
				}
			}
		}
	}
	
	
	
	

	@Override
	public Boolean isSystemInstalled() {
		return coreInformacao.getSystemInstalled();
	}
	
	
	/* FUNCAO PARA FAZER LOGOUT */
	@Override
	public void logout(){
		admin = null;
		egresso = null;
		FacesContext fc = FacesContext.getCurrentInstance();     
		HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);     
		session.invalidate(); 
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
		} catch (IOException e) {} 
	}

	
}
