package testeMain;

import java.text.DecimalFormat;
import java.util.List;

import ResolveSistema.MetodoGauss;
import ResolveSistema.MetodoJacobbi;
import ZeroFuncao.zeroFuncao;

public class Main {

	public static void main(String[] args) {
		double[][]a = new double[3][4];
		a[0][0]=-5;
		a[0][1]=1;
		a[0][2]=-2;
		a[0][3]=0;
		a[1][0]=2;
		a[1][1]=4;
		a[1][2]=-2;
		a[1][3]=3;
		a[2][0]=1;
		a[2][1]=-1;
		a[2][2]=6;
		a[2][3]=2;
		double[]variaveis= {1,1,-6};
		zeroFuncao zf= new zeroFuncao();
		double i = zf.derivada(variaveis, 1);
		double h=zf.metodoSecantes(variaveis, 1.5, 1.7, 0);
		System.out.println(h);
	}	

}
