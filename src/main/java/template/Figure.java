package template;

import java.awt.*;

public abstract class Figure {
    public int granicaX = 583;
    public int granicaY = 330;

    public int width = 15;
    public int heigth = 15;

    public int napravlenie = 0;

    public int x = granicaX - width;
    public int y = granicaY - heigth;

    public Graphics2D g2;

    public Figure(Graphics2D g2) {
        this.g2 = g2;
    }

    public abstract void Ddraw();
    public void draw() {

        Ddraw();

        if (napravlenie == 0) {
            x--;
            y--;
        } else if (napravlenie == 1) {
            x++;
            y--;
        } else if (napravlenie == 2) {
            x++;
            y++;
        } else if (napravlenie == 3) {
            x--;
            y++;
        }

      
        if (x == 0 && y == 0) napravlenie = 2;
        else if (x + width == granicaX && y == 0) napravlenie = 3;
        else if (x + width == granicaX && y + heigth == granicaY) napravlenie = 0;
        else if (x == granicaX && y + heigth == granicaY) napravlenie = 1;
        
        
        
        else if (x == 0 && napravlenie == 0) napravlenie = 1;
        else if (x == 0 && napravlenie == 3) napravlenie = 2;

        else if (x + width == granicaX && napravlenie == 1) napravlenie = 0;
        else if (x + width == granicaX && napravlenie == 2) napravlenie = 3;

        else if (y == 0 && napravlenie == 0) napravlenie = 3;
        else if (y == 0 && napravlenie == 1) napravlenie = 2;

        else if (y + heigth == granicaY && napravlenie == 3) napravlenie = 0;
        else if (y + heigth == granicaY && napravlenie == 2) napravlenie = 1;


    }
}
