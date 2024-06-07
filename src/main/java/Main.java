import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String MSG_INPUT_GOOD = "Введите название товара:";
        final String MSG_GOODS_ADDED = "Товар добавлен.";
        final String MSG_REQUEST_CONTINUE = "Вы хотите добавить еще товар? (введите любое слово чтобы продолжть или введите 'Завершить' чтобы закончить.";
        final String COMMAND_FINISH = "Завершить";

        int payersCount = getPayersCount();
        MyBuscket myBuscket = new MyBuscket(payersCount);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(MSG_INPUT_GOOD);
            String itemName = scanner.next();
            myBuscket.addItem(itemName, getItemPrice());
            System.out.println(MSG_GOODS_ADDED);

            System.out.println(MSG_REQUEST_CONTINUE);
            if (scanner.next().equalsIgnoreCase(COMMAND_FINISH)) {
                break;
            }
        }
        myBuscket.printItems();
        myBuscket.countPayments();
    }

    static int getPayersCount() {

        final String MSG_INPUT_COUNT_PAYERS = "На сколько человек разделить счет? (введите целое число больше 1)";
        final String ERR_ONE_PAYER = "Ошибка! Нет смысла делить счет на одного человека.";
        final String ERR_NO_PAYERS = "Ошибка! Вы ввели меньше одного человека.";
        final String ERR_INCORRECT_INPUT = "Ошибка! Требуется ввести целое число.";

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(MSG_INPUT_COUNT_PAYERS);
                int payersCount = scanner.nextInt();
                if (payersCount > 1) {
                    return payersCount;
                } else if (payersCount == 1) {
                    System.out.println(ERR_ONE_PAYER);
                } else {
                    System.out.println(ERR_NO_PAYERS);
                }
            } catch (Exception e) {
                scanner.next();
                System.out.println(ERR_INCORRECT_INPUT);
            }
        }
    }

    static double getItemPrice() {

        final String MSG_INPUT_PRICE = "Введите стоимость товара:";
        final String ERR_NEGATIVE_PRICE = "Ошибка! Стоимость должна быть больше нуля.";
        final String ERR_INCORRECT_INPUT = "Ошибка! Требуется ввести число.";

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        while (true) {
            try {
                System.out.println(MSG_INPUT_PRICE);
                double itemPrice = scanner.nextDouble();
                if (itemPrice > 0) {
                    return itemPrice;
                } else {
                    System.out.println(ERR_NEGATIVE_PRICE);
                }
            } catch (Exception e) {
                scanner.next();
                System.out.println(ERR_INCORRECT_INPUT);
            }
        }
    }
}
