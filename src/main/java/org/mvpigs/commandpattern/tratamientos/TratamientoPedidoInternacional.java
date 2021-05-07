package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.interfaces.TratamientoPedido;
import org.mvpigs.commandpattern.pedidos.PedidoInternacional;

public class TratamientoPedidoInternacional implements TratamientoPedido {

    private final PedidoInternacional pedido;

    public TratamientoPedidoInternacional(PedidoInternacional pedido) {
        this.pedido = pedido;
    }

	@Override
    public boolean tratar() {
        return ! pedido.destino().equals("Mordor");
    }

    public PedidoInternacional getPedido() {
        return this.pedido;
    }
}