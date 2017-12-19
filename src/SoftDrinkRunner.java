import java.util.Scanner;
import java.util.Map;

public class SoftDrinkRunner
{
    private final static Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args)
    {
        double fInput = -1;

        //double fTemp = PromptDouble("Enter the temperature: ");
        double fTemp = SoftDrinkMachine.randomTemperature();

        System.out.println("Current temperature: " + fTemp);

        while (fInput < 0 || fInput > 1.00)
            fInput = PromptDouble("Enter money (Accepts up to $1.00): ");

        double fCost = SoftDrinkMachine.getPrice(fTemp);

        System.out.println("Cost of the soda: $" + fCost);

        if (fCost > fInput)
        {
            System.out.println("Insufficient amount");
            return;
        }

        double fChange = fInput - fCost;

        Map<String, Integer> mChange = SoftDrinkMachine.Coins.convert(fChange);

        System.out.println(String.format("\r\n\r\nChange: \r\n\r\nQuarter: %d\r\nDime: %d\r\nNickel: %d\r\nPenny: %d", mChange.get("quarter"), mChange.get("dime"), mChange.get("nickel"), mChange.get("penny")));
    }

    protected static double PromptDouble(String question)
    {
        System.out.print(question);

        while (!SCAN.hasNextDouble())
        {
            System.out.flush();

            System.out.print("Enter a decimal: ");

            SCAN.next();
        }

        return SCAN.nextDouble();
    }
}
