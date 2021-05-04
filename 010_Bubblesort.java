//Java program that implements the Bubblesort algorithm

class Bubblesort
{
    //This function implements the bubblesort algorithm.
    //Input:
    //      A - array of integers.
    //Output: none.
    //Limitations: input only array of ints.
    public void bubblesort(int A[])
    {
        for (int i=0; i<A.length; i++){
            for (int j=A.length-1;j>0;j--){
                if (A[j]<A[j-1]){//exchange A[j] and A[j-1]
                    int temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
            }
        }
    }

    // A utility function to print an array
    static void printArray(int A[])
    {
        for (int i = 0; i < A.length; ++i)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int TestArray[] = {4, 2, 6, 29, 18};//initialize an array that will be used for testing
 
        Bubblesort object = new Bubblesort();
        
        //test the bubblesort method
        object.bubblesort(TestArray);
        printArray(TestArray);
    }    
}
