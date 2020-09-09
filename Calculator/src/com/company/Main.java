package com.company;

import Calculator.Calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calcObj = new Calculator();
        //TODO у тебя метод startInput делает все на свете: вводит значения, парсит значения и выводит результат.
        // правильнее будет декомпозировать:
        // calcObj.initInput(); - где у нас только сканнер.
        // calcObj.initVariablesFromInput(); - где бы ты значения из введенной строки записывал в поля класса Calculator
        // calcObj.evaluate(); - где бы происходили вычисления
        // и в main уже сделать вывод на экран
        // System.out.println(calcObj.getResult());
        calcObj.startInput();
    }
}
