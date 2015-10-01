
package br.edu.impacta.ads.lp3.empresa.main.daojdbc;

import java.io.Serializable;
import java.util.List;


public interface GenericoDAO<E> extends Serializable {
    
    public void inserir(E e);
    
    public void remover(E e);
    
    public void alterar(E e);
    
    public List<E> listar ();
    
    
}
