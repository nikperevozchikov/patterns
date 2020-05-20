package cor;

import factory_method.Vehicle;

import java.io.IOException;

public interface ChainOfResponsibility {

    void write(Vehicle vehicle) throws IOException;

    void next(Vehicle vehicle) throws IOException;
}
