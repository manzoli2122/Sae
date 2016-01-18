package sae.core.application;

import javax.ejb.Local;
import javax.faces.convert.Converter;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.core.domain.Assunto_Interesse;

@Local
public interface ManageAssunto_InteresseSevice extends CrudService<Assunto_Interesse>{
	public Converter getAssuntoConverter();

}
