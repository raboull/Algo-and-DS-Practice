//Java program that implements the Horner's Polynomial Evaluation algorithm.

class HornersPolynomialEvaluation
{
    //This function implements Horner's polynomial evaluation method.
    //Input:
    //      A - array of constant coeffiecients in the polynomail equation that correspond to exponentiated x in increasing order.
    //      x - value at which we would like to evaluate our exponential equation.
    //Output: evaluated polynomial equation answer as an integer.
    public int naivePolynomialEvaluation(int A[], int x)
    {
        int y = 0;//intialize the answer to 0
        for (int i=A.length; i>=0; i--){
            y = A[i]+x*y;
        }
        return y;
    }

    // Driver method
    public static void main(String args[])
    {
        int TestArray[] = {-1, 2, -6, 2};//initialize an array that will be used for testing
        int x = 3;

        NaivePolynomialEvaluation object = new NaivePolynomialEvaluation();
        
        //test the bubblesort method
        System.out.println(object.naivePolynomialEvaluation(TestArray, x));
    }    
}
