
package br.edu.impacta.ads.lp3.empresa.main.model;

import java.io.Serializable;


 
public class Departamento implements Serializable {

    public static void add(Departamento departamento) {
    }
    
    
    private Integer codigo;
    private String nome;
    
    public Departamento(){
        
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

    public void setCodigo() {
       
    }
    
}
