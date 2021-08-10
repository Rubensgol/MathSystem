package ZeroFuncao;

public class zeroFuncao {
	public double[] baskara(double[] variaveis) {
		if (variaveis.length > 3)
			return null;
		else {
			double zeros[] = new double[2];
			double delta = (variaveis[1] * variaveis[1]) - (4 * variaveis[0] * variaveis[2]);
			zeros[0] = ((-1 * variaveis[1]) - Math.sqrt(delta)) / 2 * variaveis[0];
			zeros[1] = ((-1 * variaveis[1]) + Math.sqrt(delta)) / 2 * variaveis[0];
			return zeros;
		}

	}

	public double bissecao(double[] variaveis, double a, double b, double erro) {
		double x = 0;
		double erroT = erro + 1;
		double fxa;
		double fxb;
		double fxx;
		while (erroT > erro) {
			x = (a + b) / 2;
			fxa = resolveEquacao(variaveis, a);
			fxb = resolveEquacao(variaveis, b);
			fxx = resolveEquacao(variaveis, x);
			if (fxa * fxx < 0)
				b = x;
			else
				a = x;
			erroT = Math.abs(fxx);
		}

		return x;
	}

	public double resolveEquacao(double[] variaveis, double x) {
		double resultado = 0;
		for (int i = 0; i < variaveis.length - 1; i++) {
			double eleva = Math.pow(x, variaveis.length - i - 1);
			resultado += variaveis[i] * eleva;
		}
		resultado += variaveis[variaveis.length - 1];
		return resultado;
	}

	public double derivada(double[] variaveis, double x) {
		double resultado[] = new double[variaveis.length - 1];
		double deriva;
		for (int i = 0; i < variaveis.length - 1; i++) {
			resultado[i] = variaveis[i] * (variaveis.length - i - 1);

		}
		deriva = resolveEquacao(resultado, x);
		return deriva;
	}

	public double newtonRaphon(double[] variaveis, double a, double b, double erro) {
		double x = a;
		double erroT = erro + 1;
		double fx;
		double flx;
		while (erroT > erro) {
			fx = resolveEquacao(variaveis, x);
			flx = derivada(variaveis, x);
			x = x - fx / flx;
			erroT = Math.abs(resolveEquacao(variaveis, x));
		}
		return x;
	}

	public double metodoSecantes(double[] variaveis, double a, double b, double erro) {
		double x = a;
		double x2 = b;
		double erroT = erro + 1;
		double fxa;
		double fxb;
		while (erroT > erro) {
			fxa=resolveEquacao(variaveis, x);
			fxb=resolveEquacao(variaveis, x2);
			a=x;
			x =x-((x-x2)/(fxa-fxb))*fxa;
			x2=b;
			erroT = Math.abs(resolveEquacao(variaveis, x));
		}
		return x;
	}
}
