package sae.publico.domain;

public enum Area_Atuacao_Enum {
	EMPREENDEDOR("Empreendedor"),
	FUNCIONARIO_PUBLICO("Funcionário Público"),
	FUNCIONARIO_PRIVADO("Funcionário Privado"),
	PROFESSOR("Professor"),
	PESQUISADOR("Pesquisador");
	
	
	private final String label;

	private Area_Atuacao_Enum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }

}
