/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.info;

import java.util.Date;

/**
 *
 * @author leon
 */
public class Emprestimos {
   private Date dataEmprestimo;
   private Date dataDevolucao = null;
   // variaveis de relacionamento
   private Cliente cliente;
   private Livros livro; 
   private Artigos artigo; 
   private Periodicos periodico; 
   private Exemplares exemplares;
   

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public Artigos getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigos artigo) {
        this.artigo = artigo;
    }

    public Periodicos getPeriodico() {
        return periodico;
    }

    public void setPeriodico(Periodicos periodico) {
        this.periodico = periodico;
    }

    public Exemplares getExemplares() {
        return exemplares;
    }

    public void setMateriais(Exemplares exemplares) {
        this.exemplares = exemplares;
    }
}
