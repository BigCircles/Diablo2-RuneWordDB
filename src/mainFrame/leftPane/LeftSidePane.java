package mainFrame.leftPane;

import javafx.scene.layout.*;

/**
 * Created by yatch on 2/12/2017.
 */
public class LeftSidePane extends VBox {
    Pane[] paneArray = new Pane[3];
    SearchByRunePane SBRPane;
    SearchByOpenSocketPane SBOSPane;
    SearchBySlotPane SBSPane;

    public LeftSidePane()
    {   super();
        setPrefSize(300,700);
        setMaxSize(300,700);
        SBRPane = new SearchByRunePane();
        SBRPane.setId("RunePane");
        SBOSPane = new SearchByOpenSocketPane();
        SBOSPane.setId("OSPane");
        SBSPane = new SearchBySlotPane();
        SBSPane.setId("SBSPane");
        getChildren().addAll(SBRPane, SBOSPane, SBSPane);

    }
}
