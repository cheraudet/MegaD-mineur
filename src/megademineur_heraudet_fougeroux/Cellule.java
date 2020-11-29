/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megademineur_heraudet_fougeroux;

/**
 *
 * @author cheraudet
 */
public class Cellule {
    boolean bombe;
    boolean drapeau;
    boolean kitDeminage;
    
    public boolean presenceBombe(){
        return true;
    }
    
    public boolean presenceKit() {
        return true;
    }
    
    public boolean placerBombe() {
        return true;
    }
    
    public boolean placerKit(){
        return true;
    }
    
    public boolean placerDrapeau(){
        return true;
    }
    
    public boolean activerBombe(){
        return true;
    }
    
    public boolean activerKit(){
        return true;
    }
    
    public boolean supprimerBombe(){
        return true;
    }
    
    public boolean etreVisible(){
        return true;
    }
}
