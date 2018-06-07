package org.mvpigs.commandpattern;

import org.mvpigs.commandpattern.interfaces.Pedido;
import org.mvpigs.commandpattern.interfaces.PedidoPeligroso;
import org.mvpigs.commandpattern.interfaces.TratamientoPedido;
import org.mvpigs.commandpattern.pedidos.PedidoInternacional;
import org.mvpigs.commandpattern.pedidos.PedidoPeligrosoOrden;
import org.mvpigs.commandpattern.procesadores.Oficina;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoInternacional;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoPeligroso;

/**
 * Crea una oficina que procesa pedidos.
 * 
 * En funcion de si el tratamiento del pedido es posible o no
 * la oficina procesa el pedido (true /false) 
 * e informa de su estado (aceptado /rechazado).
 * 
 * Como los pedidos pueden ser de multiples tipos, 
 * muchos de ellos aun desconocidos y cada uno 
 * con sus particularidades propias,
 * vamos a usar el patron COMMAND.
 * 
 * Consulta el manual de referencia para ver un ejemplo del patron.
 * 
 * Aplicando el patron COMMAND no procesaremos pedidos,
 * sino que le pasaremos a la oficina /procesador
 * el tipo de tratamiento que ha de aplicar a cada pedido,
 * y sera el propio pedido el que decida como debe ser tratado.
 * 
 * PASA LOS CASOS TEST PROPUESTOS y utilizalos como guia para el desarrollo. 
 * 
 * La clase App.java contiene el main y ha de funcionar.
 * 
 * - Crea un proyecto Maven que incluya tu nombre y apellidos.
 * - Realiza commits periódicamente mientras avanzas en el desarrollo de la aplicación.
 * - Publica tu solucion en GitHub.
 * - Enviame tu proyecto comprimido en un ZIP a gelpiorama@gmail.com
 * 
 * No olvides dibujar a mano alzada el diagrama de clases UML de tu solucion
 * para completar la evaluacion de la parte practica de ED. 
 */

public class App {

    public static void main(String[] args) {

        Oficina oficina = new Oficina();

        Pedido pedido = new PedidoInternacional("Comarca", 10);
        TratamientoPedido tratamientoInt = new TratamientoPedidoInternacional(
                                                    (PedidoInternacional) pedido);
        System.out.println(oficina.printarStatus(oficina.procesa(tratamientoInt), pedido));

        pedido = new PedidoInternacional("Mordor", 10);
        tratamientoInt = new TratamientoPedidoInternacional((PedidoInternacional) pedido);
        System.out.println(oficina.printarStatus(oficina.procesa(tratamientoInt), pedido));

        pedido = new PedidoPeligrosoOrden("Cima de los vientos", 
                                          "no limpiarse las uñas con este puñal");
        TratamientoPedido peligroso = new TratamientoPedidoPeligroso((PedidoPeligroso) pedido);
        System.out.println(oficina.printarStatus(oficina.procesa(peligroso), pedido));

        pedido = new PedidoPeligrosoOrden("Monde del destino", 
                                          "no ponerselo en el dedo");
        peligroso = new TratamientoPedidoPeligroso((PedidoPeligroso) pedido);
        System.out.println(oficina.printarStatus(oficina.procesa(peligroso), pedido));   
    }
}
