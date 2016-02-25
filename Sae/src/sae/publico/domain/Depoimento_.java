package sae.publico.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sae.core.domain.Curso;
import sae.core.domain.Egresso;

@Generated(value="Dali", date="2016-02-20T08:52:42.331-0200")
@StaticMetamodel(Depoimento.class)
public class Depoimento_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Depoimento, String> conteudo;
	public static volatile SingularAttribute<Depoimento, Date> data_envio;
	public static volatile SingularAttribute<Depoimento, Egresso> autor;
	public static volatile SingularAttribute<Depoimento, Curso> curso;
	public static volatile SingularAttribute<Depoimento, Boolean> anonimo;
	public static volatile SingularAttribute<Depoimento, StatusDepoimento_Enum> status;
}
