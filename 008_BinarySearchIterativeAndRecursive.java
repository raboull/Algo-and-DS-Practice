//Java program that implements the Binary Search in iterative and recursive formats
import java.lang.Math;
class BinarySearchIterativeAndRecursive 
{
    //This function implements the binary search algorithm in an iterative approach.
    //Input:
    //      A - array of numberic values that are sorted
    //      v - value that needs to be found in A
    //      low - lowest index of sub-array of A currently checked
    //      high - highest index of sub-array of A currently checked
    //Output:
    //      -1 - if the value v is not found in array A
    //      positive int - that is the index in A that contains value v
    int binarySearchIterative(int A[], int v, int low, int high)
    {
        while (low<=high)
        {
            int mid = (int)Math.floor((low+high)/2);
            if (v == A[mid])
                return mid;
            else if (v > A[mid])
                low = mid+1;//discard left half of current sub-array
            else
                high = mid-1;//discard right half of current sub-array
        }
        return -1;
    }

    //This function implements the binary search algorithm in a recursive approach.
    //Input:
    //      A - array of numberic values that are sorted
    //      v - value that needs to be found in A
    //      low - lowest index of sub-array of A currently checked
    //      high - highest index of sub-array of A currently checked
    //Output:
    //      -1 - if the value v is not found in array A
    //      positive int - that is the index in A that contains value v
    int binarySearchRecursive(int A[], int v, int low, int high)
    {
        if (low>high)
            return -1;
        int mid = (int)Math.floor((low+high)/2);
        if (v==A[mid])
            return mid;
        else if(v>A[mid])//eliminate left half of the current sub-array
            return binarySearchRecursive(A, v, mid+1, high);
        else //eliminate right half of current sub-array
            return binarySearchRecursive(A, v, low, mid-1);
    }

    // Driver method
    public static void main(String args[])
    {
        int TestArray[] = {2, 4, 6, 18, 29};//initialize an array that will be used for testing
 
        BinarySearchIterativeAndRecursive object = new BinarySearchIterativeAndRecursive();
        
        //test the iterative approach
        int result = object.binarySearchIterative(TestArray, 18, 0, TestArray.length);
        System.out.println("Iterative binary search result: "+result);
        
        //test the recursive approach
        result = object.binarySearchRecursive(TestArray, 18, 0, TestArray.length);
        System.out.println("Recursive binary search result: "+result);
    }    
}
