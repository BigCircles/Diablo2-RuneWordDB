package mainFrame.leftPane;

import controllers.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 * Created by yatch on 2/13/2017.
 */
public class SearchBySlotPane extends VBox {
    Label titleLabel, armorLabel, weaponLabel;
    GridPane gridArmorPane, gridWeaponPane;
    RadioButton[] armorRadioButtons, weaponRadioButtons;
    public SearchBySlotPane()
    {
        super();

        titleLabel = new Label("Search By Slot:");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setPadding(new Insets(10,10,10,10));

        armorLabel = new Label("Armor");
        armorLabel.setMaxWidth(Double.MAX_VALUE);
        armorLabel.setAlignment(Pos.CENTER);
        armorLabel.setPadding(new Insets(10,10,10,10));

        weaponLabel = new Label("Weapons");
        weaponLabel.setMaxWidth(Double.MAX_VALUE);
        weaponLabel.setAlignment(Pos.CENTER);
        weaponLabel.setPadding(new Insets(10,10,10,10));

        gridArmorPane = new GridPane();
       // gridArmorPane.setGridLinesVisible(true);
        gridArmorPane.setAlignment(Pos.CENTER);
        gridArmorPane.setMaxWidth(Double.MAX_VALUE);
        ColumnConstraints[] columnC = new ColumnConstraints[3];
        RowConstraints rowC = new RowConstraints(30);
        gridArmorPane.getRowConstraints().add(rowC);
        for (int x=0;x<columnC.length;x++)
        {
            columnC[x] = new ColumnConstraints();
            columnC[x].setPercentWidth(30);
            gridArmorPane.getColumnConstraints().add(columnC[x]);
        }

        gridWeaponPane = new GridPane();
        //gridWeaponPane.setGridLinesVisible(true);
        gridWeaponPane.setAlignment(Pos.CENTER);
        gridWeaponPane.setMaxWidth(Double.MAX_VALUE);
        ColumnConstraints[] columnCon = new ColumnConstraints[5];
        RowConstraints[] rowCon = new RowConstraints[3];
        for (int x=0;x<columnCon.length;x++)
        {
            columnCon[x] = new ColumnConstraints();
            columnCon[x].setPercentWidth(30);
            gridWeaponPane.getColumnConstraints().add(columnCon[x]);
        }
        for (int x=0;x<rowCon.length;x++)
        {
            rowCon[x] = new RowConstraints(30);;
            gridWeaponPane.getRowConstraints().add(rowCon[x]);
        }

        String[] armorSubLabel = {"Armor","Helmet","Shield"};
        armorRadioButtons = new RadioButton[3];
        for (int x=0;x<armorRadioButtons.length;x++)
        {
            armorRadioButtons[x] = new RadioButton(armorSubLabel[x]);
            armorRadioButtons[x].setStyle("-fx-text-fill: #c4d8de;");
            armorRadioButtons[x].setAlignment(Pos.CENTER);
            armorRadioButtons[x].setMaxWidth(Double.MAX_VALUE);
            gridArmorPane.add(armorRadioButtons[x],x,0);
        }

        weaponRadioButtons = new RadioButton[13];
        for (int x=0;x<weaponRadioButtons.length;x++)
        {
            weaponRadioButtons[x] = new RadioButton(Controller.WeaponTypeList[x]);
            weaponRadioButtons[x].setAlignment(Pos.CENTER);
           // weaponRadioButtons[x].setMaxWidth(Double.MAX_VALUE);
        }
        int buttoncounter = 0;
        for (int row = 0; row < rowCon.length; row++) {
            for (int column = 0; column < columnCon.length; column++) {
                if (buttoncounter<13){
                    if (row==2 && column==0)
                        continue;
                    gridWeaponPane.add(weaponRadioButtons[buttoncounter++], column, row);
                }

            }


        }

        setPadding(new Insets(10,10,10,10));
        setPrefSize(300,300);

        getChildren().addAll(titleLabel, armorLabel,gridArmorPane, weaponLabel, gridWeaponPane);
    }
}
