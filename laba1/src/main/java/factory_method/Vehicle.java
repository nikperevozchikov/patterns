package factory_method;

import factory_method.exceptions.DuplicateModelNameException;
import factory_method.exceptions.NoSuchModelNameException;

import java.io.Serializable;

public interface Vehicle extends Serializable, Cloneable {
    String getMark();
    void setMark(String mark);
    String[] getAllModelNames();
    double[] getAllModelPrices();
    void setModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException;
    double getPriceByName(String name) throws NoSuchModelNameException;
    void setPriceByName(String name, double price) throws NoSuchModelNameException;
    void addNameModelAndPrice(String name, double price) throws DuplicateModelNameException;
    void deleteModel(String name) throws NoSuchModelNameException;
    int getModelLength();
    Object clone() throws CloneNotSupportedException;
}
