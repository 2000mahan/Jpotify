package GUI;

import java.awt.Color;

public class CustomColor{
    private Color background;
    private Color mainBackground;
    private Color font;

    public CustomColor(String font, String background){
        if(font.equals("Dark Blue"))
            this.font = new Color(10,50,100);
        else if(font.equals("Red"))
            this.font = new Color(100,20, 20);
        else if(font.equals("Yellow"))
            this.font = new Color(212, 175, 15);
        if(background.equals("Dark")){
            mainBackground = new Color(60, 60, 60);
            this.background = new Color(10, 10, 20);
        }
        else if(background.equals("Light")){
            mainBackground = new Color(211, 211, 211);
            this.background = new Color(109, 109, 109);
        }
    }
    public Color getBackground(){
        return background;
    }

    public Color getFont() {
        return font;
    }

    public Color getMainBackground() {
        return mainBackground;
    }
}
