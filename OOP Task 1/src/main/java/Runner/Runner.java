package Runner;
import Animal.Animal;
import Animal.Elephant;
import Animal.Tiger;
import Animal.Wolf;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    //TODO а id точно должен быт static?
    private static int id = 0;
    private int chooseNum, num1, num2 = 0;
    private Animal[] animalCage = new Animal[10];

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private Animal getRandomAnimal() {
        int num = getRandomNumber(1, 4);
        if (num < 2) {
            return new Elephant("Elephant_" + id, getRandomNumber(1, 9), getRandomNumber(900, 1000));
        } else if (num < 3) {
            return new Tiger("Tiger_" + id, getRandomNumber(1, 9), getRandomNumber(100, 150));
        } else {
            return new Wolf("Wolf_" + id, getRandomNumber(1, 9), getRandomNumber(60, 85));
        }
    }

    public void fillAnimalCage() {
        for (int i = 0; i < animalCage.length; i++) {
            animalCage[i] = getRandomAnimal();
            id++;
        }
    }

    //TODO придираюсь: метод переводится - как "получить всех животных" но метод ничего не возвращает
    // я считаю, что такой метод должен иметь название printAnimals()
    // ИМХО
    public void getAllAnimals() {
        for (Animal animal : animalCage) {
            System.out.println(animal.toString());
        }
    }

    private void inputChoose() {
        Scanner in = new Scanner(System.in);
        try {
            chooseNum = in.nextInt();
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException("Разрешен ввод только цифр!!!");
        }
    }

    public void getSpecificAnimal() {
        System.out.println("Выберите животноe: \n1)Слон; \n2)Тигр; \n3)Волк; \nВвод:");
        inputChoose();
        switch (chooseNum) {
            case 1:
                for (Animal animal : animalCage) {
                    if (animal instanceof Elephant) {
                        System.out.println(animal.toString());
                    }
                }
                break;
            case 2:
                for (Animal animal : animalCage) {
                    if (animal instanceof Tiger) {
                        System.out.println(animal.toString());
                    }
                }
                break;
            case 3:
                for (Animal animal : animalCage) {
                    if (animal instanceof Wolf) {
                        System.out.println(animal.toString());
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Неправильный ввод");
        }
    }

    //TODO придираюсь: метод сортировки безусловно работает, но это велосипед
    // посмотри про Comparator, интерфейс Comparable и сортировки с помощью Arrays.sort()
    private void sortByWeight() {
        int n = animalCage.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (animalCage[j].getWeight() > animalCage[j + 1].getWeight()) {
                    Animal temp = animalCage[j];
                    animalCage[j] = animalCage[j + 1];
                    animalCage[j + 1] = temp;
                }
            }
        }
    }

    private void sortByHungryStatus() {
        int n = animalCage.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (animalCage[j].getHungryStatus() > animalCage[j + 1].getHungryStatus()) {
                    Animal temp = animalCage[j];
                    animalCage[j] = animalCage[j + 1];
                    animalCage[j + 1] = temp;
                }
            }
        }
    }

    private void sortByName() {
        int n = animalCage.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int res = animalCage[j].getName().compareTo(animalCage[j + 1].getName());
                if (res > 0) {
                    Animal temp = animalCage[j];
                    animalCage[j] = animalCage[j + 1];
                    animalCage[j + 1] = temp;
                }
            }
        }

    }

    public void getSortedAnimals() {
        System.out.println("Выберите параметр для сортировки: \n1)По весу; \n2)По сытости; \n3)По имени; \nВвод:");
        inputChoose();
        switch (chooseNum) {
            case 1:
                sortByWeight();
                getAllAnimals();
                break;
            case 2:
                sortByHungryStatus();
                getAllAnimals();
                break;
            case 3:
                sortByName();
                getAllAnimals();
                break;
            default:
                throw new IllegalArgumentException("Неправильный ввод");
        }
    }

    private void inputRange() {
        Scanner in = new Scanner(System.in);
        String text;
        System.out.println("Введите диапазон в формате 1-9999: ");
        text = in.nextLine();
        try {
            String[] blocks = text.split("-");
            num1 = Integer.parseInt(blocks[0]);
            num2 = Integer.parseInt(blocks[1]);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Не верный формат данных");
        }
    }

    public void getAnimalByParameter() {
        System.out.println("Выберите параметр: \n1)По весу; \n2)По сытости; \nВвод:");
        inputChoose();
        inputRange();
        switch (chooseNum) {
            case 1:
                for (Animal anim : animalCage) {
                    if (anim.getWeight() >= num1 && anim.getWeight() <= num2) {
                        System.out.println(anim.toString());
                    }
                }
                break;
            case 2:
                for (Animal anim : animalCage) {
                    if (anim.getHungryStatus() >= num1 && anim.getHungryStatus() <= num2) {
                        System.out.println(anim.toString());
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Неправильный ввод");
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.fillAnimalCage(); //заполнить клетку случайными животными
        runner.getAllAnimals(); //Показать весь питомник
        runner.getSpecificAnimal(); //Показать только выбранный вид животных
        runner.getSortedAnimals(); //Отсортировать коллекцию по выбранному параметру
        runner.getAnimalByParameter();//Вывести животное подходящее под заданные параметры
    }
}
