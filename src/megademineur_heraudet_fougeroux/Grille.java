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
public class Grille {
    int largeur;
    int hauteur;
    Cellule cellules [][] = new Cellule [largeur][hauteur];
    
    public void viderGrille(){
        
    }
    
    public boolean placerBombe(int ligne, int colonne){
        return true;
    }
    
    public boolean placerKit(int ligne, int colonne){
        return true;
    }
    
    public boolean placerDrapeau(int ligne, int colonne){
        return true;
    }
    
    public void affficherGrilleSurConsole(){
        
    }
    
    public boolean etreGagnantePourJoueur(Joueur j){
        return true;
    }
    
    public boolean etrePerdantePourJoueur(Joueur j){
        return true;
    }
    
    public boolean demasquerCellule(int ligne, int colonne){
        return true;
    }
    
    public boolean demasquerCelluleVoisine(int ligne, int colonne){
        return true;
    }
}
