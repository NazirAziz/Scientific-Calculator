package src.Scientific;

import src.MathFile.MathClass;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Scientific extends JPanel {

    JLabel showAllOperationLabel;
    JLabel inputArea;
    ButtonsPanel buttonsPanel;

    String immediateInput = "";
    String historyInput = "";

    public Scientific(){
        setUpshowAllOperationLabel();
        setUpInputArea();
        setUpButtons();
        
        
        
        
        
        
        
        setUpActionForNumberButtons();
        setUpActionForOtherButtons();
        setActionToChoicesButtons();
        
        
        
        
        setUpMainPanel();
    }

    
    private void setUpMainPanel(){
        this.setLayout(new BorderLayout());
        this.add(showAllOperationLabel, BorderLayout.NORTH);
        this.add(inputArea, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);
    }
    // sets up the label that shows a complete your input
    private void setUpshowAllOperationLabel(){
        showAllOperationLabel = new JLabel(historyInput);
        showAllOperationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        showAllOperationLabel.setFont(new Font("Arial", Font.ITALIC, 15));
    }
    // sets up the place where user imediate input is shown
    private void setUpInputArea(){
        inputArea = new JLabel(immediateInput);
        inputArea.setHorizontalAlignment(SwingConstants.RIGHT);
        inputArea.setFont(new Font("Arial", Font.ITALIC, 20));
    }
    // creates a buttonPanel object
    private void setUpButtons(){
        buttonsPanel = new ButtonsPanel();
    }
    // through a loop calls addActionToButton and adds action. SMART
    private void setUpActionForNumberButtons(){
        // 48 - 57
        JButtonCustom[] numberButtonsArray = new JButtonCustom[]{buttonsPanel.zero, buttonsPanel.one, buttonsPanel.two, buttonsPanel.three, buttonsPanel.four, 
                                                                    buttonsPanel.five, buttonsPanel.six, buttonsPanel.seven, buttonsPanel.eight, buttonsPanel.nine};

        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int keyStroke = 48;
        
        for (int i = 0; i < 10; ++i){
            addActionToButton(numberButtonsArray[i], numbers[i], keyStroke++);
        }

    }
    // it is related to setUpActionForNumberButtons. it adds action and keyStroke
    private void addActionToButton(JButtonCustom button, String number, int keyStroke){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputArea.setText(immediateInput += number);
            }
        });     
        button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyStroke, 0), number);
        button.getActionMap().put(number, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
                
            }
        });
    }
    // set up action for other buttons
    private void setUpActionForOtherButtons(){
        setActionForOperatorKey();
        setActionToChoicesButtons();
        setUpKeyStrokeForOperationButtons();

        // pie
        buttonsPanel.pie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                immediateInput = "3.141";
                inputArea.setText(immediateInput);
            }
        });
        // e number
        buttonsPanel.eNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                immediateInput = "2.718";
                inputArea.setText(immediateInput);
            }
        });
        // C -> clear all
        buttonsPanel.clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(immediateInput == ""){
                    historyInput = "";
                    showAllOperationLabel.setText("");
                }
                immediateInput = "";
                inputArea.setText(immediateInput);
            }
        });
        // < clear last
        buttonsPanel.clearLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput != ""){
                    immediateInput = immediateInput.substring(0, immediateInput.length() - 1);
                    inputArea.setText(immediateInput);

                }
            }
        });
        // power of 2
        buttonsPanel.xToThePowerTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    historyInput = deleteToLastOperator(historyInput);
                    historyInput += (String.format("sqr(%s)", immediateInput));
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = Math.pow(Double.parseDouble(immediateInput), 2) + "";
                    inputArea.setText(immediateInput);
                    immediateInput = "";
                    
                }
            }
        });
        // 1/x
        buttonsPanel.oneDividedByX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    historyInput = deleteToLastOperator(historyInput);
                    historyInput += (String.format("1 / %s", immediateInput));
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = 1 / Double.parseDouble(immediateInput) + "";
                    inputArea.setText(immediateInput);
                    immediateInput = "";

                }
            }
        });
        // abs(x)
        buttonsPanel.absoluteValueOfX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    historyInput = deleteToLastOperator(historyInput);
                    historyInput += (String.format("abs(%s)", immediateInput));
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = Math.abs(Double.parseDouble(immediateInput)) + "";
                    inputArea.setText(immediateInput);
                    immediateInput = "";

                }
            }
        });
        // exp
        // ....
        // sqrt(x)
        buttonsPanel.sqrtX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){    
                    historyInput = deleteToLastOperator(historyInput);
                    historyInput += (String.format("√(%s)", immediateInput));
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = Math.sqrt(Double.parseDouble(immediateInput)) + "";
                    inputArea.setText(immediateInput);
                    immediateInput = "";

                }
            }
        });
        // (
        // ...
        // )
        // ...
        buttonsPanel.nFactorail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){    
                    historyInput = deleteToLastOperator(historyInput);
                    historyInput += (String.format("%s!", immediateInput));
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = fact((int)Double.parseDouble(immediateInput)) + "";
                    inputArea.setText(immediateInput);
                    immediateInput = "";

                }
            }
        });
        // x ^ y
        // ...
        // 10 ^ x
        buttonsPanel.tenToThePowerOfX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){    
                    historyInput = deleteToLastOperator(historyInput);
                    historyInput += (String.format("10^(%s)", immediateInput));
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = Math.pow(10, (int)Double.parseDouble(immediateInput)) + "";
                    inputArea.setText(immediateInput);
                    immediateInput = "";
                }
            }
        });
        // log
        buttonsPanel.logToBaseTenOfX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    historyInput = deleteToLastOperator(historyInput);
                    historyInput += (String.format("log(%s)", immediateInput));
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = Math.log10((int)Double.parseDouble(immediateInput)) + "";
                    inputArea.setText(immediateInput);
                    immediateInput = "";
                }
            }
        });
        // ln
        buttonsPanel.ln.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    historyInput = deleteToLastOperator(historyInput);
                    historyInput += (String.format("ln(%s)", immediateInput));
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = Math.log(Double.parseDouble(immediateInput)) / Math.log(Math.E) + "";
                    inputArea.setText(immediateInput);
                    immediateInput = "";
                }
            }
        });
        buttonsPanel.point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    if(immediateInput.charAt(immediateInput.length() - 1) != '.')
                        immediateInput += ".";
                    inputArea.setText(immediateInput);

                }
            }
        });
    }
    // the fun and tri JDialog
    private void setActionToChoicesButtons(){
        buttonsPanel.trigonometry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsPanel.fun.dispose();
                buttonsPanel.tri.setVisible(true);
            }
        });
        buttonsPanel.function.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsPanel.tri.dispose();
                buttonsPanel.fun.setVisible(true);
            }
        });
        setUpChoiceDialogPanelsButtons();
    }
    // the buttons insider tri and fun
    private void setUpChoiceDialogPanelsButtons(){
        // tri
        buttonsPanel.sin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    historyInput = deleteToLastOperator(historyInput);
                    immediateInput = String.format("%.5f", Math.sin(Math.toRadians(Double.parseDouble(immediateInput)))) + "";
                    inputArea.setText(immediateInput);
                    historyInput += immediateInput;
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = "";

                }
                buttonsPanel.tri.dispose();
            }
        });
        buttonsPanel.cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    historyInput = deleteToLastOperator(historyInput);
                    immediateInput = String.format("%.5f", Math.cos(Math.toRadians(Double.parseDouble(immediateInput)))) + "";
                    inputArea.setText(immediateInput);
                    historyInput += immediateInput;
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = "";

                }
                buttonsPanel.tri.dispose();
            }
        });
        buttonsPanel.tan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    historyInput = deleteToLastOperator(historyInput);
                    immediateInput = String.format("%.5f", Math.tan(Math.toRadians(Double.parseDouble(immediateInput)))) + "";
                    inputArea.setText(immediateInput);
                    historyInput += immediateInput;
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = "";

                }
                buttonsPanel.tri.dispose();
            }
        });

        buttonsPanel.ceil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    historyInput = deleteToLastOperator(historyInput);
                    immediateInput = Math.ceil(Double.parseDouble(immediateInput)) + "";
                    inputArea.setText(immediateInput);
                    historyInput += immediateInput;
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = "";

                }
                buttonsPanel.fun.dispose();
            }
        });
        buttonsPanel.floor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (immediateInput.length() != 0){
                    historyInput = deleteToLastOperator(historyInput);
                    immediateInput = Math.floor(Double.parseDouble(immediateInput)) + "";
                    inputArea.setText(immediateInput);
                    historyInput += immediateInput;
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = "";

                }
                buttonsPanel.fun.dispose();
            }
        });
    }
    // deletes all the char in historyInput intill it reaches an operator
    private String deleteToLastOperator(String input){
        if (input.length() == 0)
            return input;

        int index = input.length() - 1;
        while (index >= 0 && input.charAt(index) != '+' && input.charAt(index) != '-' && 
                input.charAt(index) != '*' && input.charAt(index) != '/' && input.charAt(index) != '^' && input.charAt(index) != 'd'){
                index--;
            }
        return input.substring(0, index + 1) + " ";
    }
    // set up the keyStroke for the operators
    private void setUpKeyStrokeForOperationButtons(){
        // +
        buttonsPanel.addition.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.SHIFT_DOWN_MASK), "plusKey");
        buttonsPanel.addition.getActionMap().put("plusKey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsPanel.addition.doClick();
            }
        });
        // -
        buttonsPanel.subtraction.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "minuesKey");
        buttonsPanel.subtraction.getActionMap().put("minuesKey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsPanel.subtraction.doClick();
            }
        });
        // *
        buttonsPanel.multiplication.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_8, KeyEvent.SHIFT_DOWN_MASK), "multiKey");
        buttonsPanel.multiplication.getActionMap().put("multiKey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsPanel.multiplication.doClick();
            }
        });
        // /
        buttonsPanel.division.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0), "divideKey");
        buttonsPanel.division.getActionMap().put("divideKey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsPanel.division.doClick();
            }
        });

        buttonsPanel.answer.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "equalKey");
        buttonsPanel.answer.getActionMap().put("equalKey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsPanel.answer.doClick();
            }
        });
    }
    // No disciption
    private boolean checkIfLastCharIsOperator(char c){
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == 'd')
            return true;
        return false;
    }
    // it sets up the actions listner for operators and takes care of displaying the immedate input as well
    private void setActionForOperatorKey(){
        // wanted to do it all in a loop but was unsuccessful
        // addition +
        buttonsPanel.addition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((immediateInput.length() != 0 && (immediateInput.charAt(immediateInput.length() - 1) != '+') 
                || (historyInput.length() != 0 && !checkIfLastCharIsOperator(historyInput.charAt(historyInput.length() - 2))))){
                    if (immediateInput.length() != 0)
                        historyInput = deleteToLastOperator(historyInput);
                    historyInput += immediateInput + " + ";
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = "";
                }
            }
        });
        // subtraction -
        buttonsPanel.subtraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((immediateInput.length() != 0 && (immediateInput.charAt(immediateInput.length() - 1) != '-')) 
                || (historyInput.length() != 0 && !checkIfLastCharIsOperator(historyInput.charAt(historyInput.length() - 2)))){
                    if (immediateInput.length() != 0)
                        historyInput = deleteToLastOperator(historyInput);
                    historyInput += immediateInput + " - ";
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = "";
                }
            }
        });
        // division /
        buttonsPanel.division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((immediateInput.length() != 0 && (immediateInput.charAt(immediateInput.length() - 1) != '/')) 
                || (historyInput.length() != 0 && !checkIfLastCharIsOperator(historyInput.charAt(historyInput.length() - 2)))){
                    if (immediateInput.length() != 0)
                        historyInput = deleteToLastOperator(historyInput);
                    historyInput += immediateInput + " / ";
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = "";
                }
            }
        });
        // multiplication *
        buttonsPanel.multiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((immediateInput.length() != 0 && (immediateInput.charAt(immediateInput.length() - 1) != '*')) 
                || (historyInput.length() != 0 && !checkIfLastCharIsOperator(historyInput.charAt(historyInput.length() - 2)))){
                    if (immediateInput.length() != 0)
                        historyInput = deleteToLastOperator(historyInput);
                    historyInput += immediateInput + " * ";
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = "";
                }
            }
        });
        // answer
        buttonsPanel.mod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((immediateInput.length() != 0 && (immediateInput.charAt(immediateInput.length() - 1) != 'd')) 
                || (historyInput.length() != 0 && !checkIfLastCharIsOperator(historyInput.charAt(historyInput.length() - 2)))){
                    if (immediateInput.length() != 0)
                        historyInput = deleteToLastOperator(historyInput);
                    historyInput += immediateInput + " Mod ";
                    showAllOperationLabel.setText(historyInput);
                    immediateInput = "";
                }
            }
        });
        // here
        buttonsPanel.answer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valid = validateTheStringForTheLastTime();
                double ans = 0;
                if (valid != "")
                    ans = MathClass.calculateTheReadyPrefixedInput(valid);
        
                inputArea.setText(ans + " ");
                historyInput = ans + "";                
                immediateInput = "";
            }
        });

        
    }
    private boolean checkIfOperatorExist(){
        boolean hasOp = false;
        int index = historyInput.length() - 1;
        while (index >= 0){
            if (historyInput.charAt(index) == '+' || historyInput.charAt(index) == '-' || historyInput.charAt(index) == '*' 
            || historyInput.charAt(index) == '/' ||historyInput.charAt(index) == 'M'){
                hasOp = true;
                break;
            }
            index--;
        }
        return hasOp;
    }
    // math shit area
    // factorial
    private long fact(int num){
        if (num == 1 || num == 2)
            return num;
        if (num % 2 == 0){
            long a = 1;
            long b = 1;
            for(int i = 1; i < num; i += 2){
                a *= i;
                b *= i + 1;
            }
            return (long)a * b;
        }
        long ans = 1;
        for (int i = 2; i <= num; ++i)
            ans *= i;
        return ans;
    }
    // setting things up for the real Math
    private String createTheValidNumberString(){
        String readyString = "";
        String tempString = "";
        if (checkIfOperatorExist())
            tempString = historyInput + immediateInput;
        else{
            if (immediateInput.length() > 0){
                tempString = immediateInput;
                historyInput = "";
            }else{
                tempString = historyInput;
            }
        }
        
        String[] eachSectionOfNumber = tempString.split(" ");
        for (int i = 0; i < eachSectionOfNumber.length; ++i){
            if(MathClass.isEmpty(eachSectionOfNumber[i]))
                continue;
            String temp = "";
            double holder = 0;
            if (eachSectionOfNumber[i].contains("+") || eachSectionOfNumber[i].contains("-") || eachSectionOfNumber[i].contains("*") || eachSectionOfNumber[i].contains("/") || eachSectionOfNumber[i].contains("Mod"))
                readyString += " " + eachSectionOfNumber[i] + " ";
            else if (eachSectionOfNumber[i].matches("[0.0-9.0]+")){
                readyString += eachSectionOfNumber[i];
            }
            else{
                if (eachSectionOfNumber[i].contains("sqr")){
                    temp = eachSectionOfNumber[i].substring(4, eachSectionOfNumber[i].length() - 1);
                    holder = Integer.parseInt(temp);
                    holder = Math.pow(holder, 2);
                    readyString += holder;
                }else if (eachSectionOfNumber[i].contains("abs")){
                    temp = eachSectionOfNumber[i].substring(4, eachSectionOfNumber[i].length() - 1);
                    holder = Integer.parseInt(temp);
                    holder = Math.abs(holder);
                    readyString += holder;
                }else if (eachSectionOfNumber[i].contains("!")){
                    temp = eachSectionOfNumber[i].substring(0, eachSectionOfNumber[i].length() - 1);
                    holder = Integer.parseInt(temp);
                    holder = (double)fact((int)holder);
                    readyString += holder;
                }else if (eachSectionOfNumber[i].contains("^")){
                    temp = eachSectionOfNumber[i].substring(4, eachSectionOfNumber[i].length() - 1);
                    holder = Integer.parseInt(temp);
                    holder = Math.pow(10, (int)holder);
                    readyString += holder;
                }else if (eachSectionOfNumber[i].contains("log")){
                    temp = eachSectionOfNumber[i].substring(4, eachSectionOfNumber[i].length() - 1);
                    holder = Integer.parseInt(temp);
                    holder = Math.log10(holder);
                    readyString += holder;
                }else if (eachSectionOfNumber[i].contains("ln")){
                    temp = eachSectionOfNumber[i].substring(3, eachSectionOfNumber[i].length() - 1);
                    holder = Integer.parseInt(temp);
                    holder = Math.log10(holder);
                    readyString += holder;
                }else if (eachSectionOfNumber[i].contains("√")){
                    temp = eachSectionOfNumber[i].substring(2, eachSectionOfNumber[i].length() - 1);
                    holder = Integer.parseInt(temp);
                    holder = Math.sqrt(holder);
                    readyString += holder;
                }
            }
        }
        return readyString;
    }
    // here and math
    private String validateTheStringForTheLastTime(){
        String last = createTheValidNumberString();
        int i = last.length() - 1;
        while (i >= 0){
            if (last.charAt(i) == '+' || last.charAt(i) == '-' || last.charAt(i) == '*' || last.charAt(i) == '/' 
            || last.charAt(i) == 'M' || last.charAt(i) == 'o' || last.charAt(i) == 'd' || last.charAt(i) == ' ')
                i--;
            else
                break;
        }
        historyInput = last.substring(0, i + 1);
        showAllOperationLabel.setText(historyInput);
        return historyInput;
    }
    
}