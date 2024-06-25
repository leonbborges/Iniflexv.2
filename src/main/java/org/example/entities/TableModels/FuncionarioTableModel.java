package org.example.entities.TableModels;

import org.example.entities.Funcionario;

import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioTableModel extends AbstractTableModel {

    private List<Funcionario> items;
    public FuncionarioTableModel() {
        items = new ArrayList<>();
    }
    public FuncionarioTableModel(List<Funcionario> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
            case 2:
            case 3:
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "nome";
            case 1: return "data de Nascimento";
            case 2: return "salário";
            case 3: return "função";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario item = items.get(rowIndex);
        String formattedDate = item.getDataNascimento().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,###,###,###.00");
        String salarioFormatado = df.format(item.getSalario());
        String salarioComReal = "R$ " + salarioFormatado;

        switch (columnIndex) {
            case 0: return item.getNome();
            case 1: return formattedDate;
            case 2: return salarioComReal;
            case 3: return item.getFuncao();
        }
        return null;
    }
}
