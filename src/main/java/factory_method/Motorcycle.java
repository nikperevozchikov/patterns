package factory_method;

import factory_method.exceptions.DuplicateModelNameException;
import factory_method.exceptions.ModelPriceOutfBoundsException;
import factory_method.exceptions.NoSuchModelNameException;
import visitor.Visitor;

import java.util.Objects;

public class Motorcycle implements Vehicle {

    private String mark;
    private int size = 0;

    public Motorcycle(String mark, int size) throws DuplicateModelNameException {
        this.mark = mark;
        for (int i = 0; i < size; i++) {
            addNameModelAndPrice("модель мото" + i, 1000);
        }
    }


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


    public String[] getAllModelNames() {
        String[] names = new String[size];
        MotorcycleModel link = head.next;
        int index = 0;
        while (link != head) {
            names[index++] = link.name;
            link = link.next;
        }
        return names;
    }


    public double[] getAllModelPrices() {

        double[] prices = new double[size];
        MotorcycleModel link = head.next;
        int index = 0;
        while (link != head) {
            prices[index++] = link.price;
            link = link.next;


        }
        return prices;

    }

    public double getPriceByName(String name) throws NoSuchModelNameException {
        if (name == null) {
            throw new NoSuchModelNameException(null);
        }

        MotorcycleModel link = head.next;
        while (link != head) {
            if (link.name.equals(name)) {
                return link.price;
            }
            link = link.next;
        }
        throw new NoSuchModelNameException(name);
    }

    public boolean dublicate(String name) {
        MotorcycleModel link = head.next;
        while (link != head &&
                !link.name.equals(name)) {
            link = link.next;

        }
        return link != head;
    }

    public void setModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        if (oldName == null) {
            throw new NoSuchModelNameException(null);
        }

        if (newName == null) {
            throw new NullPointerException("npe");
        }

        if (oldName.equals(newName) || dublicate(newName)) {
            throw new DuplicateModelNameException(newName);
        }

        MotorcycleModel link = head.next;
        while (link != head) {
            if (oldName.equals(link.name)) {
                link.name = newName;
                return;
            }
            link = link.next;
        }
    }

    public void setPriceByName(String name, double price) throws NoSuchModelNameException {
        if (name == null) {
            throw new NoSuchModelNameException(null);
        }
        if (!(price > 0) && (price < Double.MAX_VALUE)) {
            throw new ModelPriceOutfBoundsException(price);
        }
        MotorcycleModel link = head.next;
        while (link != head) {
            if (link.name.equals(name)) {
                link.price = price;
                return;
            }
            link = link.next;
        }
        throw new NoSuchModelNameException(name);
    }


    public void addNameModelAndPrice(String name, double price) throws DuplicateModelNameException {
        if (!(price > 0) && (price < Double.MAX_VALUE)) {
            throw new ModelPriceOutfBoundsException(price);
        }
        String[] arr = getAllModelNames();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(name)) {
                throw new DuplicateModelNameException(name);
            }
        }

        MotorcycleModel addModel = new MotorcycleModel(name, price);
        addModel.next = head;
        addModel.prev = head.prev;
        head.prev.next = addModel;
        head.prev = addModel;
        size++;

    }

    public void deleteModel(String name) throws NoSuchModelNameException {

        MotorcycleModel link = head.next;
        while (link != head && !link.name.equals(name)) {
            link = link.next;
        }
        if (link != head) {
            link.prev.next = link.next;
            link.next.prev = link.prev;
            size--;
        } else throw new NoSuchModelNameException(name);
    }


    public int getModelLength() {
        return size;
    }
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    @Override
    public Object clone() {

        Motorcycle clonedMotorcycle = null;
        try {
            clonedMotorcycle = (Motorcycle) super.clone();
            clonedMotorcycle.head = new MotorcycleModel();
            clonedMotorcycle.head.next = clonedMotorcycle.head;
            clonedMotorcycle.head.prev = clonedMotorcycle.head;
            clonedMotorcycle.size = 0;//при добавление поймаем npe, размерность будет четыре,  узел будет головой, массив имен поэтому будет пуст, нужно обнулить поэтому
            MotorcycleModel link = head;
            while (link.next != head) {
                link = link.next;
                clonedMotorcycle.addNameModelAndPrice(link.name, link.price);

            }


        } catch (CloneNotSupportedException | DuplicateModelNameException e) {
            e.printStackTrace();

        }


        return clonedMotorcycle;
    }


    private class MotorcycleModel {
        String name = null;
        double price = Double.NaN;
        MotorcycleModel prev = null;
        MotorcycleModel next = null;

        MotorcycleModel() {
        }

        MotorcycleModel(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    private MotorcycleModel head = new MotorcycleModel();

    {
        head.prev = head;
        head.next = head;
    }
}