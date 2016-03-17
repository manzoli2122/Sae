package sae.core.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import br.ufes.inf.nemo.util.ejb3.controller.JSFController;
import sae.core.application.InstallSystemService;
import sae.core.application.ManageAdministradorService;
import sae.core.domain.Administrador;
import sae.core.domain.SaeConfiguracao;

@Named
@SessionScoped
public class InstallSystemControl extends JSFController{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(InstallSystemControl.class.getCanonicalName());
	
	
	/** The view path where the web pages are located. */
	private static final String VIEW_PATH = "/installSystem/";
	
	
	/** The InstallSystem service. */
	@EJB
	private InstallSystemService installSystemService;

	
	/** The "Manage Administrador" service. */
	@EJB
	private ManageAdministradorService manageAdministradorService;
	
	
	private SaeConfiguracao config = new SaeConfiguracao();
	
	private Administrador admin = new Administrador();


	

	
	
	
	
	/**
	 * Displays the page of installation.
	 * 
	 * @return The view path for the INSTALAÇÃO.
	 */
	public String begin() {
		logger.log(Level.INFO, "REDIRECIONADO PARA INSTALAÇÃO");
		return VIEW_PATH + "admin.xhtml?faces-redirect=true";
	}


	
	/**
	 * Save administrator and displays the page of installation servidor email.
	 * 
	 * @return The view path for the installation servidor email.
	 */	
	public String saveAdmin() {
		try {
			logger.log(Level.INFO, "SAVING THE ADMINISTRADOR..........");
			installSystemService.saveAdmin(admin);
		}
		catch (Exception e) {
			logger.log(Level.INFO, "ERROR IN SAVING THE ADMINISTRADOR..........");
			addGlobalI18nMessage("msgs", FacesMessage.SEVERITY_FATAL, "installSystem.error.installFailed.summary", "installSystem.error.installFailed.detail");
			return null;
		}
		return VIEW_PATH + "index.xhtml?faces-redirect=true";
	}
	

	
	/**
	 * Save servidor and displays the page of initial page.
	 * 
	 * @return The view path of home.
	 */
	public String saveSmtpConfig() {
		try {
			logger.log(Level.INFO, "SAVING THE CONFIGURAÇÃO..........");
			config.setAdministrador(admin);
			installSystemService.installSystem( config);
		}
		catch (Exception e) {
			addGlobalI18nMessage("msgs", FacesMessage.SEVERITY_FATAL, "installSystem.error.installFailed.summary", "installSystem.error.installFailed.detail");
			return null;
		}
		return "/index.xhtml?faces-redirect=true";
	}

	
	
	/** Getter and Setter. */
	public SaeConfiguracao getConfig() { return config; }
	public void setConfig(SaeConfiguracao config) { this.config = config; }
	
	public Administrador getAdmin() { return admin; }
	public void setAdmin(Administrador admin) { this.admin = admin; }

}
