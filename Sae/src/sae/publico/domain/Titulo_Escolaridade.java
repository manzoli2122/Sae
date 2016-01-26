package sae.publico.domain;

public enum Titulo_Escolaridade {

	Superior("Superior"),
	Especializacao("Especializacao"),
	Mestrado("Mestrado"),
	Doutorado("Doutorado"),
	Pos_Doutorado("Pos Doutorado");
	
	
	private final String label;

	private Titulo_Escolaridade(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }
}
