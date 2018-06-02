package org.mvpigs.commandpattern;

import org.mvpigs.commandpattern.interfaces.Pedido;
import org.mvpigs.commandpattern.interfaces.Status;
import org.mvpigs.commandpattern.pedidos.PedidoInternacional;
import org.mvpigs.commandpattern.pedidos.PedidoPeligrosoOrden;
import org.mvpigs.commandpattern.procesadores.Oficina;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoInternacional;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoPeligroso;

public class App {

    public static void main(String[] args) {

        Oficina oficina = new Oficina();

        Pedido pedido = new PedidoInternacional("Comarca", 10);
        TratamientoPedidoInternacional tratamientoInt = new TratamientoPedidoInternacional((PedidoInternacional) pedido);
        printarStatus(oficina.recibe(tratamientoInt), tratamientoInt.getPedido());

        pedido = new PedidoInternacional("Mordor", 10);
        tratamientoInt = new TratamientoPedidoInternacional((PedidoInternacional) pedido);
        printarStatus(oficina.recibe(tratamientoInt), tratamientoInt.getPedido());

        TratamientoPedidoPeligroso peligroso = new TratamientoPedidoPeligroso(new PedidoPeligrosoOrden("Cima de los vientos", "no limpiarse las uñas con este puñal"));
        printarStatus(oficina.recibe(peligroso), peligroso.getPedido());

        peligroso = new TratamientoPedidoPeligroso(new PedidoPeligrosoOrden("Monde del destino", "no ponerselo en el dedo"));
        printarStatus(oficina.recibe(peligroso), peligroso.getPedido());

        // Tratamiento de pedidos multiples va en los casos test

        /**
         *  List<Pedido> pedidos = new ArrayList<>();

        PedidoNacional pedidoNacional = new PedidoNacional("Gondor", 10);
        pedidos.add(pedidoNacional);
        
        pedidoNacional = new PedidoNacional("Minas Tirith", 10);
        pedidos.add(pedidoNacional);

        pedidoNacional = new PedidoNacional("Roahn", 10);
        pedidos.add(pedidoNacional);

        TratamientoPedidoMultiple multiple = new TratamientoPedidoMultiple(pedidos);

         */
       
    }

    public static void printarStatus(boolean status, Pedido pedido) {
        if (status) {
            System.out.println(pedido.destino() + " " + Status.ACEPTADO.name());
        } else {
            System.out.println(pedido.destino() + " " + Status.RECHAZADO.name());
        }
    }

}
