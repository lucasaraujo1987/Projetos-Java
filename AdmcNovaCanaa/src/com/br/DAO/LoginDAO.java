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

public class LoginDAO {

    Connection con;

    public ResultSet login(LoginDTO objLoginDTO) {
        String senha = objLoginDTO.getSenha_login();

        con = new ConexaoDAO().coonexaoBD();

        try {
            String sql = "select * from login where usuario_login = ? and senha_login = ?";
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (byte b : messageDigest) {
                sb.append(String.format("%02X", 0xFF & b));

            }
            String senhaEx = sb.toString();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, objLoginDTO.getUsuario_login());
            pstm.setString(2, senhaEx);

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Conectar LoginDAO" + e);
            return null;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
