//Java program that given a set A of n integers and another integer x, determines whether
//or not there exist two elements in A whose sum is exactly x.

import java.lang.Math; 

class TwoElementsAreSum {

    //This functions determines whether or not there exists two elements in A whose sum is exactly x.
    //Input:
    //      A - array of integers.
    //      x - integer.
    //Output:
    //      1 - if there exists two integers in A whose sum is exactly x.
    //      0 - if there does not exist two integers in A whose sum is exactly x.
    //Runtime of this approach is 2nLog(2n)
    int twoElementsAreSum(int A[], int x){
        //initialize an empty array B with the same length as A
        int[] B = new int[A.length];

        //form the set B, where each element is sum-A[i]
        for (int i=0; i<A.length; i++)
            B[i] = x-A[i];

        //merge sets A and B into set C
        int[] C = new int[A.length+B.length];
        int k = 0; //initialize a counter that will iterate through array C
        for(int j=0; j<A.length; j++){//first copy the elements from array A
            C[k] = A[j];
            k++;
        }
        for(int j=0; j<B.length; j++){//now copy the elemets from array B into remaining elements of C
            C[k] = B[j];
            k++;
        }

        //sort the elements in C using mergeSort
        mergeSort(C, 0, C.length-1);

        //Check if the same value appears in consecutive positions in the sorted merged set C.
        for (int i = 0; i<C.length; i++){
            if(i+1<C.length && C[i]==C[i+1])
                return 1;
        }
        return 0;
    }

    //This functions determines whether or not there exists two elements in A whose sum is exactly x.
    //Input:
    //      A - array of integers.
    //      x - integer.
    //Output:
    //      1 - if there exists two integers in A whose sum is exactly x.
    //      0 - if there does not exist two integers in A whose sum is exactly x.
    //Runtime of this approach is nLog(n)
    int twoElementsAreSum_1(int A[], int x){
        //sort the elements in A using merge sort
        mergeSort(A,0,A.length-1);

        //initialize an empty array B with the same length as A
        int[] B = new int[A.length];

        //form the set B, where each element is sum-A[i]
        for (int i=0; i<A.length; i++)
            B[i] = x-A[i];

        //sort the elements in B using merge sort
        mergeSort(B, 0, B.length-1);

        //merge sets A and B into set C
        int[] C = new int[A.length+B.length];
        int k = 0; //initialize a counter that will iterate through array C
        for(int j=0; j<A.length; j++){//first copy the elements from array A
            C[k] = A[j];
            k++;
        }
        for(int j=0; j<B.length; j++){//now copy the elemets from array B into remaining elements of C
            C[k] = B[j];
            k++;
        }

        //merge the sorted elements of A and B into sorted set C
        merge(C,0,A.length-1,C.length-1);

        //Check if the same value appears in consecutive positions in the sorted merged set C.
        for (int i = 0; i<C.length; i++){
            if(i+1<C.length && C[i]==C[i+1])
                return 1;
        }
        return 0;
    }

   
    //This function merges two sorted arrays into one sorted array.
    //Input:
    //      A - array of integers that is a concatenation of two sorted arrays.
    //      p - index of the first element of the left array.
    //      q - index of the last element in the left array.
    //      r - index of the last element in the right array.
    //Output: none.
    //Limitations:
    void merge(int A[], int p, int q, int r){
        int n1 = q-p+1;//length of the left half of the input array
        int n2 = r-q;//length of the right half of the input array
        
        int[] L = new int[n1];//initialize the left array to be of appropriate size
        int[] R = new int[n2];//initialize the right array to be of appropriate size

        //copy first n1 elements of A into L, and remaining element of A into R
        for (int i = 0; i<n1; i++)
            L[i] = A[p+i];
        for (int i = 0; i<n2; i++)
            R[i] = A[q+i+1];

        //initialize iterators i and j, that will be used to step through arrays L and R respectively
        int i = 0;
        int j = 0;

        //initizlize counter k to starting index of our left array
        int k = p;

        //copy elements from L and R into A in an increasing order
        while (i<n1 && j<n2){
            if (L[i] <= R[j]){
                A[k] = L[i];
                i = i+1;
            }
            else {
                A[k] = R[j];
                j = j+1;
            }
            k = k+1;
        }

        //copy any remainig elements from L into A
        while (i<n1){
            A[k] = L[i];
            k = k+1;
            i = i+1;
        }
        //copy any remaining elements from R into A
        while (j<n2){
            A[k] = R[j];
            k = k+1;
            j = j+1;
        }
    }

    //This function sorts and array using merge sort recursively.
    //Input:
    //      A - array of integers
    //      p - index of the first element of the sub-array of A we are processing
    //      r - index of the last element of the sub-array of A we are processing
    //Output: none.
    //Limitations:
    void mergeSort(int[] A, int p, int r){
        if (p<r){
            int q = (int)Math.floor((p+r)/2);
            mergeSort(A,p,q);
            mergeSort(A,q+1,r);
            merge(A,p,q,r);
        }
    }


    //A utility function to print array of size n
    static void printArray(int A[])
    {
        for (int i = 0; i < A.length; ++i)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    //Driver method
    public static void main(String args[]){
        int testArray[] = {2,4,15,8};//initialize our input array

        TwoElementsAreSum object = new TwoElementsAreSum();//instantiate an instance of our class

        //Test the twoElementsAreSum function
        int result = object.twoElementsAreSum_1(testArray, 13);
        System.out.println("Is sum element present? Boolean answer: "+ result);
    }    
}
