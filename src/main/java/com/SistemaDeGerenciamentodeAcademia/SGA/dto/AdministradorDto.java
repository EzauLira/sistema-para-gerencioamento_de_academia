package com.SistemaDeGerenciamentodeAcademia.SGA.dto;

public class AdministradorDto {

    private String usuario;
    private String senha;

    public  AdministradorDto(String usuario, String senha){
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
