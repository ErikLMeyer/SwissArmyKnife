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

        if (readLink()){
            if (loadIndex()){
                System.out.println("Index loaded.");
                System.out.println(this);
            } else{
                System.out.println("Index load failed.");
            }
        }
    }

    public Boolean loadIndex(){
        Boolean itWorked = false;
        int lineCounter = 0;
        String foundLink;
        // Find URLS and add to the list
        for (String line : linkContent){
            lineCounter++;
            if (line.contains("https://")){
                foundLink = line.substring(line.indexOf("https://"), line.lastIndexOf("\"") - 1);
                listOLinks.add(new Req(foundLink));
                lineNums.add(lineCounter);
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
            if (lineNums.get(arrayCounter) == lineCounter){
                theContent = "\t" + listOLinks.get(arrayCounter);
                arrayCounter++;
            }
        }
        return theContent;
    }
}