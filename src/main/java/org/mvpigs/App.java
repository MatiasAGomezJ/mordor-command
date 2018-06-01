package org.mvpigs;

import org.mvpigs.interfaces.*;
import org.mvpigs.pedidos.*;
import org.mvpigs.tratamientos.*;
import org.mvpigs.procesadores.Oficina;

public class App {

    public static void main(String[] args) {

        Oficina oficina = new Oficina();

        Pedido pedido = new PedidoInternacional("Comarca", 10);
        TratamientoPedido tratamientoInt = new TratamientoPedidoInternacional((PedidoInternacional) pedido);
        printarStatus(oficina.recibe(tratamientoInt), tratamientoInt);

        pedido = new PedidoInternacional("Mordor", 10);
        tratamientoInt = new TratamientoPedidoInternacional((PedidoInternacional) pedido);
        printarStatus(oficina.recibe(tratamientoInt), tratamientoInt);

        TratamientoPedido peligroso = new TratamientoPedidoPeligroso(new PedidoPeligrosoOrden("no limpiarse las uñas con este puñal"));
        printarStatus(oficina.recibe(peligroso), peligroso);

        peligroso = new TratamientoPedidoPeligroso(new PedidoPeligrosoOrden("no ponerselo en el dedo"));
        printarStatus(oficina.recibe(peligroso), peligroso);

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

    public static void printarStatus(boolean status, TratamientoPedido tratamiento) {
        if (status) {
            System.out.println(tratamiento.getClass().getSimpleName() + " " + Status.ACEPTADO.name());
        } else {
            System.out.println(tratamiento.getClass().getSimpleName() + " " + Status.RECHAZADO.name());
        }
    }

}
