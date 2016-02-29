package sae.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;


/**
 * CLASSE DE DOMMINIO QUE REPRESENTA OS CURSOS.
 * 
 * IMPLEMENTADA COM BASE NO Documento de Análise de Requisitos VERSÃO 1.4
 * 
 * <i>ESTA CLASSE FAZ PARTE DO SISTEMA SAE.</i>
 * 
 * @author BRUNO MANZOLI (manzoli2122@gmail.com)
 */

@Entity
public class Curso  extends  PersistentObjectSupport implements Comparable<Curso> {
	
	private static final long serialVersionUID = 1L;
	
	/** NOME DO CURSO */
	@NotNull
	@Size(max = 60)
	@Column(unique=true)
	private String nome;
	
	
	/** CODIGO DO CURSO */
	@NotNull
	@Size(max = 8)
	@Column(unique=true)
	private String codigo;
	

	/** COORDENADOR DO CURSO */
	@NotNull
	@ManyToOne
	private Administrador coordenador;
	
	
	
	@Override
	public int compareTo(Curso o) { 
		
		if (nome == null)	return 1;
		if (o.nome == null) return -1;
		
		if (codigo == null)	return 1;
		if (o.codigo == null) return -1;
		
		int cmp = nome.compareTo(o.nome);
		if (cmp != 0 ) return cmp;
		
		int cmpcpf = codigo.compareTo(o.codigo);
		if (cmpcpf != 0) return cmpcpf;
		
		return super.compareTo(o); 
		
	}
	
	@Override
	public String toString() { return nome; }

	
	
	/**  GETS AND SETS  */
	public String getCodigo() { return codigo; }
	public void setCodigo(String codigo) { this.codigo = codigo; }

	public Administrador getCoordenador() { return coordenador; }
	public void setCoordenador(Administrador coordenador) { this.coordenador = coordenador; }

	public String getNome() {return nome; }
	public void setNome(String nome) { this.nome = nome; }	
	
}
