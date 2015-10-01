
package br.edu.impacta.ads.lp3.empresa.main.daojdbc;

import br.edu.impacta.ads.lp3.empresa.main.model.Funcionario;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class FuncionarioDAO implements GenericoDAO<Funcionario>{
    
    private Date Contratacao;
    

    
    //Listar  
    
 public List<Funcionario> listar(){
    List<Funcionario>  funcionarios = new ArrayList<>();
    
    String sql = "SELECT F.ID_FUNCIONARIO, F.NOME, F.DT_CONTRATACAO"
            + " C.ID_CARGO, C.NOME CARGO, D.ID_DEPARTAMENTO, D.NOME DEPARTAMENTO"
            + " FROM EMPRESA.FUCIONARIO F "
            + " INNER JOIN EMPRESA.CARGO C"
            + " ON F.ID_CARGO = C.ID_CARGO"
            + " INNER JOIN EMPRESA.DEPARTAMENTO D"
            + " ON F.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO";
    
    
    try{
            Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(result.getInt("ID_FUNCIONARIO"));
                funcionario.setNome(result.getString("NOME"));
                java.sql.Date date = result.getDate("DT_CONTRATACAO");
                java.util.Date dateContratacao = new Date(date.getTime());
                
                funcionario.setContratacao((Date) dateContratacao);
                
                
              
                funcionarios.add(funcionario);
            }
    
     } catch (SQLException ex) {
         Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
    return funcionarios;
 }

    // Inserir 
 
    public void inserir(Funcionario e) {
     
        String sql = "INSERT INTO EMPRESA.FUNCIONARIO (NOME, ID_CARGO, ID_DEPARTAMENTO, DT_CONTRATACAO) "
                + "VALUES ('" + e.getNome() + "', " + e.getCargo().getCodigo() + ", " + e.getDepartamento().getCodigo() + ", " + e.getContratacao() + ")";
        try {
            Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            
        } catch (Exception ex) {
           Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
     } 
        
        
    }

     //Remover
    
    public void remover(Funcionario e) {
        
        try {
            
            Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM EMPRESA.FUNCIONARIO  WHERE NOME = " + e.getNome() + "");
           
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
     // Alterar 
    
    public void alterar(Funcionario e) {
        try {
            Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE EMPRESA FUNCIONARIO SET NOME= " + e.getNome() + " WHERE NOME " + e.getNome() + "");
           
        } catch (Exception ex) {
             Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public void inserir(FuncionarioDAO func) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

