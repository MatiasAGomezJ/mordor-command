package org.mvpigs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.mvpigs.commandpattern.interfaces.Pedido;
import org.mvpigs.commandpattern.interfaces.Procesador;
import org.mvpigs.commandpattern.interfaces.TratamientoPedido;
import org.mvpigs.commandpattern.pedidos.PedidoInternacional;
import org.mvpigs.commandpattern.pedidos.PedidoNacional;
import org.mvpigs.commandpattern.pedidos.PedidoPeligrosoOrden;
import org.mvpigs.commandpattern.procesadores.Oficina;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoInternacional;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoMultiple;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoPeligroso;

public class TestPedidos {

    /**
     * Crea una clase TratamientoPedidoInternacional que permita tratar
     * pedidos internacionales.
     * La clase debe permitir tratar todos los pedidos excepto 
     * los que van a Mordor.
     */
    @Test
	public void test_Mordor() {		
        PedidoInternacional pedidoInt = new PedidoInternacional("Mordor", 100);
        assertEquals("Mordor", pedidoInt.destino());
		TratamientoPedido tratamientoKO = new TratamientoPedidoInternacional(pedidoInt);
        assertNotNull(tratamientoKO);
        assertFalse(tratamientoKO.tratar());			
	}

	@Test
	public void test_Comarca() {
		TratamientoPedido tratamientoOK = new TratamientoPedidoInternacional(new PedidoInternacional("Comarca", 100));
		assertTrue(tratamientoOK.tratar());
    }

    @Test
    public void test_pedido_peligroso_KO() {
        TratamientoPedido tratamientoKO = new TratamientoPedidoPeligroso(new PedidoPeligrosoOrden("Monte del destino", "no ponerselo en el dedo"));
        assertFalse(tratamientoKO.tratar());
    }

    @Test
    public void test_pedido_peligroso_OK() {
        TratamientoPedido tratamientoOK = new TratamientoPedidoPeligroso(new PedidoPeligrosoOrden("Cima de los vientos", "no limpiarse las uñas con este puñal"));
        assertTrue(tratamientoOK.tratar());
    }

    @Test
    public void test_UUID_generator() {
        PedidoInternacional internacional = new PedidoInternacional("Mordor", 10);
        PedidoPeligrosoOrden peligroso = new PedidoPeligrosoOrden("Cima de los vientos", "no limpiarse las uñas con este puñal");
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