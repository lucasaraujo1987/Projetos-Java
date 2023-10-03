package com.br.DAO;

import com.br.DTO.AdicionarMembroDTO;
import com.br.DTO.DadosIgrejaMembroDTO;
import com.br.DTO.EndereçoMembroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MembroDAO {
    
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AdicionarMembroDTO> lista_membro = new ArrayList<>();
    ArrayList<DadosIgrejaMembroDTO> lista_dadosIgreja = new ArrayList<>();
    ArrayList<EndereçoMembroDTO> lista_endereco = new ArrayList<>();
    
    public void adicionarMembro(AdicionarMembroDTO objAdicionarMembroDTO, EndereçoMembroDTO objEndereçoMembroDTO, DadosIgrejaMembroDTO objDadosIgrejaMembroDTO){
        
        String sql = "insert into membro (id_membro, nome_membro, cpf_membro, rg_membro, nascimento_membro, email_membro, celular_membro, estadoCivil_membro, mae_membro, pai_membro, conjugue_membro) values (?,?,?,?,?,?,?,?,?,?,?)";
        
        String sql2 = "insert into endereco_membro (id_endereco, cep_endereco, logradouro_endereco, numero_endereco, complemento_endereco, bairro_endereco, cidade_endereco, uf_endereco, pais_endereco) values (?,?,?,?,?,?,?,?,?)";
        
        String sql3 = "insert into dadosnaigreja (id_dados, data_batismo, cargo_eclesiastico, numero_cartaoMembro, matriculado_EBD) values (?,?,?,?,?)" ;
                
        con = new ConexaoDAO().conexaoBD();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, objAdicionarMembroDTO.getId_membro());
            pstm.setString(2, objAdicionarMembroDTO.getNome_membro());
            pstm.setString(3, objAdicionarMembroDTO.getCpf_membro());
            pstm.setString(4, objAdicionarMembroDTO.getRg_membro());
            pstm.setString(5, objAdicionarMembroDTO.getNascimento_membro());
            pstm.setString(6, objAdicionarMembroDTO.getEmail_membro());
            pstm.setString(7, objAdicionarMembroDTO.getCelular_membro());
            pstm.setString(8, objAdicionarMembroDTO.getEstadoCivil_membro());
            pstm.setString(9, objAdicionarMembroDTO.getMae_membro());
            pstm.setString(10, objAdicionarMembroDTO.getPai_membro());
            pstm.setString(11, objAdicionarMembroDTO.getConjugue_membro());
            
            pstm.execute();
            pstm.close();
            
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
            
            pstm = con.prepareStatement(sql3);
            pstm.setInt(1, objDadosIgrejaMembroDTO.getId_dados());
            pstm.setString(2, objDadosIgrejaMembroDTO.getData_batismo());
            pstm.setString(3, objDadosIgrejaMembroDTO.getCargo_eclesiastico());
            pstm.setString(4, objDadosIgrejaMembroDTO.getNumero_cartaoMembro());
            pstm.setString(5, objDadosIgrejaMembroDTO.getMatriculado_EBD());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar Membro" + e);
        }
    }
    
    public ArrayList<AdicionarMembroDTO> pesquisarMembro(){
        
        String sql = "select * from membro";
        
        con = new ConexaoDAO().conexaoBD();
        
        try {
            
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                AdicionarMembroDTO objAdicionarMembroDTO = new AdicionarMembroDTO();
                objAdicionarMembroDTO.setId_membro(rs.getInt("id_membro"));
                objAdicionarMembroDTO.setCelular_membro(rs.getString("celular_membro"));
                objAdicionarMembroDTO.setConjugue_membro(rs.getString("conjugue_membro"));
                objAdicionarMembroDTO.setCpf_membro(rs.getString("cpf_membro"));
                objAdicionarMembroDTO.setEmail_membro(rs.getString("email_membro"));
                objAdicionarMembroDTO.setEstadoCivil_membro(rs.getString("estadoCivil_membro"));
                objAdicionarMembroDTO.setMae_membro(rs.getString("mae_membro"));
                objAdicionarMembroDTO.setNascimento_membro(rs.getString("nascimento_membro"));
                objAdicionarMembroDTO.setNome_membro(rs.getString("nome_membro"));
                objAdicionarMembroDTO.setPai_membro(rs.getString("pai_membro"));
                objAdicionarMembroDTO.setRg_membro(rs.getString("rg_membro"));
                
                lista_membro.add(objAdicionarMembroDTO);
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Listar Membros" + e);
            
        }
        
        return lista_membro;
    }
    
    public ArrayList<EndereçoMembroDTO> pesquisarEndereco(){
        
        String sql2 = "select * from endereco_membro";
        
        con = new ConexaoDAO().conexaoBD();
        
        try {
            
            pstm = con.prepareStatement(sql2);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                EndereçoMembroDTO objEndereçoMembroDTO = new EndereçoMembroDTO();
                objEndereçoMembroDTO.setId_endereco(rs.getInt("id_endereco"));
                objEndereçoMembroDTO.setBairro_endereco(rs.getString("bairro_endereco"));
                objEndereçoMembroDTO.setCep_endereco(rs.getString("cep_endereco"));
                objEndereçoMembroDTO.setCidade_endereco(rs.getString("cidade_endereco"));
                objEndereçoMembroDTO.setComplemento_endereco(rs.getString("complemento_endereco"));
                objEndereçoMembroDTO.setLogradouro_endereco(rs.getString("logradouro_endereco"));
                objEndereçoMembroDTO.setNumero_endereco(rs.getString("numero_endereco"));
                objEndereçoMembroDTO.setPais_endereco(rs.getString("pais_endereco"));
                objEndereçoMembroDTO.setUf_endereco(rs.getString("uf_endereco"));
                
                lista_endereco.add(objEndereçoMembroDTO);
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Listar Endereço" + e);
            
        }
        
        return lista_endereco;
    }
    
    public ArrayList<DadosIgrejaMembroDTO> pesquisarDadosIgreja(){
        
        String sql3 = "select * from dadosnaigreja";
        
        con = new ConexaoDAO().conexaoBD();
        
        try {
            
            pstm = con.prepareStatement(sql3);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                DadosIgrejaMembroDTO objDadosIgrejaMembroDTO = new DadosIgrejaMembroDTO();
                objDadosIgrejaMembroDTO.setId_dados(rs.getInt("id_dados"));
                objDadosIgrejaMembroDTO.setCargo_eclesiastico(rs.getString("cargo_eclesiastico"));
                objDadosIgrejaMembroDTO.setData_batismo(rs.getString("data_batismo"));
                objDadosIgrejaMembroDTO.setMatriculado_EBD(rs.getString("matriculado_EBD"));
                objDadosIgrejaMembroDTO.setNumero_cartaoMembro(rs.getString("numero_cartaoMembro"));
                
                lista_dadosIgreja.add(objDadosIgrejaMembroDTO);
            }
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Listar Dados" + e);
            
        }
        
        return lista_dadosIgreja;
    }
    
    public AdicionarMembroDTO getPesquisar(int id_membro){
        
        String sql = "select * from membro where id_membro = ?";
        
        con = new ConexaoDAO().conexaoBD();
        
        try {
            
            pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setInt(1, id_membro);
            rs = pstm.executeQuery();
            
            AdicionarMembroDTO objAdicionarMembroDTO = new AdicionarMembroDTO();
            
            rs.first();
            
            objAdicionarMembroDTO.setId_membro(id_membro);
            objAdicionarMembroDTO.setNome_membro(rs.getString("nome_membro"));
            objAdicionarMembroDTO.setNascimento_membro(rs.getString("nascimento_membro"));
            objAdicionarMembroDTO.setCelular_membro(rs.getString("celular_membro"));
            objAdicionarMembroDTO.setConjugue_membro(rs.getString("conjugue_membro"));
            objAdicionarMembroDTO.setCpf_membro(rs.getString("cpf_membro"));
            objAdicionarMembroDTO.setEmail_membro(rs.getString("email_membro"));
            objAdicionarMembroDTO.setEstadoCivil_membro(rs.getString("estadoCivil_membro"));
            objAdicionarMembroDTO.setMae_membro(rs.getString("mae_membro"));
            objAdicionarMembroDTO.setPai_membro(rs.getString("pai_membro"));
            objAdicionarMembroDTO.setRg_membro(rs.getString("rg_membro"));
            
            return objAdicionarMembroDTO;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Listar Membros " + e);
        }
            return null;
        
    }
    
    public EndereçoMembroDTO getEndereco(int id_endereco){
        
        String sql = "select * from endereco_membro where id_endereco = ?";
        
        con = new ConexaoDAO().conexaoBD();
        
        try {
            
            pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setInt(1, id_endereco);
            rs = pstm.executeQuery();
            
            EndereçoMembroDTO objEndereçoMembroDTO = new EndereçoMembroDTO();
            
            rs.first();
            
            objEndereçoMembroDTO.setId_endereco(id_endereco);
            objEndereçoMembroDTO.setBairro_endereco(rs.getString("bairro_endereco"));
            objEndereçoMembroDTO.setCep_endereco(rs.getString("cep_endereco"));
            objEndereçoMembroDTO.setCidade_endereco(rs.getString("cidade_endereco"));
            objEndereçoMembroDTO.setComplemento_endereco(rs.getString("complemento_endereco"));
            objEndereçoMembroDTO.setLogradouro_endereco(rs.getString("logradouro_endereco"));
            objEndereçoMembroDTO.setNumero_endereco(rs.getString("numero_endereco"));
            objEndereçoMembroDTO.setPais_endereco(rs.getString("pais_endereco"));
            objEndereçoMembroDTO.setUf_endereco(rs.getString("uf_endereco"));
            
            return objEndereçoMembroDTO;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Listar Endereço " + e);
        }
            return null;
        
    }
    
    public DadosIgrejaMembroDTO getDados(int id_dados){
        
        String sql = "select * from dadosnaigreja where id_dados = ?";
        
        con = new ConexaoDAO().conexaoBD();
        
        try {
            
            pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm.setInt(1, id_dados);
            rs = pstm.executeQuery();
            
            DadosIgrejaMembroDTO objDadosIgrejaMembroDTO = new DadosIgrejaMembroDTO();
            
            rs.first();
            
            objDadosIgrejaMembroDTO.setId_dados(id_dados);
            objDadosIgrejaMembroDTO.setCargo_eclesiastico(rs.getString("cargo_eclesiastico"));
            objDadosIgrejaMembroDTO.setData_batismo(rs.getString("data_batismo"));
            objDadosIgrejaMembroDTO.setMatriculado_EBD(rs.getString("matriculado_EBD"));
            objDadosIgrejaMembroDTO.setNumero_cartaoMembro(rs.getString("numero_cartaoMembro"));
            
            return objDadosIgrejaMembroDTO;
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Listar Dados " + e);
        }
            return null;
        
    }
     
}
