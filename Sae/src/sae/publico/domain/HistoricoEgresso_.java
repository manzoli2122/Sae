package sae.publico.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sae.core.domain.Egresso;

@Generated(value="Dali", date="2016-02-25T14:42:55.123-0300")
@StaticMetamodel(HistoricoEgresso.class)
public class HistoricoEgresso_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<HistoricoEgresso, Egresso> egresso;
	public static volatile SingularAttribute<HistoricoEgresso, Date> data_envio;
	public static volatile SingularAttribute<HistoricoEgresso, Faixa_Salarial> faixa_salarial;
	public static volatile SingularAttribute<HistoricoEgresso, Area_Atuacao> area_atuacao;
	public static volatile SingularAttribute<HistoricoEgresso, Boolean> reside_no_ES;
	public static volatile SingularAttribute<HistoricoEgresso, Area_Formacao> atua_na_area;
}
