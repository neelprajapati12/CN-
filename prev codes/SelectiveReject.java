import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SelectiveReject {
    public static void main(String[] args) {
        final int WINDOW_SIZE = 4;
        final int FRAME_COUNT = 7;
        int frame = 0;
        Random rand = new Random();
        ArrayList<Integer> window = new ArrayList<>();
        HashSet<Integer> notsent = new HashSet<>();

        while (frame < FRAME_COUNT) {
            // Fill the window with frames, respecting the WINDOW_SIZE
            while (window.size() < WINDOW_SIZE && frame + window.size() < FRAME_COUNT) {
                window.add(frame + window.size());
            }

            System.out.println("Current Window ---> " + window);

            // Simulate sending frames and receiving ACKs
            for (int currentFrame : window) {
                System.out.print("Sending frame " + currentFrame + ".....");
                if (rand.nextInt(0,FRAME_COUNT) == currentFrame) {
                    System.out.print("Unable to get ack for frame " + currentFrame);
                    System.out.println("  NegativeACK " + currentFrame);
                    notsent.add(currentFrame); // Store frames that need to be resent
                } else {
                    System.out.println("Received ACK for frame " + currentFrame);
                }
            }

            // Resend frames that were negatively acknowledged
            if(!notsent.isEmpty()) {
                System.out.println("Resending NegativeACK frames....");
                for (int i = 0; i < window.size(); i++) {
                    int notsentFrame = window.get(i);
                    if (notsent.contains(notsentFrame)) {
                        System.out.println("Resending frame " + notsentFrame);
                        System.out.println("Received ACK for frame: " + notsentFrame);
                        notsent.remove(notsentFrame); // Remove from notsent once resent
                    }
                }
            }

            // If no frames need to be resent, move the frame pointer
            if (notsent.isEmpty()) {
                System.out.println("Successfully sent all frames.");
                frame += window.size(); // Move to the next set of frames
                window.clear(); // Clear the window for the next batch of frames
            }
        }
    }
}
