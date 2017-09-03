import java.io.*;
import java.util.*;

/**
 * Calculate the standard deviation of a given array of numbers.
 * INPUT:
 * The first line contains an integer, N, denoting the number of elements in the array. 
 * The second line contains N space-separated integers describing the respective elements of the array.
 * @author Patrick Kowalski
 * Print the standard deviation on a new line, rounded to a scale of 1 decimal place
 */

public class StandardDeviation {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int total = 0;
        double mean;
        int tempNumber;
        double deviation = 0;
        
        
        for(int i=0; i<size; i++) {
            tempNumber = in.nextInt();
            total += tempNumber;
            numbers.add(tempNumber);
        }
        
        mean = total/size;
      
        System.out.println(String.format( "%.1f",StandardDeviation.CalcDeviationOfList(numbers, mean)));
        
    }
    
    public static double CalcSquaredDistance(double mean, double compare) {
        
        return (Math.pow((compare - mean), 2));
    }
    
    public static double CalcDeviationOfList(List<Integer> numbers, double mean) {
        double deviation = 0;
        int size = numbers.size();
        
        for(int i = 0;i<size;i++) {
            deviation += StandardDeviation.CalcSquaredDistance(mean, numbers.get(i));
        }
        
        return Math.sqrt((deviation/size));
    }
    
}

