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
public class Joueur {
    String Nom;
    int nombreVies = 3;
    int nombreKit;
    
    public void obtenirKit(){
        nombreKit++;
    }
    
    public boolean utiliserKit(){
        if(nombreKit==0){
            return false;
        }
        nombreKit--;
        return true;
    }
    
    public void perdrePointsVies(){
        nombreVies --;
    }
}
