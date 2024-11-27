import java.util.ArrayList;
import java.util.Random;

public class GObackN{
    public static void main(String[] args) {
        final int WINDOW_SIZE = 3;
        final int FRAME_COUNT = 7;
        int frame = 0;
        Random rand = new Random();
        ArrayList<Integer> window = new ArrayList<>();

        while(frame < FRAME_COUNT)
        {
            //initialize the window
            while(window.size() < WINDOW_SIZE && window.size()+frame < FRAME_COUNT)
            {
                window.add(window.size() + frame);
            }

            System.out.println("Current Window ---> "+window);
            boolean success = true;
            int failedframe = -1;

            for(int currentframe : window)
            {
                if(rand.nextInt(0,4) == 0)
                {
                    System.out.println("Frame "+currentframe+" Ack not received");
                    success = false;
                    failedframe = currentframe;
                    break;
                }
                else {
                    System.out.println("Ack for Frame "+currentframe+ " Received");
                }
            }

            if(success)
            {
                System.out.println("All Frames in the window were sent succesfully!");
                frame = frame+window.size();
                window.clear();
            }
            else{
                System.out.println("Resending frames from "+failedframe+ "...");
                frame = failedframe;
                window.clear();
            }

        }
    }
}