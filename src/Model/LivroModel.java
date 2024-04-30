package Model;

public class LivroModel {
    private Integer idLivro;
    private String nomeLivro;
    private String autor;
    private String anoPublicacao;
    private String tipo;

    public LivroModel(String nomeLivro, String autor, String anoPublicacao, String tipo) {
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.tipo = tipo;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public LivroModel() {
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
