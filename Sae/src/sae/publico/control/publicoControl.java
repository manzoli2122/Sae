package sae.publico.control;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import sae.core.domain.Administrador;
import sae.core.domain.Curso;
import sae.core.persistence.AdministradorDAO;
import sae.publico.domain.Area_Atuacao;
import sae.publico.domain.Area_Formacao;
import sae.publico.domain.Depoimento;
import sae.publico.domain.Faixa_Salarial;
import sae.publico.domain.Titulo_Escolaridade;
import sae.publico.persistence.DepoimentoDAO;

@Named
@ApplicationScoped
public class publicoControl implements Serializable{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(publicoControl.class.getCanonicalName());
	
	
	/** The DAO for Administrador objects. */
	@EJB    	
	private DepoimentoDAO depoimentoDAO;
	
	
	
	public Faixa_Salarial[] getFaixa_Salarial() {
		return Faixa_Salarial.values();
	}
	
	public Area_Atuacao[] getArea_Atuacao() {
		return Area_Atuacao.values();
	}
	
	
	public Area_Formacao[] getArea_Formacao() {
		return Area_Formacao.values();
	}
	
	public Titulo_Escolaridade[] getTitulo_Escolaridade() {
		logger.log(Level.INFO, "return Titulo_Escolaridade values...");
		return Titulo_Escolaridade.values();
	}
	
	
	
	
	public List<Depoimento> getDepoimentos(Curso curso){
		return depoimentoDAO.retrieveAllCurso(curso);
	}
	
	
}
