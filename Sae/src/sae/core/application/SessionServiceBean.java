package sae.core.application;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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

import br.ufes.inf.nemo.util.TextUtils;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.util.ejb3.persistence.exceptions.PersistentObjectNotFoundException;
import sae.core.domain.Administrador;
import sae.core.domain.CursoRealizado;
import sae.core.domain.Egresso;
import sae.core.persistence.AdministradorDAO;
import sae.core.persistence.CursoRealizadoDAO;
import sae.core.persistence.EgressoDAO;


/**
 * Stateful session bean implementing the session information component. See the implemented interface documentation for
 * details.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see sae.core.application.SessionService
 */
@SessionScoped
@Stateful
public class SessionServiceBean implements SessionService{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(SessionServiceBean.class.getCanonicalName());
	
	
	/** Indicates the decorator being used. */
	private static final String DEFAULT_DECORATOR_NAME = "default";
	private static final String NO_MENU_DECORATOR_NAME = "nomenu";
	private static final String EGRESSO_DECORATOR_NAME = "egresso";

	
	@Resource 	private SessionContext sessionC;
	
	@EJB        
	private CoreInformacao coreInformacao;
	
	
	/** The DAO for Administrador objects. */
	@EJB        
	private AdministradorDAO administradorDAO;
	
	
	/** The DAO for Egresso objects. */
	@EJB        
	private EgressoDAO egressoDAO;
	
	
	/** The DAO for CursoRealizado objects. */
	@EJB        
	private CursoRealizadoDAO cursoRealizadoDAO;
	
	
	/** Indicates the decorator being used. */
	private String decorator;
	
	
	
	private Administrador admin;
	private Egresso egresso;
	
	
	
	
	
	
	/** @see sae.core.application.SessionService#getCursoRealizado() */
	@Override
	public List<CursoRealizado> getCursoRealizado() {
		return cursoRealizadoDAO.retrieveMyCursos(egresso);
	}
	
	
	
	/** @see sae.core.application.SessionService#getAdmin() */
	@Override
	public Administrador getAdmin() { 
		if(admin == null)
			getCurrentUser();
		return admin;
	}  
	
	
	
	@Override
	public boolean isPasswordDefault(){
		if(admin != null){
			try {
				String senha = TextUtils.produceMd5Hash(coreInformacao.getDefaultSenhaAdmin());
				if(admin.getSenha().equals(senha))
					return true;
			} catch (NoSuchAlgorithmException e) {}
			
		}
		return false;
	}
	
	
	
	/** @see sae.core.application.SessionService#getEgresso() */
	@Override
	public Egresso getEgresso() {
		if(egresso == null)
			getCurrentUser();
		return egresso; 
	}  
	
	
	
	/** @see sae.core.application.SessionService#isLoggedIn() */
	@Override
	public boolean isLoggedIn(){
		if(admin != null || egresso != null)
			return true;
		return false;
	}
	
	
	
	/** @see sae.core.application.SessionService#getDecorator() */
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
	public void getCurrentUser(){	
 		logger.log(Level.INFO, "GET CORRENTE USUARIO ");
		if((admin==null) &&  (egresso == null)){
			logger.log(Level.INFO, "PESQUISANDO USUARIO ");
			Principal principal = sessionC.getCallerPrincipal();
			if(principal != null){
			
				try { 
					admin = administradorDAO.retrieveByEmail(principal.getName());
					logger.log(Level.INFO, "USER ADMIN LOGGED");
					return;
				} 
				catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
					admin = null ;
					logger.log(Level.INFO, "ADMIN NOT LOGGED");
				}
			
				try { 
					egresso = egressoDAO.retrieveByEmail(principal.getName());
					logger.log(Level.INFO, "USER EGRESSO LOGGED ");
					return;
				} 
				catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
					egresso = null ;
					logger.log(Level.INFO, "EGRESSO NOT LOGGED");
				}
			}
		}
	}
	
	
	

	/** @see sae.core.application.SessionService#logout() */
	@Override
	public void logout(){
		logger.log(Level.INFO, "Invalidating a user session..... ");
		admin = null;
		egresso = null;
		
		FacesContext fc = FacesContext.getCurrentInstance();  
		
		// Destroys the session for this user.
		HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);     
		session.invalidate(); 
		
		// Redirects back to the initial page.
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
		} catch (IOException e) {} 
		
	}

	
}
