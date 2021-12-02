package homework1;
// структура Участника
public class Member {
    String name;
    boolean isWinner;
    int endurance;

    public Member(String name, int endurance) {
        this.name = name;
        isWinner = false;
        this.endurance =  endurance;
    }

    @Override
    public  String toString() {

        return "name:" + name + ",  Победитель?:" + isWinner + " Выносливость:" + endurance;
    }
}
