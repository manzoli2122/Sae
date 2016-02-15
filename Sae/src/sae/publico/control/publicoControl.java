package sae.publico.control;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import sae.publico.domain.Area_Atuacao;
import sae.publico.domain.Faixa_Salarial;
import sae.publico.domain.Titulo_Escolaridade;

@Named
@ApplicationScoped
public class publicoControl implements Serializable{

	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;
	
	
	/** The logger. */
	private static final Logger logger = Logger.getLogger(publicoControl.class.getCanonicalName());
	
	
	
	
	
	public Faixa_Salarial[] getFaixa_Salarial() {
		return Faixa_Salarial.values();
	}
	
	public Area_Atuacao[] getArea_Atuacao() {
		return Area_Atuacao.values();
	}
	
	public Titulo_Escolaridade[] getTitulo_Escolaridade() {
		logger.log(Level.INFO, "return Titulo_Escolaridade values...");
		return Titulo_Escolaridade.values();
	}
	
	
}
