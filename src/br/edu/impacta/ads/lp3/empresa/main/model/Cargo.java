
package br.edu.impacta.ads.lp3.empresa.main.model;

import java.io.Serializable;
        
public class Cargo implements Serializable {
    private Integer codigo;
    private String nome;
     
    
    public Cargo(){   
    }

    public Cargo(String nome) {
        this.nome = nome;
    }
    
    // Criando construtor para dois parametros 
    
    public Cargo(Integer codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
}

