package sae.publico.application;

import java.util.List;

import javax.ejb.Local;

import sae.core.domain.Curso;
import sae.publico.domain.Faixa_Salarial;
import sae.publico.domain.Historico_Egresso;

@Local
public interface ConsultaService {

	long countFaixaSalarial(Faixa_Salarial faixa, Curso curso);

	long countReside(Boolean mora, Curso curso);

	List<Historico_Egresso> consultaHistoricos(Curso curso);

}
