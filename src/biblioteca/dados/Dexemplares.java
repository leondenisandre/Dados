/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.dados;

import biblioteca.info.Exemplares;
import java.util.ArrayList;

/**
 *
 * @author leon
 */
public class Dexemplares {
    ArrayList<Exemplares> material = new  ArrayList<Exemplares>();
 
 
    public ArrayList<Exemplares> getMaterial() {
    return material;
    }
    
    public void setMaterial(ArrayList<Exemplares> material) {
        this.material = material;
    }
   //cadastra um exemplar
    public Exemplares create(Exemplares novoMaterial) {
        this.material.add(novoMaterial);
        return novoMaterial;
    } 
 
    public ArrayList<Exemplares> ListarExemplares() {
        return material;
    } 
    // busca exemplar pelo tipo.
    // utiliza o tipo de exemplar de barra para determinar o tipo do exemplar.
    //1- Livro 2-Artigo 3-Periodico
    public ArrayList<Exemplares> procuraTipo(int tipo) {
        ArrayList<Exemplares> subLista = new ArrayList<Exemplares>();

        if (tipo == 1) 
        {
            for (Exemplares aux : material) 
            {
                if (aux.getT_exemplar() == 1) {
                    
                    subLista.add(aux);
                }   
            }
            return subLista;
        } 
        else if (tipo == 2) 
        {
            for (Exemplares m : material) 
            {
                if (m.getT_exemplar() == 2)
                {
                    subLista.add(m);
                }
            }
            return subLista;
        } 

        else if (tipo == 3) 
        {
            for (Exemplares m : material) 
            {
                if (m.getT_exemplar() == 3)
                {
                    subLista.add(m);
                }
            }
            return subLista;
        }
        return null;
    } 
     // Busca o exemplar pelo codigo 
    //ver se a lista está vazia e depois percorre o exemplar
    public Exemplares procuraCodigo(long codigo){
    if(!material.isEmpty()){
    for (Exemplares aux : material) {
        if(aux.getCodigo() == (Integer.valueOf((int) codigo)))
        return aux;
        } 
    } 
    return null;
    } 
    
}
