package Runner;

import java.util.Comparator;
import java.util.Arrays;

import Animal.Animal;
import Animal.Elephant;
import Animal.Tiger;
import Animal.Wolf;

import java.util.Scanner;

public class Runner {
    private int id = 0;
    private int chooseNum, num1, num2 = 0;
    private Animal[] animalCage = new Animal[10];

    //TODO нарушение конвенции, всегда!!! требуется код заключать в {} даже если он однострочный
    private final class SortByWeight implements Comparator<Animal> {
        public int compare(Animal a, Animal b) {
            if (a.getWeight() < b.getWeight()) {
                return -1;
            } else if (a.getWeight() == b.getWeight()) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    private final class SortByHungryStatus implements Comparator<Animal> {
        public int compare(Animal a, Animal b) {
            if (a.getHungryStatus() < b.getHungryStatus()) {
                return -1;
            } else if (a.getHungryStatus() == b.getHungryStatus()) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    private final class SortByName implements Comparator<Animal> {
        public int compare(Animal a, Animal b) {
            int res = a.getName().compareTo(b.getName());
            if (res < 0) {
                return 1;
            } else if (res == 0) {
                return 0;
            } else {
                return -1;
            }
        }
    }

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

    public void printAnimals() {
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

    public void getSortedAnimals() {
        System.out.println("Выберите параметр для сортировки: \n1)По весу; \n2)По сытости; \n3)По имени; \nВвод:");
        inputChoose();
        switch (chooseNum) {
            case 1:
                Arrays.sort(animalCage, new SortByWeight());
                printAnimals();
                break;
            case 2:
                Arrays.sort(animalCage, new SortByHungryStatus());
                printAnimals();
                break;
            case 3:
                Arrays.sort(animalCage, new SortByName());
                printAnimals();
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
        //runner.printAnimals(); //Показать весь питомник
        //runner.getSpecificAnimal(); //Показать только выбранный вид животных
        runner.getSortedAnimals(); //Отсортировать коллекцию по выбранному параметру
        // runner.getAnimalByParameter();//Вывести животное подходящее под заданные параметры
    }
}
