import socket 

server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server.bind(("0.0.0.0", 5001))

while True:
    clientMsg, client_addr = server.recvfrom(1024)
    clientMsg.decode('utf-8')

    if clientMsg == 'quit':
        print('disconnected')
        break

    else:
        print(f"Client: {clientMsg}")

    serverMsg = input("You: ")
    server.sendto(serverMsg.encode('utf-8'), client_addr)

server.close()

