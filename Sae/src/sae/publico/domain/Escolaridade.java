package sae.publico.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;
import sae.core.domain.Egresso;


/**
 * CLASSE DE DOMMINIO QUE REPRESENTA A ESCOLARIDADE DO EGRESSO.
 * 
 * IMPLEMENTADA COM BASE NO Documento de Análise de Requisitos VERSÃO 1.4
 * 
 * <i>ESTA CLASSE FAZ PARTE DO SISTEMA SAE.</i>
 * 
 * @author BRUNO MANZOLI (manzoli2122@gmail.com)
 */

@Entity
public class Escolaridade extends PersistentObjectSupport implements Comparable<Escolaridade>{

	private static final long serialVersionUID = 1L;
	
	/** EGRESSO DA ESCOLARIDADE */
	@NotNull
	@ManyToOne
	private Egresso egresso;
	
	/** ESTADO ONDE FOI REALIZADO O CURSO */
	@NotNull
	private String estado;
	
	/** PAIS ONDE FOI REALIZADO O CURSO */
	@NotNull
	private String pais;
	
	/** INSTITUICAO ONDE FOI REALIZADO O CURSO*/
	@NotNull
	private String instituicao;
	
	/** ANO DE TERMINO DO CURSO */
	@NotNull
	private String ano;
	
	/** TITULO DO CURSO */
	@NotNull
	private Titulo_Escolaridade titulo;
	
	
	
	
	@Override
	public int compareTo(Escolaridade  o) { 
		
		if (egresso == null)	return 1;
		if (o.egresso == null) return -1;
		int cmp = egresso.compareTo(o.egresso);
		if (cmp != 0 ) return cmp;
				
		
		if (titulo == null)	return 1;
		if (o.titulo == null) return -1;		
		cmp = titulo.compareTo(o.titulo);
		if (cmp != 0 ) return cmp;
				
		return super.compareTo(o);
		
	}
	
	@Override
	public String toString() { return egresso.toString(); }

	
	
	
	
	
	/**  GETS AND SETS  */
	public Egresso getEgresso() { return egresso; }
	public void setEgresso(Egresso egresso) { this.egresso = egresso; }

	public String getEstado() { return estado; }
	public void setEstado(String estado) { 	this.estado = estado; }

	public String getPais() { return pais;  }
	public void setPais(String pais) { 	this.pais = pais; }

	public String getInstituicao() {  return instituicao; }
	public void setInstituicao(String instituicao) {  this.instituicao = instituicao; }

	public String getAno() { 	return ano; }
	public void setAno(String ano) { 	this.ano = ano; }

	public Titulo_Escolaridade getTitulo() { return titulo; }
	public void setTitulo(Titulo_Escolaridade titulo) { this.titulo = titulo; }
	
}

