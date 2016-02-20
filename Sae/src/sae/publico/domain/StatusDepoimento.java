package sae.publico.domain;

public enum StatusDepoimento {

	
	P("Pendente"),
	A("Aprovada"),
	D("Desaprovada");
	
	
	private final String label;

	private StatusDepoimento(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }
	
	
}
