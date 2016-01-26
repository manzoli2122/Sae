package sae.core.application;

import javax.ejb.Local;
import javax.faces.convert.Converter;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.core.domain.Curso;

@Local
public interface ManageCursoService  extends CrudService<Curso>{

	Converter getCursoConverter();

}
