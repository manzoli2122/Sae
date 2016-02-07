package sae.publico.domain;

public enum Area_Atuacao {
	empreendedor("Empreendedor"),
	funcionario_publico("Funcionário Público"),
	funcionario_privado("Funcionário Privado"),
	professor("Professor"),
	pesquisador("Pesquisador");
	
	
	private final String label;

	private Area_Atuacao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }

}
