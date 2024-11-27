import java.util.Scanner;

public class crc {
    // Function to perform XOR operation for error detection and remainder calculation
    public static String xorbit(String dividend, String divisor) {
        StringBuilder result = new StringBuilder();
        if (dividend.charAt(0) == '1') {
            for (int i = 0; i < dividend.length(); i++) {
                result.append((dividend.charAt(i) - '0') ^ (divisor.charAt(i) - '0')); // XOR each bit
            }
        } else {
            result.append(dividend); // If first bit is 0, return as is
        }
        return result.substring(1); // Return substring excluding the first bit
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter \n1: Error detection \n2: Find transmitted bit stream");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter transmitted message: ");
            String dataTrans = sc.next();
            System.out.print("Enter divisor: ");
            String divisor = sc.next();

            String newMsg = dataTrans + "0".repeat(divisor.length() - 1); // Append 0's
            String dividend = newMsg.substring(0, divisor.length());
            int i = divisor.length();

            while (i < newMsg.length()) {
                String prod = xorbit(dividend, divisor);
                dividend = prod + newMsg.charAt(i); // Update dividend
                i++;
            }

            String remainder = xorbit(dividend, divisor);
            if (Integer.parseInt(remainder) == 0) {
                System.out.println("No Error");
            } else {
                System.out.println("Error");
            }

        } else if (choice == 2) {
            System.out.print("Enter data to be transmitted: ");
            String data = sc.next();
            System.out.print("Enter divisor: ");
            String divisor = sc.next();

            String newMsg = data + "0".repeat(divisor.length() - 1); // Append 0's
            String dividend = newMsg.substring(0, divisor.length());
            int i = divisor.length();

            while (i < newMsg.length()) {
                String prod = xorbit(dividend, divisor);
                dividend = prod + newMsg.charAt(i); // Update dividend
                i++;
            }

            String remainder = xorbit(dividend, divisor);
            System.out.println("Transmitted bit stream: " + data + remainder);
        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
