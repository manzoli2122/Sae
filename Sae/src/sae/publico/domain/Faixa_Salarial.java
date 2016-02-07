package sae.publico.domain;

public enum Faixa_Salarial {
	
	ate_3_salarios_minimos ("Até 3 salários mínimos"),
	de_3_a_5_salarios_minimos("De 3 a 5 salários mínimos"),
	de_5_a_10_salarios_minimos("De 5 a 10 salários mínimos"),
	de_10_a_15_salarios_minimos("De 10 a 15 salários mínimos"),
	de_15_a_20_salarios_minimos("De 15 a 20 salários mínimos"),
	maior_20_salarios_minimos("Mais de 20 salários mínimos");
	
	private final String label;

	private Faixa_Salarial(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
    }

}
