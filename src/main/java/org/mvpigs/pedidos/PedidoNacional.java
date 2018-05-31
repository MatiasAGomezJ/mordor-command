package org.formacion.command;

import java.util.UUID;

public class PedidoNacional implements Pedido {

	private final String id;
	private String destino = null;
	private int peso = 0;
	
	public PedidoNacional(String destino, int peso) {
		this.id = UUID.randomUUID().toString();
		this.destino = destino;
		this.peso = peso;
	}
    
	@Override
	public int peso() {
		return peso;
	}

	public String getId() {
		return this.id;
	}

	@Override
	public String destino() {
        return this.destino;
    }
}