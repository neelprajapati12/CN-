import random 

frame_count=8
window_size=3
frame=0

while frame<frame_count:
    window=[]
    for i in range(window_size):
        if frame+i<frame_count:
            window.append(frame+i)

    print(f"Sending frames in window :",window)

    success=True

    for j in window:
        if random.randint(0,7)<2:
            print(f"frame {j} is lost!")
            success=False
            break
        else:
            print(f"ack received for frame:",j)
    
    if success:
        frame+=window_size
    else:
        print("resending frames from ",frame)