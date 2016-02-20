package sae.publico.domain;

public enum Titulo_Escolaridade {

	A_Superior("Superior"),
	B_Especializacao("Especializacao"),
	C_Mestrado("Mestrado"),
	D_Doutorado("Doutorado"),
	E_Pos_Doutorado("Pos Doutorado");
	
	
	private final String label;

	private Titulo_Escolaridade(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }
}
