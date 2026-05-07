package com.udesc.musicas;

import com.udesc.gerenciador.Database;
import com.udesc.generos.GenerosBean;
import com.udesc.generos.GenerosModel;
import com.udesc.artistas.ArtistasBean;
import com.udesc.artistas.ArtistasModel;
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
        setTitle("Músicas");
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
            v.add(bean.getIdMusica());       // col 0: id
            v.add(bean.getTitulo());         // col 1: título
            v.add(bean.getDuracao());        // col 2: duração
            v.add(bean.getAno());            // col 3: ano
            v.add(bean.getNomeGenero());     // col 4: gênero (visible name)
            v.add(bean.getNomeArtista());    // col 5: artista (visible name)
            v.add(bean.getIdGenero());       // col 6: idGenero (hidden)
            v.add(bean.getArtista());        // col 7: idArtista (hidden)
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
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"id", "Título", "Duração", "Ano", "Gênero", "Artista", "idGenero", "idArtista"}) {
            public boolean isCellEditable(int r, int c) { return false; }
        });
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        for (int col : new int[]{6, 7}) {
            jTable1.getColumnModel().getColumn(col).setMinWidth(0);
            jTable1.getColumnModel().getColumn(col).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(col).setWidth(0);
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);  // id
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(130); // Título
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(55);  // Duração
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);  // Ano
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(100); // Gênero
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(130); // Artista

        jButton1.setText("Editar");
        jButton1.addActionListener(e -> editarActionPerformed());
        jButton2.setText("Remover");
        jButton2.addActionListener(e -> removerActionPerformed());
        jButton3.setText("Adicionar");
        jButton3.addActionListener(e -> adicionarActionPerformed());

        jLabel1.setFont(new java.awt.Font("Roboto Slab", 1, 48));
        jLabel1.setText("Músicas");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(e -> botaoVoltarActionPerformed());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        JComboBox<GenerosBean> generoCombo = new JComboBox<>();
        JComboBox<ArtistasBean> artistaCombo = new JComboBox<>();

        try {
            List<GenerosBean> generos = GenerosModel.listAll(getConnection());
            for (GenerosBean genero : generos) {
                generoCombo.addItem(genero);
            }
            List<ArtistasBean> artistas = ArtistasModel.listAll(getConnection());
            for (ArtistasBean artista : artistas) {
                artistaCombo.addItem(artista);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JPanel panel = new JPanel(new java.awt.GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Título:"));     panel.add(tituloField);
        panel.add(new JLabel("Duração:"));    panel.add(duracaoField);
        panel.add(new JLabel("Ano:"));        panel.add(anoField);
        panel.add(new JLabel("Gênero:"));     panel.add(generoCombo);
        panel.add(new JLabel("Artista:"));    panel.add(artistaCombo);

        if (JOptionPane.showConfirmDialog(this, panel, "Adicionar Música",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
            try {
                if (tituloField.getText().trim().isEmpty()) { JOptionPane.showMessageDialog(this, "Preencha o título.", "Aviso", JOptionPane.WARNING_MESSAGE); return; }
                GenerosBean selectedGenero = (GenerosBean) generoCombo.getSelectedItem();
                ArtistasBean selectedArtista = (ArtistasBean) artistaCombo.getSelectedItem();
                if (selectedGenero == null || selectedArtista == null) {
                    JOptionPane.showMessageDialog(this, "Selecione um gênero e um artista.", "Aviso", JOptionPane.WARNING_MESSAGE); return;
                }
                MusicasBean bean = new MusicasBean(0,
                        tituloField.getText().trim(),
                        duracaoField.getText().trim(),
                        anoField.getText().trim(),
                        selectedGenero.getIdGenero(),
                        selectedArtista.getId());
                MusicasModel.create(bean, getConnection());
                loadData();
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
        int currentGenreId  = (int) dtm.getValueAt(row, 6);
        int currentArtistId = (int) dtm.getValueAt(row, 7);

        JTextField tituloField  = new JTextField((String) dtm.getValueAt(row, 1), 20);
        JTextField duracaoField = new JTextField((String) dtm.getValueAt(row, 2), 20);
        JTextField anoField     = new JTextField((String) dtm.getValueAt(row, 3), 20);
        JComboBox<GenerosBean> generoCombo = new JComboBox<>();
        JComboBox<ArtistasBean> artistaCombo = new JComboBox<>();

        try {
            List<GenerosBean> generos = GenerosModel.listAll(getConnection());
            GenerosBean selectedGenre = null;
            for (GenerosBean genero : generos) {
                generoCombo.addItem(genero);
                if (genero.getIdGenero() == currentGenreId) {
                    selectedGenre = genero;
                }
            }
            if (selectedGenre != null) {
                generoCombo.setSelectedItem(selectedGenre);
            }
            
            List<ArtistasBean> artistas = ArtistasModel.listAll(getConnection());
            ArtistasBean selectedArtist = null;
            for (ArtistasBean artista : artistas) {
                artistaCombo.addItem(artista);
                if (artista.getId() == currentArtistId) {
                    selectedArtist = artista;
                }
            }
            if (selectedArtist != null) {
                artistaCombo.setSelectedItem(selectedArtist);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JPanel panel = new JPanel(new java.awt.GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Título:"));     panel.add(tituloField);
        panel.add(new JLabel("Duração:"));    panel.add(duracaoField);
        panel.add(new JLabel("Ano:"));        panel.add(anoField);
        panel.add(new JLabel("Gênero:"));     panel.add(generoCombo);
        panel.add(new JLabel("Artista:"));    panel.add(artistaCombo);

        if (JOptionPane.showConfirmDialog(this, panel, "Editar Música (ID: " + id + ")",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
            try {
                if (tituloField.getText().trim().isEmpty()) { JOptionPane.showMessageDialog(this, "Preencha o título.", "Aviso", JOptionPane.WARNING_MESSAGE); return; }
                GenerosBean selectedGenero = (GenerosBean) generoCombo.getSelectedItem();
                ArtistasBean selectedArtista = (ArtistasBean) artistaCombo.getSelectedItem();
                if (selectedGenero == null || selectedArtista == null) {
                    JOptionPane.showMessageDialog(this, "Selecione um gênero e um artista.", "Aviso", JOptionPane.WARNING_MESSAGE); return;
                }
                MusicasBean bean = new MusicasBean(id,
                        tituloField.getText().trim(),
                        duracaoField.getText().trim(),
                        anoField.getText().trim(),
                        selectedGenero.getIdGenero(),
                        selectedArtista.getId());
                MusicasModel.alterar(bean, getConnection());
                loadData();
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

    private void botaoVoltarActionPerformed() {
        this.dispose();
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

    private javax.swing.JButton botaoVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
