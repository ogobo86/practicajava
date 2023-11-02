package PcWorld.Model;

public class Keyboard extends InputDevice{

    private final int idKeyboard;

    private static int counterKeyboard;


    public Keyboard (String typeInput, String brand){

        super(typeInput, brand);

        idKeyboard = ++counterKeyboard;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "idKeyboard=" + idKeyboard +
                "} " + super.toString();
    }
}
