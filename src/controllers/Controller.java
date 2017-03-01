package controllers;

public class Controller {
    //List is sorted by Level from lowest to highest
    public final static String[] RuneWordList = {"El","Eld","Tir","Nef","Eth","Ith","Tal","Ral","Ort","Thul",
                                     "Amn","Sol","Shael","Dol","Hel","Io","Lum","Ko","Fal","Lem",
                                     "Pul","Um","Mal","Ist","Gul","Vex","Ohm","Lo","Sur","Ber",
                                     "Jah","Cham","Zod",};
    public final static String[] WeaponTypeList = {"Axe","Bow","Crossbow","Dagger","Javelin","Mace","Polearm","Scepter","Spear","Stave","Sword","Throwing Weapon","Wands"};
    public final static String[] ArmorTypeList = {"Armor", "Helmet", "Shield"};

    ////////////////////////////////////////////////////////////////////////////////////
    /**Controls which sub-panels are enabled based on which button was clicked first after reset, a
     * lso sends the search parameters (buttons clicked) to the right panel to display which Runewords match which params */
     class LeftSidePaneController
    {
        public LeftSidePaneController()
        {

        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Searches through the runeword list to find whatever search params the leftside panels are currently searching by.
     * */
    class RightSidePaneController
    {
        public RightSidePaneController()
        {

        }
    }
    //////////////////////////////////////////////////////////////////////////////////////
}
