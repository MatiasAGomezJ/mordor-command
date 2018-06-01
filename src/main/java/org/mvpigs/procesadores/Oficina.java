package org.mvpigs.procesadores;

import org.mvpigs.interfaces.Procesador;
import org.mvpigs.interfaces.TratamientoPedido;

public class Oficina implements Procesador {

	@Override
	public boolean recibe(TratamientoPedido tratamiento) {
				
        if (tratamiento.tratar()) {
			return true;
		} else {
			return false;
		}
        	
	}
}