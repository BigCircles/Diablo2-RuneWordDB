package mainFrame;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import mainFrame.leftPane.LeftSidePane;
import mainFrame.rightPane.RightSidePane;

/**
 * Created by yatch on 2/12/2017.
 */
public class MainFrame extends BorderPane {
    private LeftSidePane leftPane;
    private RightSidePane rightPane;
    private MenuBarFrame menubar; //Top

    Text d2text = new Text(); //



    public MainFrame()
    {
        //Initializations
        super();
        setPrefSize(1400,700);
        setMaxSize(1400,700);
        menubar = new MenuBarFrame();
        leftPane = new LeftSidePane();
        rightPane = new RightSidePane();


        //Setting Layouts
        setTop(menubar);
        setLeft(leftPane);
        setCenter(rightPane.getScrollPane());
        setVisible(true);
    }

    class MenuBarFrame extends MenuBar
    {
        //Menu Bar Options
        final Menu menu1 = new Menu("File");
        final Menu menu2 = new Menu("Options");
        final Menu menu3 = new Menu("Help");

        //File Menu Options
        final MenuItem reset = new MenuItem("Reset");
        final MenuItem exit = new MenuItem("Exit");


        MenuBarFrame()
        {
            super();
            menu1.getItems().addAll(reset,exit);
            menu1.setId("menu1");
            getMenus().addAll(menu1,menu2,menu3);
            setVisible(true);
        }


    }

}
