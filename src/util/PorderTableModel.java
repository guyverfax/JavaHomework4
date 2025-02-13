package util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Porder;

public class PorderTableModel extends AbstractTableModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private final String[] columnNames = {"訂單編號", "顧客名字", "蘋果數量", "香蕉數量", "檸檬數量", "總金額"};
    private List<Porder> orders;
    
    public PorderTableModel(List<Porder> orders) {
        this.orders = orders;
    }
    
	@Override
	public int getRowCount() {
		return orders.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
    public String getColumnName(int column) {  
        return columnNames[column];
    }
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Porder order = orders.get(rowIndex);
        switch (columnIndex) {
            case 0: return order.getId();
            case 1: return order.getName();
            case 2: return order.getApple();
            case 3: return order.getBanana();
            case 4: return order.getLemon();
            case 5: return order.getApple()*50+order.getBanana()*20+order.getLemon()*30;
            default: return null;
        }
	}
	
	public void updateRow(int rowIndex, Porder updatedOrder) {
        orders.set(rowIndex, updatedOrder);
        fireTableRowsUpdated(rowIndex, rowIndex); // 通知 JTable 更新 UI
    }
}
