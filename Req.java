import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Req {
    protected String reqLink;
    protected ArrayList<String> linkContent;

    Req(){
        reqLink = "";
        linkContent = new ArrayList<String>();
    }

    Req(String requestedLink){
        reqLink = requestedLink;
        linkContent = new ArrayList<String>();
    }

    public Boolean readLink(){ return readLink(reqLink); }

    public Boolean readLink(String requestedLink){
        reqLink = requestedLink;
        Boolean itWorked;

        try{
            URL theLink = new URL(reqLink);
            URLConnection theConnection = theLink.openConnection();
            BufferedReader siteData = new BufferedReader(new InputStreamReader(theConnection.getInputStream()));
            String currentLine;
            while ((currentLine = siteData.readLine()) != null){
                linkContent.add(currentLine);
            }
            itWorked = true;
            siteData.close();
        } catch (Exception e){
            itWorked = false;
            System.out.println("Something went wrong trying to read data.");
        }

        return itWorked;
    }

    public String toString(){
        String theContent = "URL: " + reqLink + "\n";
        for (String inTheArrList : linkContent){
            theContent = theContent + inTheArrList + "\n";
        }
        return theContent;
    }
}
