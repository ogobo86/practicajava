package PcWorld.Model;

public class Monitor {

    private final int idMonitor;

    private String brand;

    private double size;

    private static int counterMonitor;

    private Monitor (){
        idMonitor = ++counterMonitor;
    }
     public Monitor (String brand, double size){

        this();

        this.brand = brand;
        this.size = size;
     }

    @Override
    public String toString() {
        return "Monitor{" +
                "idMonitor=" + idMonitor +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                '}';
    }
}
