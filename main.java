import java.util.*;
import java.lang.*;
import java.io.*;
import java.time.*;
import java.


public class Main {
    static void merge(int A[], int p, int q, int r) {
        // Following template for Merge and collectData
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int R[] = new int[n2];

       
        for (int i = 0; i < n1; ++i)
            L[i] = A[p + i];

        for (int j = 0; j < n2; ++j)
            R[j] = A[q + j + 1];


        int i = 0;
        int j = 0;

        int k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
        //Following mergeSort listed
    static void mergeSort(int A[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    //Generating new array
    public static void main(String args[]) throws FileNotFoundException{
        //set println output to new file
        PrintStream file = new PrintStream(new File("output.txt"));
        PrintStream console = System.out;

        //create and populate huge array G with random numbers
        Random randArray = new Random();
        int G[] = new int[201000];
        for (int i = 0; i < 201000; i++)
        {
            G[i] = randArray.nextInt();
        }

        //Date date = new Date();

        double fx[] = new double[400]; //loop will iterate 400 times
        int arrTwo[] = new int[400];
        //array A
        int arrThree[] = new int[201000]; //max size is all possible values of G
        int count = 0;
        //cycles through array G, runs merge sort, gathers data
        for (int n = 1000; n <= 201000; n = n + 500) {

            arrTwo[count] = n;
            //Arrays.fill(arrThree, null); //empties out all previous values of A <------------------ may cause errors?? unsure if merge sort would work properly on array not totally filled
            //populate array A with n numbers from G
            for (int i = 0; i < n; i++) {
                arrThree[i] = G[i];
            }
            //start time
            //date = new Date();
            long start = System.nanoTime(); //date.getTime();
            //execute merge sort(A,0,n-1)
            mergeSort(arrThree, 0, arrThree.length - 1);
            //end time
            //date = new Date();
            long end = System.nanoTime(); //date.getTime();
            fx[count] = (end - start); //T(n) in nanoseconds
            count++;

        }

        System.setOut(file);
        for (int k = 0; k < 400; k++) {
            System.out.println("value of n: " + arrTwo[k]
                + "\n\tT(n)/(n^2)*(sqrt(n)): " + fx[k] / (Math.pow(arrTwo[k], 2) * Math.sqrt((double)arrTwo[k]))
                + "\n\tT(n)/n*log(n): " + fx[k] / (arrTwo[k] * Math.log((double)arrTwo[k]))
                + "\n\tT(n)/sqrt(n)*log(n): " + fx[k] / (Math.sqrt((double)arrTwo[k]) * Math.log((double)arrTwo[k])));
        }
        System.setOut(console);

    }
}

