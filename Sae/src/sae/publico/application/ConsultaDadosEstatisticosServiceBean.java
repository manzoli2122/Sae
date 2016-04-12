package sae.publico.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sae.core.domain.Curso;
import sae.publico.domain.Faixa_Salarial_Enum;
import sae.publico.domain.HistoricoEgresso;
import sae.publico.persistence.HistoricoEgressoDAO;

@Stateless
public class ConsultaDadosEstatisticosServiceBean implements ConsultaDadosEstatisticosService{

	
	@EJB
	private HistoricoEgressoDAO historico_EgressoDAO;
	
	
	
	public long countFaixaSalarial(Faixa_Salarial_Enum faixa, Curso curso){
		return historico_EgressoDAO.contFaixaSalarial(faixa, curso);
	}
	
	
	
	public long countReside(Boolean mora, Curso curso){
		return historico_EgressoDAO.contReside(mora, curso);
	}
	
	
	@Override
	public List<HistoricoEgresso> consultaHistoricos(Curso curso){
		return historico_EgressoDAO.consultaHistorico(curso);
	}
	
	
}
