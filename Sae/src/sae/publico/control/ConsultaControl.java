package sae.publico.control;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;
import sae.core.domain.Curso;
import sae.publico.application.ConsultaService;
import sae.publico.domain.Faixa_Salarial;
import java.io.Serializable;
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
	
	private PieChartModel faixaSalarial , residencia;
 
	
	
	/*   CONSTRUTOR DA CLASSE */
	public ConsultaControl(){
		 viewPath = "/consulta/";
	     bundleName = "msgs";
	}
	
	public boolean getFacesRedirect() { return true; }
	
	public String getViewPath() {return viewPath;	}
	
	
	
	
	
	// FUNCÕES DE FAIXA SALARIAL
	
	public String faixa_salarial() {
		
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
		
		return getViewPath() + "faixa.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	public PieChartModel getFaixaSalarial() {  return faixaSalarial;   }
	
	 
	 

	// FUNCÕES DE
	
	public String Reside() {
		
		residencia = new PieChartModel();
		
		residencia.set("Reside no ES",consultaService.countReside(true, curso));
		residencia.set("Não Reside no ES",consultaService.countReside(false, curso));
		
		residencia.setTitle("Reside no Espirito Santo");
		residencia.setLegendPosition("s");
		residencia.setShowDataLabels(true);
		residencia.setDiameter(250);
		
		return getViewPath() + "residencia.xhtml?faces-redirect=" + getFacesRedirect();
	}
	
	public PieChartModel getResidencia() {  return residencia;   }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	public String list() {
		//logger.log(Level.INFO, "Listing entities...");

		// Clears the selection.
		//selectedEntity = null;

		// Gets the entity count.
		//count();

		// Checks if the index of the listing should be changed and reload the page.
		//if (firstEntityIndex < 0) goFirst();
		//else if (lastEntityIndex > entityCount) goLast();
		//else retrieveEntities();

		// Goes to the listing.
		logger.log(Level.INFO, "LIST CONSULTA ");
		return getViewPath() + "index.xhtml?faces-redirect=" + getFacesRedirect();
	}

	public Curso getCurso() { return curso; }
	public void setCurso(Curso curso) { this.curso = curso; }
	
	
}
