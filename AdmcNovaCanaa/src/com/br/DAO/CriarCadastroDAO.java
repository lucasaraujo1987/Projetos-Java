package com.br.DAO;

import com.br.DTO.LoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CriarCadastroDAO {
    
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    
    public void cadastrarLogin(LoginDTO objLoginDTO){
        
        String sql = "insert into login (id_login, usuario_login, senha_login, email_login) values (?,?,?,?)";
        
        con = new ConexaoDAO().coonexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, objLoginDTO.getId_login());
            pstm.setString(2, objLoginDTO.getUsuario_login());
            pstm.setString(3, objLoginDTO.getSenha_login());
            pstm.setString(4, objLoginDTO.getEmail_login());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar novo acesso " + e);
        }
    }
}
