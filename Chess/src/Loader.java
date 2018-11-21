public class Loader
{
    public static void main(String[] args)
    {
        String letters[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String number[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        String chess[][] = new String[letters.length][number.length];
        System.out.print("  ");
        for(String out : number)
        {
            System.out.print(out + "  ");
        }
        for(int i = 0; i <= letters.length - 1; i++)
        {
            System.out.println();
            System.out.print(letters[i] + " ");
            for(int j = 0; j <= number.length - 1; j++)
            {
                chess[i][j] = letters[i] + number[j];
                System.out.print(chess[i][j] + " ");
            }
        }
    }
}
