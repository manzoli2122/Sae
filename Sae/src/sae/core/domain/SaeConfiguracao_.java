package sae.core.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-04-13T15:10:07.384-0300")
@StaticMetamodel(SaeConfiguracao.class)
public class SaeConfiguracao_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<SaeConfiguracao, Date> creationDate;
	public static volatile SingularAttribute<SaeConfiguracao, String> smtpServerAddress;
	public static volatile SingularAttribute<SaeConfiguracao, Integer> smtpServerPort;
	public static volatile SingularAttribute<SaeConfiguracao, String> smtpUsername;
	public static volatile SingularAttribute<SaeConfiguracao, String> smtpPassword;
	public static volatile SingularAttribute<SaeConfiguracao, Administrador> administrador;
	public static volatile SingularAttribute<SaeConfiguracao, Date> envioEmailAtualizacao;
}
