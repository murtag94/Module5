import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Loader
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> carOwners = new HashMap<>();

        for(;;)
        {
            System.out.println("Пожалуйста, введите номер автомобиля:");
            String carNumber = reader.readLine().trim();
            String name = carOwners.get(carNumber);

            if(name == null)
            {
                System.out.println("Этого номера нет в базе!\nДля регистрации, пожалуйста, введите имя владельца:");
                name = reader.readLine().trim();
                carOwners.put(carNumber, name);
            }
            else{
                System.out.println(String.format("Владелец автомобиля с номером %s: %s", carNumber, name));
            }
        }
    }
}
