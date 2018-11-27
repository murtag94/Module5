import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Loader
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> medication = new TreeSet<>();
        for(;;)
        {
            System.out.println("Пожалуйста, введите новое лекарство:");
            String command = reader.readLine().trim();
            if(command.equals("LIST"))
            {
                if(medication.size() == 0)
                {
                    System.out.println("Список лекарств пуст!");
                }
                else {
                    System.out.println("Список всех лекарств:");
                    for(String name : medication)
                    {
                        System.out.println(name);
                    }
                }
            }
            else {
                medication.add(command);
            }
        }
    }
}
