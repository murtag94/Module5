import java.util.Calendar;

public class Loader
{
    public static void main(String[] args)
    {
        int region[] = {11, 12, 15, 17, 19, 22};
        int firstYear = 1997;
        int lastYear = Calendar.getInstance().get(Calendar.YEAR);
        int series[] = new int[lastYear - firstYear + 1];
        for(int i = 0; i <= series.length - 1; i++)
        {
            series[i] = (firstYear + i) % 100;
        }
        for(int i = 0; i <= region.length - 1; i++)
        {
            for(int j = 0; j <= series.length - 1; j++)
            {
                System.out.printf(region[i] + " %02d\n", series[j]);
            }
        }
    }
}
