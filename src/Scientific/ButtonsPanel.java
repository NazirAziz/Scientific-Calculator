package src.Scientific;

import java.awt.*;
import javax.swing.*;



public class ButtonsPanel extends JPanel{
    
    JButtonCustom secondIDK;
    JButtonCustom pie;
    JButtonCustom eNumber;
    JButtonCustom clearAll;
    JButtonCustom clearLast;
    JButtonCustom xToThePowerTwo;
    JButtonCustom oneDividedByX;
    JButtonCustom absoluteValueOfX;
    JButtonCustom notKnown;
    JButtonCustom mod;
    JButtonCustom sqrtX;
    JButtonCustom openParenthesis;
    JButtonCustom closeParenthesis;
    JButtonCustom nFactorail;
    JButtonCustom division;
    JButtonCustom xTOthePowerOfY;
    JButtonCustom seven;
    JButtonCustom eight;
    JButtonCustom nine;
    JButtonCustom multiplication;
    JButtonCustom tenToThePowerOfX;
    JButtonCustom four;
    JButtonCustom five;
    JButtonCustom six;
    JButtonCustom subtraction;
    JButtonCustom logToBaseTenOfX;
    JButtonCustom one;
    JButtonCustom two;
    JButtonCustom three;
    JButtonCustom addition;
    JButtonCustom ln;
    JButtonCustom notKnown2;
    JButtonCustom zero;
    JButtonCustom point;
    JButtonCustom answer;

    JPanel upChoices;
    JPanel downButtons;

    JButtonCustom trigonometry;
    JButtonCustom function;

    JDialog tri;
    JDialog fun;

    JButtonCustom sin;
    JButtonCustom cos;
    JButtonCustom tan;

    JButtonCustom ceil;
    JButtonCustom floor;
    ButtonsPanel(){
        this.setLayout(new BorderLayout());
        
        setUpDownButtons();
        setUpUpChoices();
        

        createButtons();
        addButtonsToPanel();
        customiseTheColorOfNumbers();

        this.add(upChoices, BorderLayout.NORTH);
        this.add(downButtons, BorderLayout.SOUTH);

        
        
    }
    
    // sets up the upper section of the main panel
    private void setUpUpChoices(){
        upChoices = new JPanel();
        upChoices.setLayout(new FlowLayout(FlowLayout.LEFT));
        upChoices.setPreferredSize(new Dimension(0, 40));
        trigonometry = new JButtonCustom("trigonometry");
        function = new JButtonCustom("function");
        upChoices.add(trigonometry);
        upChoices.add(function);
        setUpFunDialog();
        setUpTriDialog();
    }
    // the extra buttons for more functionality
    private void setUpFunDialog(){
        fun = new JDialog();
        fun.setLayout(new FlowLayout());

        ceil = new JButtonCustom("ceil(x)");
        floor = new JButtonCustom("floor(x)");

        fun.add(ceil);
        fun.add(floor);
        fun.pack();
        fun.setResizable(false);
        fun.setLocationRelativeTo(function);

    }
    private void setUpTriDialog(){
        tri = new JDialog();
        tri.setLayout(new FlowLayout());

        sin = new JButtonCustom("sin");
        cos = new JButtonCustom("cos");
        tan = new JButtonCustom("tan");

        tri.add(sin);
        tri.add(cos);
        tri.add(tan);
        tri.pack();
        tri.setResizable(false);
        tri.setLocationRelativeTo(trigonometry);
    }
    // sets up the buttons sub panel
    private void setUpDownButtons(){
        downButtons = new JPanel();
        downButtons.setLayout(new GridLayout(7, 5));
        downButtons.setPreferredSize(new Dimension(0, 300));
    }
// creates the buttons and give them Icon
    private void createButtons(){
        secondIDK = new JButtonCustom("<html>2<sup>nd</sup></html>");
        secondIDK.setEnabled(false);
        pie = new JButtonCustom("π");
        eNumber = new JButtonCustom("e");
        clearAll = new JButtonCustom("C");
        // we use icon here
        Image iicon = new ImageIcon("E:/Practice code/Java Code/Uni Chanllenge/Calculator/src/back Space.png").getImage().getScaledInstance(20, 20, Image.SCALE_FAST);
        ImageIcon icon = new ImageIcon(iicon);
        clearLast = new JButtonCustom(icon);  
        xToThePowerTwo = new JButtonCustom("<html>x<sup>2</sup></html>");
        oneDividedByX = new JButtonCustom("1/x");
        absoluteValueOfX = new JButtonCustom("|x|");
        notKnown = new JButtonCustom("exp");
        notKnown.setEnabled(false);
        mod = new JButtonCustom("Mod");
        mod.setFont(new Font("Arial", Font.ITALIC, 12));
        sqrtX = new JButtonCustom("2√x");
        openParenthesis = new JButtonCustom("(");
        closeParenthesis = new JButtonCustom(")");
        nFactorail = new JButtonCustom("n!");
        division = new JButtonCustom("÷");
        xTOthePowerOfY = new JButtonCustom("<html>x<sup>y</sup></html>");
        seven = new JButtonCustom("7");
        eight = new JButtonCustom("8");
        nine = new JButtonCustom("9");
        multiplication = new JButtonCustom("×");
        tenToThePowerOfX = new JButtonCustom("<html>10<sup>x</sup></html>");
        four = new JButtonCustom("4");
        five = new JButtonCustom("5");
        six = new JButtonCustom("6");
        subtraction = new JButtonCustom("-");
        logToBaseTenOfX = new JButtonCustom("log");
        one = new JButtonCustom("1");
        two = new JButtonCustom("2");
        three = new JButtonCustom("3");
        addition = new JButtonCustom("+");
        ln = new JButtonCustom("ln");
        notKnown2 = new JButtonCustom("+/-");
        zero = new JButtonCustom("0");
        point = new JButtonCustom(".");
        answer = new JButtonCustom("=");
    }
// adds all the buttons onto the panel
    private void addButtonsToPanel(){
        downButtons.add(secondIDK);
        downButtons.add(pie);
        downButtons.add(eNumber);
        downButtons.add(clearAll);
        downButtons.add(clearLast);
        downButtons.add(xToThePowerTwo);
        downButtons.add(oneDividedByX);
        downButtons.add(absoluteValueOfX);
        downButtons.add(notKnown);
        downButtons.add(mod);
        downButtons.add(sqrtX);
        downButtons.add(openParenthesis);
        downButtons.add(closeParenthesis);
        downButtons.add(nFactorail);
        downButtons.add(division);
        downButtons.add(xTOthePowerOfY);
        downButtons.add(seven);
        downButtons.add(eight);
        downButtons.add(nine);
        downButtons.add(multiplication);
        downButtons.add(tenToThePowerOfX);
        downButtons.add(four);
        downButtons.add(five);
        downButtons.add(six);
        downButtons.add(subtraction);
        downButtons.add(logToBaseTenOfX);
        downButtons.add(one);
        downButtons.add(two);
        downButtons.add(three);
        downButtons.add(addition);
        downButtons.add(ln);
        downButtons.add(notKnown2);
        downButtons.add(zero);
        downButtons.add(point);
        downButtons.add(answer);
    }
// costomise the color of numbers buttons
    private void customiseTheColorOfNumbers(){
        Color color = Color.WHITE;
        one.setBackground(color);
        two.setBackground(color);
        three.setBackground(color);
        four.setBackground(color);
        five.setBackground(color);
        six.setBackground(color);
        seven.setBackground(color);
        eight.setBackground(color);
        nine.setBackground(color);
        zero.setBackground(color);
        point.setBackground(color);
        notKnown2.setBackground(color);
    }
}
