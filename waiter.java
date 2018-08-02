import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {
         int k=0,value=2,i=0;int a[]=new int[q];String res="";
    while(k<q){
        for(i=2;i<value;i++){
            if(value%i==0){
                break;
            }
        }
        if(i==value){
            a[k++]=value;
        }
        value++;
    }
        ArrayList<Integer> arr=new ArrayList<Integer>();
        Stack stack1=new Stack();
        int n=0;
        for(int j=0;j<number.length;j++)
            stack1.add(number[j]);
        for(int j=0;j<q;j++){
            Stack sub1=new Stack();
            Stack sub2=new Stack();
            n=stack1.size();
            for(int h=0;h<n;h++){
                if((int)stack1.peek()%a[j]==0){
                     sub1.push(stack1.pop());
                }
                else{
                    sub2.push(stack1.pop());
                }
            }
            n=sub1.size();
            for(int f=0;f<n;f++){
                arr.add((Integer)sub1.pop());
                
            }
            stack1.clear();
            stack1=sub2;
            n=stack1.size();
        }
        n=stack1.size();
        for(int j=0;j<n;j++)
            arr.add((Integer)stack1.pop());
        int b[]=new int[arr.size()];
        for(int p=0;p<arr.size();p++)
            b[p]=arr.get(p);
        return b;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] result = waiter(number, q);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
