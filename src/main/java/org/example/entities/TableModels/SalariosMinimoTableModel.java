package org.example.entities.TableModels;

import org.example.BusinessRuler.OperacoesComSalarioService;
import org.example.entities.Funcionario;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SalariosMinimoTableModel extends AbstractTableModel {


    private List<Funcionario> items;
    public SalariosMinimoTableModel() {
        items = new ArrayList<>();
    }
    public SalariosMinimoTableModel(List<Funcionario> items) {
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
            case 0: return "nome";
            case 1: return "salarios minimos";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario item = items.get(rowIndex);
        String quantidade = OperacoesComSalarioService.quantidadeDeSalariosMinimos(item);

        switch (columnIndex) {
            case 0: return item.getNome();
            case 1: return quantidade;
        }
        return null;
    }
}
