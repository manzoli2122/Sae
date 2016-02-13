package sae.core.application;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import br.ufes.inf.nemo.util.ejb3.application.CrudException;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Administrador;
import sae.core.domain.SaeConfiguracao;
import sae.core.persistence.AdministradorDAO;



/**
 * Stateless session bean implementing the "Manage Administrador" use case component. See the implemented interface
 * documentation for details.
 * 
 * @author Bruno Manzoli (manzoli2122@gmail.com)
 * @see sae.core.application.ManageAdministradorService
 */
@Stateless
@DeclareRoles({"Admin", "egresso", "guest"})
@RolesAllowed({ "Admin" })
public class ManageAdministradorServiceBean extends CrudServiceBean<Administrador> implements ManageAdministradorService{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(ManageAdministradorServiceBean.class.getCanonicalName());
	
	
	/** The DAO for Administrador objects. */
	@EJB    	
	private AdministradorDAO administradorDAO;
	
	
	/** The information singleton for the core module. */
	@EJB    	
	private CoreInformacao coreInformacao;
	
	
	
	
	/** @see br.ufes.inf.nemo.util.ejb3.application.CrudService#getDAO() */
	@Override
	public BaseDAO<Administrador> getDAO() {
		return administradorDAO;
	}

	
	
	/** @see sae.core.application.CrudServiceBean#createNewEntity() */
	@Override
	protected Administrador createNewEntity() {
		return new Administrador();
	}
	
	
	
	/** @see sae.core.application.CrudServiceBean#validateCreate(br.ufes.inf.nemo.util.ejb3.persistence.PersistentObject) */
	@Override
	@PermitAll
	public void validateCreate(Administrador entity) throws CrudException {
		entity.setSenha(coreInformacao.getDefaultSenhaAdmin());
	}
	
	
	
	/** @see sae.core.application.CrudServiceBean#create()  */
	@PermitAll
	@Override
	public void create(Administrador entity) {
		super.create(entity);
	}
	
		
	
	@Override
	public void sendEmailCadastro(Administrador entity){
		logger.log(Level.INFO, "Send Email ......");
		
		String emailAddress = entity.getEmail();
		emailAddress = "manzoli2122@gmail.com";
		
		SaeConfiguracao config = coreInformacao.getCurrentConfig(); 
	
		String msg = "Bem Vindo Ao Sistema de Acompanhamento de Egresso \n\n"
				+ "o senhor foi cadastrado como administrador ddo sistema \n"
				+ "para realizar o primeiro acesso entre na pagina \n ";
		

		 try{
			 MultiPartEmail email = new MultiPartEmail();
			 email.setHostName(config.getSmtpServerAddress());
			 email.setSmtpPort(config.getSmtpServerPort());
			 email.setAuthenticator(new DefaultAuthenticator(config.getSmtpUsername(), config.getSmtpPassword()));
			 email.setTLS(true);
			 //email.setSSL(true);
			 email.setFrom(config.getSmtpUsername());
			 email.setSubject("Cadastro Sistema SAE");
			 email.setMsg(msg);
			 email.addTo(emailAddress);
			 email.addTo(config.getSmtpUsername());
			 email.send();
		  
		}
		catch (EmailException e) {
			e.printStackTrace();
		}	
	}
	
}
