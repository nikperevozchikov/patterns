package factory_method.exceptions;

public class DuplicateModelNameException extends Exception {
    public DuplicateModelNameException(String name){
        System.out.println("Дубликат модели"+name);
    }
}
