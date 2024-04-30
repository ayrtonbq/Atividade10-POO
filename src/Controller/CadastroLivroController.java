package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import Model.LivroModel;

public class CadastroLivroController {

    Connection conexao = null;
    private PreparedStatement pstmt = null;

    public int salvarLivro(String nomeLivro, String autor, String data, String tipo) throws SQLException {
        LivroModel livro = new LivroModel(nomeLivro, autor, data, tipo);
        conexao = Conexao.obterConexao();
    
        String sql = "INSERT INTO livro (nome, autor, ano_publicacao, tipo) VALUES (?, ?, ?, ?)";
        pstmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    
        pstmt.setString(1, livro.getNomeLivro());
        pstmt.setString(2, livro.getAutor());
        pstmt.setString(3, livro.getAnoPublicacao());
        pstmt.setString(4, livro.getTipo());
        
        pstmt.executeUpdate();
    
        // Obter o ID do livro salvo
        ResultSet rs = pstmt.getGeneratedKeys();
        int idLivroSalvo = -1; // Inicialize com um valor inválido
        if (rs.next()) {
            idLivroSalvo = rs.getInt(1);
        }

        fecharRecursos(); // Chamada do método para fechar recursos

        // Retornar o ID do livro salvo
        return idLivroSalvo;
    }

    // Método para fechar recursos
    private void fecharRecursos() {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
