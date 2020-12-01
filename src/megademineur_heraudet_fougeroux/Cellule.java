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
    
    public Cellule(){
        bombe = false;
        drapeau = false;
        kitDeminage = false;
    }
    
    public boolean placerBombe(){
        if(bombe){
            return false;
        }
        bombe = true;
        return true;
    }
    
    public boolean placerKit() {
        if(kitDeminage){
            return false;
        }
        kitDeminage = true;
        return true;
    }
    
    public boolean placerDrapeau() {
        if(drapeau){
            return false;
        }
        drapeau = true;
        return true;
    }
    
    public boolean presenceBombe() {
        return bombe;
    }
    
    public boolean presenceKit(){
        return kitDeminage;
    }
    
    public boolean presenceDrapeau(){
        return drapeau;
    }
    
    public boolean activerBombe(){
        if(bombe){
            bombe = false;
            return true;
        }
        return false;
    }
    
    public boolean activerKit(){
        if(kitDeminage){
            kitDeminage = false;
            if(bombe){
                bombe = false;
            }
            return true;
        }
        return false;
    }
    
    public boolean recupererKit(){
        if(presenceKit()){
            kitDeminage = false;
            return true;
        }
        return false;
    }
    
    public boolean supprimerBombe(){
        if(bombe == false){
            return false;
        }
        bombe = false;
        return true;
    }
    
    /*public boolean etreVisible(){
        if(activerBombe() || activerKit()){
            return true;
        }
        return false;
    }*/
}
