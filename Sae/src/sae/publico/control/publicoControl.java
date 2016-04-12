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
import sae.publico.domain.Area_Atuacao_Enum;
import sae.publico.domain.Area_Formacao_Enum;
import sae.publico.domain.Depoimento;
import sae.publico.domain.Faixa_Salarial_Enum;
import sae.publico.domain.Titulo_Escolaridade_Enum;
import sae.publico.persistence.DepoimentoDAO;

@Named
@ApplicationScoped
public class publicoControl implements Serializable{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(publicoControl.class.getCanonicalName());
	
	
	/** The DAO for Depoimento objects. */
	@EJB    	
	private DepoimentoDAO depoimentoDAO;
	
	
	
	public String login(){
		return "/public/egresso/index.xhtml?faces-redirect=true" ;
	}
	
	
	
	
	public Faixa_Salarial_Enum[] getFaixa_Salarial() {
		return Faixa_Salarial_Enum.values();
	}
	
	public Area_Atuacao_Enum[] getArea_Atuacao() {
		return Area_Atuacao_Enum.values();
	}
	
	
	public Area_Formacao_Enum[] getArea_Formacao() {
		return Area_Formacao_Enum.values();
	}
	
	public Titulo_Escolaridade_Enum[] getTitulo_Escolaridade() {
		logger.log(Level.INFO, "return Titulo_Escolaridade values...");
		return Titulo_Escolaridade_Enum.values();
	}
	
	
	
	
	public List<Depoimento> getDepoimentos(Curso curso){
		return depoimentoDAO.retrieveAllCurso(curso);
	}
	
	
}
