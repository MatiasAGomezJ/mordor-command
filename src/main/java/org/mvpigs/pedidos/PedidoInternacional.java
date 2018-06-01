package org.mvpigs.pedidos;

import java.util.UUID;

import org.mvpigs.interfaces.Pedido;

/**
 * No existe una unica clase Stock
 * Existe una clase específica de pedido
 * por cada tipo de pedido 
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
