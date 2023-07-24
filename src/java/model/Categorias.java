
package model;

public class Categorias {
    private int id;
    private String descricao;
    
    public Categorias(int id,String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public Categorias(String descricao) {
        this.descricao = descricao;
    }

    public Categorias() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
