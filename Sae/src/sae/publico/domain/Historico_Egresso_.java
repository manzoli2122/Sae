package sae.publico.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sae.core.domain.Egresso;

@Generated(value="Dali", date="2016-02-02T16:14:42.200-0200")
@StaticMetamodel(Historico_Egresso.class)
public class Historico_Egresso_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Historico_Egresso, Egresso> egresso;
	public static volatile SingularAttribute<Historico_Egresso, Date> data_envio;
	public static volatile SingularAttribute<Historico_Egresso, Boolean> atua_na_area;
	public static volatile SingularAttribute<Historico_Egresso, Boolean> reside_no_ES;
	public static volatile SingularAttribute<Historico_Egresso, Faixa_Salarial> faixa_salarial;
	public static volatile SingularAttribute<Historico_Egresso, Area_Atuacao> area_atuacao;
}