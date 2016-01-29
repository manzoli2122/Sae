package sae.core.persistence;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.core.domain.Curso;
import sae.core.domain.Egresso;

@Local
public interface CursoDAO extends BaseDAO<Curso>{

}
