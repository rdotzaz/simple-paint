package grafika;

import java.awt.*;

public class Kreska {

    protected Point poczatek, koniec;
    public final Color kolor;

    public Kreska(Point pocz, Point kon, Color kol){
        this.poczatek=pocz;
        this.kolor=kol;
        this.koniec=kon;
    }

    public Point getPoczatek() {
        return poczatek;
    }

    public Point getKoniec() {
        return koniec;
    }

    public Color getKolor() {
        return kolor;
    }

    public void draw(Graphics g)
    {
        g.setColor(this.kolor);
        g.drawLine(this.poczatek.x,this.poczatek.y,this.koniec.x,this.koniec.y);
    }

    public static void draw(Graphics g, int poczX, int poczY, int konX, int konY, Color c)
    {
        g.setColor(c);
        g.drawLine(poczX,poczY,konX,konY);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Kreska)
        {
            return this.poczatek.x==((Kreska) obj).poczatek.x &&
                   this.poczatek.y==((Kreska) obj).poczatek.y &&
                   this.koniec.x==((Kreska) obj).koniec.x &&
                   this.koniec.y==((Kreska) obj).koniec.y;
        }
        return false;
    }
}
