package controllers.RwController;

import controllers.ArmorType;
import controllers.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * Created by yatch on 2/13/2017.
 */

public class RuneWordController {
    /////////////////////////////////////RuneWord Inner Class///////////////////////////////////////////////
    private class RuneWord extends VBox {

        //RuneWord Data
        private String runeWordName;
        private String itemSlot;
        private ArrayList<String> runesToMake;
        private HashMap<String, String> attributeKeeper;

        private Label rwTitleLabel;
        private Label itemSlotLabel;
        private Label runesLabel;
        private ArrayList<Label> attributeLabels;

        private Insets tenby = new Insets(15,5,10,5);

        //RuneWord panel UI
        RuneWord(String RWName)
        {
            super();
            this.runeWordName = RWName;
            runesToMake = new ArrayList<>();
            attributeKeeper = new HashMap<>();
            itemSlot = "Item Slot";

            rwTitleLabel = new Label(this.runeWordName);
            rwTitleLabel.setMaxWidth(Double.MAX_VALUE);
            rwTitleLabel.setPadding(tenby);
            rwTitleLabel.setStyle("-fx-text-fill:#908858");

            attributeLabels = new ArrayList<>(0);

            setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            setStyle("-fx-background-color: black");
            setFillWidth(true);

            getChildren().addAll(rwTitleLabel);
        }

        void setRuneLabel(String labelText)
        {
            runesLabel = new Label(labelText);
            runesLabel.setMaxWidth(Double.MAX_VALUE);
            runesLabel.setPadding(new Insets(5,10,5,10));
            runesLabel.setStyle("-fx-text-filL:#908858");
            getChildren().add(runesLabel);
        }

        void setItemSlotLabel(String labelText)
        {
            itemSlotLabel = new Label(labelText);
            itemSlotLabel.setMaxWidth(Double.MAX_VALUE);
            itemSlotLabel.setPadding(new Insets(5,10,5,10));
            itemSlotLabel.setStyle("-fx-text-fill:#6f6844");
            getChildren().add((itemSlotLabel));
        }


        void setItemSlot(String itemSlot)
        {
            this.itemSlot = itemSlot;
        }

        void setRunesToMake(String runeElement)
        {
            String runeLabelText = "";
            for (String element: runesToMake)
            {
                runeLabelText = runeLabelText+""+element;
            }

            runesToMake.add(runeElement);
            runesLabel = new Label(runeLabelText+"Test");
        }

        String getRunesToMakeToString()
        {
            String returnString = "";
            for  (int x=0;x<runesToMake.size();x++)
            {
                returnString = returnString + runesToMake.get(x);
            }

            return returnString;
        }


        void addAttribute(String key, String value)
        {
            attributeKeeper.put(key,value);
        }

        void addAttributeLabel(String labelText)
        {
            attributeLabels.add(new Label(labelText));
            attributeLabels.get(attributeLabels.size()-1).setAlignment(Pos.CENTER);
            attributeLabels.get(attributeLabels.size()-1).setMaxWidth(Double.MAX_VALUE);
            attributeLabels.get(attributeLabels.size()-1).setPadding(new Insets(5,10,5,10));
            attributeLabels.get(attributeLabels.size()-1).setStyle("-fx-text-fill:#4850b8");

            getChildren().add(attributeLabels.get(attributeLabels.size()-1));
        }


        String getRuneWordName() {return runeWordName;}


        String rwToString()
        {
            String runes= "";
            for (int x =0;x<runesToMake.size();x++)
            {
                runes = runes + runesToMake.get(x);
            }

            return "Name:"+runeWordName +" "+"#Runes:"+runesToMake.size()+" "+"Item Slot:"+itemSlot+" "+"Rune Order:"+getRunesToMakeToString();
        }








    }
    /////////////////////////////////////End Inner Class/////////////////////////////////////////////////
    /////////////////////////////////////Begin StatKeeper//////////////////////////////////////////////////////
    private class AttributeKeeper
    {
        int attribute;
        String statDescription;

        public AttributeKeeper()
        {
            attribute = 0;
            statDescription = new String();
        }

        public AttributeKeeper(int attribute, String statDescription)
        {
            this.attribute = attribute;
            this.statDescription = statDescription;
        }


        String getAttribute()
        {
            return attribute + statDescription;
        }
    }
    /////////////////////////////////////End StatKeeper//////////////////////////////////////////////////
    /////////////////////////////////////End S/////////////////////////////////////////////////
    //Instance Variables
    private ArrayList<RuneWord> runeWordList;

    public RuneWordController()
    {
        runeWordList = new ArrayList<>(84);
        RuneWordsFromFile("RunewordList.txt");

    }

    public ArrayList<RuneWord> getRuneWords(){return runeWordList;}



    public void RuneWordsFromFile(String runeWordTextFile)
    {
        //Initializations
        URL url = getClass().getClassLoader().getResource(runeWordTextFile);
        File file;
        InputStream is;
        Scanner read;
        StringTokenizer tk;
        int lineCounter;

        try
        {
            file = new File(url.toURI());
            read = new Scanner(file);
            //RuneWord
            RuneWord fill;
            //Read File Loop
            lineCounter =0;
            while (read.hasNextLine())
            {
                String[] data = new String[4];
                String currLine = read.nextLine();
                data[0] = currLine;
                //Gather the last 3 lines of data
                String lineRead=" ";
                int elementCounter =1;
                while (!lineRead.equals(""))
                {
                    lineRead = read.nextLine();
                    if (lineRead.equals("EOF"))
                        break;
                    if (read.hasNextLine()) {

                        if (lineRead.equals(""))
                            break;
                        data[elementCounter] = lineRead;
                        elementCounter++;
                    }

                }

                RuneWord temp = new RuneWord(data[0]); // Make new RuneWord with the name
                temp.setItemSlot(data[1]); //Set the itemslot to the correct String
                temp.setItemSlotLabel(data[1]);
                StringTokenizer stRunes = new StringTokenizer(data[2]);
                String labeltext="";
                while (stRunes.hasMoreTokens())
                {
                    String token = stRunes.nextToken();
                    if (token.equals("+"))
                        continue;
                    else {
                        labeltext = labeltext+" "+token;
                        temp.setRunesToMake(token); // Set the runes without + characters added
                    }

                }
                temp.setRuneLabel(labeltext);

                StringTokenizer stAttributes = new StringTokenizer(data[3], "|");
                while (stAttributes.hasMoreTokens())
                {
                    String token = stAttributes.nextToken();
                    temp.addAttribute(token, token);
                    temp.addAttributeLabel(token);

                }
                runeWordList.add(temp);
            }
        }
        catch (FileNotFoundException e)
        {
            e.getStackTrace();
        }
        catch (URISyntaxException e)
        {
            e.getStackTrace();
        }

    }

}
