package sae.publico.application;

import java.util.List;

import javax.ejb.Local;

import sae.core.domain.Curso;
import sae.publico.domain.Depoimento;

@Local
public interface ConsultaDepoimentoService {

	List<Depoimento> getDepoimentos(Curso curso);

}
