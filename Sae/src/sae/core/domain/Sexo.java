package sae.core.domain;

public enum Sexo {
	Feminino("Feminino"),
	Masculino("Masculino");
	
	
	private final String label;

	private Sexo(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }

}
