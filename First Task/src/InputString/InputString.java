package InputString;

import java.util.Scanner;

public class InputString {
    String[] strArr;
    char ch;
    Scanner in = new Scanner(System.in);
    String str;

    public void inputLine() {
        System.out.print("Введите строки разделяя пробелами: ");
        strArr = in.nextLine().split(" ");
        if (strArr.length == 0 || strArr[0].length() == 0) {
            throw new IllegalArgumentException("Ввод пустой строки невозможен");
        }
    }

    public void inputChar() {
        System.out.print("Введите символ: ");
        ch = in.next().charAt(0);
    }

    public String getWordWithMaxEntries() {
        int count = 0;
        int lastMax = 0;
        int max = 0;

        //TODO если тебе нужен индекс внутри цикла, лучше использовать обычный for вместо foreach
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length(); j++) {
                if (strArr[i].charAt(j) == (ch)) {
                    count++;
                }
            }
            lastMax = count;
            if (lastMax > max) {
                max = lastMax;
                str = strArr[i];
            }
            count = 0;
        }
        return str;
    }
}
