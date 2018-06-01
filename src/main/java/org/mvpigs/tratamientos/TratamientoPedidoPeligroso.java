package org.mvpigs.tratamientos;

import org.mvpigs.interfaces.PedidoPeligroso;
import org.mvpigs.interfaces.TratamientoPedido;

public class TratamientoPedidoPeligroso implements TratamientoPedido {

	private PedidoPeligroso pedido = null;

	public TratamientoPedidoPeligroso(PedidoPeligroso pedido) {
		this.pedido = pedido;
	}

	public boolean tratar() {
		// tratar el pedido segun las instrucciones
		if (pedido.instrucciones().equals("no ponerselo en el dedo")) {
			return false;
		} else {
			return true; // si es false ... :-(
		}		 
	}
}
