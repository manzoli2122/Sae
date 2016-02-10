package sae.publico.persistence;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Curso;
import sae.publico.domain.Faixa_Salarial;
import sae.publico.domain.Historico_Egresso;

@Local
public interface Historico_EgressoDAO  extends BaseDAO<Historico_Egresso>{

	long contFaixaSalarial(Faixa_Salarial faixa, Curso curso);

	long contReside(Boolean mora, Curso curso);

	List<Historico_Egresso> consultaHistorico(Curso curso);

}
