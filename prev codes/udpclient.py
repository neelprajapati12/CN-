import socket 

while True:
    client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    server_addr = (("127.0.0.1", 5001))

    clientMsg = input("You: ")
    client.sendto(clientMsg.encode('utf-8'), server_addr)

    if clientMsg == 'quit':
        print("disconnected")
        break
    
    serverMsg, _ = client.recvfrom(1024)
    serverMsg.decode('utf-8')
    print(f"Server: {serverMsg}")

client.close()