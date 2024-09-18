package src.Main;

import javax.swing.*;
import src.Scientific.Scientific;

public class Calculator extends JFrame{
    Scientific scientificPanel;

    Calculator(){
        super("Calculator");

        
        setUpFrame();
        setUpScientificClass();

        this.setVisible(true);
    }
    // sets up the frame
    private void setUpFrame(){
        this.setSize(350, 550);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    private void setUpScientificClass(){
        scientificPanel = new Scientific();
        this.getContentPane().add(scientificPanel);
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
