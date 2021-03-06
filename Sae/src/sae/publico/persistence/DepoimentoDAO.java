package sae.publico.persistence;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Administrador;
import sae.core.domain.Curso;
import sae.core.domain.Egresso;
import sae.publico.domain.Depoimento;

@Local
public interface DepoimentoDAO extends BaseDAO<Depoimento>{

	List<Depoimento> retrieveAllMine(Egresso egresso);

	List<Depoimento> retrieveAllCurso(Curso curso);

	List<Depoimento> retrieveAllAnalisar(Administrador admin);

}
