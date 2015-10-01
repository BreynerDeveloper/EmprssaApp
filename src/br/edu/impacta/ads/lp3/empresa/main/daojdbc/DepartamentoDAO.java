
package br.edu.impacta.ads.lp3.empresa.main.daojdbc;

import br.edu.impacta.ads.lp3.empresa.main.model.Cargo;
import br.edu.impacta.ads.lp3.empresa.main.model.Departamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DepartamentoDAO  implements GenericoDAO<Departamento>{

    
    //Insereir
    
    public void inserir(Departamento e) {
        
        try {
            
            Connection connection = Conexao.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO EMPRESA.DEPARTAMENTO (NOME) VALUES('" + e.getNome() + "')");
            
        } catch (Exception ex){
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null,ex);
        } 
        
    }

  // Remover 
   

    public void remover(Departamento e) {
        
        try {
            
        Connection connection = Conexao.getInstance().getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM EMPRESA.DEPARTAMENTO WHERE NOME = " + 
                e.getNome() + "");
            
            
        } catch (Exception ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE,null,ex);
        
        }
    }
    
        
   //Alterar 
    
    public void alterar(Departamento e) {
        
        try {
            
           Connection connection = Conexao.getInstance().getConnection();
           Statement statement = connection.createStatement();
           statement.executeUpdate("UPDATE EMPRESA.DEPARTAMENTO WHERE NOME = " + e.getNome() + "");
            
        } catch (Exception ex) {
        Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE,null,ex);
        
        }
    }       
    
        

   
    public List<Departamento> listar() {
         List<Departamento>  departamentos = new ArrayList<>();
        
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
               
                
                Departamento departamento = new Departamento();
                departamento.setCodigo(result.getInt("ID_DEPARTAMENTO"));
                departamento.setNome(result.getNString("NOME"));
               
                Departamento.add(departamento);
            }
         } catch (SQLException ex) {
         Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
     
   
         }
        return departamentos;
    }
        public Departamento findById(Departamento departamento) {            
            String sql = "SELECT ID_DEPARTAMENTO, NOME FROM EMPRESA.DEPARTAMENTO "
                    + "WHERE ID_CARGO = " + departamento.getCodigo();
             
            
        try{    
            
            Connection connection = Conexao.getInstance().getConnection();
            Statement  statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM EMPRESA.DEPARTAMENTO");
            while(result.next()){
                departamento.setCodigo(result.getInt("ID_CARGO"));
                departamento.setNome(result.getString("NOME"));
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamento;
    }
    
    public Departamento findByName(Departamento departamento) {
        
        String sql = "SELECT ID_DEPARTAMENTO, NOME FROM EMPRESA.DEPARTAMENTO "
                + "WHERE UPPER(NOME) LIKE '%" + departamento.getNome().toUpperCase() + "%'";
        try{    
            
            Connection connection = Conexao.getInstance().getConnection();
            Statement  statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                departamento.setCodigo(result.getInt("ID_CARGO"));
                departamento.setNome(result.getString("NOME"));
               
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamento;
    }

    
}

    

        
    