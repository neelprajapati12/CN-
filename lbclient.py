import socket

HOST = '127.0.0.1' 
PORT = 5001

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client_socket.connect((HOST, PORT))

while True:
    message=input("Enter data:")
    client_socket.sendall(message.encode())
    if(message=="end"):
        break
print("End")
# Close the client socket
client_socket.close()
