package mainFrame.leftPane;

import controllers.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;



/**
 * Created by yatch on 2/12/2017.
 */
public class SearchByRunePane extends VBox {
    private GridPane gridPane;
    private Label label, textFieldLabel;
    private TextField textField;
    private ToggleButton[] button = new ToggleButton[33];
    public SearchByRunePane()
    {
        super();
        setPadding(new Insets(10,10,10,10));
        setMaxSize(300,300);
        setAlignment(Pos.CENTER);
        //Label Setup
        label = new Label("Search By Rune");
        label.setAlignment(Pos.CENTER);
        label.setId("white text");
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(new Insets(10,10,10,10));
        label.setLayoutX(100);
        textFieldLabel = new Label("Search by comma list:");
        textFieldLabel.setAlignment(Pos.BASELINE_CENTER);
        textFieldLabel.setMaxWidth(150);
        textFieldLabel.setPadding(new Insets(30,10,10,10));
        textField = new TextField();
        textField.setPromptText("Ex: El, Hel, El");
        textField.setPrefColumnCount(15);
        textField.setMaxWidth(150);

        //GridPane Setup And Constraint Setups
        gridPane = new GridPane();
        RowConstraints[] rowConstraints = new RowConstraints[7];
        ColumnConstraints[] columnConstraints = new ColumnConstraints[5];
        for (int x=0;x<rowConstraints.length;x++)
        {
            final int rowHeight = 30;
            rowConstraints[x] = new RowConstraints(rowHeight);
            gridPane.getRowConstraints().add(rowConstraints[x]);
        }
        for (int x=0;x<columnConstraints.length;x++)
        {
            final int columnWidth = 70;
            columnConstraints[x] = new ColumnConstraints(columnWidth);
            gridPane.getColumnConstraints().add(columnConstraints[x]);
        }

        //ButtonArray Setup
        for (int x=0;x< button.length;x++)
        {
             button[x] = new ToggleButton();
             button[x].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
             button[x].setText(Controller.RuneWordList[x]);
        }
        int buttoncounter =0;
        for (int rows =0;rows<rowConstraints.length;rows++)
        {
            for (int columns=0;columns<columnConstraints.length;columns++)
            {
                if (buttoncounter<button.length) {
                    if (rows==6 && columns==0 )
                    {
                        continue;
                    }

                    gridPane.add(button[buttoncounter++], columns, rows);
                }
                else
                    break;
            }
        }


        setPrefSize(300,300);
        getChildren().addAll(label, gridPane, textFieldLabel, textField);

    }
}
