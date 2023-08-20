package com.br.DAO;

import com.br.DTO.LoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginDAO {
    
    Connection con;
    
    public ResultSet login(LoginDTO objLoginDTO){
        
        con = new ConexaoDAO().coonexaoBD();
        
        try {
            String sql = "select * from login where usuario_login = ? and senha_login = ?";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, objLoginDTO.getUsuario_login());
            pstm.setString(2, objLoginDTO.getSenha_login());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Conectar LoginDAO" + e);
            return null;
        }
    }
    
}
