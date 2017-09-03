import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

/**
 * Calcuates quartiles of numbers entered
 * TASK:
 * Given an array, N, of  integers, 
 * calculate the respective first quartile (Q1), second quartile (Q2), 
 * and third quartile (Q3). It is guaranteed that Q1, Q2, and Q3 are integers.
 * INPUT:
 * The first line contains an integer, denoting the number of elements in the array. 
 * The second line contains  space-separated integers describing the array's elements.
 * OUTPUT:
 * Print  lines of output in the following order:
 * The first line should be the value of Q1
 * The second line should be the value of Q2
 * The third line should be the value of Q3
 * @author Patrick Kowalski
 *
 */

public class Quartiles {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int middle = size/2;
        double qCenter;
        double qLeft;
        double qRight;
        DecimalFormat format = new DecimalFormat("0.#");
        
        for(int i=0; i<size; i++){
            numbers.add(in.nextInt());
        }
        
        Collections.sort(numbers);
        
        if(size % 2 == 1) {
            qCenter = numbers.get(middle);
            qRight = Quartiles.GetMedian(middle + 1, size - 1, numbers);
        }
        else {
            qCenter = Quartiles.GetMedian(0, size - 1, numbers);
            qRight = Quartiles.GetMedian(middle, size - 1, numbers);
        }

        qLeft = Quartiles.GetMedian(0, middle - 1, numbers);
        
        System.out.println(format.format(qLeft));
        System.out.println(format.format(qCenter));
        System.out.println(format.format(qRight));
    }
    
    public static double GetMedian(int start, int end, List<Integer> numbers) {
        List<Integer> sublist = numbers.subList(start, end + 1);
        int length = sublist.size();
        int middle = length / 2;
        
        if(length % 2 == 1) {
            return (double) sublist.get(middle);
        }
        
        return (sublist.get(middle-1) + sublist.get(middle)) / 2;
    }
}

