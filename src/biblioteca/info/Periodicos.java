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
public class Periodicos extends Exemplares {
    private String editora;
    
    public void Periodicos(String editora){
        this.editora = editora;
    }
    public String getEditora(){
        return this.editora;
    }
    public void setEditora(String editora){
        this.editora = editora;
    }
}
