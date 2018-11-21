import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Loader
{
    public static void main(String[] args) throws IOException {
        String[] letters = {"A", "B", "C", "E", "H", "K", "M", "O", "P", "T", "Y", "X"};
        int[] regions = {1, 2, 3 , 4, 5, 6, 7, 8, 9, 10, 11, 50, 51, 52, 53, 61, 62, 63 ,64, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 101, 102, 103, 109, 111, 113, 116, 118, 121, 123, 124, 125, 126, 136, 138, 142, 150, 152, 154, 159, 161, 163, 164, 173, 174, 176, 177, 178, 186, 190, 196, 197, 199, 777, 799};

        HashSet<String> tmp = new HashSet<>();
        HashSet<String> carNumbers = new HashSet<>();

        for(String letter1 : letters){
            for(String letter2 : letters){
                for(String letter3 : letters){
                    for(int digit = 0; digit < 10; digit++)
                    {
                        tmp.add(String.format("%1$s%2$d%2$d%2$d%3$s%4$s", letter1, digit, letter2, letter3));
                    }
                }
            }
        }

        for(String letter : letters){
            for(int digit = 0; digit < 1000; digit++)
            {
                tmp.add(String.format("%1$s%2$03d%1$s%1$s",letter, digit));
            }
        }

        for(int region : regions) {
            for(String number : tmp){
                carNumbers.add(String.format("%s%02d",number, region));
            }
        }

        //******************************************************************************************
        ArrayList<String> carNumberArrayList = new ArrayList<>(carNumbers);
        ArrayList<String> carNumberSortArrayList = new ArrayList<>(carNumbers);
        Collections.sort(carNumberSortArrayList);
        HashSet<String> carNumberHashSet = new HashSet<>(carNumbers);
        TreeSet<String> carNumberTreeSet = new TreeSet<>(carNumbers);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(;;)
        {
            System.out.println("Please type car number:");
            String number = reader.readLine().trim();

            long start = System.nanoTime();
            boolean result = carNumberArrayList.contains(number);
            long finish = System.nanoTime();
            System.out.println("Search by ArrayList: " + String.format(Locale.US, "%b(%f ms)", result, (finish - start) / 1_000_000.0));

            start = System.nanoTime();
            int index = Collections.binarySearch(carNumberSortArrayList, number);
            finish = System.nanoTime();
            if(index >= 0){
                result = true;
            }
            else{
                result = false;
            }
            System.out.println("BinarySearch: " + String.format(Locale.US, "%b(%f ms)", result, (finish - start) / 1_000_000.0));

            start = System.nanoTime();
            result = carNumberHashSet.contains(number);
            finish = System.nanoTime();
            System.out.println("Search by HashSet: " + String.format(Locale.US, "%b(%f ms)", result, (finish - start) / 1_000_000.0));

            start = System.nanoTime();
            result = carNumberTreeSet.contains(number);
            finish = System.nanoTime();
            System.out.println("Search by TreeSet: " + String.format(Locale.US, "%b(%f Ams)", result, (finish - start) / 1_000_000.0));
        }
    }
}
