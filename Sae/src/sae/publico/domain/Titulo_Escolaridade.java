package sae.publico.domain;

public enum Titulo_Escolaridade {

	A_SUPERIOR("Superior"),
	B_ESPECIALIZACAO("Especializacao"),
	C_MESTRADO("Mestrado"),
	D_DOUTORADO("Doutorado"),
	E_POS_DOUTORADO("Pos Doutorado");
	
	
	private final String label;

	private Titulo_Escolaridade(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }
}
