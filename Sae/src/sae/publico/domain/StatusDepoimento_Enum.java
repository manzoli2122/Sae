package sae.publico.domain;

public enum StatusDepoimento_Enum {

	
	P("Pendente"),
	A("Aprovada"),
	D("Desaprovada");
	
	
	private final String label;

	private StatusDepoimento_Enum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }
	
	
}
