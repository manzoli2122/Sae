package sae.core.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class CursoRealizado extends PersistentObjectSupport implements Comparable<CursoRealizado> {

	
	private static final long serialVersionUID = 1L;

	
	/** MATRICULA*/
	@NotNull 
	private String matricula;
	
	
	@NotNull 
	@Temporal(TemporalType.DATE)
	private Date anoInicio;
	
	@NotNull 
	@Temporal(TemporalType.DATE)
	private Date anoTermino;
	
	@NotNull
	@ManyToOne
	private Curso curso;
	
	@NotNull
	@ManyToOne
	private Egresso egresso;
	
	
	
	
	@Override
	 public int compareTo(CursoRealizado o) {
		if (matricula == null)	return 1;
		if (o.matricula == null) return -1;
		int cmp = matricula.compareTo(o.matricula);
		if (cmp != 0 ) return cmp;
		return super.compareTo(o);	
	 }


	public String getMatricula() { return matricula;}
	public void setMatricula(String matricula) { this.matricula = matricula; }

	public Date getAnoInicio() {	return anoInicio; }
	public void setAnoInicio(Date anoInicio) {	this.anoInicio = anoInicio;	}

	public Date getAnoTermino() {	return anoTermino;	}
	public void setAnoTermino(Date anoTermino) { this.anoTermino = anoTermino;	}

	public Curso getCurso() { return curso;	}
	public void setCurso(Curso curso) {	this.curso = curso;	}

	public Egresso getEgresso() {	return egresso; }
	public void setEgresso(Egresso egresso) { this.egresso = egresso; }
	
	
 }




