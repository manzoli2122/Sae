package sae.core.application;

import javax.ejb.Local;
import javax.faces.convert.Converter;

import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import sae.core.domain.Egresso;

@Local
public interface ManageEgressoService  extends CrudService<Egresso>{

	void sendEmailCadastro(Egresso entity);

	Converter getEgressoConverter();

}