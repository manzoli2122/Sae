package sae.publico.application;

import java.util.List;

import javax.ejb.Local;

import sae.core.domain.Curso;
import sae.publico.domain.Faixa_Salarial_Enum;
import sae.publico.domain.HistoricoEgresso;

@Local
public interface ConsultaService {

	

	List<HistoricoEgresso> consultaHistoricos(Curso curso);

}
