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
public class Artigos extends Exemplares{
    private String autor;
    
    public void Artigos(String autor){
        this.autor = autor;
    }
    public String getAutor(){
        return this.autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    
}
