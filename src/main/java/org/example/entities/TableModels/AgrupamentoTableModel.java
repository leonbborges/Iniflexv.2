package org.example.entities.TableModels;

import org.example.entities.MapPrint;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgrupamentoTableModel extends AbstractTableModel {

    List<MapPrint> mapPrints = new ArrayList<>();
    private Map<String, ArrayList<String>> items;
    public AgrupamentoTableModel() {
        items = new HashMap<>();
    }
    public AgrupamentoTableModel(Map<String, ArrayList<String>> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Função";
            case 1: return "Nome";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        items.forEach((key, value)
                -> mapPrints.add(new MapPrint(key, value)));

        switch (columnIndex) {
            case 0: return mapPrints.get(rowIndex).getChave();
            case 1: return mapPrints.get(rowIndex).getLista().toString();
        }
        return null;
    }
}
