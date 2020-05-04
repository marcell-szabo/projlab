package gui;

import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {
    //Indicate the row and column of this cell in the board
    private int GridRow;
    private int GridColumn;
    ImageResoucres imageResoucres = new ImageResoucres();


    public Cell(int GridRow, int GridColumn) {

        this.GridRow = GridRow;
        this.GridColumn = GridColumn;

        setBackground(imageResoucres.sea);

    }
}

