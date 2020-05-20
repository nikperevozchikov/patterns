package template;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Star extends Figure {
    public Star(Graphics2D g2) {
        super(g2);
    }

    int xPoints[] = {9, 15, 0, 18, 3};
    int yPoints[] = {0, 18, 6, 6, 18};

    public GeneralPath getStar(){
        GeneralPath star = new GeneralPath();

        star.moveTo(xPoints[0] + x, yPoints[0] + y);
        for (int i = 1; i < xPoints.length; i++) {
            star.lineTo(xPoints[i] + x, yPoints[i] + y);
        }
        star.closePath();
        return star;
    }

    @Override
    public void Ddraw() {
        g2.fill(getStar());
    }
}
