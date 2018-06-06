package org.mvpigs.commandpattern.pedidos;

import java.util.UUID;

import org.mvpigs.commandpattern.interfaces.PedidoPeligroso;

/**
 * Existe una clase específica de pedido
 * para cada tipo de tratamiento  
 */

public class PedidoPeligrosoOrden implements PedidoPeligroso {

    private final String id;
	private String destino = null;
    private int peso = 0;
    private String instrucciones = null;
    
    public PedidoPeligrosoOrden(String destino, String instrucciones) {
        this.destino = destino;
        this.id = UUID.randomUUID().toString();
        this.instrucciones = instrucciones;
    }

	@Override
	public int peso() {
		return this.peso;
	}

	@Override
	public String instrucciones() {
		return this.instrucciones;
    }
    
    @Override
    public String destino() {
        return this.destino;
    }

    public String getId() {
        return this.id;
    }
}