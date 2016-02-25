package sae.core.domain;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import br.ufes.inf.nemo.util.TextUtils;
import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

/**
 * CLASSE DE DOMMINIO QUE REPRESENTA O ADMINISTRADOR DO SISTEMA.
 * 
 * IMPLEMENTADA COM BASE NO Documento de Análise de Requisitos VERSÃO 1.4
 * 
 * <i>ESTA CLASSE FAZ PARTE DO SISTEMA SAE.</i>
 * 
 * @author BRUNO MANZOLI (manzoli2122@gmail.com)
 */

@Entity
public class Administrador extends PersistentObjectSupport implements Comparable<Administrador> {

	
	private static final long serialVersionUID = 1L;
	
	
	/** NOME DO ADMINISTRADOR */
	@NotNull
	@Size(max = 60)
	private String nome;
	
	
	/** EMAIL DO ADMINISTRADOR */
	@NotNull 
	@Email
	@Size(max = 60)
	@Column(unique=true)
	private String email;

	
	/** CPF DO ADMINISTRADOR */
	@NotNull 
	@CPF
	@Size(max = 14)
	@Column(unique=true)
	private  String  cpf;
	
	
	/** SENHA DO ADMINISTRADOR  (32 pelo md5)*/
	@NotNull 
	@Size(max = 32)
	private String senha;
	
	
	/** MATRICULA DO ADMINISTRADOR */
	@NotNull 
	@Column(unique=true)
	private String matricula;
	
	
	/** CURSO QUE O ADMINISTRADOR COORDENA*/
	@OneToMany(mappedBy="coordenador")
	private Set<Curso> cursosCoordenados;
	
	
	
	
	
	

	@Override
	public int compareTo(Administrador o) { 
		// Compara os nomes das pessoas
		if (nome == null)	return 1;
		if (o.nome == null) return -1;
		int cmp = nome.compareTo(o.nome);
		if (cmp != 0 ) return cmp;
		
		if (cpf == null)	return 1;
		if (o.cpf == null) return -1;
		cmp = cpf.compareTo(o.cpf);
		if (cmp != 0) return cmp;
		
		// Se o nome e cpf são os mesmos, checa se são a mesma entity.
		return super.compareTo(o);	
	}
	
	@Override
	public String toString() { return nome; }

	
	
	
	/**  GETS AND SETS  */
	public String getNome() { return nome; 	}
	public void setNome(String name) { this.nome = name; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getSenha() { return senha; }
	public void setSenha(String senha) { 
		try {
			this.senha = TextUtils.produceMd5Hash(senha);
		} catch (NoSuchAlgorithmException e) {	}
		}

	public String getCpf() { return cpf; }
	public void setCpf(String cpf) { this.cpf = cpf; }

	public String getMatricula() { return matricula; }
	public void setMatricula(String matricula) { this.matricula = matricula; }
	
	public Set<Curso> getCursosCoordenados() { 	return cursosCoordenados; }
	public void setCursosCoordenados(Set<Curso> cursosCoordenados) {this.cursosCoordenados = cursosCoordenados;}
	
}
