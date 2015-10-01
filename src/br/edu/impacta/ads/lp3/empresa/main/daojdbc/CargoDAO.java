
package br.edu.impacta.ads.lp3.empresa.main.daojdbc;

import br.edu.impacta.ads.lp3.empresa.main.model.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CargoDAO implements GenericoDAO<Cargo>{
    
    public CargoDAO(){
    }
    
    
    //Inserir 
  
    public void inserir(Cargo e) {
      
            //PREPAREDSTATEMENT
        
            try{
                String sql = "INSERT INTO EMPRESA.CARGO (NOME) VALUES (?)";
                Connection connection = Conexao.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, e.getNome());
                connection.close();
     
          
            } catch (SQLException ex) {
                Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
          
    }

    // Remover 
    
    public void remover(Cargo e) {
        
            
            try {
                Connection connection = Conexao.getInstance().getConnection();
                 Statement statement = connection.createStatement();
                 statement.executeUpdate("DELETE FROM EMPRESA.CARGO(NOME) WHERE NOME = " + e.getNome() + "");
            
            } catch (SQLException ex) {
                Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
   }
    // Alterar 
    
    public void alterar(Cargo e) {
           
          try{
              Connection connection = Conexao.getInstance().getConnection();
              Statement statement = connection.createStatement();
              statement.executeUpdate(e.getNome() + "UPDATE EMPRESA.CARGO SET NOME" + e.getNome () + " WHERE NOME " +  e.getNome() + "" );
          
           }catch (SQLException ex) {
                Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

  
    
    public List<Cargo> listar() {
        
            List<Cargo> cargos = new ArrayList<Cargo>();
            
            String sql = "SELECT ID_CARGO, NOME FROM EMPRESA.CARGO";
             
            
        try{    
            
            Connection connection = Conexao.getInstance().getConnection();
            Statement  statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM EMPRESA.GARGO");
            while(result.next()){
                
              
                
                Cargo cargo = new Cargo();
                cargo.setCodigo(result.getInt("ID_CARGO"));
                cargo.setNome(result.getNString("NOME"));
                cargos.add(cargo);
               
            }
            connection.close();
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargos;
    }
    
    public Cargo findById(Cargo cargo) {            
            String sql = "SELECT ID_CARGO, NOME FROM EMPRESA.CARGO "
                    + "WHERE ID_CARGO = " + cargo.getCodigo();
             
            
        try{    
            
            Connection connection = Conexao.getInstance().getConnection();
            Statement  statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM EMPRESA.GARGO");
            while(result.next()){
                cargo.setCodigo(result.getInt("ID_CARGO"));
                cargo.setNome(result.getString("NOME"));
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargo;
    }
    
    public Cargo findByName(Cargo cargo) {
        
        String sql = "SELECT ID_CARGO, NOME FROM EMPRESA.CARGO "
                + "WHERE UPPER(NOME) LIKE '%" + cargo.getNome().toUpperCase() + "%'";
        try{    
            
            Connection connection = Conexao.getInstance().getConnection();
            Statement  statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                cargo.setCodigo(result.getInt("ID_CARGO"));
                cargo.setNome(result.getString("NOME"));
               
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargo;
    }
   
} 