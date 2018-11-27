import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Pattern;

public class Loader
{
    public static boolean isSerial(String string) {
        return Pattern.compile("[0-9]{2}\\s[0-9]{2}").matcher(string).matches();
    }

    public static boolean isPassport(String string) {
        return Pattern.compile("[0-9]{2}\\s[0-9]{2}\\s[0-9]{6}").matcher(string).matches();
    }

    public static boolean isName(String string) {
        return Pattern.compile("[А-ЯЁ&&[^ЪЬЫ]]{1}[а-яё]+\\s[А-ЯЁ&&[^ЪЬЫ]]{1}[а-яё]+\\s[А-ЯЁ&&[^ЪЬЫ]]{1}[а-яё]+$").matcher(string).matches();
    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> passports = new HashMap<>();
        int region[] = {1, 3, 4, 5, 11, 12, 15, 17, 19, 22};
        int number = 0;
        int year = Calendar.getInstance().get(Calendar.YEAR) % 100;

        for(;;)
        {
            System.out.println("Введите серию для добавления нового паспорта или AUTO для автоматической генерации серии!");
            String command = reader.readLine().trim();

            if(command.equals("AUTO"))
            {
                number++;
                String key = String.format("%02d %02d %06d", getRandom(region), year, number);
                System.out.println("Введите ФИО владельца паспорта!");
                String name = reader.readLine().trim();
                if(isName(name))
                {
                    passports.put(key, name);
                    System.out.println("Запись сохранена, спасибо!");
                }
                else {
                    System.out.println("Имя введено некорректно!");
                }
            }
            else if(isSerial(command))
            {
                number++;
                String key = String.format("%s %06d", command, number);
                System.out.println("Введите ФИО владельца паспорта!");
                String name = reader.readLine().trim();
                if(isName(name))
                {
                    passports.put(key, name);
                    System.out.println("Запись сохранена, спасибо!");
                }
                else {
                    System.out.println("Имя введено некорректно!");
                }
            }
            else if(isPassport(command))
            {
                String name = passports.get(command);
                if(name != null)
                {
                    System.out.println(String.format("Владельцем паспорта с номером %s является %s", command, name));
                }
                else {
                    System.out.println("Паспорт с данным номером отсутствует в списке!");
                }
            }
            else {
                System.out.println("Команда введена некорректно!");
            }
        }
    }
}
