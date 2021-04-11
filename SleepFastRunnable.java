public class SleepFastRunnable implements Runnable{
    private int sleepID;

    SleepFastRunnable(int sleepNum){
        sleepID = sleepNum;
    }

    public void sleep(){
        System.out.println(sleepID + " says nighty night.");
        try{
            Thread.sleep(1000);
        } catch(Exception e){
            System.out.println("Something broke. Exception = " + e);
        }
        System.out.println(sleepID + " is waking up.");
    }

    public void run(){
        sleep();
    }
}
