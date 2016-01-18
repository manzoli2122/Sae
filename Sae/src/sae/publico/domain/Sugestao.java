package sae.publico.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;
import sae.core.domain.Curso;
import sae.core.domain.Egresso;

@Entity
public class Sugestao extends PersistentObjectSupport implements Comparable<Sugestao>{

	
	private static final long serialVersionUID = 1L;
	
	
	/* NOME DO USUARIO */
	@NotNull
	private String conteudo;
	
	/* NOME DO USUARIO */
	@NotNull
	private String resposta;	
	
	/* NOME DO USUARIO */
	@NotNull
	private Date data_envio;
	
	/* NOME DO USUARIO */
	@NotNull
	private Egresso autor;
	
	/* NOME DO USUARIO */
	@NotNull
	private Curso curso;
	
	
	
	
	
	
	@Override
	public int compareTo(Sugestao  o) { return super.compareTo(o); }
	
	@Override
	public String toString() { return conteudo; }
}
