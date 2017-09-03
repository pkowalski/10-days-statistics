import java.io.*;
import java.util.*;

public class WeightedMean {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        List<Integer> weights = new ArrayList<Integer>();
        int sum = 0;
        int weightSum = 0;
        double weightedMean = 0;
        int temp = 0;
        Scanner ln = new Scanner(System.in);
        
        int size = ln.nextInt();
        
        for(int i = 0; i<(size*2); i++){
            temp = ln.nextInt();
            if(i < size){
                numbers.add(temp);
            }
            else {
                weights.add(temp);
                weightSum+= temp;
            }
        }
        
        for(int j = 0; j<size; j++){
            sum+= (numbers.get(j) * weights.get(j));
        }
        
        weightedMean = (double)sum/(double)weightSum;
        
        System.out.println(String.format("%.1f", weightedMean));
        
    }
}
