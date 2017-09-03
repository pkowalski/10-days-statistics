import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

/**
 * The interquartile range of an array is the difference between its first (Q1) and third (Q2) quartiles (i.e. Q3 - Q1 ).
 * Given an array, X, of N integers and an array, F, representing the respective frequencies of X's elements, 
 * construct a data set, S, where each (Xi) occurs at frequency (Fi). Then calculate and print S's interquartile range, 
 * rounded to a scale of 1 decimal place.
 * INPUT:
 * The first line contains an integer, N, denoting the number of elements in arrays X and F
 * The second line contains N space-separated integers describing the respective elements of array X
 * The third line contains N space-separated integers describing the respective elements of array F
 * @author patrick
 *
 */


public class Interquartile {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        List<Integer> freq = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int inputSize = in.nextInt();
        int listSize = 0;
        int middle;
        int tempInt;
        double qLeft;
        double qRight;
        double result;
        
        for(int i = 0;i<inputSize*2;i++) {
            tempInt = in.nextInt();
            if(i < inputSize) {
                numbers.add(tempInt);
            }
            else {
                listSize += tempInt;
                freq.add(tempInt);
            }
        }
        
        
        middle = listSize / 2;
        
        numbers = Interquartile.BuildArrayFromFreq(listSize, numbers, freq);
        Collections.sort(numbers);
              
        if(listSize % 2 == 1) {
            qLeft = Interquartile.GetMedian(0, middle - 1, numbers);
            qRight = Interquartile.GetMedian(middle + 1, listSize - 1, numbers);
        }
        else {
            qLeft = Interquartile.GetMedian(0, middle - 1, numbers);
            qRight = Interquartile.GetMedian(middle, listSize - 1, numbers);
        }
        
        result = qRight - qLeft;
        System.out.println(result);
    }
    
    public static double GetMedian(int start, int end, List<Integer> numbers) {
        int length = end - start + 1;
        int middle = start + (length / 2);
        
        if(length % 2 == 1) {
            return (double) numbers.get(middle);
        }
        
        return (numbers.get(middle-1) + numbers.get(middle)) / 2.00;
    }
    
    public static List<Integer> BuildArrayFromFreq(int size, List<Integer> numbers, List<Integer> freq) {
        int freqIndex = 0;
        int indexVal = freq.get(freqIndex);
        int startIndex = 0;
        boolean continueBuild = true;
        List<Integer> subList = new ArrayList<Integer>();
       
        while(continueBuild) {
            if(startIndex >= size) {
                continueBuild = false;
            }
            else {
                if(startIndex < indexVal) {
                    subList.add(numbers.get(freqIndex));
                    startIndex++;
                }
                else {
                    freqIndex++;
                    indexVal+= freq.get(freqIndex);
                }
            } 
        }
        return subList;
    }
        
}

