package com.br.DTO;
public class LoginDTO {
    
    private int id_login;
    private String usuario_login, senha_login, email_login;

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getUsuario_login() {
        return usuario_login;
    }

    public void setUsuario_login(String usuario_login) {
        this.usuario_login = usuario_login;
    }

    public String getSenha_login() {
        return senha_login;
    }

    public void setSenha_login(String senha_login) {
        this.senha_login = senha_login;
    }

    public String getEmail_login() {
        return email_login;
    }

    public void setEmail_login(String email_login) {
        this.email_login = email_login;
    }
    
}
