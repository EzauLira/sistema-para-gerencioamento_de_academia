package com.SistemaDeGerenciamentodeAcademia.SGA.mdoel;

public class Administrador {

    private String usuario;
    private String senha;

    public  Administrador(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario(String usuario){
        return usuario;
    }
    public void setUsuario(){
        this.usuario = usuario;
    }

    public String getSenha(String senha){
        return senha;
    }

    public void setSenha(){
        this.senha = senha;
    }
}
