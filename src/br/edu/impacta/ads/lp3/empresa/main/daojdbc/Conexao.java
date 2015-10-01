
package br.edu.impacta.ads.lp3.empresa.main.daojdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
  /**Implementaçāo  Singleton para a conexão com a base de dados 
     * 
     */


public class Conexao implements Serializable {

    
    // criando um referencia para conexao private
    
   private static Conexao conexao;

    
       
    private Conexao() {
        
        
    }
    public static Conexao getInstance(){
        
        if (conexao == null){
            conexao  = new Conexao ();
        
    }
    return conexao;
    
}
    
    public Connection getConnection() {
        Connection connection = null; 
        
        
       try {
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Empresa", "fit", "fit");
        
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
       } catch(SQLException ex){
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
       }        
        return connection;
    }
}