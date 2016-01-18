package sae.core.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-22T14:56:48.861-0200")
@StaticMetamodel(Historico_Egresso.class)
public class Historico_Egresso_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Historico_Egresso, Egresso> egresso;
	public static volatile SingularAttribute<Historico_Egresso, Date> data_envio;
	public static volatile SingularAttribute<Historico_Egresso, Boolean> atua_na_area;
	public static volatile SingularAttribute<Historico_Egresso, Boolean> reside_no_ES;
	public static volatile SingularAttribute<Historico_Egresso, Faixa_Salarial> faixa_salarial;
}
