package homework2;

import java.util.Random;
import java.util.Scanner;

public class Homework2 {


    private static final int ARRAY_SIZE_ROWS = 4; // размер правильного массива, количество строк
    private static final int ARRAY_SIZE_COLUMNS = 4; // размер правильного массиваб количество столбцов

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        System.out.println("Создайте массив, с которым будут происходить дальнейшие манипуляции");

        System.out.println("Введите количество строк в массиве");
        Scanner scanRows = new Scanner(System.in);
        int rows = scanRows.nextInt();

        System.out.println("Введите количество столбцов в массиве");
        Scanner scanCols = new Scanner(System.in);
        int cols = scanRows.nextInt();

        String[][] array = new String[rows][cols];

        actionsOnArray(array);

        }

    private static void actionsOnArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (isArray4X4(array)) // массив правильный, можем продолжать манипуляции?
         {
            System.out.println("Заполнили массив");
            filledArray(array); // заполним массив рандомными значениями

            System.out.println("Напечатали заполненный массив");
            printArray(array);

            System.out.println("Суммируем массив.....");
            sumElementsArray(array);
        }

        System.out.println("Манипуляции с массивом закончены! Всем спасибо за участие :-)");

}

    private static boolean isArray4X4(String[][] a) {
        int rows = a.length;
        int columns = a[0].length;

        try {
            if (rows != ARRAY_SIZE_ROWS | columns != ARRAY_SIZE_COLUMNS) {
                throw new MyArraySizeException();
            } else {
                System.out.println("Размер массива равен "+ ARRAY_SIZE_ROWS +"X" + ARRAY_SIZE_COLUMNS +
                        "Можем продолжать манипуляции");
            }
        } catch (MyArraySizeException exc){
            System.out.println("Размер массива не равен " + ARRAY_SIZE_ROWS +"X" + ARRAY_SIZE_COLUMNS + ", а равен " + rows + "X" + columns);
            return false;
        }
        return true;
    }

    private static void filledArray(String[][] arr)  {

        int randomNumber;
        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j < arr.length ; j++) {
                arr[i][j] = String.valueOf(rand(10));
            }
        }

        randomNumber = rand(ARRAY_SIZE_ROWS+2); // определим случайное число для заполнения массива строкой

        // применяем только знак < чтобы была вероятность не заполнять строкой ячейку
        if (randomNumber < arr[0].length || randomNumber < arr.length) {
            arr[randomNumber][randomNumber] = "exception";
        }
    }

    private static void printArray(String[][] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }


    private static void sumElementsArray(String[][] array) {
        int i= 0;
        int j= 0;

        try {
            int[][] arrayTmp = new int[array.length][array[0].length];
            int sum = 0;
            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array.length; j++) {
                    if (isDigit(array[i][j])) { // можем преобразовать значение ячейки в целое число?
                        sum = sum + Integer.parseInt(array[i][j]);
                        arrayTmp[i][j] = sum;
                    } else {
                        throw new MyArrayDataException();
                    }
                }
            }
            printArrayInt(arrayTmp);

        } catch(MyArrayDataException e){
            System.out.println("В массиве есть строка, которая не может быть преобразована в число, в row:"
                    + (i+1) + " column:" +  (j+1) ) ;
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(String.valueOf(s));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private static void printArrayInt(int[][] arr){

        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j < arr.length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }



    private static int rand(int number) {
        Random rand1 = new Random();
        return rand1.nextInt(number);
    }

    static class MyArrayDataException extends Exception {

    }


    static class MyArraySizeException extends Exception {
    }

}


