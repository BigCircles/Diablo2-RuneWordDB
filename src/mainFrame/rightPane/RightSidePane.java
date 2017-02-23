package mainFrame.rightPane;

import controllers.RwController.RuneWordController;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.shape.Box;

/**
 * Created by yatch on 2/12/2017.
 */
public class RightSidePane{
    private GridPane rightGridPane;
    private ScrollPane scrollPane;

    private RuneWordController rwController;
    public RightSidePane()
    {
        rwController = new RuneWordController();

        rightGridPane = new GridPane();
        //rightGridPane.setGridLinesVisible(true);
        rightGridPane.setMaxWidth(Double.MAX_VALUE);
        rightGridPane.setVgap(10);
        rightGridPane.setHgap(10);
        
        RowConstraints[] rowC = new RowConstraints[26];
        ColumnConstraints[] colC = new ColumnConstraints[3];
        for (int x=0;x<rowC.length;x++)
        {
            rowC[x] = new RowConstraints(400);
            rightGridPane.getRowConstraints().add(rowC[x]);
        }
        for (int x=0;x<colC.length;x++)
        {
            colC[x] = new ColumnConstraints();
            colC[x].setPercentWidth(33.3);
            rightGridPane.getColumnConstraints().add(colC[x]);
        }

        int buttoncounter=0;
        for (int row=0;row<rowC.length;row++)
        {
            for(int column=0;column<colC.length;column++)
            {
                if (buttoncounter<rwController.getRuneWords().size())
                rightGridPane.add(rwController.getRuneWords().get(buttoncounter++),column,row);
            }
        }
        scrollPane = new ScrollPane(rightGridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


    }

    public ScrollPane getScrollPane()
    {
        return scrollPane;
    }


}
