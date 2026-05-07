package com.udesc.playlists;

import com.udesc.gerenciador.Database;
import com.udesc.musicas.MusicasBean;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PlaylistMusicasFrame extends javax.swing.JFrame {

    private final int idPlaylist;
    private final String nomePlaylist;

    private JTable tabelaNaPlaylist;
    private JTable tabelaDisponivel;
    private JScrollPane scrollNaPlaylist;
    private JScrollPane scrollDisponivel;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JButton btnVoltar;
    private JLabel labelTitulo;
    private JPanel jPanel1;

    public PlaylistMusicasFrame(int idPlaylist, String nomePlaylist) {
        this.idPlaylist = idPlaylist;
        this.nomePlaylist = nomePlaylist;
        initComponents();
        loadData();
    }

    private Connection getConnection() throws SQLException {
        return new Database().getConnection();
    }

    private DefaultTableModel createTableModel() {
        return new DefaultTableModel(
            new Object[][]{},
            new String[]{"id", "Título", "Duração", "Ano", "Gênero", "Artista"}
        ) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
    }

    private void loadTable(JTable table, List<MusicasBean> list) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        for (MusicasBean bean : list) {
            Vector<Object> v = new Vector<>();
            v.add(bean.getIdMusica());
            v.add(bean.getTitulo());
            v.add(bean.getDuracao());
            v.add(bean.getAno());
            v.add(bean.getNomeGenero());
            v.add(bean.getNomeArtista());
            dtm.addRow(v);
        }
        // Tighten the id column
        table.getColumnModel().getColumn(0).setMaxWidth(45);
        table.getColumnModel().getColumn(0).setPreferredWidth(45);
    }

    public void loadData() {
        try {
            loadTable(tabelaNaPlaylist,  PlaylistMusicasModel.listByPlaylist(idPlaylist, getConnection()));
            loadTable(tabelaDisponivel,  PlaylistMusicasModel.listAvailable(idPlaylist,  getConnection()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        jPanel1          = new JPanel();
        tabelaNaPlaylist = new JTable(createTableModel());
        tabelaDisponivel = new JTable(createTableModel());
        scrollNaPlaylist = new JScrollPane(tabelaNaPlaylist);
        scrollDisponivel = new JScrollPane(tabelaDisponivel);
        btnAdicionar     = new JButton("← Adicionar");
        btnRemover       = new JButton("Remover →");
        btnVoltar        = new JButton("Voltar");
        labelTitulo      = new JLabel("Playlist: " + nomePlaylist);

        tabelaNaPlaylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaDisponivel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        labelTitulo.setFont(new Font("Roboto Slab", Font.BOLD, 24));

        btnAdicionar.addActionListener(e -> adicionarMusica());
        btnRemover.addActionListener(e -> removerMusica());
        btnVoltar.addActionListener(e -> dispose());

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // --- Layout ---
        // Button panel (center column)
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        btnAdicionar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRemover.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPanel.add(Box.createVerticalGlue());
        btnPanel.add(btnAdicionar);
        btnPanel.add(Box.createVerticalStrut(10));
        btnPanel.add(btnRemover);
        btnPanel.add(Box.createVerticalGlue());

        // Table labels
        JLabel labelNaPlaylist  = new JLabel("Músicas na Playlist");
        JLabel labelDisponiveis = new JLabel("Músicas Disponíveis");
        labelNaPlaylist.setFont(new Font("SansSerif", Font.BOLD, 13));
        labelDisponiveis.setFont(new Font("SansSerif", Font.BOLD, 13));

        // Left panel
        JPanel leftPanel = new JPanel(new BorderLayout(0, 5));
        leftPanel.add(labelNaPlaylist, BorderLayout.NORTH);
        leftPanel.add(scrollNaPlaylist, BorderLayout.CENTER);

        // Right panel
        JPanel rightPanel = new JPanel(new BorderLayout(0, 5));
        rightPanel.add(labelDisponiveis, BorderLayout.NORTH);
        rightPanel.add(scrollDisponivel, BorderLayout.CENTER);

        // Tables row
        JPanel tablesPanel = new JPanel(new BorderLayout());
        tablesPanel.add(leftPanel,  BorderLayout.WEST);
        tablesPanel.add(btnPanel,   BorderLayout.CENTER);
        tablesPanel.add(rightPanel, BorderLayout.EAST);

        scrollNaPlaylist.setPreferredSize(new Dimension(480, 350));
        scrollDisponivel.setPreferredSize(new Dimension(480, 350));

        // Main panel
        jPanel1.setLayout(new BorderLayout(10, 10));
        jPanel1.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        jPanel1.add(btnVoltar,   BorderLayout.NORTH);
        jPanel1.add(labelTitulo, BorderLayout.BEFORE_FIRST_LINE); // stacks above NORTH via wrapper
        
        // Wrap title + voltar together at the top
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(btnVoltar,   BorderLayout.WEST);
        topPanel.add(labelTitulo, BorderLayout.CENTER);

        jPanel1.remove(btnVoltar);
        jPanel1.add(topPanel,    BorderLayout.NORTH);
        jPanel1.add(tablesPanel, BorderLayout.CENTER);

        getContentPane().add(jPanel1);
        pack();
        setLocationRelativeTo(null);
    }

    private void adicionarMusica() {
        int row = tabelaDisponivel.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma música disponível para adicionar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idMusica = (int) tabelaDisponivel.getModel().getValueAt(row, 0);
        try {
            PlaylistMusicasModel.addMusica(idPlaylist, idMusica, getConnection());
            loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar música: " + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerMusica() {
        int row = tabelaNaPlaylist.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma música da playlist para remover.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idMusica = (int) tabelaNaPlaylist.getModel().getValueAt(row, 0);
        String titulo = (String) tabelaNaPlaylist.getModel().getValueAt(row, 1);
        if (JOptionPane.showConfirmDialog(this,
                "Remover \"" + titulo + "\" da playlist?",
                "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                PlaylistMusicasModel.removeMusica(idPlaylist, idMusica, getConnection());
                loadData();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao remover música: " + ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}