package factory_method.exceptions;

public class ModelPriceOutfBoundsException extends  RuntimeException {
    public ModelPriceOutfBoundsException(double price){
        super("Неверная цена модели");
    }

}
