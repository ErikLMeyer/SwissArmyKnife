public class sak {
    public static void main(String args[]) {
        long start = System.currentTimeMillis();
        if (args.length < 1) { // Not enough args
            System.out.println("Insufficient arguments. Please try again. Type -Help for more info.");
        } else if (args[0].equalsIgnoreCase("-Help")) { // User wants help
            System.out.println("Getting help...");
            Help.printH();
        } else if (args[0].equalsIgnoreCase("-httprequest")) { // User wants to print a url
            if (args.length < 2) { // Didn't give a url
                System.out.println("Requests require a url. Please try again.");
            } else if (args.length > 2) { // User entered an extra arguement
                System.out.println("Too many arguments. Please try again.");
            } else {
                System.out.println("Fetching data...");
                Req request = new Req();
                if (request.readLink(args[1])){ // args[1] should equal the URL
                    System.out.println(request);
                }
            }
        } else if (args[0].equalsIgnoreCase("-httprequestindex")) { // User wants to print any urls found within a url
            if (args.length < 2) { // Didn't give a url
                System.out.println("Requests require a url. Please try again.");
            } else if (args.length > 2) { // User entered an extra arguement
                System.out.println("Too many arguments. Please try again.");
            } else {
                System.out.println("Fetching data...");
                // Do http/url stuff here
                ReqIndex requestI = new ReqIndex(args[1]);
                if (requestI.readLink(args[1])){
                    if (requestI.loadIndex()){
                        System.out.println(requestI);
                    }
                }
            }
        } else if (args[0].equalsIgnoreCase("-sleep")) {
            Sleep mySleeper = new Sleep(0);
            mySleeper.sleep();
        } else if (args[0].equalsIgnoreCase("-sleepfast")){
            SleepFast mySleeper0 = new SleepFast(0);
            SleepFast mySleeper1 = new SleepFast(1);

            mySleeper0.start();
            mySleeper1.start();

            try{
                mySleeper0.join();
                mySleeper1.join();
            } catch(Exception e){
                System.out.println("Something broke. Exception = " + e);
            }
        } else if (args[0].equalsIgnoreCase("-sleepfastrunnable")){
            SleepFastRunnable mySleeper0 = new SleepFastRunnable(0);
            SleepFastRunnable mySleeper1 = new SleepFastRunnable(1);

            Thread myThread0 = new Thread(mySleeper0);
            Thread myThread1 = new Thread(mySleeper1);

            myThread0.start();
            myThread1.start();

            try{
                myThread0.join();
                myThread1.join();
            } catch(Exception e){
                System.out.println("Something broke. Exception = " + e);
            }
        }

        System.out.println("Application took " + (System.currentTimeMillis() - start) + "ms to complete.");
    }

}