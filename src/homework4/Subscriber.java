package homework4;

public class Subscriber {
    String name;
    String phone;

    public Subscriber(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public  String toString(){
        return ("[Имя: " +  name + ", Телефон: " + phone + "]");
    }
}
