package sae.publico.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;
import sae.core.domain.Egresso;




/**
 * CLASSE DE DOMMINIO QUE REPRESENTA O HISTORICO DO EGRESSO.
 * 
 * IMPLEMENTADA COM BASE NO Documento de Análise de Requisitos VERSÃO 1.4
 * 
 * <i>ESTA CLASSE FAZ PARTE DO SISTEMA SAE.</i>
 * 
 * @author BRUNO MANZOLI (manzoli2122@gmail.com)
 */

@Entity
public class HistoricoEgresso  extends PersistentObjectSupport implements Comparable<HistoricoEgresso> {

	
	private static final long serialVersionUID = 1L;
	
	
	/** EGRESSO DO HISTORICO */
	@NotNull
	@ManyToOne
	private Egresso egresso;
		
	
	/** DATA DE ENVIO DO HSTORICO */
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date data_envio;
	
	
	/** FAIXA SALARIAL DO EGREESO */
	@NotNull
	private Faixa_Salarial faixa_salarial;
	
	
	@NotNull
	private Area_Atuacao  area_atuacao ;
	
	
	/** SE O EGREESO RESIDE NO ES */
	@NotNull
	private Boolean reside_no_ES;
	
	
	
	
	
	
	
	/** SE O EGREESO ATUA NA AREA DE INFORMATICA */
	@NotNull
	private Area_Formacao atua_na_area;
	
	
	
	
	
	
	@Override
	public int compareTo(HistoricoEgresso  o) { 
		if (egresso == null)	return 1;
		if (o.egresso == null) return -1;
		int cmp = egresso.compareTo(o.egresso);
		if (cmp != 0 ) return cmp;
		
		if (data_envio == null)	return 1;
		if (o.data_envio == null) return -1;
		int cmpcpf = data_envio.compareTo(o.data_envio);
		if (cmpcpf != 0) return cmpcpf;
		
		return super.compareTo(o);
		
	}
	
	@Override
	public String toString() { return egresso.toString(); }

	
	
	
	/**  GETS AND SETS  */
	public Egresso getEgresso() { 	return egresso; }
	public void setEgresso(Egresso egresso) { this.egresso = egresso; }

	public Date getData_envio() { return data_envio; }
	public void setData_envio(Date data_envio) { this.data_envio = data_envio; }

	public Area_Formacao getAtua_na_area() { return atua_na_area; }
	public void setAtua_na_area(Area_Formacao atua_na_area) { this.atua_na_area = atua_na_area; }

	public Boolean getReside_no_ES() { return reside_no_ES; }
	public void setReside_no_ES(Boolean reside_no_ES) { this.reside_no_ES = reside_no_ES; }

	public Faixa_Salarial getFaixa_salarial() { return faixa_salarial; }
	public void setFaixa_salarial(Faixa_Salarial faixa_salarial) { this.faixa_salarial = faixa_salarial;}

	public Area_Atuacao getArea_atuacao() { return area_atuacao; }
	public void setArea_atuacao(Area_Atuacao area_atuacao) { this.area_atuacao = area_atuacao; }
		
	
}
