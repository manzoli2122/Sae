package sae.publico.domain;

public enum Area_Formacao {

	atua_na_area("Atua na Área"),
	atua_em_area_correlata("Atua em Área Correlata"),
	atua_em_area_nao_correlata("Atua em Área não Correlata");
	
	
	private final String label;

	private Area_Formacao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }
}
