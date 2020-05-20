package visitor;

import factory_method.Auto;
import factory_method.Motorcycle;

public class PrintVisitor implements  Visitor {
    @Override
    public void visit(Auto auto) {
        StringBuilder autos = new StringBuilder();
        autos.append(auto.getMark()).append(" ").append(auto.getModelLength()).append(" ");
        String[] arrN = auto.getAllModelNames();
        double[] arrP = auto.getAllModelPrices();
        for (int i = 0; i < arrN.length; i++) {
            autos.append(arrN[i] + " " + arrP[i] + " ");
        }

        System.out.println(autos);
    }

    @Override
    public void visit(Motorcycle motorcycle) {
        StringBuilder motorcycles = new StringBuilder();
        motorcycles.append(motorcycle.getMark()).append("\n").append(motorcycle.getModelLength()).append("\n");
        String[] arrN = motorcycle.getAllModelNames();
        double[] arrP = motorcycle.getAllModelPrices();
        for (int i = 0; i < arrN.length; i++) {
            motorcycles.append(arrN[i] + "\n" + arrP[i] + "\n");
        }
        System.out.println(motorcycles);
    }
}