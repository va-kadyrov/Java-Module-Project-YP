import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int payersCount = GetPayersCount();
        MyBuscket myBuscket = new MyBuscket(payersCount);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название товара:");
            String itemName = scanner.next();
            myBuscket.addItem(itemName, getItemPrice());
            System.out.println("Товар добавлен.");

            System.out.println("Вы хотите добавить еще товар? (введите любое слово чтобы продолжть или введите 'Завершить' чтобы закончить.");
            if (scanner.next().equalsIgnoreCase("Завершить")) {
                break;
            }
        }
        myBuscket.PrintItems();
        myBuscket.CountPayments();
    }

    static int GetPayersCount() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("На сколько человек разделить счет? (введите целое число больше 1)");
                int payersCount = scanner.nextInt();
                if (payersCount > 1) {
                    return payersCount;
                } else if (payersCount == 1) {
                    System.out.println("Ошибка! Нет смысла делить счет на одного человека.");
                } else {
                    System.out.println("Ошибка! Вы ввели меньше одного человека.");
                }
            } catch (Exception e) {
                scanner.next();
                System.out.println("Ошибка! Требуется ввести целое число.");
            }
        }
    }

    static double getItemPrice() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        while (true) {
            try {
                System.out.println("Введите стоимость товара:");
                double itemPrice = scanner.nextDouble();
                if (itemPrice > 0) {
                    return itemPrice;
                } else {
                    System.out.println("Ошибка! Стоимость должна быть больше нуля.");
                }
            } catch (Exception e) {
                scanner.next();
                System.out.println("Ошибка! Требуется ввести число.");
            }
        }
    }
}
