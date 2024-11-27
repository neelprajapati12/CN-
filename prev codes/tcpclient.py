import socket 

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(("127.0.0.1", 5001))

while True:
    clientMsg = input("You: ")
    client.sendall(clientMsg.encode('utf-8'))

    if clientMsg == 'quit':
        print('disconnected')
        break

    serverMsg = client.recv(1024).decode('utf-8')
    print(f"server: {serverMsg}")
client.close()