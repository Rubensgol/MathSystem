package ResolveSistema;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Classe que define o metodo de resolução de sistema Jacobi
 * 
 * @author Rubens
 *
 */
public class MetodoJacobbi {

	private int pLinha = 0;
	private double pErro = -1;

	/**
	 * construtor que recebe os dois atribuitos de parada
	 * 
	 * @param pLinha para parada no criterio de linha
	 * @param pErro  para parada no criterio de erro
	 */
	public MetodoJacobbi(int pLinha, double pErro) {
		this.pLinha = pLinha;
		this.pErro = pErro;
	}

	/**
	 * construtor que recebe o atribuito de parada de linha
	 * 
	 * @param pLinha para parada no criterio de linha
	 * 
	 */
	public MetodoJacobbi(int pLinha) {
		this.pLinha = pLinha;
	}

	/**
	 * construtor que recebe o atribuitos de parada de erro
	 * 
	 * @param pLinha para parada no criterio de linha
	 * 
	 */
	public MetodoJacobbi(double pErro) {
		this.pErro = pErro;
	}

	/**
	 * Metodo para prerapar o sistema para receber o meotodo de jacobi
	 * 
	 * @param sistema o sistema no formato double
	 * @return o sistema organizado
	 */
	public double[][] preparaSistema(double[][] sistema) {

		for (int i = 0; i < sistema.length; i++) {
			for (int j = 0; j < sistema.length; j++) {
				if (i == j)
					sistema[i][i] = 1 / sistema[i][i];
				else if (j <= sistema.length - 1)
					sistema[i][j] = -1 * sistema[i][j];
			}
		}
		return sistema;
	}
	/**
	 * O metodo recebe o sistema, arruma com o metodo preparaSsistem
	 * e resolve passo a passo ate um dos dois criterios serem atentido
	 * @see preparaSistema()
	 * @param sistema que vai ser resolvido mXm 
	 * @return retorna o sistema resolvido com todos os passos
	 */
	public List<double[]> resolveSistema(double[][] sistema) {
		DecimalFormat df = new DecimalFormat("#.####");
		sistema = preparaSistema(sistema);
		List<double[]> tabela = new ArrayList<double[]>();
		List<double[]> tabelaE = new ArrayList<double[]>();
		double[] xis;
		double[] erro;
		double paradaE = 0;
		int paradaL = 1;

		do {
			xis = new double[sistema.length];
			erro = new double[sistema.length];
			if (paradaL == 1) {
				for (int i = 0; i < sistema.length; i++) {
					xis[i] = sistema[i][i] * sistema[i][sistema[i].length - 1];
				}
				for (int i = 0; i < erro.length; i++) {
					erro[i] =xis[i];
				}

			} else {
				for (int i = 0; i < sistema.length; i++) {
					for (int j = 0; j < sistema.length; j++) {
						if (i != j) {
							xis[i] += sistema[i][j] * tabela.get(tabela.size() - 1)[j];
						}
					}

					xis[i] += sistema[i][sistema[i].length - 1];
					xis[i] *= sistema[i][i];
					xis[i] = Double.parseDouble(df.format(xis[i]).replace(',', '.'));
					if (paradaL > 1) {
						erro[i] = Math.abs(xis[i] - tabela.get(tabela.size() - 1)[i]);
						erro[i] = Double.parseDouble(df.format(erro[i]).replace(',', '.'));
					}

				}
			}
			tabela.add(xis);
			tabelaE.add(erro);

			paradaE = Arrays.stream(erro).max().getAsDouble();
			paradaL += 1;
		} while (pErro <= paradaE && pLinha >= paradaL);

		return tabelaE;
	}

}
