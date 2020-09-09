package Calculator;
import java.util.Scanner;

public class Calculator {
    private int num1, num2;
    private char operation;
    private boolean success;

    public void startInput() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        try {
        System.out.print("Введите операцию в формате 2+3: ");
        String text = scanner.nextLine();
        String [] blocks = text.split("[+-/*]");

        num1 = Integer.parseInt(blocks[0]);
        operation = text.charAt(blocks[0].length());
        num2 = Integer.parseInt(blocks[1]);
        success=true;

        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Не верный формат данных");
        }
        if(success){
            System.out.print(calculate());
        }
    }

    private int calculate(){
        int result = 0;
        switch (operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw  new IllegalArgumentException("Не верный знак операции");
        }
            return result;
    }

}