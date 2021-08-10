package ResolveSistema;

/**
 * 
 * Classe que define o metodo de resolução de sistema de Gauss
 * 
 * @author Rubens
 *
 */

public class MetodoGauss {
	public double[][] eliminacao(double[][] sistema) {
		for (int i = 0; i < sistema.length; i++) {

			for (int j = i + 1; j < sistema.length; j++) {
				double m = sistema[j][i] / sistema[i][i];
				sistema[j][i] = 0;
				for (int k = i + 1; k < sistema.length; k++) {
					sistema[j][k] = sistema[j][k] - (sistema[i][k] * m);
				}
				sistema[j][sistema.length] = sistema[j][sistema.length] - (m * sistema[i][sistema.length]);

			}
		}
		return sistema;
	}

	public double[] resolucao(double[][] sistema) {
		sistema = eliminacao(sistema);
		double[] xis = new double[sistema.length];
		xis[xis.length-1] = sistema[sistema.length-1][sistema.length-1] / sistema[sistema.length-1][sistema.length - 1];
		for (int i = sistema.length - 1; i >= 0; i--) {
			double s = 0;
			for (int j = i + 1; j < xis.length; j++) {
				s=s+sistema[i][j]*xis[j];
			}
			xis[i]=(sistema[i][sistema.length]-s)/sistema[i][i];
		}
		return xis;
	}
}
