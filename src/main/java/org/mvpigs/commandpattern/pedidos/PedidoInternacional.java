package org.mvpigs.commandpattern.pedidos;

import java.util.UUID;

import org.mvpigs.commandpattern.interfaces.Pedido;

/**
 * Existe una clase específica de pedido
 * para cada tipo de tratamiento  
 */

public class PedidoInternacional implements Pedido {

 	private final String id;
	private String destino;
	private int peso;
	
	public PedidoInternacional(String destino, int peso) {
		// https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html
		this.id = UUID.randomUUID().toString();
		this.destino = destino;
		this.peso = peso;
	}

	@Override
	public int peso() {
		return peso;
	}

	@Override
	public String destino() {
		return destino;
	}

	public String getId() {
		return this.id;
	}

}
