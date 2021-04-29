#this algorithm sorts the input array in descending order
print('Running...')

A = [5,2,4,6,1,3]

for j in range(1,len(A)): #iterate over the A array starting with second element
    key = A[j] #assign value of A[j] to the key variable
    #Move elements of A[0..j], that are greater than key, to one position ahead
    #of their current position.
    i=j-1
    while i>=0 and A[i]<key:
        A[i+1]=A[i]
        i=i-1
    A[i+1]=key

print('done')