package template;

import java.awt.*;

public class Ball extends Figure {
    public Ball(Graphics2D g2) {
        super(g2);
    }

    @Override
    public void Ddraw() {
        g2.fillOval(x,y,width,heigth);
    }

}
