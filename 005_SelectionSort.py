#Python program for performing selection sort on an array.

#Function to sort an array using selection sort.
#Input: array A. 
#Output: sorter array A.
#Limitation: array can only contain numbers.
def SelectionSort(A):
    for i in range(0, len(A)-1):#iterate through every element of A
        current = A[i]#store the current value being checked
        min_index = i#initialize the index of the minimum element to i

        for j in range(i+1, len(A)):#iterate through every element to the right of element i
            if A[j]<A[min_index]:#if a smaller value is found then value at current min_index, then update the min_index
                min_index = j
        A[i] = A[min_index]#place the current value into the element that contains the smalles value found
        A[min_index] = current#place the smallest value found into the current element

    return A#A is now a sorted array

#Driver code to test above 
#Initialize the input array of numeric values.
A = [31,41,59,26,41,58]

#Call the SelectionSort function and print the result.
print(SelectionSort(A))
