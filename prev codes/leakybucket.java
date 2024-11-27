import java.util.Scanner;

public class leakybucket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input parameters
        System.out.print("Enter bucket capacity: ");
        int bucketCapacity = scanner.nextInt();
        System.out.print("Enter outgoing rate: ");
        int outgoingRate = scanner.nextInt();
        System.out.print("Enter number of incoming packets: ");
        int numPackets = scanner.nextInt();

        int[] packets = new int[numPackets];
        System.out.println("Enter packet sizes:");
        for (int i = 0; i < numPackets; i++) {
            packets[i] = scanner.nextInt();
        }

        int bucketContent = 0;

        // Process packets
        for (int i = 0; i < numPackets; i++) {
            System.out.println("\nIncoming packet size: " + packets[i]);
            if (packets[i] + bucketContent > bucketCapacity) {
                System.out.println("Bucket overflow! Packet of size " + packets[i] + " is discarded.");
            } else {
                bucketContent += packets[i];
                System.out.println("Bucket content after adding: " + bucketContent);
            }

            // Leak packets at the outgoing rate
            int leaked = Math.min(bucketContent, outgoingRate);
            bucketContent -= leaked;
            System.out.println("Leaked " + leaked + " packets. Bucket content now: " + bucketContent);
        }

        // Handle remaining packets in the bucket
        while (bucketContent > 0) {
            System.out.println("\nLeaking remaining packets...");
            int leaked = Math.min(bucketContent, outgoingRate);
            bucketContent -= leaked;
            System.out.println("Leaked " + leaked + " packets. Bucket content now: " + bucketContent);
        }

        System.out.println("\nAll packets processed.");
        scanner.close();
    }
}
