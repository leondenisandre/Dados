/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.info;

/**
 *
 * @author leon
 */
public class Cliente {
    private long rg;
    private String nome;
    private int idade;
    private String telefone;
    private String endereco;
    
    public Cliente(){
        this.setRg(rg);
        this.setNome(nome);
        this.setIdade(idade);
        this.setTelefone(telefone);
        this.setEndereco(endereco);
    }
    

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
}
