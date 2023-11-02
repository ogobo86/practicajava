package PcWorld;


import PcWorld.Model.Keyboard;
import PcWorld.Model.Monitor;
import PcWorld.Model.Mouse;
import PcWorld.Model.Pc;
import PcWorld.service.Order;

public class SalesPcsApp {
    public static void main(String[] args) {
        //Creamos objetos
        Mouse mouseLenovo = new Mouse("ubs", "Lenovo");

       // System.out.println(mouseLenovo);

        Keyboard keyboardLenovo = new Keyboard("usb", "Lenovo");

       // System.out.println(keyboardLenovo);

        Monitor monitorLenovo = new Monitor("Lenovo", 23);

      //  System.out.println(monitorLenovo);

        Pc pcLenovo = new Pc( "Lenovo Pc", monitorLenovo, keyboardLenovo, mouseLenovo);

      //  System.out.println(pcLenovo);
        Monitor monitorDell = new Monitor ("Dell", 27);
        Mouse mouseDell = new Mouse ("Bluetooth", "Dell");
        Keyboard keyboardDell = new Keyboard("Bluetooth", "Dell");
        Pc pcDell = new Pc ( "Dell M", monitorDell, keyboardDell, mouseDell);


        //ORDEN

        Order order1 = new Order();
        order1.addPc(pcLenovo);
        order1.showOrder();
        Order order2 = new Order();
        order2.addPc (pcDell);
        order2.showOrder();


    }
}