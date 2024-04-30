package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.LivroModel;
import Model.CategoriaModel;

public class CadastroVinculacaoLivroCategoriaController {

    Connection conexao = null;
    private PreparedStatement pstmt = null;

    public void salvarVinculacaoLivroCategoria(Integer idCategoria, Integer idLivro) throws SQLException {
        conexao = Conexao.obterConexao();
        try {
            String sql = "INSERT INTO LivroCategoria (id_categoria, id_livro) VALUES (?, ?)";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, idCategoria);
            pstmt.setInt(2, idLivro);
            pstmt.executeUpdate();
            System.out.println("Vínculo atualizado com sucesso!");
        } finally {
            fecharRecursos();
        }
    }

    // Método para listar os livros disponíveis
    public List<LivroModel> listarLivrosDisponiveis() throws SQLException {
        List<LivroModel> livros = new ArrayList<>();
        conexao = Conexao.obterConexao();
        try {
            String sql = "SELECT id_livro, nome FROM livro";
            pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                LivroModel livro = new LivroModel();
                livro.setIdLivro(rs.getInt("id_livro"));
                livro.setNomeLivro(rs.getString("nome"));
                livros.add(livro);
            }
        } finally {
            fecharRecursos();
        }
        return livros;
    }

    // Método para listar as categorias disponíveis
    public List<CategoriaModel> listarCategoriasDisponiveis() throws SQLException {
        List<CategoriaModel> categorias = new ArrayList<>();
        conexao = Conexao.obterConexao();
        try {
            String sql = "SELECT id_categoria, nome FROM categoria";
            pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CategoriaModel categoria = new CategoriaModel();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome"));
                categorias.add(categoria);
            }
        } finally {
            fecharRecursos();
        }
        return categorias;
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
