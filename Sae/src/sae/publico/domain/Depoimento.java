package sae.publico.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;
import sae.core.domain.Curso;
import sae.core.domain.Egresso;

@Entity
public class Depoimento extends PersistentObjectSupport implements Comparable<Depoimento> {

	
	private static final long serialVersionUID = 1L;
	
	/* NOME DO USUARIO */
	@NotNull
	private String conteudo;
	
	
	/* NOME DO USUARIO */
	@NotNull
	private Date data_envio;
	
	/* NOME DO USUARIO */
	@NotNull
	private Egresso autor;
	
	/* NOME DO USUARIO */
	@NotNull
	private Curso curso;
	
	
	/* NOME DO USUARIO */
	@NotNull
	private Boolean anonimo;
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public int compareTo(Depoimento  o) { return super.compareTo(o); }
	
	@Override
	public String toString() { return conteudo; }
}
