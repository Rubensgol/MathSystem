package ResolveSistema;
/**
 * 
 * @author Rubens
 *
 * @param <T> interface para os metodos de calculo de sistema
 */

public interface CalculaSistema<T> {
	/**
	 *  Metodo para organizar o sistema antes de aplicar o metodo
	 * @param sistema que seja quadrado de qualquer tipo de dado
	 * @return o sistema formatado da melhor maneira possivel para o calculo do metodo escolhido
	 */
	T organizaSistema(T sistema);
	 
	/**
	 * Calcula o resultado do sistema
	 * @param sistemaOrganizado
	 * @return
	 */
	T calculaSistema(T sistemaOrganizado);

}
