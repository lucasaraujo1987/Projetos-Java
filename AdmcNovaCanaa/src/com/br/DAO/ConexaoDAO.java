package com.br.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    public Connection coonexaoBD() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/admc_nova_canaa?user=root&password=";
            con = DriverManager.getConnection(url);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Conectar " + e);
        }
        return con;
    }
}
