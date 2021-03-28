import java.util.ArrayList;;

class ReqIndex extends Req{
    private ArrayList<Req> listOLinks;
    private ArrayList<Integer> lineNums;

    ReqIndex(){
        super();
        listOLinks = new ArrayList<Req>();
        lineNums = new ArrayList<Integer>();
    }

    ReqIndex(String requestedLink){
        super(requestedLink);
        listOLinks = new ArrayList<Req>();
        lineNums = new ArrayList<Integer>();
    }

    public Boolean loadIndex(){
        Boolean itWorked = false;
        int lineCounter = 0;
        String foundLink;
        // Find URLS and add to the list
        for (String line : linkContent){
            lineCounter++;
            if (line.contains("https://")){
                foundLink = line.substring(line.indexOf("https://"), line.lastIndexOf("\""));
                System.out.println("Current link = " + foundLink);
                listOLinks.add(new Req(foundLink));
                System.out.println("Request added: " + listOLinks.get(listOLinks.size()-1));
                lineNums.add(lineCounter);
                System.out.println("Line added: Line " + lineNums.get(lineNums.size()-1));
                if (listOLinks.get(listOLinks.size()-1).readLink()){
                    itWorked = true;
                } else{
                    listOLinks.remove(listOLinks.size()-1);
                }
            }
        }
        // Check whether any of the possible URLs worked
        if (listOLinks.size() <= 0)
            itWorked = false;

        return itWorked;
    }

    public String toString(){
        String theContent = "URL: " + reqLink + "\n";
        int lineCounter = 0;
        int arrayCounter = 0;
        for (String inTheArrList : linkContent){
            lineCounter++;
            theContent = theContent + inTheArrList + "\n";
            if (arrayCounter < lineNums.size() && lineNums.get(arrayCounter) == lineCounter){
                theContent = theContent + "\n" + listOLinks.get(arrayCounter) + "\n";
                arrayCounter++;
            }
        }
        return theContent;
    }
}