public class Loader
{
    public static void main(String[] args)
    {
        String rainbow[] = {"Red", "Orange", "Yellow", "Green", "Cyan", "Blue", "Violet"};
        System.out.println("Original rainbow:");
        for(String out : rainbow){
            System.out.println(out);
        }
        String temp;
        for(int i = 0; i <= rainbow.length / 2; i++)
        {
            temp = rainbow[i];
            rainbow[i] = rainbow[rainbow.length - i - 1];
            rainbow[rainbow.length - i - 1] = temp;
        }
        System.out.println();
        System.out.println("Reversed rainbow:");
        for(String out : rainbow){
            System.out.println(out);
        }
    }
}
