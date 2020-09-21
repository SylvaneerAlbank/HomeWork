package BasePackage;

import InputString.InputString;

public class Main {

    public static void main(String[] args) {
        InputString inputObj = new InputString();
        inputObj.inputLine();
        inputObj.inputChar();
        System.out.println(inputObj.getWordWithMaxEntries());
        //метод делает всю работу, это нехорошо,
        // лучше декомпозировать
        // inputObj.inputLine(); - вводишь и запоинаеш ьстроку
        // initInput.initChar(); - вводишь и запоминаешь символ
        // inputObj.searchWordWithMaxEntries() - ищещшь слово с максимальным количеством повторений и запоминаешь его
        // System.out.println(inputObj.getWord()) - выводишь его на экран
        // P.S. последние два метода могут быть соеденины и называться inputObj.getWordWithMaxEntries();
    }
}
