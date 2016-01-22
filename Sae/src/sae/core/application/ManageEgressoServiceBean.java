package sae.core.application;

import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import br.ufes.inf.nemo.util.TextUtils;
import br.ufes.inf.nemo.util.ejb3.application.CrudException;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Administrador;
import sae.core.domain.Egresso;
import sae.core.domain.SaeConfiguracao;
import sae.core.persistence.EgressoDAO;

@Stateless
public class ManageEgressoServiceBean  extends CrudServiceBean<Egresso> implements ManageEgressoService{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EgressoDAO egressoDAO;
	
	@EJB    	
	private CoreInformacao coreInformacao;
	
	
	@Override
	public BaseDAO<Egresso> getDAO() {
		return egressoDAO;
	}

	@Override
	protected Egresso createNewEntity() {
		return new Egresso();
	}

	
	@Override
	public void validateCreate(Egresso entity) throws CrudException {
		try {
			entity.setSenha(TextUtils.produceMd5Hash(entity.getSenha()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void sendEmailCadastro(Egresso entity){
		
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
