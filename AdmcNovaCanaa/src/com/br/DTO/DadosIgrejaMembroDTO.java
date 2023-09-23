package com.br.DTO;

import java.util.Date;

public class DadosIgrejaMembroDTO {
    
    private int id_dados;
    private String cargo_eclesiastico, numero_cartaoMembro, matriculado_EBD;
    private Date data_batismo;
    
    public int getId_dados() {
        return id_dados;
    }

    public void setId_dados(int id_dados) {
        this.id_dados = id_dados;
    }

    public Date getData_batismo() {
        return data_batismo;
    }

    public void setData_batismo(Date data_batismo) {
        this.data_batismo = data_batismo;
    }

    public String getCargo_eclesiastico() {
        return cargo_eclesiastico;
    }

    public void setCargo_eclesiastico(String cargo_eclesiastico) {
        this.cargo_eclesiastico = cargo_eclesiastico;
    }

    public String getNumero_cartaoMembro() {
        return numero_cartaoMembro;
    }

    public void setNumero_cartaoMembro(String numero_cartaoMembro) {
        this.numero_cartaoMembro = numero_cartaoMembro;
    }

    public String getMatriculado_EBD() {
        return matriculado_EBD;
    }

    public void setMatriculado_EBD(String matriculado_EBD) {
        this.matriculado_EBD = matriculado_EBD;
    }
    
}
