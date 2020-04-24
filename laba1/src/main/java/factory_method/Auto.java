package factory_method;

import com.sun.deploy.Environment;
import factory_method.exceptions.DuplicateModelNameException;
import factory_method.exceptions.ModelPriceOutfBoundsException;
import factory_method.exceptions.NoSuchModelNameException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Auto implements Vehicle, Cloneable, Serializable {
    private String mark;
    private Model[] models;
    private int size;

    public Auto(String mark, int modelSize) {
        this.mark = mark;
        models = new Model[modelSize];
        for (int i = 0; i < models.length; i++) {
            models[i] = new Model("модель авто" + i, 2000.0);
        }
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String[] getAllModelNames() {
        String[] arr = new String[models.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = models[i].name;
        }
        return arr;
    }

    public double[] getAllModelPrices() {
        double[] arr = new double[models.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = models[i].price;
        }
        return arr;
    }

    public void setModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        if (oldName.equals(newName) || getIndexOfModelByName(newName) != -1) {
            throw new DuplicateModelNameException(newName);
        }// проверка на дубликат по нормальному сделать
        if (oldName != null && newName != null) {
            int number = getIndexOfModelByName(oldName);
            if (number != -1) {
                models[number].name = newName;
            } else throw new NoSuchModelNameException(oldName);

        }

    }

    public double getPriceByName(String name) throws NoSuchModelNameException {
        int number = getIndexOfModelByName(name);
        if (number != -1) {
            return models[number].price;
        } else throw new NoSuchModelNameException(name);
    }

    public int getIndexOfModelByName(String name) {
        for (int i = 0; i < models.length; i++) {
            if (models[i].name.equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public void setPriceByName(String name, double price) throws NoSuchModelNameException {
        int number = getIndexOfModelByName(name);
        if (number != -1) {
            if (price > 0 && price < Double.MAX_VALUE) {
                models[number].price = price;
            } else throw new ModelPriceOutfBoundsException(price);
        } else throw new NoSuchModelNameException(name);
    }

    public void addNameModelAndPrice(String name, double price) throws DuplicateModelNameException {

        if (getIndexOfModelByName(name) == -1) {
            if (price > 0 && price < Double.MAX_VALUE) {
                Model[] newModels = Arrays.copyOf(models, models.length + 1);
                newModels[models.length] = new Model(name, price);
                models = newModels;

            } else throw new ModelPriceOutfBoundsException(price);
        } else throw new DuplicateModelNameException(name);

    }

    public void deleteModel(String name) throws NoSuchModelNameException {
        int number = getIndexOfModelByName(name);
        if (getIndexOfModelByName(name) != -1) {

            System.arraycopy(models, number + 1, models, number, models.length - number - 1);
            models = Arrays.copyOf(models, models.length - 1);
        } else throw new NoSuchModelNameException(name);

    }

    public int getModelLength() {
        return models.length;
    }
    @Override
    public String toString() {
        return "Прочитанное" + "\n" +
                "марка " + getMark() + "\n"+
                "количество моделей " + Double.toString(getModelLength()) + "\n"+
                "список моделей " + Arrays.toString(getAllModelNames()) +"\n" +
                "список цен " + Arrays.toString(getAllModelPrices()) + "\n" ;
    }
    public static String allModels(Auto auto) {
        String str = "";
        String[] strings = auto.getAllModelNames();
        for (int i = 0; i < auto.getModelLength(); i++) {
            str += strings[i].concat("");
        }
        return str;
    }
    @Override
    public Object clone() {
        Auto clonedAuto = null;
        try {
            clonedAuto = (Auto) super.clone();
            clonedAuto.models = new Model[models.length];
            for (int i = 0; i < models.length; i++) {
                clonedAuto.models[i] = new Model(models[i].name, models[i].price);
            }
            clonedAuto.setMark(mark);
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return clonedAuto;
    }

    private class Model implements Serializable {
        String name;
        double price;

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

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public Model() {
        }


    }

}
