/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;
import biblioteca.dados.Dclientes;
import biblioteca.dados.Demprestimos;
import biblioteca.dados.Dexemplares;
import biblioteca.info.Artigos;
import biblioteca.info.Cliente;
import biblioteca.info.Emprestimos;
import biblioteca.info.Exemplares;
import biblioteca.info.Livros;
import biblioteca.info.Periodicos;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author leon
 */
public class Menu {
    
    public static void main(String[] args){
        int opMenu, opc;
        
        int idade;
        int pd ;
        String dados = ""; 
        String Emp = "";
        String Exemp = "";
        long novorg = 0;
        long codigo = 0;
        
        //referincia com os "dados"
        Dclientes novoCliente = new Dclientes();
        Demprestimos novoEmprestimo = new Demprestimos();
        Dexemplares novoMaterial = new Dexemplares();
       
        
        
        do{  //Menu principal
            opMenu = Integer.parseInt(JOptionPane.showInputDialog("****** BIBLIOTECA *****"
             +"\n\n1-Emprestimo / Devolução"+"\n2-Clientes"+"\n3-Exemplares"+"\n4-Sair"));
            
            switch(opMenu)
            {
                case 1:
                    do
                    {  //Menu de empretimo/devolução
                        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Emprestimo / Devolução ***"
                        +"\n\n1-Lista de Emprestimos"+"\n2-Cadastrar Emprestimo"+"\n3-Realizar Devolução"+"\n4-Voltar"));
                        //Lista emprestimos
                        if(opc == 1)
                        {
                             SimpleDateFormat dataform = new SimpleDateFormat("dd/MM/yyyy");
                            
                             for(Emprestimos aux : novoEmprestimo.procuraEmprestimos())
                            {
                                if (aux.getDataDevolucao() == null) 
                                {
                                    Emp += " Nome: " + aux.getCliente().getNome()+", Telefone:"+aux.getCliente().getTelefone()
                                    + ", Exemplar: " +aux.getExemplares().getN_exemplar()
                                    + ", Codigo Exemplar:"+aux.getExemplares().getCodigo()
                                    + "\n " + " Data do Emprestimo: " +
                                    dataform.format(aux.getDataEmprestimo())+ "\n\n";
                                }
                             } 
                             if (Emp.equals("")) 
                             {
                               JOptionPane.showMessageDialog(null, "Não há Exemplares emprestados!");
                               continue;
                             } 
                             else
                             {
                               JOptionPane.showMessageDialog(null, Emp);
                             }
                            Emp = "";  
                           
                        }
                        //cadastra emprestimo
                        else if(opc == 2)
                        {
                            novorg = Long.parseLong(JOptionPane.showInputDialog("Informe o rg da pessoa:"));
                            Cliente retornoPessoa = novoCliente.localizaCliente(novorg);
                            
                            if (retornoPessoa != null) 
                            { 
                                codigo = Long.parseLong(JOptionPane.showInputDialog("Informe o codigo de barra do material:"));
                                Exemplares retornoMaterial = novoMaterial.procuraCodigo(codigo);
                                
                                if (retornoMaterial == null) 
                                {
                                    JOptionPane.showMessageDialog(null, " material Não Cadastrado!");
                                    continue;
                                } 
                                else 
                                {
                                    Emprestimos e = new Emprestimos(); 
                                    e = novoEmprestimo.criarEmp(retornoPessoa, retornoMaterial, new java.util.Date());
                                    JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso");
                                    continue;
                                }
                            }
                            
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Rg não cadastrado!!");
                                continue;
                            }

                        }
                        //cadastra devolução
                        else if(opc == 3)
                        {
                            codigo = Long.parseLong(JOptionPane.showInputDialog("Informe o codigo do material:")); 
                            novorg = Long.parseLong(JOptionPane.showInputDialog("Informe o rg:"));

                            Emprestimos aux = novoEmprestimo.proc(novorg, codigo);
                            if (aux != null) 
                            {
                                if (aux.getDataDevolucao() == null && aux.getExemplares().getCodigo() == codigo)
                                {
                                    novoEmprestimo.removerEmprestimo(codigo, novorg);
                                }
                            }
                            
                            else 
                            {
                                JOptionPane.showMessageDialog(null, "Exemplar não encontrado na lista dos emprestimos");
                            }
                            
                        }
                        
                        else if(opc == 4)
                        {
                            break;
                        }
                        else{
                                    JOptionPane.showMessageDialog(null, "Valor inválido");
                         }
                        
                    }while(opMenu != 4);
                    
                    break;
                    
                case 2:
                    do{//Menu usuarios
                        Cliente cl = new Cliente();//cliente novo
                        Cliente p5 = new Cliente();//armazenar
                        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu Usuario ***"+
                        "\n\n1-Cadastrar Cliente"+"\n2-Remover Cliente"+"\n3-Clientes Cadastrados"+"\n4-Voltar"));
                        //cadastra cliente
                        if(opc == 1)
                        {
                            
                            novorg = Long.parseLong(JOptionPane.showInputDialog("Informe o rg:"));
                            cl = novoCliente.localizaCliente(novorg);

                            if (cl != null) 
                            { 
                                JOptionPane.showMessageDialog(null, "Usuario com Rg cadastrado.");
                                continue;
                            }
                                    
                            else
                            {  
                                //entao cadastra         
                                p5.setNome(JOptionPane.showInputDialog("Informe o nome:"));
                                p5.setRg(novorg);
                                idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
                                p5.setTelefone(JOptionPane.showInputDialog("Informe o telefone:"));
                                p5.setIdade(idade);
                                p5.setEndereco(JOptionPane.showInputDialog("Informe Endereço:"));
                                novoCliente.createCliente(p5);       
                                JOptionPane.showMessageDialog(null, "Cliente cadastrado!");
                            }
                            
                        }
                        //remover o cliente
                        else if(opc == 2)
                        {
                            novorg = Long.parseLong(JOptionPane.showInputDialog("Informe o rg:"));
                            cl = novoCliente.localizaCliente(novorg);
                            if (cl != null)
                            { 
                                novoCliente.removeCliente(novorg);
                                JOptionPane.showMessageDialog(null,"Cliente removido com sucesso!");
                                continue;
                            }
                            else{   
                                JOptionPane.showMessageDialog(null,"Cliente com Rg não cadastrado");
                            }
                                continue;
                        }
                        //lista os clientes
                        else if(opc == 3)
                        {
                            for (Cliente a : novoCliente.CadastradosList())
                            {
                                dados += "Nome: "+a.getNome()
                                +" Idade:"+a.getIdade()+"  Telefone: "+a.getTelefone()
                                +"\nEndereço:"+a.getEndereco()+"\n\n";
                            }
                                        
                                   
                            if (!novoCliente.CadastradosList().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, dados);
                            } 
                            
                            else
                            {
                                    JOptionPane.showMessageDialog(null, "Não há clientes cadastrados!");
                                    
                            }
                            
                            dados = "";
                        }
                        else if(opc == 4 ){
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Valor inválido");
                        }
                   
                    }while(opc != 4);
                    
                    break;
                case 3:
                    do{//menu exemplares
                        opc = Integer.parseInt(JOptionPane.showInputDialog("*** Exemplares ***"
                        +"\n1-Cadastrar Exemplar"+"\n2-Listar Exemplares"+"\n3-Voltar"));
                        //cadastra exemplar
                        if(opc == 1)
                        {
                           do{ 
                                opc = Integer.parseInt(JOptionPane.showInputDialog(" Cadastrar Tipo Exemplar: "
                                    +"\n1-Livro"+"\n2-Artigo"
                                    +"\n3-Periodico"+"\n4-Voltar"));
                                
                                //cadastra exemplar do tipo livro
                                if(opc == 1)
                                {
                                    codigo = Long.parseLong(JOptionPane.showInputDialog("codigo do exemplar:"));
                                    Exemplares buscaLivro = novoMaterial.procuraCodigo(codigo);
                                    if (buscaLivro != null) 
                                    {
                                        JOptionPane.showMessageDialog(null, "Exemplar Cadastrado!");
                                        
                                    }
                                    else{
                                        Livros livro = new Livros();

                                        livro.setN_exemplar(JOptionPane.showInputDialog("Nome do livro:"));
                                        livro.setCodigo(codigo);
                                        livro.setAutor(JOptionPane.showInputDialog("Autor do livro:"));
                                        livro.setEditora(JOptionPane.showInputDialog("Editora:"));
                                        livro.setEdicao(Integer.parseInt(JOptionPane.showInputDialog("Edição: ")));
                                        livro.setT_exemplar(1);
                                        novoMaterial.create(livro);
                                        

                                    }
                                } 
                                //cadastra exemplar do tipo artigo
                                else if (opc == 2)
                                {
                                    codigo = Long.parseLong(JOptionPane.showInputDialog("Informe o codigo do material:"));
                                    Exemplares buscaArtigo = novoMaterial.procuraCodigo(codigo);
                                    if (buscaArtigo != null)
                                    {
                                        JOptionPane.showMessageDialog(null, " Exemplar  Cadastrado!");
                                    }
                                    else
                                    {
                                        Artigos artig = new Artigos();
                                        artig.setN_exemplar(JOptionPane.showInputDialog("Nome do Artigo:"));
                                        artig.setCodigo(codigo);
                                        artig.setAutor(JOptionPane.showInputDialog("Autor:"));
                                        artig.setT_exemplar(2);
                                        novoMaterial.create(artig);
                                        
                                        
                                    }

                                }
                                //cadastra exemplar do tipo periodico
                                else if(opc == 3){
                                    codigo = Long.parseLong(JOptionPane.showInputDialog("Codigo do Exemplar:"));
                                    Exemplares buscaPeriodic = novoMaterial.procuraCodigo(codigo);
                                    if (buscaPeriodic != null) 
                                    {
                                        JOptionPane.showMessageDialog(null, "Exemplar Cadastrado!");
                                    }
                                    else
                                    {   
                                        Periodicos periodc = new Periodicos();
                                        periodc.setN_exemplar(JOptionPane.showInputDialog("Nome do Periodico:"));
                                        periodc.setCodigo(codigo);
                                        periodc.setEditora(JOptionPane.showInputDialog("Editora:"));
                                        periodc.setT_exemplar(3);
                                        novoMaterial.create(periodc);
                                        
                                     }

                                }
                                else if(opc == 4){
                                    break;
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Valor inválido");
                                }

                            }while(opc != 4);
                            
                        }
                        //lista exemplares
                        else if(opc == 2){
                            for (Exemplares a : novoMaterial.ListarExemplares())
                            {
                                Exemp += "Nome: "+a.getN_exemplar()
                                +" Codigo: "+a.getCodigo()+"\n\n";
                            }
                                        
                                   
                            if (!novoMaterial.ListarExemplares().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, Exemp);
                            } 
                            
                            else
                            {
                                    JOptionPane.showMessageDialog(null, "Não há Exemplares cadastrados!");
                                    
                            }
                            
                            Exemp = "";   
                            
                        }
                        else if(opc == 3){
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Valor inválido");
                        }
                    }while(opc != 3);
                        
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"valor inválido!");
                    break;
            }
            
            
        }while(opMenu!= 4);
    }
    
}
