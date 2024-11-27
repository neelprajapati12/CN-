import socket 

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(("0.0.0.0", 5001))
server.listen(1)

client, addr = server.accept()

while True:
    clientMsg = client.recv(1024).decode('utf-8')
    
    if clientMsg == "quit":
        print("disconnected")
    else:
        print(f"Client: {clientMsg}")

    serverMsg = input("You: ")
    client.sendall(serverMsg.encode('utf-8')) 

server.close()
client.close()
