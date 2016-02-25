package sae.publico.application;

import java.util.List;

import javax.ejb.Local;

import sae.core.domain.Curso;
import sae.publico.domain.Faixa_Salarial_Enum;
import sae.publico.domain.HistoricoEgresso;

@Local
public interface ConsultaService {

	long countFaixaSalarial(Faixa_Salarial_Enum faixa, Curso curso);

	long countReside(Boolean mora, Curso curso);

	List<HistoricoEgresso> consultaHistoricos(Curso curso);

}
