package grafika;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener, KeyListener {

    private ArrayList<Kreska> listKreska = new ArrayList<>();
    private MyList list;
    private boolean isNowDraw = false;
    private int poczX,poczY, konX, konY;

    public MyCanvas(MyList l)
    {
        this.list=l;
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
    }

    private void setParamsPaint()
    {
        requestFocus(true);
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g){

        setParamsPaint();
        for(Kreska k: listKreska)
        {
            k.draw(g);
            //g.setColor(k.kolor);
            //g.drawLine(k.poczatek.x,k.poczatek.y,k.koniec.x,k.koniec.y);
        }
        if(isNowDraw)
        {
            Kreska.draw(g,poczX,poczY,konX,konY,Color.GRAY);
            //g.setColor(Color.GRAY);
            //g.drawLine(poczX,poczY,konX,konY);
        }
    }

    private boolean isInDrawableScreen(int x, int y)
    {
        return x>0 && x<getWidth() && y>0 && y<getHeight();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        this.poczX=this.konX=mouseEvent.getX();
        this.poczY=this.konY=mouseEvent.getY();
        isNowDraw=true;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {//throws IllegalArgumentException {
        this.isNowDraw=false;
        if(isInDrawableScreen(mouseEvent.getX(),mouseEvent.getY()))
        {
             Kreska tmp = new Kreska(new Point(poczX,poczY),new Point(konX,konY),list.getActualColor());
             if(!listKreska.contains(tmp)) listKreska.add(tmp);
        }
        else {
            //throw new IllegalArgumentException("Poza obszarem");
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        this.konX=mouseEvent.getX();
        this.konY=mouseEvent.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {


    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(!listKreska.isEmpty())
        {
            if(keyEvent.getKeyChar()=='b') //ostatni
            {
                listKreska.remove(0);
            }
            else if(keyEvent.getKeyChar()=='f') //pierwszy
            {
                listKreska.remove(listKreska.size()-1);
            }
            else if(keyEvent.getKeyChar()==KeyEvent.VK_BACK_SPACE)
            {
                listKreska.clear();
            }
            repaint();
        }
    }
}
