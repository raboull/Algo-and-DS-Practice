#Python program for performing a Linear Search

#Function to find index of value v in arrray A. 
#Returns None if v is not found.
#Limitation: looks through every element and returns the index of last 
#element that contains value v.
def LinearSearch_1(arr, v):
    
    for i in range(0,len(arr)): #iterate through every element of arr
        if arr[i]==v:#check if current element is equal to v
            return i
    
    return None

#Driver code to test above
A = [5,2,4,6,1,1]
v = 1
result = LinearSearch_1(A,v)

if result== None:
    print("No match found.")
elif result != None:
    print("Match found at index: "+str(result))
