package sae.publico.domain;

public enum StatusDepoimento {

	
	PENDENTE("Pendente"),
	APROVADO("Aprovada"),
	DESAPROVADO("Desaprovada");
	
	
	private final String label;

	private StatusDepoimento(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }
	
	
}
