package sae.publico.domain;

public enum Area_Formacao {

	ATUA_NA_AREA("Atua na Área"),
	ATUA_EM_AREA_CORRELATA("Atua em Área Correlata"),
	ATUA_EM_AREA_NAO_CORRELATA("Atua em Área não Correlata");
	
	
	private final String label;

	private Area_Formacao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }
}
