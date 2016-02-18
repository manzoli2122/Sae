package sae.publico.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;
import sae.core.domain.Curso;
import sae.publico.application.ConsultaService;
import sae.publico.domain.Area_Atuacao;
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
	
	private PieChartModel grafico_sexo, areaAtuacao, faixaSalarial , residencia , faixa_residencia, faixa_empreendedor , faixa_professor ;
	
	private List<Historico_Egresso>  historicos;
 
	private int numeroFaixaResidencial, numeroFaixaEmpreendedor , numeroFaixaProfessor;
	
	
	
	
	
	
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
			
		Iterator<Historico_Egresso> iterator = historicos.iterator();
		Faixa_Salarial[] faixas = Faixa_Salarial.values();
		
		
		
		int[] valor = new int[faixas.length] ;
		int[] valor_empreendedor = new int[faixas.length] ;
		int[] valor_professor = new int[faixas.length] ;
		
		
		
		faixa_residencia = new PieChartModel();
		faixa_empreendedor = new PieChartModel();
		faixa_professor = new PieChartModel();
		
		
		
		numeroFaixaResidencial=0;
		numeroFaixaEmpreendedor=0;
		numeroFaixaProfessor=0;
		
		
		
		while(iterator.hasNext()){
			
			Historico_Egresso hh = iterator.next();
			Faixa_Salarial ff = hh.getFaixa_salarial();
			
			if(hh.getArea_atuacao().equals(Area_Atuacao.professor)){
				for(int i = 0 ; i < faixas.length ; i++ ){
					if(  ff.equals(faixas[i])  ){
						valor_professor[i]++;
						numeroFaixaProfessor++;
						break;
					}
				}
			}
			
			
			if(hh.getArea_atuacao().equals(Area_Atuacao.empreendedor)){
				for(int i = 0 ; i < faixas.length ; i++ ){
					if(  ff.equals(faixas[i])  ){
						valor_empreendedor[i]++;
						numeroFaixaEmpreendedor++;
						break;
					}
				}
			}
			
			
			if(hh.getReside_no_ES()){
				for(int i = 0 ; i < faixas.length ; i++ ){
					if(  ff.equals(faixas[i])  ){
						valor[i]++;
						numeroFaixaResidencial++;
						break;
					}
				}
			}
			
			
			
			
		}
		
		for(int i = 0 ; i < faixas.length ; i++ ){
			faixa_residencia.set(faixas[i].getLabel(),valor[i]);
			faixa_empreendedor.set(faixas[i].getLabel(),valor_empreendedor[i]);
			faixa_professor.set(faixas[i].getLabel(),valor_professor[i]);
		}
		
		
		faixa_professor.setTitle("Egressos Professores");
		faixa_professor.setLegendPosition("s");
		faixa_professor.setShowDataLabels(true);
		faixa_professor.setSeriesColors("dd6542,E7982F,E4F20A,0AC9F2,7a86db,6a9660");
	    faixa_professor.setDiameter(250);
		
		
		
		faixa_empreendedor.setTitle("Egressos Empreendedores");
		faixa_empreendedor.setLegendPosition("s");
		faixa_empreendedor.setShowDataLabels(true);
		faixa_empreendedor.setSeriesColors("dd6542,E7982F,E4F20A,0AC9F2,7a86db,6a9660");
	    faixa_empreendedor.setDiameter(250);
		
		
		faixa_residencia.setTitle("Egressos Residente no Espirito Santo");
		faixa_residencia.setLegendPosition("s");
		faixa_residencia.setShowDataLabels(true);
		faixa_residencia.setSeriesColors("dd6542,E7982F,E4F20A,0AC9F2,7a86db,6a9660");
	    //faixaSalarial.setDataFormat("value percent");
		faixa_residencia.setDiameter(250);
			
		return getViewPath() + "faixa.xhtml?faces-redirect=" + getFacesRedirect();
	}
		
	public PieChartModel getFaixa_Resisdencia() {  return faixa_residencia;   }
	public PieChartModel getFaixa_Empreendedor() {  return faixa_empreendedor;   }
	public PieChartModel getFaixa_Professor() {  return faixa_professor;   }
		
		
	
	
	
	
	
	
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
		faixaSalarial.setTitle("Todos os Egressos");
		faixaSalarial.setLegendPosition("s");
        faixaSalarial.setShowDataLabels(true);
        //faixaSalarial.setDataFormat("value percent");
		faixaSalarial.setDiameter(250);
		//faixaSalarial.setSeriesColors("c95939,E7982F,E4F20A,0AC9F2,2C0AF2,178504");
		faixaSalarial.setSeriesColors("dd6542,E7982F,E4F20A,0AC9F2,7a86db,6a9660");
		
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
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
public String consulta_Area_Atuacao() {
		
		areaAtuacao = new PieChartModel();
		Iterator<Historico_Egresso> iterator = historicos.iterator();
		
		Area_Atuacao[] areas = Area_Atuacao.values();
		
		int[] valor = new int[areas.length] ;
		
		while(iterator.hasNext()){
			Area_Atuacao aa = iterator.next().getArea_atuacao();
			for(int i = 0 ; i < areas.length ; i++ ){
				if(  aa.equals(areas[i])  ){
					valor[i]++;
					break;
				}
			}
		}
		for(int i = 0 ; i < areas.length ; i++ ){
			areaAtuacao.set(areas[i].getLabel(),valor[i]);
		}
		areaAtuacao.setTitle("Todos os Egressos");
		areaAtuacao.setLegendPosition("s");
		areaAtuacao.setShowDataLabels(true);
        areaAtuacao.setDiameter(250);
        //areaAtuacao.setSeriesColors("dd6542,E7982F,E4F20A,0AC9F2,7a86db,6a9660");
        areaAtuacao.setSeriesColors("dd6542,E7982F,0AC9F2,7a86db,6a9660");
		
		return getViewPath() + "atuacao.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	public PieChartModel getAreaAtuacao() {  return areaAtuacao;   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public String consulta_Sexo() {
		
		grafico_sexo = new PieChartModel();
		Iterator<Historico_Egresso> iterator = historicos.iterator();
		
		int feminino = 0 ;
		
		while(iterator.hasNext()){
			Character ss = iterator.next().getEgresso().getSexo();
			if(  ss.equals('F')  ){
				feminino++;
			}
			
		}
		
		grafico_sexo.set("Feminino", feminino);
		grafico_sexo.set("Masculino", (historicos.size()-feminino));
		
		
		grafico_sexo.setTitle("Todos os Egressos");
		grafico_sexo.setLegendPosition("s");
		grafico_sexo.setShowDataLabels(true);
		grafico_sexo.setDiameter(250);
        grafico_sexo.setSeriesColors("dd6542,7a86db");
		
		return getViewPath() + "sexo.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	public PieChartModel getGrafico_sexo() {  return grafico_sexo;   }
	
	
	 
	 
	 
	 
	
	

	public Curso getCurso() { return curso; }
	public void setCurso(Curso curso) { this.curso = curso; }
	
	public int getNumeroEgreso() { return historicos.size(); }

	public int getNumeroFaixaResidencial() { return numeroFaixaResidencial; }

	public int getNumeroFaixaEmpreendedor() { return numeroFaixaEmpreendedor; }
	
	public int getNumeroFaixaProfessor() { return numeroFaixaProfessor; }

	
	
	
	
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
