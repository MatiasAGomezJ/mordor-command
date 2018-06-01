package org.mvpigs.tratamientos;

import java.util.Set;

import org.mvpigs.interfaces.Pedido;
import org.mvpigs.interfaces.TratamientoPedido;

public class TratamientoPedidoMultiple implements TratamientoPedido {

	// private List<Pedido> pedidos;
	private Set<Pedido> pedidos;
	private Integer pesoTotal = 0;
	private Long numBultos = 0L;

	public TratamientoPedidoMultiple(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public boolean tratar() {
		calcularPesoTotal();
		calcularTotalBultos();
		if (pesoTotal != 0 && numBultos == pedidos.size()) {
			return true;
		} else {
			return false;
		}
	}

	public Integer getPesoTotal() {
		return this.pesoTotal;
	}

	public Long getNumBultos() {
		return this.numBultos;
	}

	public void calcularPesoTotal() {
		this.pesoTotal = pedidos
							.stream()
							.map(Pedido::peso)
							.reduce(0, Integer::sum);
	}

	public void calcularTotalBultos() {
		this.numBultos = pedidos
							.stream()
							.count();
	}
}
