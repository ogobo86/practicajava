package PcWorld.Model;

import javax.print.DocFlavor;

public class Mouse extends InputDevice {

    private final int idMouse;

    private static int counterMouse;

    //Constructor

    public Mouse (String typeInput, String brand){

        super(typeInput, brand);
        idMouse = ++ counterMouse;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "idMouse=" + idMouse +
                "} " + super.toString();
    }
}
