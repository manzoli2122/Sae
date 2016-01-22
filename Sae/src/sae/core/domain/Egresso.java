package sae.core.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;



/**
 * CLASSE DE DOMMINIO QUE REPRESENTA OS EGRESSOS.
 * 
 * IMPLEMENTADA COM BASE NO Documento de Análise de Requisitos VERSÃO 1.4
 * 
 * <i>ESTA CLASSE FAZ PARTE DO SISTEMA SAE.</i>
 * 
 * @author BRUNO MANZOLI (manzoli2122@gmail.com)
 */

@Entity
public class Egresso extends PersistentObjectSupport implements Comparable<Egresso> {

	private static final long serialVersionUID = 1L;
	
	/** NOME DO EGRESSO */
	@NotNull
	@Size(max = 50)
	private String nome;
	
	/** EMAIL DO EGRESSO*/
	@NotNull 
	@Email
	@Column(unique=true)
	private String email;
	
	/** SENHA DO EGRESSO */
	@NotNull 
	private String senha;

	/** CPF DO EGRESSO */
	@NotNull 
	@CPF
	@Column(unique=true)
	private String cpf;
	
	/** IDENTIDADE DO EGRESSO */
	@NotNull 
	@Column(unique=true)
	private String identidade;
	
	/** SEXO DO EGRESSO */
	@NotNull 
	private Character sexo;
	
	/** NATURALIDADE DO EGRESSO */
	private String naturalidade;
	
	/** NACIONALIDADE DO EGRESSO */
	private String nacionalidade;
	
	/** DATA DE NASCIMENTO DO EGRESSO */
	@NotNull 
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	
	@Override
	public int compareTo(Egresso o) { 
		// Compara os nomes das pessoas
		if (nome == null)	return 1;
		if (o.nome == null) return -1;
		
		if (cpf == null)	return 1;
		if (o.cpf == null) return -1;
			
		int cmp = nome.compareTo(o.nome);
		if (cmp != 0 ) return cmp;
			
		int cmpcpf = cpf.compareTo(o.cpf);
		if (cmpcpf != 0) return cmpcpf;
			
		// Se o nome e cpf são os mesmos, checa se são a mesma entity.
		return super.compareTo(o);	
	}
	
	@Override
	public String toString() { return nome; }

	
	
	/**  GETS AND SETS  */
	public String getNome() { 	return nome; }
	public void setNome(String nome) { 	this.nome = nome; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getSenha() { return senha; }
	public void setSenha(String senha) { this.senha = senha; }

	public String getCpf() { return cpf; }
	public void setCpf(String cpf) { this.cpf = cpf; }

	public String getIdentidade() { return identidade; 	}
	public void setIdentidade(String identidade) { this.identidade = identidade;}

	public Character getSexo() { return sexo; }
	public void setSexo(Character sexo) { this.sexo = sexo; }

	public String getNaturalidade() { return naturalidade; }
	public void setNaturalidade(String naturalidade) { 	this.naturalidade = naturalidade; }

	public String getNacionalidade() { return nacionalidade; }
	public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

	public Date getNascimento() { return nascimento; }
	public void setNascimento(Date nascimento) { this.nascimento = nascimento; }
		
}
