package InputString;

import java.util.Scanner;

public class InputString {
    String[] strArr;
    char ch;

    public void startInput() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите строки разделяя пробелами: ");
        strArr = in.nextLine().split(" ");
        if (strArr.length == 0 || strArr[0].length() == 0) {
            throw new IllegalArgumentException("Ввод пустой строки невозможен");
        }

        System.out.print("Введите символ: ");
        ch = in.next().charAt(0);
        printResult();
    }

    private void printResult() {
        int count = 0;
        int[] charCount = new int[strArr.length];
        int max = 0;
        int maxIdX = 0;

        //TODO если тебе нужен индекс внутри цикла, лучше использовать обычный for вместо foreach
        int index = 0;
        for (String s : strArr) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == (ch)) {
                    count++;
                }
            }
            //TODO зачем использовать массив для хранения временного количество повторений в слове. можно обойтись обычной переменной!
            charCount[index] = count;
            if (charCount[index] > max) {
                max = charCount[index];
                maxIdX = index;
            }
            count = 0;
            index++;
        }
        if (max != 0)
            System.out.print(strArr[maxIdX]);
        else
            System.out.print("Нет совпадений");
    }

}
