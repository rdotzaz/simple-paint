package grafika;

import java.awt.*;
import java.util.Dictionary;
import java.util.HashMap;

public class MyList extends List {

    private HashMap<String,Color> mapColor = new HashMap<>();

    public MyList(){
        super();
        mapColor.put("Black",Color.BLACK);
        mapColor.put("Blue",Color.BLUE);
        mapColor.put("Green",Color.GREEN);
        mapColor.put("Orange",Color.ORANGE);
        mapColor.put("Red",Color.RED);
        mapColor.put("Yellow",Color.YELLOW);

        for(String key: mapColor.keySet())
        {
            add(key);
        }
        setBounds(0,200,150,200);
        setBackground(Color.LIGHT_GRAY);
    }

    public Color getActualColor()
    {
        return mapColor.get(getSelectedItem());
    }
}
