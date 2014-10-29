package mz.co.lunguissa.function;

import mz.co.lunguissa.object.Funcionario;

public class Filtro {

	public void filtarPorSexo(char sexo, Funcionario[] lista) {
		for (Funcionario funcionario : lista) {

			if (sexo == 's' || sexo == 'S') {
				funcionario.toString();
			}

		}
	}

	public void filtarPorExp(String exp, Funcionario[] lista) {
		for (Funcionario funcionario : lista) {

			if (exp.equalsIgnoreCase(funcionario.getExp())) {
				funcionario.toString();
			}

		}
	}
}
