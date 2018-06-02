package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.interfaces.TratamientoPedido;
import org.mvpigs.commandpattern.pedidos.PedidoInternacional;

public class TratamientoPedidoInternacional implements TratamientoPedido {

    private PedidoInternacional pedido = null;

    public TratamientoPedidoInternacional(PedidoInternacional pedido) {
        this.pedido = pedido;
    }

	@Override
    public boolean tratar() {
        if (pedido.destino().equals("Mordor")) {
            return false;
        } else {
            return true;
        }
    }

    public PedidoInternacional getPedido() {
        return this.pedido;
    }
}