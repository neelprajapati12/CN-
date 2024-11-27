data = input("Enter Data: ")
start = input("Enter Starting delimiter: ")
end = input("Enter Ending delimiter: ")
escape = input("Enter Escape character: ")

stuffed_data = start  # Begin with the starting delimiter
for i in data:
    if i == start or i == end or i == escape:
        # If the character matches a delimiter or escape, stuff it
        stuffed_data += escape
    stuffed_data += i  # Add the character
stuffed_data += end  # End with the ending delimiter

print("Stuffed Data:", stuffed_data)
