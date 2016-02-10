package sae.publico.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;
import sae.core.domain.Curso;
import sae.publico.application.ConsultaService;
import sae.publico.domain.Faixa_Salarial;
import sae.publico.domain.Historico_Egresso;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@SessionScoped
public class ConsultaControl implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(ConsultaControl.class.getCanonicalName());
	
	@EJB 
	private ConsultaService consultaService;

	protected String viewPath;
	
	protected String bundleName;
	
	private Curso curso;
	
	private PieChartModel faixaSalarial , residencia , faixa_residencia ;
	
	private List<Historico_Egresso>  historicos;
 
	
	
	/*   CONSTRUTOR DA CLASSE */
	public ConsultaControl(){
		 viewPath = "/consulta/";
	     bundleName = "msgs";
	}
	
	public boolean getFacesRedirect() { return true; }
	
	public String getViewPath() {return viewPath;	}
	
	
	public String list() {
		
		logger.log(Level.INFO, "LIST CONSULTA ");
		return getViewPath() + "index.xhtml?faces-redirect=" + getFacesRedirect();
	}
	

	
	public String selectGrafico(){
		historicos = consultaService.consultaHistoricos(curso);
		return getViewPath() + "curso.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	
	// FUNCÕES DE FAIXA SALARIAL
	
	public String consulta_faixa_residencia() {
			
		faixa_residencia = new PieChartModel();
		Iterator<Historico_Egresso> iterator = historicos.iterator();
		Faixa_Salarial[] faixas = Faixa_Salarial.values();
		int[] valor = new int[faixas.length] ;
		
		while(iterator.hasNext()){
			Historico_Egresso hh = iterator.next();
			if(hh.getReside_no_ES()){
				Faixa_Salarial ff = hh.getFaixa_salarial();
				
				for(int i = 0 ; i < faixas.length ; i++ ){
					if(  ff.equals(faixas[i])  ){
						valor[i]++;
						break;
					}
				}
			}
		}
		
		for(int i = 0 ; i < faixas.length ; i++ ){
			faixa_residencia.set(faixas[i].getLabel(),valor[i]);
		}
		faixa_residencia.setTitle("Faixa Salarial / Residencia");
		faixa_residencia.setLegendPosition("s");
		faixa_residencia.setShowDataLabels(true);
	    //faixaSalarial.setDataFormat("value percent");
		faixa_residencia.setDiameter(250);
			
		return getViewPath() + "faixa.xhtml?faces-redirect=" + getFacesRedirect();
	}
		
	public PieChartModel getFaixa_Resisdencia() {  return faixa_residencia;   }
		
		
	
	
	
	
	
	
	// FUNCÕES DE FAIXA SALARIAL
	
	public String consulta_faixa_salarial() {
		
		faixaSalarial = new PieChartModel();
		Iterator<Historico_Egresso> iterator = historicos.iterator();
		Faixa_Salarial[] faixas = Faixa_Salarial.values();
		int[] valor = new int[faixas.length] ;
		while(iterator.hasNext()){
			Faixa_Salarial ff = iterator.next().getFaixa_salarial();
			for(int i = 0 ; i < faixas.length ; i++ ){
				if(  ff.equals(faixas[i])  ){
					valor[i]++;
					break;
				}
			}
		}
		for(int i = 0 ; i < faixas.length ; i++ ){
			faixaSalarial.set(faixas[i].getLabel(),valor[i]);
		}
		faixaSalarial.setTitle("Faixa Salarial");
		faixaSalarial.setLegendPosition("s");
        faixaSalarial.setShowDataLabels(true);
        //faixaSalarial.setDataFormat("value percent");
		faixaSalarial.setDiameter(250);
		consulta_faixa_residencia();
		return getViewPath() + "faixa.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	public PieChartModel getFaixaSalarial() {  return faixaSalarial;   }
	
	
	
	
	
	
	
	
	// FUNCÕES DE RESIDENCIA
	
	public String consulta_Residencia() {
		
		residencia = new PieChartModel();
		Iterator<Historico_Egresso> iterator = historicos.iterator();
		int reside = 0, naoreside = 0;
		while(iterator.hasNext()){
			if(  iterator.next().getReside_no_ES()  ){
				reside++;
			}
			else {
				naoreside++;
			}
		}
		residencia.set("Reside no ES",reside);
		residencia.set("Não Reside no ES",naoreside);
		
		residencia.setTitle("Reside no Espirito Santo");
		residencia.setLegendPosition("s");
		residencia.setShowDataLabels(true);
		residencia.setDiameter(250);
		
		return getViewPath() + "residencia.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	public PieChartModel getResidencia() {  return residencia;   }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	

	public Curso getCurso() { return curso; }
	public void setCurso(Curso curso) { this.curso = curso; }
	
	public int getNumeroEgreso() { return historicos.size(); }
	
	
	
	
	/*
	public String faixa_salarial() {
		long tempoInicio = System.currentTimeMillis();
		faixaSalarial = new PieChartModel();
		Faixa_Salarial[] faixas = Faixa_Salarial.values();
		for(int i = 0 ; i < faixas.length ; i++ ){
			faixaSalarial.set(faixas[i].getLabel(),consultaService.countFaixaSalarial(faixas[i], curso));
		}
		faixaSalarial.setTitle("Faixa Salarial");
		faixaSalarial.setLegendPosition("s");
        //pieModel1.setFill(false);
		faixaSalarial.setShowDataLabels(true);
		faixaSalarial.setDiameter(250);
		
		System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
		
		return getViewPath() + "faixa.xhtml?faces-redirect=" + getFacesRedirect();
	}
	*/
	
}
