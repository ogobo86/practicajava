package PcWorld.Model;

public class InputDevice {
    private String typeInput;
    private String brand;


    //Constructor
    public InputDevice(String typeInput, String brand ){
        this.typeInput = typeInput;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "InputDevice{" +
                "typeInput='" + typeInput + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
