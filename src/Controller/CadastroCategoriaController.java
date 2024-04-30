package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.CategoriaModel;

public class CadastroCategoriaController {

    Connection conexao = null;
    private PreparedStatement pstmt = null;

    public void salvarCategoria(String nome) throws SQLException {
        CategoriaModel categoria = new CategoriaModel(nome);
        conexao = Conexao.obterConexao();
    
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        pstmt = conexao.prepareStatement(sql);
    
        pstmt.setString(1, categoria.getNome());
        
        pstmt.executeUpdate();
    
        fecharRecursos(); // Chamada do método para fechar recursos
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
