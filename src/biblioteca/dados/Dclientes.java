/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.dados;

import biblioteca.info.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author leon
 */
public class Dclientes {
    private ArrayList<Cliente> cliente = new ArrayList<Cliente>();

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<Cliente> cliente) {
        this.cliente = cliente;
    }
 
    public Cliente createCliente(Cliente clienteNovo){
        
        this.cliente.add(clienteNovo);
        return clienteNovo;
    } 
     public ArrayList<Cliente> CadastradosList() {
        return cliente;
    }
     
     // realiza a busca do cliente pelo rg. 
   
    public Cliente localizaCliente(long rg){
        if(!cliente.isEmpty()){
            for (Cliente x: cliente) {
                if(x.getRg() == rg)
                    return x;
            } 
        }
        return null;
    } 
    //localiza o rg e se for igual ao fornecido,remove o cliente
    public void removeCliente(long rg){
        Cliente x = localizaCliente(rg);
        if(rg == x.getRg()){
            cliente.remove(x);
        }else{
            
        }
    } 
    
}
