package org.mvpigs.commandpattern;

import org.mvpigs.commandpattern.interfaces.Pedido;
import org.mvpigs.commandpattern.pedidos.PedidoInternacional;
import org.mvpigs.commandpattern.pedidos.PedidoPeligrosoOrden;
import org.mvpigs.commandpattern.procesadores.Oficina;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoInternacional;
import org.mvpigs.commandpattern.tratamientos.TratamientoPedidoPeligroso;

public class App {

    public static void main(String[] args) {

        Oficina oficina = new Oficina();

        Pedido pedido = new PedidoInternacional("Comarca", 10);
        TratamientoPedidoInternacional tratamientoInt = new TratamientoPedidoInternacional(
                                                                (PedidoInternacional) pedido);
        System.out.println(oficina.printarStatus(oficina.procesa(tratamientoInt), 
                                                 tratamientoInt.getPedido()));

        pedido = new PedidoInternacional("Mordor", 10);
        tratamientoInt = new TratamientoPedidoInternacional((PedidoInternacional) pedido);
        System.out.println(oficina.printarStatus(oficina.procesa(tratamientoInt), 
                                                 tratamientoInt.getPedido()));

        TratamientoPedidoPeligroso peligroso = new TratamientoPedidoPeligroso(
                                                    new PedidoPeligrosoOrden("Cima de los vientos", 
                                                                             "no limpiarse las uñas con este puñal"));
        System.out.println(oficina.printarStatus(oficina.procesa(peligroso), 
                                                 peligroso.getPedido()));

        peligroso = new TratamientoPedidoPeligroso(
                        new PedidoPeligrosoOrden("Monde del destino", 
                                                 "no ponerselo en el dedo"));
        System.out.println(oficina.printarStatus(oficina.procesa(peligroso), 
                                                 peligroso.getPedido()));   
    }
}
