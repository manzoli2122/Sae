package sae.publico.persistence;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Curso;
import sae.core.domain.Egresso;
import sae.publico.domain.Faixa_Salarial_Enum;
import sae.publico.domain.HistoricoEgresso;

@Local
public interface HistoricoEgressoDAO  extends BaseDAO<HistoricoEgresso>{

	long contFaixaSalarial(Faixa_Salarial_Enum faixa, Curso curso);

	long contReside(Boolean mora, Curso curso);

	List<HistoricoEgresso> consultaHistorico(Curso curso);

	List<HistoricoEgresso> retrieveAllMine(Egresso egresso);

}
