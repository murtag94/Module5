import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Loader
{
    public static void main(String[] args) throws IOException {
        ArrayList<String> aircraftNumbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(;;)
        {
            System.out.println("Пожалуйста, введите бортовой номер самолета, прибывшего на стоянку:");
            String command = reader.readLine().trim();
            if(command.equals("exitAll"))
            {
                if (aircraftNumbers.size() == 0)
                {
                    System.out.println("Стоянка пуста!");
                }
                else {
                    System.out.println("Самолеты покидающие стоянку:");
                    while (aircraftNumbers.size() != 0)
                    {
                        String numbers = aircraftNumbers.remove(aircraftNumbers.size() - 1);
                        System.out.println(numbers);
                    }
                }
            }
            else if(command.equals("exitLast"))
            {
                if (aircraftNumbers.size() == 0)
                {
                    System.out.println("Стоянка пуста!");
                }
                else {
                    String number = aircraftNumbers.remove(aircraftNumbers.size() - 1);
                    System.out.println(String.format("Самолет с бортовым номером %s покидает стоянку!", number));
                }
            }
            else
            {
                if(aircraftNumbers.size() < 5){
                aircraftNumbers.add(command);
                }
                else {
                System.out.println("Стоянка заполнена, въезд запрещен!");
                }
            }
        }
    }
}
