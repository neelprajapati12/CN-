import java.util.Random;

public class StopandWait {
    public static void main(String[] args) {
        final int FRAME_COUNT = 5;
        int frame = 0;
        boolean ack;

        while(frame < FRAME_COUNT)
        {
            System.out.print("Sending Frame " +frame+"....");
            Random rand = new Random();
            ack = rand.nextBoolean();
            if(ack)
            {
                System.out.println("Received acknowledgement for "+frame);
                frame ++;
            }
            else
            {
                System.out.println("Acknowledgement lost for "+frame);
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }

    }
}
