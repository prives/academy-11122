package homework3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;


private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) throws ParseException {

    boolean check = true;

    User seller = new User("Max",1000);
    User buyer = new User("Nick", 1000);

    Date date = new Date();

    while (true) {
        System.out.print("Введите свою дату рождения: ");
        String date1 = scanner.next();
        if (date.checkDate1(date1)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date2 = simpleDateFormat.parse(date1);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2);
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            break;
        }

        else if (date.checkDate2(date1)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date date2 = simpleDateFormat.parse(date1);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2);
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            break;
        }

        else{
            System.out.println("Вы нерпавильно ввели свою дату рождения. Повторите попытку.");
        }
    }

   BelarusPhoneValidator belarusPhoneValidator = new BelarusPhoneValidator();

    while (true){
        System.out.print("Введите свой номер телефона: ");
        String number = scanner.next();
        if (belarusPhoneValidator.validate(number)){
            seller.setPhone(number);
            break;
        }
        else{
            System.out.println("Вы неправильно ввели свой номер телефона. Повторите попытку.");
        }
    }

    EmailValidator emailValidator = new EmailValidator();

    while (true){
        System.out.print("Введите свою почту: ");
        String email = scanner.next();
        if (emailValidator.validate(email)){
            seller.setEmail(email);
            break;
        }
        else{
            System.out.println("Вы неправильно ввели свою почту. Повторите попытку");
        }
    }


    Product[] products = new Product[0];

    Deal deal = new Deal(seller,buyer,products);

    while (true) {
        System.out.print("Еслм вы хотите добавить продукт(продукты) в корзину введите 1\n" +
                "Если вы хотите удалить продукт из корзины введите 2\n" +
                "Если вы хотите просмотреть корзину введите 3: ");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                products = deal.addProducts(products);
                break;
            case 2:
                products = deal.deleteProduct(products);
                break;
            case 3:
                deal.countingProducts(products);
                break;
            default:
                System.out.println("Я не знаю такую команду.");
                break;
        }
        while (true) {
            System.out.print("Введите 1, если хотите продолжить выбор продуктов и 2, если хотите получить счёт: ");
            int endOperation = scanner.nextInt();
            if (endOperation == 1) {
                check = false;
                break;
            } else if (endOperation == 2) {
                deal.setProducts(products);
                break;
            } else {
                System.out.println("Я не знаю такой команды. Повторите попытку");
            }
        }
        if (check){
            break;
        }
        check = true;
    }
    deal.bill(deal);
}public class Main {

}
