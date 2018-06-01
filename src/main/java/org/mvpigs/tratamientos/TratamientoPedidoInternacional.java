package org.mvpigs.tratamientos;

import org.mvpigs.interfaces.TratamientoPedido;
import org.mvpigs.pedidos.PedidoInternacional;

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