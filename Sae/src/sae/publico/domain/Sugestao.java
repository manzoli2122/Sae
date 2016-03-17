package sae.publico.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;
import sae.core.domain.CursoRealizado;

@Entity
public class Sugestao extends PersistentObjectSupport implements Comparable<Sugestao>{

	
	private static final long serialVersionUID = 1L;
	
	
	/* NOME DO USUARIO */
	@NotNull
	@Column(length=1000)
	private String conteudo;
	
	/* NOME DO USUARIO */
	@Column(length=1000)
	private String resposta;	
	
	/* NOME DO USUARIO */
	@NotNull
	private Date data_envio;
	
	/* NOME DO USUARIO */
	@NotNull
	@ManyToOne
	private CursoRealizado cursoRealizado;
	
	
	
	
	public String getConteudo() { return conteudo; 	}
	public void setConteudo(String conteudo) { 	this.conteudo = conteudo; }

	public String getResposta() { return resposta; }
	public void setResposta(String resposta) { this.resposta = resposta; }

	public Date getData_envio() { return data_envio; }
	public void setData_envio(Date data_envio) { this.data_envio = data_envio; }

	public CursoRealizado getCursoRealizado() { return cursoRealizado; 	}
	public void setCursoRealizado(CursoRealizado cursoRealizado) { 	this.cursoRealizado = cursoRealizado; 	}

	@Override
	public int compareTo(Sugestao  o) { return super.compareTo(o); }
	
	@Override
	public String toString() { return cursoRealizado.getCurso().getNome() + " na data " +data_envio.toString(); }
}
