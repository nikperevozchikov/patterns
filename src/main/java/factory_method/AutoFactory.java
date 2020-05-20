package factory_method;

public class AutoFactory implements VehicleFactory {
    public Auto createInstance(String mark, int size) {
        return new Auto(mark, size);
    }
}
