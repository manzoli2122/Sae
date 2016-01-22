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

	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(InstallSystemControl.class.getCanonicalName());
	
	private static final String VIEW_PATH = "/installSystem/";
	
	@EJB
	private InstallSystemService installSystemService;

	@EJB
	private ManageAdministradorService manageAdministradorService;
	
	private SaeConfiguracao config = new SaeConfiguracao();
	
	private Administrador admin = new Administrador();

	
	public String begin() {
		logger.log(Level.INFO, "REDIRECIONADO PARA INSTALAÇÃO");
		return VIEW_PATH + "admin.xhtml?faces-redirect=true";
	}

	
	public String saveAdmin() {
		try {
			admin.setSenha("123");
			
			manageAdministradorService.create(admin);
			
		}
		catch (Exception e) {
			addGlobalI18nMessage("msgs", FacesMessage.SEVERITY_FATAL, "installSystem.error.installFailed.summary", "installSystem.error.installFailed.detail");
			return null;
		}
		return VIEW_PATH + "index.xhtml?faces-redirect=true";
	}
	

	
	public String saveSmtpConfig() {
		try {
			config.setAdministrador(admin);
			installSystemService.installSystem( config);
		}
		catch (Exception e) {
			addGlobalI18nMessage("msgs", FacesMessage.SEVERITY_FATAL, "installSystem.error.installFailed.summary", "installSystem.error.installFailed.detail");
			return null;
		}
		//return VIEW_PATH + "done.xhtml?faces-redirect=true";
		return "/index.xhtml?faces-redirect=true";
	}

	
	/** Getter and Setter. */
	public SaeConfiguracao getConfig() { return config; }
	public void setConfig(SaeConfiguracao config) { this.config = config; }
	
	public Administrador getAdmin() { return admin; }
	public void setAdmin(Administrador admin) { this.admin = admin; }

}
