package sae.publico.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;
import sae.core.domain.CursoRealizado;

@Entity
public class Depoimento extends PersistentObjectSupport implements Comparable<Depoimento> {

	private static final long serialVersionUID = 1L;
	
	
	/* NOME DO USUARIO */
	@NotNull
	private Date data_envio;
	
	
	/* NOME DO USUARIO */
	// @Column(length=1000)
	@NotNull
	@Lob
	private String conteudo;
	
	
	/* NOME DO USUARIO */
	@NotNull
	private Boolean anonimo;
	
	
	/* NOME DO USUARIO */
	@NotNull
	@ManyToOne
	private CursoRealizado cursoRealizado;
	
	
	@NotNull
	private StatusDepoimento status;
	
	
	
	
	public String getConteudo() { return conteudo; 	}
	public void setConteudo(String conteudo) { 	this.conteudo = conteudo; }

	public Date getData_envio() { return data_envio; }
	public void setData_envio(Date data_envio) { this.data_envio = data_envio; }

	public Boolean getAnonimo() { 	return anonimo; }
	public void setAnonimo(Boolean anonimo) { this.anonimo = anonimo; }
	
	public StatusDepoimento getStatus() {return status;}
	public void setStatus(StatusDepoimento status) {this.status = status;}
	
	
	public CursoRealizado getCursoRealizado() { return cursoRealizado; 	}
	public void setCursoRealizado(CursoRealizado cursoRealizado) { 	this.cursoRealizado = cursoRealizado; 	}

	

	@Override
	public int compareTo(Depoimento  o) { return super.compareTo(o); }
	
	@Override
	public String toString() { return cursoRealizado.getCurso().getNome() + " na data " + data_envio.toString(); }
	
}
