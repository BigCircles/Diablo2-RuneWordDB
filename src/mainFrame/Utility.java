package mainFrame;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Utility {
    private class DelimiterIndexPair
    {
        int spanStartIndex, spanEndIndex;

        DelimiterIndexPair(int start, int end)
        {
            spanStartIndex = start;
            spanEndIndex = end;
        }

        int getStartIndex()
        {
            return spanStartIndex;
        }

        int getEndIndex()
        {
            return spanEndIndex;
        }

    }

        public static void parseWebPage(String filename) throws MalformedURLException, IOException {
            String urlString;
            URL myUrl;
            InputStream inStream;

            //File Stuff
            File httpholder;
            PrintStream out;

            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter URL (i.e. yahoo.com)");
            urlString = keyboard.next();

            if (!urlString.contains("http")) {
                urlString = "http://" + urlString;
                myUrl = new URL(urlString);
                System.out.println("Appended on \"http\": " + myUrl.toString());
            } else {
                myUrl = new URL(urlString);
                System.out.println("No Http appended" + myUrl.toString());
            }

            inStream = myUrl.openStream();

            Scanner in = new Scanner(inStream);


            //take out the '.' in .com so that its a valid filename
            String periodless = urlString;
            System.out.println(periodless);
            while (periodless.contains(".")) {
                int indexfirstperiod = periodless.indexOf('.');
                periodless = periodless.substring(0, indexfirstperiod) + periodless.substring(indexfirstperiod + 1);
            }
            System.out.println("periodless variable=" + periodless);

            //Take out http:// for the filename;
            if (periodless.contains("http://"))
                periodless = periodless.substring(7);
            else if (periodless.contains("https://"))
                periodless = periodless.substring(8);
            System.out.println(periodless + "periodless is all stripped");

            //Make file with correct hostname as file
            // httpholder = new File(periodless+".txt");
            httpholder = new File("OriginalRunewords");


            if (httpholder.exists() != true)
                try{
                    httpholder.createNewFile();
                }
                catch (IOException e)
                {
                    System.out.println(e.getStackTrace());

                }


            out = new PrintStream(httpholder);


            //Url is a thing and were about to read it to a file
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
                out.println(line);
            }

            out.close();
            in.close();
        }

        public void readRuneWordsFromHTML(String[] delimiterList, String fileReadFrom) {
            File fileToReadFrom;
            Scanner read;
            String lineReadIn;
            PrintStream outStream;


            try {
                fileToReadFrom = new File(fileReadFrom);
                read = new Scanner(fileToReadFrom);
                lineReadIn = "";
                outStream = new PrintStream(new File("test.txt")); //@TODO: Change this to an actual file name if you want it to work.

                //Make the page into one line so I can easily find the words to replaceAll.
                String noNewLines = "";
                while (read.hasNextLine()) {
                    lineReadIn = read.nextLine();
                    noNewLines = noNewLines + lineReadIn;
                }
                read.close();

                //Search through the delimiter array and replaceAll instances of the words
                Scanner replaceAllReader = new Scanner(noNewLines);
                String replacedString = noNewLines;
                for (String delimiter : delimiterList) {
                    replacedString = replacedString.replaceAll(delimiter, "");

                }
                replaceAllReader.close();

                String compactedString = replacedString;
                while (compactedString.length() > 6) {
                    int openBracket = compactedString.indexOf("<span>");
                    int closeBracket = compactedString.indexOf("</span>");
                    System.out.println(compactedString);
                    outStream.println(compactedString.substring(openBracket + 6, closeBracket));
                    compactedString = compactedString.substring(closeBracket + 4);

                }
                outStream.close();

            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException Thrown");
                e.getStackTrace();
            }
        }






}



