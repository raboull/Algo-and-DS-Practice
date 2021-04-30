#Python program for performing addition of two binary numbers

#Function to perform addition of two binary numbers.
#Input: two n-element arrays containing 1'a and 0's. These arrays are named 
#A and B.
#Output: (n+1)-element array that contains the binary sum of arrays A and B.
#Limitation: the input arrays are of the same length
def AddBinary(A, B):

    #Initialize array C to contain n+1 elements with value of None.
    C =  [None]*(len(A)+1)
    
    #The carry variable will keep track of carry over numbers, initially set to 0.
    carry = 0

    for i in range(len(A)-1,-2,-1): #iterate through every element of the input arrays backwards and then populate the first element of the results array with the latest carry-over value
        #follow rules for binary addition and update the carry value after addition of elements at index i
        if i==-1:
             C[0]=carry
        elif A[i]+B[i]+carry == 0:
            C[i+1] = 0
            carry = 0
        elif A[i]+B[i]+carry == 1:
            C[i+1] = 1
            carry = 0
        elif A[i]+B[i]+carry == 2:
            C[i+1] = 0
            carry = 1
        elif A[i]+B[i]+carry == 3:
            C[i+1] = 1
            carry = 1    
    return C

#Driver code to test above 
#Initialize the input arrays that represent binary values.
A = [1,1]
B = [1,1]

#calculate the addition of binary numbers A and B and store the resulting binary array as result.
result = AddBinary(A,B)

#Print the result.
print(result)
