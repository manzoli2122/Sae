package sae.core.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.core.domain.Seminario;

@Local
public interface ManageSeminarioService  extends CrudService<Seminario> {

}
