data = input("Enter the data in bits: ")
count = i = 0

while i < len(data):
    print(data[i], end='')  # Print the current bit
    if data[i] == '1':  # Check if the current bit is '1'
        count += 1
    else:
        count = 0  # Reset the count if a '0' is encountered

    # If there are 5 consecutive '1's, insert a '0'
    if count == 5:
        print(0, end='')  # Insert the stuffed bit
        count = 0  # Reset the count after stuffing

    i += 1  # Move to the next bit
