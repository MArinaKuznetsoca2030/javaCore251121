package homework3;

public class Box<T extends Fruit> {
    T[] arrayList;

    public Box(T[] arrayLists) {
        this.arrayList = arrayLists;
    }

    public void printAllBox() {
        for (T arrayList: arrayList) {
            System.out.println(arrayList.name +" "+ arrayList.weight);
        }
    }

    public double getWeight() {
        double sum = 0;
        for (T arrayLists: arrayList){
            sum += arrayLists.weight;
        }

        return sum;
    }

    public boolean compare(Box<?> secondbox) {

        return this.getWeight() > secondbox.getWeight();
    }


}
