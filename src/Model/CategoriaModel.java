package Model;

public class CategoriaModel {
    private Integer idCategoria;
    private String nome;

    public CategoriaModel(String nome) {
        this.nome = nome;
    }    
   
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaModel(){
        
    }
}
