
// Java program for implementation of rucursive Insertion Sort
class InsertionSortRecursive {
    /*Function to sort array using insertion sort*/
    void insertionSortRecursive(int A[], int n)
    {
        if (n>1){
            n = n-1;
            insertionSortRecursive(A,n);
            //at this point all elements to the left of element n are sorted in increasing order
            //keep swapping element n of the input array until it is larger than all elements to the left of it
            while (n>0 && A[n]<A[n-1]){
                int temp = A[n];
                A[n] = A[n-1];
                A[n-1] = temp;
                n = n-1;
            }
        }
    }
 
    /* A utility function to print array of size n*/
    static void printArray(int A[])
    {
        for (int i = 0; i < A.length; ++i)
            System.out.print(A[i] + " ");
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[])
    {
        int TestArray[] = {12,11,13,5,6};//initialize an array that will be used for testing
 
        InsertionSortRecursive object = new InsertionSortRecursive();
        object.insertionSortRecursive(TestArray, TestArray.length);
 
        printArray(TestArray);
    }
}