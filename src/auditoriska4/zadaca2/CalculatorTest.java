package auditoriska4.zadaca2;

import java.util.Scanner;

public class CalculatorTest{

    private double result;
    private CalcOperations strategy;

    CalculatorTest(){
        result = 0.0;
    }

    public String execute(char operation, double value) throws UnknownOperatorException {
        if(operation == '+') strategy = new Addition();
        else if(operation == '-') strategy = new Substraction();
        else if(operation == '*') strategy = new Multiplication();
        else if(operation == '/') strategy = new Division();
        else
            throw new UnknownOperatorException(operation);

        result = strategy.doOperation(result,value);
        return String.format("result %c %.2f = %.2f",operation,value,result);
    }

    public String init(){
        return String.format("initial result is: %.2f", result);
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return String.format("updated result: %.2f",result);
    }

    public static char getCharLower(String line){
        if(line.trim().length() > 0){
            return Character.toLowerCase(line.charAt(0));
        }
        return '?';
    }

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        while(true) {
            CalculatorTest cal = new CalculatorTest();
            System.out.println(cal.init());
            while (true) {
                String line = key.nextLine(); // +5.0 ovaa se povtoruva
                char choice = getCharLower(line); //za site da bidat lower cases, za da procite i golemo R
                if (choice == 'r') {
                    System.out.printf("final result is: %.2f", cal.getResult());
                    break;
                }
                String[] parts = line.split("\\s+");
                char operator = parts[0].charAt(0);
                double value = Double.parseDouble(parts[1]);

                try {
                    System.out.println(cal.execute(operator, value));
                    System.out.println(cal);
                } catch (UnknownOperatorException e) {
                    System.out.println(e.getMessage());
                }
                //R --> pravime proverka
            }
            System.out.println("Again (Y/N)");
            String line = key.nextLine();
            char choice = getCharLower(line);
            if (choice == 'r') break;
            //(Y/N)
        }
    }
}
