package burp.finger;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public  class FingerTableModel extends AbstractTableModel {
    private final String[] columnNames = {"序号", "漏洞分类","匹配方式", "匹配位置","匹配值","重要程度","CMS分类"};
    public static final List<FingerEntry> all_finger_data = new ArrayList<>();//用于展现poc

    @Override
    public int getRowCount()
    {
        return all_finger_data.size();

    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex >= all_finger_data.size() || columnIndex < 0 || columnIndex >= columnNames.length) {
            return "";
        }
        FingerEntry fingerEntry = all_finger_data.get(rowIndex);
        switch (columnIndex)
        {


            case 0:
                return fingerEntry.id;
            case 1:
                return fingerEntry.cms;
            case 2:
                return fingerEntry.method;
            case 3:
                return fingerEntry.location;
            case 4:
                return fingerEntry.keyword;
            case 5:
                return fingerEntry.isImportant;
            case 6:
                return fingerEntry.type;
            default:
                return "";
        }
    }

    public Object getValueRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= all_finger_data.size()) {
            return "";
        }
        return all_finger_data.get(rowIndex);
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        return columnNames[columnIndex];
    }
    public Class<?> getColumnClass(int columnIndex)
    {
        switch (columnIndex)
        {
            case 0:
            case 5:
                return Integer.class;
            case 4:
            case 3:
            case 2:
            case 6:
            case 1:
            default:
                return String.class;
        }
    }
    public List<FingerEntry> getAllValue(){
        return  all_finger_data;
    }

    public  void ClearData() {
        all_finger_data.clear();
        fireTableDataChanged();
    }

    public   void  addValueAt(FingerEntry value)
    {
        all_finger_data.add(value);
        fireTableDataChanged();
    }

}
