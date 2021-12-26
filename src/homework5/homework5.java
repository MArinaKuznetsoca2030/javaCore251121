package homework5;

import java.io.*;

public class homework5 {
    public static void main(String[] args) {

        saveDataFileCsv(); //запишем данные в файл csv
        System.out.println("__________________________________________");
        readDataFileCsv(); //считаем данные из файла csv

    }

    private static void readDataFileCsv() {

        // считаем из файла данные по строкам
        File fileStart = new File("src/homework5/start.csv");
        String[] wordsFromFile; // строка считанная из файла, разрезанная на слова без ";"
        String[][] wordsNew = new String[3][3];
        String str;

        System.out.println("Начинаем считывать данные из файла.....");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileStart))) {
            int i = 0;
            while ((str = reader.readLine()) != null) {
                wordsFromFile = str.split(";"); // разрежем на слова

                //заполним массив готовыми словами
                wordsNew[i][0]= wordsFromFile[0];
                wordsNew[i][1]= wordsFromFile[1];
                wordsNew[i][2]= wordsFromFile[2];
                i++;
            }
            System.out.println("Считанные данные из файла:");
            printarray(wordsNew); // покажем обработанные данные считанные из файла

        } catch (IOException e)
        { e.printStackTrace();}

    }

    private static void printarray(String[][] wordsNew) {
        for (String[] strings : wordsNew) {
            for (int j = 0; j < wordsNew.length; j++) {
                System.out.print(strings[j] + " ");
            }

            System.out.println();
        }
    }


    private static void saveDataFileCsv() {

        File file = new File("src/homework5/homework5_1.csv");
        String[] header ={"Value 1", "Value 2","Value 3"};
        int[][] data1 = {{100, 200, 300,},
                        {100, 200, 300,},
                        {100, 200, 300,},
                        };

        AppData appData = new AppData(header, data1); // Подготовим данные для записи в файл

        System.out.println("Начинаем записывать данные в homework5_1.csv");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(appData);

            System.out.println("Данные записаны в homework5_1.csv");
            }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
