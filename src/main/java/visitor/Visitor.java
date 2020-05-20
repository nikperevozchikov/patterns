package visitor;

import factory_method.Auto;
import factory_method.Motorcycle;
import factory_method.Vehicle;

public interface Visitor {
    public void visit(Motorcycle motorcycle);
    public void visit(Auto auto);
}
