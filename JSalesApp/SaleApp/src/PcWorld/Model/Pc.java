package PcWorld.Model;

import javax.xml.namespace.QName;

public class Pc {

    private int idPc;
    private String name;

    private Monitor monitor;

    private Keyboard keyboard;

    private Mouse mouse;

    private static int counterPc;

    private Pc (){
        idPc = ++counterPc;
    }

    public Pc (String name, Monitor monitor, Keyboard keyboard, Mouse mouse){
        this();
        this.name = name;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "idPc=" + idPc +
                ", \n name='" + name + '\'' +
                ", \n monitor=" + monitor +
                ", \n keyboard=" + keyboard +
                ", \n mouse=" + mouse +
                '}';
    }
}
