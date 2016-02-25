package sae.core.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-02-25T14:03:57.987-0300")
@StaticMetamodel(Seminario.class)
public class Seminario_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Seminario, String> palestrante;
	public static volatile SingularAttribute<Seminario, Date> data_hora;
	public static volatile SingularAttribute<Seminario, String> local;
	public static volatile SingularAttribute<Seminario, AssuntoInteresse> assunto_interesse;
	public static volatile SingularAttribute<Seminario, String> titulo;
}
