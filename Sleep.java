public class Sleep{
    private int sleepID;

    public int getID(){ return sleepID; }

    Sleep(int sleepNum){
        sleepID = sleepNum;
    }

    public void sleep(){
        System.out.println("Nighty night.");
        try{
            Thread.sleep(1000);
        } catch(Exception e){
            System.out.println("Stuff broke. Exception = " + e);
        }
        System.out.println("Good morning.");
    }
}