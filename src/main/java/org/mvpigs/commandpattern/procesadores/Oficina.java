package org.mvpigs.commandpattern.procesadores;

import org.mvpigs.commandpattern.interfaces.Pedido;
import org.mvpigs.commandpattern.interfaces.Procesador;
import org.mvpigs.commandpattern.interfaces.Status;
import org.mvpigs.commandpattern.interfaces.TratamientoPedido;

public class Oficina implements Procesador {

	@Override
	public boolean procesa(TratamientoPedido tratamiento) {
				
        if (tratamiento.tratar()) {
			return true;
		} else {
			return false;
		}        	
	}

	public String printarStatus(boolean status, Pedido pedido) {
        if (status) {
            return pedido.destino() + " " + Status.ACEPTADO.name();
        } else {
            return pedido.destino() + " " + Status.RECHAZADO.name();
        }
    }
}