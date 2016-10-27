package lab;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class WeightedAverage
{
    public static void main(String[] args)
    {
        double result;
        Map<Double, Double> inputNumbers;

        inputNumbers = getInputNumbersWithWeights();

        for (Map.Entry<Double, Double> entry : inputNumbers.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        if(inputNumbers.size() > 0)
        {
            result = getWeightedAverageFrom(inputNumbers);

            System.out.println("Weighted average: " + result);
        }
    }

    private static Map<Double, Double> getInputNumbersWithWeights()
    {
        double number;
        double weight;
        String userAnswer;
        Map<Double, Double> inputNumbers = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Provide a number: ");

            try
            {
                number = Double.parseDouble(scanner.nextLine());
                weight = getRandomWeightFromRange(1, 10);

                inputNumbers.put(number, weight);
            }
            catch(NumberFormatException $e)
            {
                System.out.println("Invalid value provided");
                break;
            }

            System.out.println("Would you like to provide next number? (y/n): ");
            userAnswer = scanner.nextLine();

            if (!userAnswer.equals("y"))
            {
                break;
            }
        }

        return inputNumbers;
    }

    private static Double getWeightedAverageFrom(Map<Double, Double> dataSet)
    {
        double counter = 0.0;
        double denominator = 0.0;
        double result;

        for (Map.Entry<Double, Double> entry : dataSet.entrySet())
        {
            double number = entry.getKey();
            double weight = entry.getValue();

            counter += number * weight;
            denominator += weight;
        }

        result = counter / denominator;

        return result;
    }

    private static Double getRandomWeightFromRange(Integer min, Integer max)
    {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }
}
