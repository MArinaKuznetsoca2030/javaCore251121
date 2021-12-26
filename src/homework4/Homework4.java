package homework4;

import java.util.ArrayList;
import java.util.HashMap;


public class Homework4 {

    public static void main(String[] args) {
        /*Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти
        и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать,
        сколько раз встречается каждое слово.
         */
        countDuplicates();

        /*
        Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных
        номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью
        метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть
        несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все
        телефоны.
        */

        addSearchSubscriber();

    }

    private static void countDuplicates() {

        HashMap<String, Integer> arrayStrHash = new HashMap<>();
        String[] arrStr = new String[]{"Мама", "мыла", "раму", "раму", "Мама","мыла", "Карл у", "Клалы", "мыла", "украл", "кораллы", "мыла", "Карл у", "украл", "кораллы"};

        System.out.println("Исходный массив:");
        for (int i=0; i < arrStr.length; i++){
            System.out.print("[" + arrStr[i] + "] ");
        }

        for (String arr :arrStr){
            if (arrayStrHash.get(arr) == null) {
                arrayStrHash.put(arr, 1);
            } else {
                arrayStrHash.put(arr, arrayStrHash.get(arr) + 1);
            }

        }
        System.out.println();
        System.out.println("Массив после удаления дублей, с количеством дублей:");
        System.out.println(arrayStrHash);
    }

    private static void addSearchSubscriber() {
        // телефонный справочник
        Subscriber subscriber1 = new Subscriber("Иванов Иван Иванович", "7777770000");
        Subscriber subscriber2 = new Subscriber("Иванов Иван Иванович", "7777770021");
        Subscriber subscriber3 = new Subscriber("Петров Петр Петрович", "7767777007");
        Subscriber subscriber4 = new Subscriber("Иванова Иванесса Ивановна", "7887770100");
        Subscriber subscriber5 = new Subscriber("Иванова Иванесса Ивановна", "7777770000");
        Subscriber subscriber6 = new Subscriber("Иванова Иванесса Ивановна", "7757778800");
        Subscriber subscriber7 = new Subscriber("Козлов Иван Петрович", "7477774444");
        Subscriber subscriber8 = new Subscriber("Иванов Петр Иванович", "7977771111");


        //запись данных Абонентов в Справочник
        ArrayList<Subscriber>  helpDesk = new ArrayList<>();
        helpDesk.add(subscriber1);
        helpDesk.add(subscriber2);
        helpDesk.add(subscriber3);
        helpDesk.add(subscriber4);
        helpDesk.add(subscriber5);
        helpDesk.add(subscriber6);
        helpDesk.add(subscriber7);
        helpDesk.add(subscriber8);
        System.out.println(helpDesk);  //вывод данных Абонентов

        getPhoneSubscriber(helpDesk); // посмотрим есть такой абонент в базе или нет
    }


    private static void getPhoneSubscriber(ArrayList<Subscriber> helpDesk) {
        String  searchGender = "Иванова Иванесса Ивановна";
        int count = 0;
        for (Subscriber subscribers : helpDesk) {
            if (searchGender.equals(subscribers.getName())) {
                System.out.println(subscribers.getPhone());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Абонент по указанной фамилией не зарегистрирован");
        }
    }


}
