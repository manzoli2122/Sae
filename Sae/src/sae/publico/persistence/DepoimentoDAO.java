package sae.publico.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;
import sae.publico.domain.Depoimento;

@Local
public interface DepoimentoDAO extends BaseDAO<Depoimento>{

}