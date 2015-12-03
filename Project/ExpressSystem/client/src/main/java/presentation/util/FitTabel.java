//自动调整tabel列宽
package presentation.util;

import java.awt.Component;
import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class FitTabel {
	public static void FitTableColumns(JTable myTable){
		  JTableHeader header = myTable.getTableHeader();
		     int rowCount = myTable.getRowCount();
		     Enumeration<TableColumn> columns = myTable.getColumnModel().getColumns();
		     while(columns.hasMoreElements()){
		         TableColumn column = (TableColumn)columns.nextElement();
		         int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
		         int width = (int)myTable.getTableHeader().getDefaultRenderer()
		                 .getTableCellRendererComponent(myTable, column.getIdentifier()
		                         , false, false, -1, col).getPreferredSize().getWidth();
		         for(int row = 0; row<rowCount; row++){
		             int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
		               myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
		             width = Math.max(width, preferedWidth);
		         }
		         header.setResizingColumn(column); // 此行很重要
		         column.setWidth(width+myTable.getIntercellSpacing().width);
		     }
	}
	 public static int getPreferredWidthForColumn(TableColumn col,JTable table) {
	        int hw = columnHeaderWidth(col,table);  // hw = header width
	        int cw = widestCellInColumn(col,table);  // cw = column width

	        return hw > cw ? hw : cw;
	    }

	   public static int columnHeaderWidth(TableColumn col,JTable table) {
	        TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
	        Component comp = renderer.getTableCellRendererComponent(
	                             table, col.getHeaderValue(),
	                             false, false, 0, 0);

	        return comp.getPreferredSize().width;
	    }

	    public static int widestCellInColumn(TableColumn col,JTable table) {
	        int c = col.getModelIndex();
	        int width = 0, maxw = 0;

	        for (int r =0; r < table.getRowCount(); r++) {
	            TableCellRenderer renderer = table.getCellRenderer(r, c);
	            Component comp = renderer.getTableCellRendererComponent(
	                                 table, table.getValueAt(r, c),
	                                 false, false, r, c);
	            width = comp.getPreferredSize().width;
	            maxw = width > maxw ? width : maxw;
	        }
	        return maxw;
	    }
	    public static void fitTable(JTable table){
	    	int count=table.getColumnCount();
	    	for(int i=0;i<count;i++){
	    	   TableColumn column = table.getColumnModel().getColumn(i);  // 第 2 列
	           column.setPreferredWidth(getPreferredWidthForColumn(column,table));
	    	}
	    }
}
