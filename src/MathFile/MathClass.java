package src.MathFile;

import java.util.Stack;

public class MathClass {

    public static double calculateTheReadyPrefixedInput(String inputRaw){
        String input = changeToPostFix(inputRaw);
        Stack<String> stackOfNumbers = new Stack<>();
        String[] listStrings = input.split(" ");
        for (int i = 0; i < listStrings.length; ++i){
            if (isEmpty(listStrings[i]))
                continue;
            if (isOperator(listStrings[i])){
                double b = Double.parseDouble(stackOfNumbers.peek());
                stackOfNumbers.pop();
                double a = Double.parseDouble(stackOfNumbers.peek());
                stackOfNumbers.pop();
                double ans = doMath(a, b, listStrings[i]);
                stackOfNumbers.push(ans + " ");
            }else{
                stackOfNumbers.push(listStrings[i]);
            }
        }
        return Double.parseDouble(stackOfNumbers.peek());
    }

    public static boolean isEmpty(String input){
        int c = 0;
        for (int i = 0; i < input.length(); ++i){
            if (input.charAt(i) != ' ')
                c++;
        }
        if (c != 0)
            return false;
        return true;
    }

    public static double doMath(double a, double b, String op){
        if(op.equals("Mod"))
            return a % b;
        if(op.equals("*"))
            return a * b;
        if(op.equals("/"))
            return a / b;
        if(op.equals("+"))
            return a + b;
        return a - b;
    }

    private static String changeToPostFix(String input){
        String result = "";
        Stack<String> stackOfOperators = new Stack<>();
        String[] listOfEachNumber = input.split(" ");
        for (int i = 0; i < listOfEachNumber.length; ++i){
            if (!isOperator(listOfEachNumber[i]))
                result += " " + listOfEachNumber[i] + " ";
            else{
                if (stackOfOperators.isEmpty())
                    stackOfOperators.push(listOfEachNumber[i]);
                else{
                    if (isStronger(stackOfOperators.peek(), listOfEachNumber[i])){
                        stackOfOperators.push(listOfEachNumber[i]);
                    }else{
                        while (!stackOfOperators.isEmpty() && !isStronger(stackOfOperators.peek(), listOfEachNumber[i])){
                            result += " " + stackOfOperators.peek() + " ";
                            stackOfOperators.pop();
                        }
                        stackOfOperators.push(listOfEachNumber[i]);
                    }
                }
            }
        }
        while(!stackOfOperators.isEmpty()){
            result += " " + stackOfOperators.peek() + " ";
            stackOfOperators.pop();
        }
        return result;
    }

    public static boolean isOperator(String check){
        if (check.equals("+") || check.equals("-") || check.equals("*")
         || check.equals("/") || check.equals("Mod"))
            return true;
        return false;
    }

    private static boolean isStronger(String inStack, String newInput){
        if (newInput.equals(inStack))
            return false;
        if (newInput.equals("Mod"))
            return true;
        if((newInput.equals("*") || newInput.equals("/")) && inStack.equals("+") || inStack.equals("-"))
            return true;
        return false;
    }
}
