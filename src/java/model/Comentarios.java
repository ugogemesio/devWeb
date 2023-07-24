package model;

import java.sql.Date;

public class Comentarios {
    private int id;
    private String comentario;
    private Date data;
    private int idcategoria;
    private int idusuario;

    public Comentarios(int id, String comentario, Date data, int idcategoria, int idusuario) {
        this.id = id;
        this.comentario = comentario;
        this.data = data;
        this.idcategoria = idcategoria;
        this.idusuario = idusuario;
    }

    public Comentarios() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    
}
