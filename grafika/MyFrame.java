package grafika;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{

    private MyList list = new MyList();
    private MyCanvas canvas = new MyCanvas(list);
    private Label info = new Label("Let's color!");

    public MyFrame(){

        setTitle("Let's color!");
        setSize(600,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setFocusable(true);
        setLayout(new BorderLayout());
        add("West",list);
        add("Center",canvas);
        add("North",info);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

}
