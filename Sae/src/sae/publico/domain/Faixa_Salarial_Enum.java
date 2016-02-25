package sae.publico.domain;

public enum Faixa_Salarial_Enum {
	
	ATE_3_SM ("Até 3 salários mínimos"),
	DE_3_A_5_SM("De 3 a 5 salários mínimos"),
	DE_5_A_10_SM("De 5 a 10 salários mínimos"),
	DE_10_A_15_SM("De 10 a 15 salários mínimos"),
	DE_15_A_20_SM("De 15 a 20 salários mínimos"),
	MAIOR_20_SM("Mais de 20 salários mínimos");
	
	private final String label;

	private Faixa_Salarial_Enum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }

}
