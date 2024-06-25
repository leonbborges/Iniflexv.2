package org.example.entities.TableModels;

import org.example.entities.Historico;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class HistoricoTableModel extends AbstractTableModel {

    private List<Historico> items;
    public HistoricoTableModel() {
        items = new ArrayList<>();
    }
    public HistoricoTableModel(List<Historico> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
            case 2:
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "tipo de operação";
            case 1: return "dia da operação";
            case 2: return "descrição";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Historico item = items.get(rowIndex);
        String formattedDate = item.getDataHora().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        String tipoDeOperacao = item.getHistoricoEnum().toString();

        switch (columnIndex) {
            case 0: return tipoDeOperacao;
            case 1: return formattedDate;
            case 2: return item.getOperacao();
        }
        return null;
    }
    }
