/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.dados;
import biblioteca.info.Emprestimos;
import biblioteca.info.Cliente;
import biblioteca.info.Exemplares;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author leon
 */
public class Demprestimos {
    
    private ArrayList<Emprestimos> emprestimo = new ArrayList<Emprestimos>();
 
    public ArrayList<Emprestimos> getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(ArrayList<Emprestimos> emprestimo) {
        this.emprestimo = emprestimo;
    }
     //cria um emprestimo
    public Emprestimos criarEmp(Cliente cliente, Exemplares exemplares, Date data)
    {
        Emprestimos emp = new Emprestimos();
        emp.setCliente(cliente);
        emp.setMateriais(exemplares);
        emp.setDataEmprestimo(data);
        emp.setDataDevolucao(null); 
        //adiciona no ArrayList emprestimo
        emprestimo.add(emp); 
        return emp;
    }
    //listar os emprestimos
    public ArrayList<Emprestimos> procuraEmprestimos()
    {
        return emprestimo;
    }
    //ver se usuario tem algum emprestimo com determinado codigo
    public Emprestimos proc(long rg, long codigo)
    {
        int cond = 0;
        for (Emprestimos aux: emprestimo) 
        {
            if(aux.getCliente().getRg() == rg)
            {  
               cond = 1;
                if(aux.getExemplares().getCodigo() == codigo)
                    return aux;  
                else 
                    JOptionPane.showMessageDialog(null, "Exemplar não está na lista de Emprestado");
                break;
            } 
            if (cond==1)
            {
                JOptionPane.showMessageDialog(null, "Usuario não possui emprestimo");
            }
        } 
        return null;
    } 
    // Realiza a devolução, retirando-o da lista dos emprestimo
    public void removerEmprestimo(long codigo, long rg)
    {
        Emprestimos devolvido = null; 
        Date data = new java.util.Date();//pega data do computador 
        
        for (Emprestimos aux : emprestimo) 
        { 
            if(aux.getExemplares().getCodigo() == codigo){
                   if(aux.getCliente().getRg() == rg){
                        devolvido = aux;
                        break; 
                 }
            } 
        } 
        //armazena posição do elemento emprestimo na lista
        int i = emprestimo.indexOf(devolvido); 
        devolvido.setDataDevolucao(data);
        JOptionPane.showMessageDialog(null, "Material devolvido com sucesso!"); 
    } 
    
}
