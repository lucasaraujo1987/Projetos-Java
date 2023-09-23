package com.br.DAO;

import com.br.DTO.AdicionarMembroDTO;
import com.br.DTO.DadosIgrejaMembroDTO;
import com.br.DTO.EndereçoMembroDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdicionarMembroDAO {
    
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    
    public void adicionarMembro(AdicionarMembroDTO objAdicionarMembroDTO){
        
        String sql = "insert into membro (id_membro, nome_membro, cpf_membro, rg_membro, nascimento_membro, email_membro, celular_membro, estadoCivil_membro, mae_membro, pai_membro, conjugue_membro) values (?,?,?,?,?,?,?,?,?,?,?)";
        
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, objAdicionarMembroDTO.getId_membro());
            pstm.setString(2, objAdicionarMembroDTO.getNome_membro());
            pstm.setString(3, objAdicionarMembroDTO.getCpf_membro());
            pstm.setString(4, objAdicionarMembroDTO.getRg_membro());
            pstm.setDate(5, new Date(objAdicionarMembroDTO.getNascimento_membro().getDate()));
            pstm.setString(6, objAdicionarMembroDTO.getEmail_membro());
            pstm.setString(7, objAdicionarMembroDTO.getCelular_membro());
            pstm.setString(8, objAdicionarMembroDTO.getEstadoCivil_membro());
            pstm.setString(9, objAdicionarMembroDTO.getMae_membro());
            pstm.setString(10, objAdicionarMembroDTO.getPai_membro());
            pstm.setString(11, objAdicionarMembroDTO.getConjugue_membro());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar Membro" + e);
        }
    }
    
    public void enderecoMembro(EndereçoMembroDTO objEndereçoMembroDTO){
        
        String sql2 = "insert into endereco_membro (id_endereco, cep_endereco, logradouro_endereco, numero_endereco, complemento_endereco, bairro_endereco, cidade_endereco, uf_endereco, pais_endereco) values (?,?,?,?,?,?,?,?,?)";
        
        con = new ConexaoDAO().conexaoBD();
        
        try {
            
            pstm = con.prepareStatement(sql2);
            pstm.setInt(1, objEndereçoMembroDTO.getId_endereco());
            pstm.setString(2, objEndereçoMembroDTO.getCep_endereco());
            pstm.setString(3, objEndereçoMembroDTO.getLogradouro_endereco());
            pstm.setString(4, objEndereçoMembroDTO.getNumero_endereco());
            pstm.setString(5, objEndereçoMembroDTO.getComplemento_endereco());
            pstm.setString(6, objEndereçoMembroDTO.getBairro_endereco());
            pstm.setString(7, objEndereçoMembroDTO.getCidade_endereco());
            pstm.setString(8, objEndereçoMembroDTO.getUf_endereco());
            pstm.setString(9, objEndereçoMembroDTO.getPais_endereco());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao adicionar endereço" + e);
            
        }
        
    }
    
    public void dadosIgrejaMembro(DadosIgrejaMembroDTO objDadosIgrejaMembroDTO){
        
        String sql3 = "insert into dadosnaigreja (id_dados, data_batismo, cargo_eclesiastico, numero_cartaoMembro, matriculado_EBD) values (?,?,?,?,?)" ;
        
        con = new ConexaoDAO().conexaoBD();
        
        try {
            
            pstm = con.prepareStatement(sql3);
            pstm.setInt(1, objDadosIgrejaMembroDTO.getId_dados());
            pstm.setDate(2, new Date (objDadosIgrejaMembroDTO.getData_batismo().getDate()));
            pstm.setString(3, objDadosIgrejaMembroDTO.getCargo_eclesiastico());
            pstm.setString(4, objDadosIgrejaMembroDTO.getNumero_cartaoMembro());
            pstm.setString(5, objDadosIgrejaMembroDTO.getMatriculado_EBD());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao adicionar dados" + e);
            
        }
    }
    
}
