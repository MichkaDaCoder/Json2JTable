package GUI;

import Model.Musee;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author MichkaDaCoder
 */
public class MuseeTableModel extends AbstractTableModel{

    /***
     * Nom des colonnes.
     */
    String[] colNames=new String[]{"Museum Name"};
    List museeList;
    
    public MuseeTableModel(List list) {
        this.museeList=list;
    }
    
    @Override
    public int getRowCount() {
        return museeList.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Musee musee=(Musee)museeList.get(row);
        switch(column) {
            case 0:
                return musee.getNOM();
        }
        return musee;
    }
    
    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }
    
    

}
