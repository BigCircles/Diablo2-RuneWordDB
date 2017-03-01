package mainFrame.leftPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

import static com.sun.javafx.fxml.expression.Expression.add;

/**
 * Created by yatch on 2/13/2017.
 */
public class SearchByOpenSocketPane extends VBox{
    private Label titleLabel;
    private GridPane gridPane;
    private ToggleButton[] osButtons;
    public SearchByOpenSocketPane()
    {
        super();

        //Set Title Label
        titleLabel = new Label("Search By Open Socket");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setPadding(new Insets(10,10,10,10));
        titleLabel.setAlignment(Pos.CENTER);

        //Grid Pane And Constraints
        gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        RowConstraints rowc = new RowConstraints(30);
        gridPane.getRowConstraints().add(rowc);
        ColumnConstraints[] columnc = new ColumnConstraints[5];
        for(int x=0;x<columnc.length;x++)
        {
            columnc[x] = new ColumnConstraints();
            columnc[x].setPercentWidth(20);
            gridPane.getColumnConstraints().add(columnc[x]);

        }

        osButtons = new ToggleButton[5];
        int buttonLabelCounter = 2;
        for (int x=0;x<osButtons.length;x++)
        {
            osButtons[x] = new ToggleButton(Integer.toString(buttonLabelCounter++));
            osButtons[x].setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            osButtons[x].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(event.getSource().toString());
                }
            });


            gridPane.add(osButtons[x],x,0);
        }

        //Vbox visual Settings
        setPadding(new Insets(10,10,10,10));
        setPrefSize(300,100);

        //Adding all components to the Vbox
        getChildren().addAll(titleLabel, gridPane);
    }
}
