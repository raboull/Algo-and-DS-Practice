#this algorithm takes an input array and a value and return the index of
#the element number that matches the value, or returns NULL if that
#value is not present in the array.

A = [5,2,4,6,1,3]
v = 5

match = None #the match variable holds NULL or the index of val if it is present in A
for i in range(0,len(A)): #iterate through every element of A
    if A[i] == v:#check if current element is equal to v
        match = i+1
    


if match == None:
    print("No match found.")
else: 
    print("Match found at index: "+str(match))