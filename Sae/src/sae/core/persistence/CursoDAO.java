package sae.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Curso;

@Local
public interface CursoDAO extends BaseDAO<Curso>{

}
