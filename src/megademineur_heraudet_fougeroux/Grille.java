/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megademineur_heraudet_fougeroux;

import java.util.Scanner;

/**
 *
 * @author cheraudet
 */
public class Grille {
    Scanner sc = new Scanner(System.in);
    int largeur = sc.nextInt();
    int hauteur = sc.nextInt();
    Cellule cellules [][] = new Cellule [largeur][hauteur];
    
    public Grille(){
        for(int i=0; i<largeur; i++){
            for(int j=0; j<hauteur; j++){
                cellules[i][j] = new Cellule();
            }
        }
    }
    
    public void viderGrille(){
        for (int i=0; i<largeur; i++) {
            for (int j=0; j<hauteur; j++) {
                cellules[i][j].bombe = false;
                cellules[i][j].kitDeminage = false;
                cellules[i][j].drapeau = false;
            }
        }
    }
    
    public boolean placerBombe(int ligne, int colonne){
        if (cellules[ligne][colonne].bombe == false) {
            cellules[ligne][colonne].bombe = true;
            return true;
        }
        return false;
    }
    
    public boolean placerKit(int ligne, int colonne){
        if (cellules[ligne][colonne].kitDeminage == false) {
            cellules[ligne][colonne].kitDeminage = true;
            return true;
        }
        return false;
    }
    
    public boolean placerDrapeau(int ligne, int colonne){
        if (cellules[ligne][colonne].drapeau == false) {
            cellules[ligne][colonne].drapeau = true;
            return true;
        }
        return false;
    }
    
    public void afficherGrilleSurConsole(){
        for (int i=0; i<largeur; i++) {
            for (int j=0; j<hauteur; j++) {
                if(cellules[i][j].bombe){
                    System.out.print("B");
                }
                  else if (cellules[i][j].drapeau) {
                    System.out.print("D");
                } else if (cellules[i][j].kitDeminage) {
                    System.out.print("K");
                } else {
                    System.out.print("V");
                }
            }
            System.out.println(" ");
        }
        
        System.out.print(" ");
    }
    
    public boolean etreGagnantePourJoueur(Joueur j){
        return true;
    }
    
    public boolean etrePerdantePourJoueur(Joueur j){
        if(j.pointVie == 0){
            return true;
        }
        return false;
    }
    
    public boolean demasquerCellule(int ligne, int colonne){
        return true;
    }
    
    public boolean demasquerCelluleVoisine(int ligne, int colonne){
        return true;
    }
}
