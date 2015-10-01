
package br.edu.impacta.ads.lp3.empresa.main;

import br.edu.impacta.ads.lp3.empresa.main.daojdbc.CargoDAO;
import br.edu.impacta.ads.lp3.empresa.main.daojdbc.DepartamentoDAO;
import br.edu.impacta.ads.lp3.empresa.main.daojdbc.FuncionarioDAO;
import br.edu.impacta.ads.lp3.empresa.main.model.Cargo;
import br.edu.impacta.ads.lp3.empresa.main.model.Departamento;
import br.edu.impacta.ads.lp3.empresa.main.model.Funcionario;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class Principal {
    public static void main(String[] args) throws Exception {
        
        
        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
        
        
        Cargo professor = new Cargo();
        professor.setNome("Professor");
        CargoDAO cargoDAO = new CargoDAO();
        
        //cargoDAO.inserir(professor);
        // professor.remover(professor);
        
        Departamento pesquisa = new Departamento();
        pesquisa.setNome("Pesquisa");
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        
//        departamentoDAO.inserir(pesquisa);
        //pesquisa.remover(pesquisa)
        
        Departamento tecnologia = new Departamento();
        tecnologia.setNome("Tecnologia");
        
        //pesquisa.altera(pesquisa,tecnologia)
        
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Israel");
        funcionario.setCargo(new CargoDAO().findByName(new Cargo("professor")));
        funcionario.setDepartamento(pesquisa);
        
        System.out.println(funcionario.getCargo().getCodigo());
        System.out.println(funcionario.getCargo().getNome());

        System.out.println(funcionario.getDepartamento().getCodigo());
        System.out.println(funcionario.getDepartamento().getNome());
       
        
        
         
    
         FuncionarioDAO func = new FuncionarioDAO();
//         func.inserir(funcionario);
//         
//        for (Funcionario funcionario1 : new FuncionarioDAO().listar()) {
//            System.out.println(funcionario1.getCodigo() + " " + funcionario1.getNome() + " " + funcionario1.getContratacao());
//        }
    
    }      
}
        
        
        
       
        
        
    
    

