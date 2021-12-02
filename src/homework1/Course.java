package homework1;
// Полоса препятствий для соревнования
public class Course {
    int[] obstacles = new int[4]; // препятствия

    public Course(int obstacle1, int obstacle2, int obstacle3, int obstacle4) {
        obstacles[0] = obstacle1;
        obstacles[1] = obstacle2;
        obstacles[2] = obstacle3;
        obstacles[3] = obstacle4;
    }

    @Override
    public  String toString() {

        return "Дистанция1" +  obstacles[0] + ",  Дистанция2:" +  obstacles[1] + " Дистанция3:" +  obstacles[3]+ " Дистанция4:" +  obstacles[4];
    }

    public void courseInfo(){
        for (int i = 0; i < obstacles.length; i++) {
            System.out.print("Размер препятствия" + i +": " + obstacles[i] + ",  " );
        }
    }

    public void doIt(Team team){
        for (Member member: team.members){
            for (int distance: obstacles){
                if (member.endurance >= distance){
                    member.isWinner = true;
                }
                else {
                    member.isWinner = false;
                    break;
                }
            }
        }
    }

}
