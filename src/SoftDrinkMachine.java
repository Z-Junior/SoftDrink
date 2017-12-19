/**
 * @author Z
 * @since 18 December 2017
 */

import java.util.HashMap;
import java.util.Map;

public class SoftDrinkMachine
{
    enum Coins
    {
        Quarter(0.25), Dime(0.10), Nickel(0.05), Penny(0.01);

        private final double iValue;

        /**
         * A helper function that stores enum data
         * @param iValue Value of the coin
         */
        Coins(double iValue)
        {
            this.iValue = iValue;
        }

        /**
         * Gets coin value
         * @return Coins value
         */
        public double getValue()
        {
            return iValue;
        }

        /**
         * Converts floating points to coin names
         * @param iValue
         * @return A Map<Coin Name, Amount>
         */
        public static Map<String, Integer> convert(double iValue)
        {
            Map<String, Integer> change = new HashMap<>();

            change.put("quarter", (int) (iValue / Quarter.getValue()));

            iValue %= Quarter.getValue();

            change.put("dime", (int) (iValue / Dime.getValue()));

            iValue %= Dime.getValue();

            change.put("nickel", (int) (iValue / Nickel.getValue()));

            iValue %= Nickel.getValue();

            change.put("penny", (int) Math.ceil(iValue / Penny.getValue()));

            return change;
        }
    };

    /**
     * Returns price base on temperature ranges
     * @param iTemp Temperature
     * @return Price in floating points
     */
    public static double getPrice(double iTemp)
    {
        if (iTemp < 50) return 0.50;
        if (iTemp <= 60) return 0.55;
        if (iTemp <= 65) return 0.60;
        if (iTemp <= 70) return 0.65;
        if (iTemp <= 75) return 0.75;
        if (iTemp <= 80) return 0.80;
        if (iTemp <= 85) return 0.85;
        if (iTemp <= 90) return 0.90;

        return 1.00;
    }

    /**
     * Generates a random temperature
     * @return Random integer between 10 - 120
     */
    public static int randomTemperature()
    {
        return (int) (Math.random() * (120 - 10 + 1)) + 10;
    }
}
