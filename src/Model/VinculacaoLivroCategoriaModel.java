package Model;

public class VinculacaoLivroCategoriaModel {
    private Integer idCategoria;
    private Integer idLivro;

    public VinculacaoLivroCategoriaModel(Integer idCategoria, Integer idLivro) {
        this.idCategoria = idCategoria;
        this.idLivro = idLivro;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }
}
