package sae.core.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class SaeConfiguracao extends PersistentObjectSupport{

	private static final long serialVersionUID = 1L;

	/** DATA DA CRIAÇÃO  */
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	/** Address for the SMTP server that sends e-mail. */
	@NotNull
	private String smtpServerAddress;
	
	/** Port for the SMTP server that sends e-mail. */
	@NotNull
	private Integer smtpServerPort;
	
	/** Username to connect to the SMTP server that sends email. */
	@NotNull
	private String smtpUsername;
	
	/** Password to connect to the SMTP server that sends email. */
	@NotNull
	private String smtpPassword;
	
	@NotNull
	@ManyToOne
	private Administrador administrador;

	
	/** DATA DA CRIAÇÃO  */
	@Temporal(TemporalType.TIMESTAMP)
	private Date envioEmailAtualizacao;
	
	
	
	
	
	
	
	/** GETTERS AND SETTERS */
	public Date getEnvioEmailAtualizacao() { return envioEmailAtualizacao; }
	public void setEnvioEmailAtualizacao(Date envioEmailAtualizacao) { 	this.envioEmailAtualizacao = envioEmailAtualizacao;}
	
	public Date getCreationDate() { return creationDate; }
	public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

	public String getSmtpServerAddress() { 	return smtpServerAddress; }
	public void setSmtpServerAddress(String smtpServerAddress) { this.smtpServerAddress = smtpServerAddress; }

	public Integer getSmtpServerPort() { return smtpServerPort; }
	public void setSmtpServerPort(Integer smtpServerPort) { this.smtpServerPort = smtpServerPort; }

	public String getSmtpUsername() { return smtpUsername; }
	public void setSmtpUsername(String smtpUsername) { 	this.smtpUsername = smtpUsername; }

	public String getSmtpPassword() { return smtpPassword; 	}
	public void setSmtpPassword(String smtpPassword) { 	this.smtpPassword = smtpPassword; 	}
	
	public Administrador getAdministrador() { return administrador; }
	public void setAdministrador(Administrador administrador) { this.administrador = administrador; }
	
}
