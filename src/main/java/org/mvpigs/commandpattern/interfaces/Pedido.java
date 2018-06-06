package org.mvpigs.commandpattern.interfaces;

/**
 * La interfaz Pedido implementa los metodos:
 * 
 * peso
 * @param 		none
 * @return      el peso del pedido
 * 
 * destino()
 * @param 		none
 * @return 		el destino del pedido
 */

public interface Pedido {
	
	public int peso();
	public String destino();

}
