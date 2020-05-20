package factory_method.exceptions;

public class NoSuchModelNameException extends Exception {
    public NoSuchModelNameException (String name){
        System.out.println("Нет такого названия модели"+ name);
    }

    }
