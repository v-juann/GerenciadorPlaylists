package com.udesc.musicas;

import com.udesc.gerenciador.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MusicasFrame extends javax.swing.JFrame {

    public MusicasFrame() throws SQLException {
        initComponents();
        loadData();
    }

    private Connection getConnection() throws SQLException {
        return new Database().getConnection();
    }

    public void loadTableData(List<MusicasBean> list) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        for (MusicasBean bean : list) {
            Vector v = new Vector();
            v.add(bean.getIdMusica());
            v.add(bean.getTitulo());
            v.add(bean.getDuracao());
            v.add(bean.getAno());
            v.add(bean.getIdGenero());
            v.add(bean.getArtista());
            dtm.addRow(v);
        }
    }

    public void loadData() {
        try {
            loadTableData(MusicasModel.listAll(getConnection()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"id", "Título", "Duração", "Ano", "ID Gênero", "ID Artista"}) {
            public boolean isCellEditable(int r, int c) { return false; }
        });
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Editar");
        jButton1.addActionListener(e -> editarActionPerformed());
        jButton2.setText("Remover");
        jButton2.addActionListener(e -> removerActionPerformed());
        jButton3.setText("Adicionar");
        jButton3.addActionListener(e -> adicionarActionPerformed());

        jLabel1.setFont(new java.awt.Font("Roboto Slab", 1, 48));
        jLabel1.setText("Músicas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 85, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }

    private void adicionarActionPerformed() {
        JTextField tituloField  = new JTextField(20);
        JTextField duracaoField = new JTextField(20);
        JTextField anoField     = new JTextField(20);
        JTextField generoField  = new JTextField(20);
        JTextField artistaField = new JTextField(20);

        JPanel panel = new JPanel(new java.awt.GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Título:"));     panel.add(tituloField);
        panel.add(new JLabel("Duração:"));    panel.add(duracaoField);
        panel.add(new JLabel("Ano:"));        panel.add(anoField);
        panel.add(new JLabel("ID Gênero:"));  panel.add(generoField);
        panel.add(new JLabel("ID Artista:")); panel.add(artistaField);

        if (JOptionPane.showConfirmDialog(this, panel, "Adicionar Música",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
            try {
                if (tituloField.getText().trim().isEmpty()) { JOptionPane.showMessageDialog(this, "Preencha o título.", "Aviso", JOptionPane.WARNING_MESSAGE); return; }
                MusicasBean bean = new MusicasBean(0,
                        tituloField.getText().trim(),
                        duracaoField.getText().trim(),
                        anoField.getText().trim(),
                        Integer.parseInt(generoField.getText().trim()),
                        Integer.parseInt(artistaField.getText().trim()));
                MusicasModel.create(bean, getConnection());
                loadData();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID Gênero e ID Artista devem ser números.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao adicionar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void editarActionPerformed() {
        int row = jTable1.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Selecione uma música para editar.", "Aviso", JOptionPane.WARNING_MESSAGE); return; }
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int id = (int) dtm.getValueAt(row, 0);

        JTextField tituloField  = new JTextField((String) dtm.getValueAt(row, 1), 20);
        JTextField duracaoField = new JTextField((String) dtm.getValueAt(row, 2), 20);
        JTextField anoField     = new JTextField((String) dtm.getValueAt(row, 3), 20);
        JTextField generoField  = new JTextField(String.valueOf(dtm.getValueAt(row, 4)), 20);
        JTextField artistaField = new JTextField(String.valueOf(dtm.getValueAt(row, 5)), 20);

        JPanel panel = new JPanel(new java.awt.GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Título:"));     panel.add(tituloField);
        panel.add(new JLabel("Duração:"));    panel.add(duracaoField);
        panel.add(new JLabel("Ano:"));        panel.add(anoField);
        panel.add(new JLabel("ID Gênero:"));  panel.add(generoField);
        panel.add(new JLabel("ID Artista:")); panel.add(artistaField);

        if (JOptionPane.showConfirmDialog(this, panel, "Editar Música (ID: " + id + ")",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
            try {
                if (tituloField.getText().trim().isEmpty()) { JOptionPane.showMessageDialog(this, "Preencha o título.", "Aviso", JOptionPane.WARNING_MESSAGE); return; }
                MusicasBean bean = new MusicasBean(id,
                        tituloField.getText().trim(),
                        duracaoField.getText().trim(),
                        anoField.getText().trim(),
                        Integer.parseInt(generoField.getText().trim()),
                        Integer.parseInt(artistaField.getText().trim()));
                MusicasModel.alterar(bean, getConnection());
                loadData();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID Gênero e ID Artista devem ser números.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao editar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void removerActionPerformed() {
        int row = jTable1.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Selecione uma música para remover.", "Aviso", JOptionPane.WARNING_MESSAGE); return; }
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int id = (int) dtm.getValueAt(row, 0);
        String titulo = (String) dtm.getValueAt(row, 1);

        if (JOptionPane.showConfirmDialog(this, "Deseja remover a música \"" + titulo + "\" (ID: " + id + ")?",
                "Confirmar Remoção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                MusicasModel.remove(id, getConnection());
                loadData();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao remover: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; }
            }
        } catch (Exception ex) { Logger.getLogger(MusicasFrame.class.getName()).log(Level.SEVERE, null, ex); }
        java.awt.EventQueue.invokeLater(() -> {
            try { new MusicasFrame().setVisible(true); }
            catch (SQLException ex) { Logger.getLogger(MusicasFrame.class.getName()).log(Level.SEVERE, null, ex); }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
