package homework1;


import java.util.Random;

public class StartCompetitions {

    private static final int MAX_ENDURANCE= 500;
    private static final int MAX_DISTANCE= 300;

    public static void main(String[] args) {
        // заполняем данные участников
        Member member1 = new Member("Maria", rand(MAX_ENDURANCE));
        Member member2 = new Member("Ivan", rand(MAX_ENDURANCE));
        Member member3 = new Member("Petr", rand(MAX_ENDURANCE));
        Member member4 = new Member("Vasilyi", rand(MAX_ENDURANCE));

        // заполняем команду участниками
        Team team = new Team("viktory", member1, member2, member3, member4);

        // генерируем полосу препятствий для соревнований
        Course course = new Course(rand(MAX_DISTANCE), rand(MAX_DISTANCE), rand(MAX_DISTANCE), rand(MAX_DISTANCE));

        System.out.println("Информация о полосе препятствий:");
        course.courseInfo();
        System.out.println("");

        System.out.println("Информация о всех участниках:");
        team.showInfoAboutAllMembers();

        //предлагаем пройти полосу препятствий
        course.doIt(team);

        System.out.println("Информация о победителях:");
        team.showInfoAboutWinners();

        System.out.println("Информация о всех участниках после прохождения полосы препятствий:");
        team.showInfoAboutAllMembers();


    }
    private static int rand(int max_number) {
        Random rand1 = new Random();
        return rand1.nextInt(max_number);
    }
}
