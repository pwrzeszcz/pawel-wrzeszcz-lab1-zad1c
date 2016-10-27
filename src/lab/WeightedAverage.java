package lab;

import java.util.*;

public class WeightedAverage
{
    public static void main(String[] args)
    {
        Map<Double, Double> dataSet;

        dataSet = getInputNumbersWithWeights();

        if(dataSet.size() > 0)
        {
            printInputNumbersAndWeights(dataSet);

            System.out.println("\nWeighted average: " + getWeightedAverageFrom(dataSet));
        }
    }

    private static Map<Double, Double> getInputNumbersWithWeights()
    {
        double number;
        double weight;
        String userAnswer;
        Map<Double, Double> dataSet = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Provide a number: ");

            try
            {
                number = Double.parseDouble(scanner.nextLine());
                weight = new Random().nextDouble();

                dataSet.put(number, weight);
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

        return dataSet;
    }

    private static void printInputNumbersAndWeights(Map<Double, Double> dataSet)
    {
        System.out.println("\nProvided numbers and generated weights: ");

        for (Map.Entry<Double, Double> entry: dataSet.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
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
}
