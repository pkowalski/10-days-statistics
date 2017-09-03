import java.io.*;
import java.util.*;

/**
 * Calculates the mean, mode, and median of given numbers.
 * INPUT:
 * The first line contains an integer, N , denoting the number of elements in the array. 
 * The second line contains N space-separated integers describing the array's elements.
 * OUTPUT:
 * lines of output in the following order:
 * the mean on a new line, to a scale of  decimal place.
 * the median on a new line, to a scale of  decimal place.
 * the mode on a new line; if more than one such value exists, print the numerically smallest one.
 *
 */

public class CalcMean {

    public static void main(String[] args) {
        double median = 0;
        double sum = 0;
        int mode = 0;
        int highestFreq = 0;

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i< size; i++){
           numbers.add(scanner.nextInt());
        }
        
        Collections.sort(numbers);
        
        for(int i : numbers){
            int currentFreq = Collections.frequency(numbers, i);
            sum += i;
            
            if(currentFreq > highestFreq) {
                highestFreq = currentFreq;
                mode = i;
            }
            
        }
        
        sum = sum/numbers.size();
        
        median = (numbers.get(numbers.size()/2) + numbers.get((numbers.size()/2) - 1)) / 2.00;       
        
        System.out.println(sum);
        System.out.println(median);
        System.out.println(mode);
        
    }
   
}