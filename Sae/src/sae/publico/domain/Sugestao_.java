package sae.publico.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sae.core.domain.Curso;
import sae.core.domain.Egresso;

@Generated(value="Dali", date="2016-02-02T12:53:47.727-0200")
@StaticMetamodel(Sugestao.class)
public class Sugestao_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Sugestao, String> conteudo;
	public static volatile SingularAttribute<Sugestao, String> resposta;
	public static volatile SingularAttribute<Sugestao, Date> data_envio;
	public static volatile SingularAttribute<Sugestao, Egresso> autor;
	public static volatile SingularAttribute<Sugestao, Curso> curso;
}
