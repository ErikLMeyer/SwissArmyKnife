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
        }

        System.out.println("Application took " + (System.currentTimeMillis() - start) + "ms to complete.");
    }

}