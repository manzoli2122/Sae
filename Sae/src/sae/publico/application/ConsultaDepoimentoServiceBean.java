package sae.publico.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sae.core.domain.Curso;
import sae.publico.domain.Depoimento;
import sae.publico.persistence.DepoimentoDAO;

@Stateless
public class ConsultaDepoimentoServiceBean  implements ConsultaDepoimentoService {
	
	

	/** The DAO for Depoimento objects. */
	@EJB    	
	private DepoimentoDAO depoimentoDAO;
	
	
	@Override
	public List<Depoimento> getDepoimentos(Curso curso){
		return depoimentoDAO.retrieveAllCurso(curso);
	}

}
