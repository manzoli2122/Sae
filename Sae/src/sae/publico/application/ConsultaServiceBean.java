package sae.publico.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sae.core.domain.Curso;
import sae.publico.domain.Faixa_Salarial;
import sae.publico.domain.Historico_Egresso;
import sae.publico.persistence.Historico_EgressoDAO;

@Stateless
public class ConsultaServiceBean implements ConsultaService{

	
	@EJB
	private Historico_EgressoDAO historico_EgressoDAO;
	
	
	@Override
	public long countFaixaSalarial(Faixa_Salarial faixa, Curso curso){
		return historico_EgressoDAO.contFaixaSalarial(faixa, curso);
	}
	
	
	@Override
	public long countReside(Boolean mora, Curso curso){
		return historico_EgressoDAO.contReside(mora, curso);
	}
	
	
	@Override
	public List<Historico_Egresso> consultaHistoricos(Curso curso){
		return historico_EgressoDAO.consultaHistorico(curso);
	}
	
	
}
