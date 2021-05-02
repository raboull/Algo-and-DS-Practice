#Python program for performing merge sort on an array.
import math

#Function for merging two sorted arrays into one sorted array.
#Input: 
#   A - numeric array
#   p - index of the first element of the left array
#   q - index of the last element in the left array
#   r - index of the last element in the right array
#Output: none
#Limitations: not tested too thoroughly
def merge(A,p,q,r):

    n1 = q-p+1#length of the left half of the input array
    n2 = r-q#length of the right half of the input array

    L = [None]*n1#initialize the L array to the appropriate size
    R = [None]*n2#initialize the R array to the appropriate size

    #Copy first half of A into L and the second half of A into R
    for i in range(0, n1):
        L[i] = A[p+i]
    for j in range(0, n2):
        R[j] = A[q+j+1]
    
    i=j=0#Reset our itterators for L and R arrays
    k=p#initialize the k counter to starting index of our left array
    #copy element from L and R into A in an increasing order
    while i<n1 and j<n2:
        if L[i] <= R[j]:
            A[k] = L[i]
            i = i+1
        else:
            A[k] = R[j]
            j = j+1
        k = k+1

    #copy any remaining elements from L into A
    while i<n1:
        A[k] = L[i]
        k = k+1
        i = i+1
    #copy any remaining elements from R into A
    while j<n2:
        A[k] = R[j]
        k = k+1
        j = j+1

#Function to sort an array using merge sort.
#Input: 
#   A - array filled with numberic values
#   p - index of the first element of the sub-array of A we are processing
#   r - index of the last element of the sub-array of A we are processing
#Output: none
#Limitations: not tested too thoroughly
def mergeSort(A, p, r):
    if p<r:
        q = math.floor((p+r)/2)
        mergeSort(A,p,q)
        mergeSort(A,q+1,r)
        merge(A,p,q,r)

#Driver code to test the above. 
#Initialize the input array with numeric values.
A = [3, 41, 52, 26, 38, 57, 9, 49]

#Call the mergeSort function and print the result.
mergeSort(A, 0, len(A)-1)
print(A)
