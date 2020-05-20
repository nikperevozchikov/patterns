package cor;

import dao.ByteView;
import dao.IAutoDAO;
import dao.TextView;
import factory_method.Auto;
import factory_method.Vehicle;
import factory_method.Vehicles;
import factory_method.exceptions.DuplicateModelNameException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws DuplicateModelNameException, IOException, CloneNotSupportedException {
        try {
            Vehicle auto = new Auto("Toyota", 4);
            //Vehicle a = (Auto) auto.clone();
            //a.addNameModelAndPrice("vesta", 2600);

            ChainOfResponsibility ch = new Column();
            // ChainOfResponsibility ch1 = new Row();

            ch.write(auto);
            //ch1.write(a);
            //System.out.println(auto);
            //System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


