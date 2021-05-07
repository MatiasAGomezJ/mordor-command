package org.mvpigs.commandpattern.procesadores;

import org.mvpigs.commandpattern.interfaces.Pedido;
import org.mvpigs.commandpattern.interfaces.Procesador;
import org.mvpigs.commandpattern.interfaces.Status;
import org.mvpigs.commandpattern.interfaces.TratamientoPedido;

public class Oficina implements Procesador {

	@Override
	public boolean procesa(TratamientoPedido tratamiento) {
				
        return tratamiento.tratar();        	
	}

	public String printarStatus(boolean status, Pedido pedido) {
        return status? 
				pedido.destino() + " " + Status.ACEPTADO.name():
				pedido.destino() + " " + Status.RECHAZADO.name();
    }
}