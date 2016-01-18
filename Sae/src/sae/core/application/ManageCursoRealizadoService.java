package sae.core.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.core.domain.CursoRealizado;

@Local
public interface ManageCursoRealizadoService extends CrudService<CursoRealizado>{

}
