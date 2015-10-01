
package br.edu.impacta.ads.lp3.empresa.main.model;

import java.io.Serializable;
import java.sql.Date;

public class Funcionario  implements Serializable{
    private Integer codigo;
    private String nome;
    private Date contratacao;
    private Departamento departamento;
    private Cargo cargo;
    
    
    
    
    public Funcionario(){
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    
    
    
    public Date getContratacao() {
        return contratacao;
    }

    public void setContratacao(Date contratacao) {
        this.contratacao = contratacao;
    }

    
            
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
    
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
    

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
            
    
}
