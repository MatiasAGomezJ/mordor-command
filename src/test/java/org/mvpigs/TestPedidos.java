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
import org.mvpigs.commandpattern.interfaces.PedidoPeligroso;
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
     * 
     * La clase debe permitir tratar todos los pedidos excepto 
     * los que van a Mordor.
     * 
     * Crea las clases necesarias que se requieren en los casos test
     * respetando los constructores que se exigen.
     */
    @Test
	public void test_Mordor() {		
        Pedido pedidoInt = new PedidoInternacional("Mordor", 100);
        assertEquals("Mordor", pedidoInt.destino());

		TratamientoPedido tratamientoKO = new TratamientoPedidoInternacional((PedidoInternacional) pedidoInt);
        assertNotNull(tratamientoKO);
        assertFalse(tratamientoKO.tratar());			
	}

	@Test
	public void test_Comarca() {
        Pedido pedidoInt = new PedidoInternacional("Comarca", 100);
        assertEquals("Comarca", pedidoInt.destino());

		TratamientoPedido tratamientoOK = new TratamientoPedidoInternacional((PedidoInternacional) pedidoInt);
        assertNotNull(tratamientoOK);        
        assertTrue(tratamientoOK.tratar());
    }

    /**
     * Crea una clase TratamientoPedidoPeligroso que permita tratar
     * pedidos peligrosos.
     * 
     * La clase debe permitir tratar todos los pedidos segun sus
     * instrucciones excepto aquellos cuya instruccion sea 
     * "no ponerselo en el dedo". 
     * 
     * Crea las clases necesarias que se requieren en los casos test
     * respetando los constructores que se exigen.
     */
    @Test
    public void test_pedido_peligroso_KO() {
        Pedido pedidoConPeligro = new PedidoPeligrosoOrden("Monte del destino", "no ponerselo en el dedo");
        assertEquals("Monte del destino", pedidoConPeligro.destino());

        TratamientoPedido tratamientoKO = new TratamientoPedidoPeligroso((PedidoPeligroso) pedidoConPeligro);
        assertNotNull(tratamientoKO);
        assertFalse(tratamientoKO.tratar());
    }

    @Test
    public void test_pedido_peligroso_OK() {
        Pedido pedidoConPeligro = new PedidoPeligrosoOrden("Cima de los vientos", "no limpiarse las uñas con este puñal");
        assertEquals("Cima de los vientos", pedidoConPeligro.destino());

        TratamientoPedido tratamientoOK = new TratamientoPedidoPeligroso((PedidoPeligroso) pedidoConPeligro);
        assertTrue(tratamientoOK.tratar());
    }

    /**
     * Añade a las clases PedidoInternacional y PedidoPeligrosoOrden
     * una identificador Id de tipo String
     * autogenerado haciendo uso de la clase UUID de Java
     * https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html
     */
    @Test
    public void test_UUID_generator() {
        PedidoInternacional internacional = new PedidoInternacional("Mordor", 10);
        PedidoPeligrosoOrden peligroso = new PedidoPeligrosoOrden("Cima de los vientos", "no limpiarse las uñas con este puñal");
        assertNotNull(internacional.getId());
        assertNotNull(peligroso.getId());
        assertTrue(internacional.getId() != peligroso.getId());
    }

    /**
     * Añade una clase para los pedidos nacionales.
     */

    @Test
    public void test_pedido_nacional_UUDI() {
        PedidoInternacional internacional = new PedidoInternacional("Mordor", 10);
        assertNotNull(internacional);
        PedidoNacional nacional = new PedidoNacional("Gondor", 50);
        assertNotNull(nacional);
        assertTrue(internacional.getId() != nacional.getId());
    }
    
    /**
     * Construye una oficina que procese todo tipo de pedidos.
     * 
     * La oficina implementa la interfaz procesador.
     */

    @Test
    public void test_interface_procesador() {
        Procesador correos = new Oficina();
        TratamientoPedido pedidoInt = new TratamientoPedidoInternacional(new PedidoInternacional("Comarca", 100));
        assertTrue(correos.recibe(pedidoInt));

        TratamientoPedido pedidoConPeligro = new TratamientoPedidoPeligroso(new PedidoPeligrosoOrden("Cima de los vientos", "no limpiarse las uñas con este puñal"));
        assertTrue(correos.recibe(pedidoConPeligro));
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