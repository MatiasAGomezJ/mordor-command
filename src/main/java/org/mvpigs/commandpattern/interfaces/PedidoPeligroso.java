package org.mvpigs.commandpattern.interfaces;

/**
 * La interfaz PedidoPeligroso implementa el metodo
 * instrucciones
 * @param   void
 * @return  String
 * 
 * Hereda de la interfaz Pedido
 * 
 * ISP
 */

public interface PedidoPeligroso extends Pedido {

     String instrucciones();

}
