package template;

import java.awt.*;

public class Kvadrat extends Figure {

    public Kvadrat(Graphics2D g2) {
        super(g2);
    }

    @Override
    public void Ddraw() {
        g2.fillRect(x,y,width,heigth);
    }


}
