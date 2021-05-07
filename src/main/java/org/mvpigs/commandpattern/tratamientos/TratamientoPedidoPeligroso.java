package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.interfaces.PedidoPeligroso;
import org.mvpigs.commandpattern.interfaces.TratamientoPedido;

public class TratamientoPedidoPeligroso implements TratamientoPedido {

	private PedidoPeligroso pedido = null;

	public TratamientoPedidoPeligroso(PedidoPeligroso pedido) {
		this.pedido = pedido;
	}

	public boolean tratar() {
		// tratar el pedido segun las instrucciones
		if (pedido.instrucciones().equals("No ponerselo en el dedo")) {
			return false;
		} else {
			return true; // si es false ... :-(
		}		 
	}

	public PedidoPeligroso getPedido() {
		return this.pedido;
	}
}
