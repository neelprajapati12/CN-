import java.util.Scanner;

public class tokenbucket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input parameters
        System.out.print("Enter bucket capacity (tokens): ");
        int bucketCapacity = scanner.nextInt();
        System.out.print("Enter token generation rate per second: ");
        int tokenRate = scanner.nextInt();
        System.out.print("Enter number of incoming packets: ");
        int numPackets = scanner.nextInt();

        int[] packetSizes = new int[numPackets];
        System.out.println("Enter packet sizes:");
        for (int i = 0; i < numPackets; i++) {
            packetSizes[i] = scanner.nextInt();
        }

        int currentTokens = 0; // Tokens in the bucket
        int time = 0;          // Time in seconds

        for (int i = 0; i < numPackets; i++) {
            time++; // Simulate time progression
            System.out.println("\nTime: " + time);

            // Add tokens to the bucket
            currentTokens = Math.min(bucketCapacity, currentTokens + tokenRate);
            System.out.println("Tokens available: " + currentTokens);

            // Process the current packet
            if (packetSizes[i] <= currentTokens) {
                currentTokens -= packetSizes[i];
                System.out.println("Packet of size " + packetSizes[i] + " transmitted.");
            } else {
                System.out.println("Packet of size " + packetSizes[i] + " dropped (insufficient tokens).");
            }
        }

        scanner.close();
        System.out.println("\nAll packets processed.");
    }
}
