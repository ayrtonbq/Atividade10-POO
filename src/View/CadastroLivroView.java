package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;
import java.util.List;

import Controller.CadastroLivroController;
import Controller.CadastroVinculacaoLivroCategoriaController;

public class CadastroLivroView extends JFrame implements ActionListener {
    private JTextField nomeLivroField;
    private JTextField autorField;
    private JTextField dataPublicacaoField;
    private JComboBox<String> tipoLivroComboBox;
    private JCheckBox romanceCheckbox;
    private JCheckBox policialCheckbox;
    private JCheckBox terrorCheckbox;
    private JCheckBox ficcaoCientificaCheckbox;
    private JCheckBox infantilCheckbox;
    private JPanel categoriaPanel;

    public CadastroLivroView() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Cadastro de Livro");
        setSize(320, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNomeLivro = new JLabel("Nome do Livro:");
        lblNomeLivro.setBounds(10, 20, 100, 20);
        panel.add(lblNomeLivro);

        nomeLivroField = new JTextField();
        nomeLivroField.setBounds(140, 20, 150, 20);
        panel.add(nomeLivroField);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(10, 50, 100, 20);
        panel.add(lblAutor);

        autorField = new JTextField();
        autorField.setBounds(140, 50, 150, 20);
        panel.add(autorField);

        JLabel lblDataPublicacao = new JLabel("Data de Publicação:");
        lblDataPublicacao.setBounds(10, 80, 200, 20);
        panel.add(lblDataPublicacao);

        dataPublicacaoField = new JTextField();
        dataPublicacaoField.setBounds(140, 80, 150, 20);
        panel.add(dataPublicacaoField);
        
        JLabel lbltipoLivro = new JLabel("Tipo Livro:");
        lbltipoLivro.setBounds(10, 110, 200, 20);
        panel.add(lbltipoLivro);
        
        String[] tipos = {"Digital", "Físico"};
        tipoLivroComboBox = new JComboBox<>(tipos);
        tipoLivroComboBox.setBounds(140, 110, 150, 20);
        panel.add(tipoLivroComboBox);        
        
        categoriaPanel = new JPanel();
        categoriaPanel.setBorder(new TitledBorder("Categorias"));
        categoriaPanel.setBounds(10, 140, 280, 130);
        categoriaPanel.setLayout(null);
        panel.add(categoriaPanel);

        romanceCheckbox = new JCheckBox("Romance");
        romanceCheckbox.setBounds(10, 20, 100, 20);
        categoriaPanel.add(romanceCheckbox);

        policialCheckbox = new JCheckBox("Policial");
        policialCheckbox.setBounds(10, 40, 100, 20);
        categoriaPanel.add(policialCheckbox);

        terrorCheckbox = new JCheckBox("Terror");
        terrorCheckbox.setBounds(10, 60, 100, 20);
        categoriaPanel.add(terrorCheckbox);

        ficcaoCientificaCheckbox = new JCheckBox("Ficção Científica");
        ficcaoCientificaCheckbox.setBounds(10, 80, 150, 20);
        categoriaPanel.add(ficcaoCientificaCheckbox);

        infantilCheckbox = new JCheckBox("Infantil");
        infantilCheckbox.setBounds(10, 100, 100, 20);
        categoriaPanel.add(infantilCheckbox);
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(100, 275, 100, 30);
        btnCadastrar.addActionListener(this);
        panel.add(btnCadastrar);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Cadastrar")) {
            String nomeLivro = nomeLivroField.getText();
            String autor = autorField.getText();
            String dataPublicacao = dataPublicacaoField.getText();
            String tipo = (String) tipoLivroComboBox.getSelectedItem();
            
            if (nomeLivro.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite o nome do livro!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }            

            if (!romanceCheckbox.isSelected() && !policialCheckbox.isSelected() &&
                !terrorCheckbox.isSelected() && !ficcaoCientificaCheckbox.isSelected() &&
                !infantilCheckbox.isSelected()) {
                JOptionPane.showMessageDialog(this, "Selecione pelo menos uma categoria!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder categoriasSelecionadas = new StringBuilder();
            if (romanceCheckbox.isSelected()) {
                categoriasSelecionadas.append("Romance, ");
            }
            if (policialCheckbox.isSelected()) {
                categoriasSelecionadas.append("Policial, ");
            }
            if (terrorCheckbox.isSelected()) {
                categoriasSelecionadas.append("Terror, ");
            }
            if (ficcaoCientificaCheckbox.isSelected()) {
                categoriasSelecionadas.append("Ficção Científica, ");
            }
            if (infantilCheckbox.isSelected()) {
                categoriasSelecionadas.append("Infantil, ");
            }


            try {
                CadastroLivroController cadastrarLivroController = new CadastroLivroController();
                int idLivro = cadastrarLivroController.salvarLivro(nomeLivro, autor, dataPublicacao, tipo);

                CadastroVinculacaoLivroCategoriaController vinculacaoController = new CadastroVinculacaoLivroCategoriaController();
                
                // Obter o ID da categoria para cada categoria selecionada e salvar a vinculação
                if (romanceCheckbox.isSelected()) {
                	vinculacaoController.salvarVinculacaoLivroCategoria(1, idLivro); 
                }
                if (policialCheckbox.isSelected()) {
                	vinculacaoController.salvarVinculacaoLivroCategoria(2, idLivro); 
                }
                
                if (terrorCheckbox.isSelected()) {
                    vinculacaoController.salvarVinculacaoLivroCategoria(3, idLivro);
                }
                if (ficcaoCientificaCheckbox.isSelected()) {
                    vinculacaoController.salvarVinculacaoLivroCategoria(4, idLivro); 
                }
                if (infantilCheckbox.isSelected()) {
                    vinculacaoController.salvarVinculacaoLivroCategoria(5, idLivro); 
                }                           
                
                JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
                clearFields();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar livro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void clearFields() {
        nomeLivroField.setText("");
        autorField.setText("");
        dataPublicacaoField.setText("");
        romanceCheckbox.setSelected(false);
        policialCheckbox.setSelected(false);
        terrorCheckbox.setSelected(false);
        ficcaoCientificaCheckbox.setSelected(false);
        infantilCheckbox.setSelected(false);  
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CadastroLivroView frame = new CadastroLivroView();
            frame.setVisible(true);
        });
    }
}
