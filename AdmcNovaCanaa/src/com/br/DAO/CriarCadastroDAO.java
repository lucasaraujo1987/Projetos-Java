package com.br.DAO;

import com.br.DTO.LoginDTO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CriarCadastroDAO {
    
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    
    public void cadastrarLogin(LoginDTO objLoginDTO){
        
        String sql = "insert into login (id_login, usuario_login, senha_login, email_login) values (?,?,?,?)";
        String senha = objLoginDTO.getSenha_login();
        
        con = new ConexaoDAO().conexaoBD();
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
            
            StringBuilder sb = new StringBuilder();

            for (byte b : messageDigest) {
                sb.append(String.format("%02X", 0xFF & b));

            }
            String senhaEx = sb.toString();
            
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, objLoginDTO.getId_login());
            pstm.setString(2, objLoginDTO.getUsuario_login());
            pstm.setString(3, senhaEx);
            pstm.setString(4, objLoginDTO.getEmail_login());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar novo acesso " + e);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(CriarCadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
