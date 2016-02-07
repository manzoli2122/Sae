package sae.publico.application;

import javax.ejb.Local;

import sae.core.domain.Curso;
import sae.publico.domain.Faixa_Salarial;

@Local
public interface ConsultaService {

	long countFaixaSalarial(Faixa_Salarial faixa, Curso curso);

	long countReside(Boolean mora, Curso curso);

}
