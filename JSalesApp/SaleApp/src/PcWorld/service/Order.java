package PcWorld.service;

import PcWorld.Model.Pc;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int idOrder;

    private final List<Pc> pcs;

    private static int counterOrder;


    public Order (){
        pcs = new ArrayList<>();
        this.idOrder = ++counterOrder;
    }

    public void addPc (Pc pc){
        pcs.add(pc);
    }

    public void showOrder(){
        System.out.println("Order #: " + idOrder);
        System.out.println("Total Pcs " + pcs.size() );

        pcs.forEach(System.out::println);

    }
}
