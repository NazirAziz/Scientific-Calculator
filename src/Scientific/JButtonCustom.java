package src.Scientific;
import java.awt.Font;

import javax.swing.*;

public class JButtonCustom extends JButton {
    JButtonCustom(){
        super();
        this.setFont(new Font("Arial", Font.ITALIC, 20));
    }
    public JButtonCustom(String s){
        super(s);
        this.setFont(new Font("Arial", Font.ITALIC, 20));
    }
    public JButtonCustom(Icon c){
        super(c);
        this.setFont(new Font("Arial", Font.ITALIC, 20));
    }
}
