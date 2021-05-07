package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.interfaces.PedidoPeligroso;
import org.mvpigs.commandpattern.interfaces.TratamientoPedido;

public class TratamientoPedidoPeligroso implements TratamientoPedido {

	private final PedidoPeligroso pedido;

	public TratamientoPedidoPeligroso(PedidoPeligroso pedido) {
		this.pedido = pedido;
	}

	public boolean tratar() {
		// tratar el pedido segun las instrucciones
		return ! pedido.instrucciones().equals("No ponerselo en el dedo");
	}

	public PedidoPeligroso getPedido() {
		return this.pedido;
	}
}
