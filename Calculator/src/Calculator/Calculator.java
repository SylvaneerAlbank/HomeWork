package Calculator;

import java.util.Scanner;

public class Calculator {
    private int num1, num2;
    private char operation;
    private String text;


    Scanner scanner = new Scanner(System.in);

    public void initInput() {
        System.out.print("Введите операцию в формате 2+3: ");
        text = scanner.nextLine();
    }

    public void initVariablesFromInput() {
        try {
            String[] blocks = text.split("[+-/*]");
            num1 = Integer.parseInt(blocks[0]);
            operation = text.charAt(blocks[0].length());
            num2 = Integer.parseInt(blocks[1]);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Не верный формат данных");
        }
    }

    public int evaluate() {
        int result = 0;
        switch (operation) {
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
                if (num2 == 0)
                    throw new IllegalArgumentException("Нельзя делить на 0 !!!");
                else
                    result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }

}