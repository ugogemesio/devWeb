/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gemes
 */
public class JavaBeans {

    private int idcon;
    private String nome;
    private int cpf;
    private String senha;
    
    public JavaBeans() {
    }

    public JavaBeans(int idcon, String nome, int cpf, String senha) {
        this.idcon = idcon;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public int getIdcon() {
        return idcon;
    }

    public void setIdcon(int idcon) {
        this.idcon = idcon;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }
    
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
