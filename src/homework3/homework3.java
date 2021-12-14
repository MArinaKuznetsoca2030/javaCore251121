package homework3;

import java.util.Arrays;

public class homework3 {
    public static void main(String[] args) {

        String[] arr ={"abs", "df" , "123", "fgg"};
        System.out.println(Arrays.toString(arr));
        changeArray(arr, 1,3);
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------------------------------");

        //Apples
        Apple apple1 = new Apple("золотое превосходное", 1);
        Apple apple2 = new Apple("кандиль", 1);
        Apple apple3 = new Apple("аппорт", 1);
        Apple apple4 = new Apple("семеренко", 1);
        Apple[] apples = new Apple[]{apple1, apple2, apple3, apple4};

        // положим в коробку
        Box<Apple> boxApple = new Box<>(apples);
        boxApple.printAllBox();

        // Вес коробки с яблоками
        System.out.println("Вес коробки: "+boxApple.getWeight());


        //Apples
        Orange orange1 = new Orange("Марокко", 1.5);
        Orange orange2 = new Orange("Китайский", 1.5);
        Orange orange3 = new Orange("Турецкий", 1.5);
        Orange orange4 = new Orange("Египедский", 1.5);
        Orange[] oranges = new Orange[]{orange1, orange2, orange3, orange4};

        // положим в коробку
        Box<Orange> boxOrange = new Box<>(oranges);

        System.out.println("---------------------------------------------");
        boxOrange.printAllBox();

        // Вес коробки с апельсинами
        System.out.println("Вес коробки: "+boxOrange.getWeight());

        //Сравним вес коробок
        System.out.println("---------------------------------------------");
        System.out.println("Сравним вес коробок boxApple и boxOrange: " + boxApple.compare(boxOrange));


        // пересыпим в другую коробку
        Box<Apple> boxApple1 = new Box<>(apples);
        Box<Orange> boxOrange1 = new Box<>(oranges);
        System.out.println("Перемещение фруктов в другую коробку:");

        boxApple1.printAllBox();
        System.out.println("---------------------------------------------");
        boxOrange1.printAllBox();


    }
    private static <T>  void changeArray(T[] array, int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }



}
