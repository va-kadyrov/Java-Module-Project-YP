import java.util.ArrayList;

public class MyBuscket {
    int payersCount;
    ArrayList<Item> items = new ArrayList<>();

    MyBuscket(int count) {
        payersCount = count;
    }

    public void addItem(String name, double price) {
        items.add(new Item(name, price));
    }

    public void printItems() {
        System.out.println("Добавленные товары:");
        for (Item item : items) {
            System.out.println(item.name + " по цене " + item.price);
        }
    }

    public void countPayments() {
        double res = 0;
        for (Item item : items) {
            res += item.price;
        }
        res = res / payersCount;

        System.out.print("Каждый человек должен заплатить: " + String.format("%.2f", res));

        int resInt = (int) res;

        if (resInt % 100 >= 11 && resInt % 100 <= 19) {
            System.out.print(" рублей");
        } else {
            switch (resInt % 10) {
                case (1):
                    System.out.print(" рубль");
                    break;
                case (2):
                case (3):
                case (4):
                    System.out.print(" рубля");
                    break;
                default:
                    System.out.print(" рублей");
            }
        }
    }
}
