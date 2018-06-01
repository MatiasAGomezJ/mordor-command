package org.mvpigs;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.mvpigs.interfaces.*;
import org.mvpigs.pedidos.*;
import org.mvpigs.procesadores.*;
import org.mvpigs.tratamientos.*;

public class TestPedidos {

    @Test
	public void test_Mordor() {		
		TratamientoPedido tratamientoKO = new TratamientoPedidoInternacional(new PedidoInternacional("Mordor", 100));
		assertFalse(tratamientoKO.tratar());		
	}

	@Test
	public void test_Comarca() {
		TratamientoPedido tratamientoOK = new TratamientoPedidoInternacional(new PedidoInternacional("Comarca", 100));
		assertTrue(tratamientoOK.tratar());
    }

    @Test
    public void test_pedido_peligroso_KO() {
        TratamientoPedido tratamientoKO = new TratamientoPedidoPeligroso(new PedidoPeligrosoOrden("no ponerselo en el dedo"));
        assertFalse(tratamientoKO.tratar());
    }

    @Test
    public void test_pedido_peligroso_OK() {
        TratamientoPedido tratamientoOK = new TratamientoPedidoPeligroso(new PedidoPeligrosoOrden("no limpiarse las uñas con este puñal"));
        assertTrue(tratamientoOK.tratar());
    }

    @Test
    public void test_UUID_generator() {
        PedidoInternacional internacional = new PedidoInternacional("Mordor", 10);
        PedidoPeligrosoOrden peligroso = new PedidoPeligrosoOrden("no limpiarse las uñas con este puñal");
        assertTrue(internacional.getId() != peligroso.getId());
    }

    @Test
    public void test_interface_procesador() {
        Procesador procesador = new Oficina();
        TratamientoPedido pedidoInt = new TratamientoPedidoInternacional(new PedidoInternacional("Comarca", 100));
        procesador.recibe(pedidoInt);
    }

    @Test
    public void test_pedido_nacional_UUDI() {
        PedidoInternacional internacional = new PedidoInternacional("Mordor", 10);
        PedidoNacional nacional = new PedidoNacional("Gondor", 50);
        assertTrue(internacional.getId() != nacional.getId());
    }

    @Test
    public void test_calcular_peso_total() {
        Set<Pedido> pedidos = new HashSet<>();
        List<String> destinos = Arrays.asList("Gondor", "Minas Tirith", "Rohan");
        List<Integer> pesos = Arrays.asList(10, 10, 10);

    }

    @Test
    public void test_tratamiento_pedido_multiple_tratar() {
        /**
         * Crea una colección de tres pedidos a "Gondor", "Minas Tirith", "Rohan"
         * con un peso de 10 cada uno
         * 
         * Pasasela a TratamientoPedidosMultiple en su constructor
         * 
         * Completa los metodos calcularTotalBultos del pedido multiple
         * y calcularNumeroBultos del pedido
         */
        Set<Pedido> pedidos = new HashSet<>();
        List<String> destinos = Arrays.asList("Gondor", "Minas Tirith", "Rohan");
        List<Integer> pesos = Arrays.asList(10, 10, 10);
        
        for (int i=0; i<destinos.size(); i++) {
            pedidos.add(new PedidoNacional(destinos.get(i), pesos.get(i)));
        }
        assertTrue(pedidos.size() == 3);

        TratamientoPedidoMultiple pedidosMult = new TratamientoPedidoMultiple(pedidos);
        pedidosMult.calcularTotalBultos();
        assertEquals(3, pedidosMult.getNumBultos(), 0);
        pedidosMult.calcularPesoTotal();
        assertEquals(30, pedidosMult.getPesoTotal(), 0);
        assertTrue(pedidosMult.tratar());
    }
}