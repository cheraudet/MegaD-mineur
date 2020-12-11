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
    int largeur;
    int hauteur;
    Cellule cellules [][] = new Cellule [largeur][hauteur];
    int nombreBombesVoisines;
    
    public Grille(){ //création du constructeur de la classe Grille
        //remplissage du tableau cellules[][]
        for(int i=0; i<largeur; i++){
            for(int j=0; j<hauteur; j++){
                cellules[i][j] = new Cellule();
            }
        }
    }
    
    public void viderGrille(){ //creation methode qui permet de vider la grille et tout réinitialiser
        for (int i=0; i<largeur; i++) {
            for (int j=0; j<hauteur; j++) {
                cellules[i][j].bombe = false;
                cellules[i][j].kitDeminage = false;
                cellules[i][j].drapeau = false;
            }
        }
    }
    
    public boolean placerBombe(int ligne, int colonne){ //creation de la methode qui place les bombes 
        //test qu'il n'y ait pas deja une bombe avant d'en rajouter une
        if (cellules[ligne][colonne].bombe == false) {
            cellules[ligne][colonne].bombe = true;
            return true;
        }
        return false;
    }
    
    public boolean placerKit(int ligne, int colonne){ //creation de la methode qui place les kit de deminage 
        //pareil que pour les bombes il faut verifier avant de placer
        if (cellules[ligne][colonne].kitDeminage == false) {
            cellules[ligne][colonne].kitDeminage = true;
            return true;
        }
        return false;
    }
    
    public boolean placerDrapeau(int ligne, int colonne){ //creation de la methode qui permet de placer un drapeau
        //meme chose que pour les deu methodes precedentes
        if (cellules[ligne][colonne].drapeau == false) {
            cellules[ligne][colonne].drapeau = true;
            return true;
        }
        return false;
    }
    
    public boolean presenceBombe(int ligne, int colonne){
        return cellules[ligne][colonne].presenceBombe();
    }
    
    public boolean presenceKit(int ligne, int colonne){
        return cellules[ligne][colonne].presenceKit();
    }
    
    public boolean presenceDrapeau(int ligne, int colonne){
        return cellules[ligne][colonne].presenceDrapeau();
    }
    
    public boolean activerBombe(int ligne, int colonne){
        if(cellules[ligne][colonne].bombe){
            cellules[ligne][colonne].bombe = false;
            return true;
        }
        return false;
    }
    
    public boolean activerKit(int ligne, int colonne){
        if(cellules[ligne][colonne].kitDeminage){
            cellules[ligne][colonne].kitDeminage = false;
            if(cellules[ligne][colonne].bombe){
                cellules[ligne][colonne].bombe = false;
            }
            return true;
        }
        return false;
    }
    
    public void afficherGrilleSurConsole(){ //methode qui affiche la grlle sur la console 
        for (int i=0; i<largeur; i++) { 
            for (int j=0; j<hauteur; j++) {
                if(demasquerCellule(i,j)==false){
                    System.out.print("X");
                }
                else if(demasquerCellule(i,j)){
                    demasquerCellule(i,j);
                }else if(cellules[i][j].drapeau){
                    System.out.print("D");
                }
            }
            System.out.println(" ");
        }
        
        System.out.print(" ");
    }
    
    public boolean etreGagnantePourJoueur(Joueur joueur){
        for(int i=0; i<largeur; i++){
            for(int j=0; j<hauteur; j++){
                if(joueur.nombreVies!=0 && demasquerCellule(i,j)==true){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean etrePerdantePourJoueur(Joueur j){
        if(j.nombreVies == 0){
            return true;
        }
        return false;
    }
    
    public boolean demasquerCellule(int ligne, int colonne){
        if(cellules[ligne][colonne].bombe){
            cellules[ligne][colonne].activerBombe();
            System.out.print("B");
            cellules[ligne][colonne].visibilite=true;
            return true;
        } else if(cellules[ligne][colonne].kitDeminage){
            cellules[ligne][colonne].recupererKit();
            System.out.print("K");
            cellules[ligne][colonne].visibilite=true;
            return true;
        } else if(cellules[ligne][colonne].bombe == false){
            System.out.print("V");
            demasquerCellulesVoisines(ligne, colonne);
            cellules[ligne][colonne].visibilite=true;
            return true;
        }
        return false;
    }
    
    public void demasquerCellulesVoisines(int ligne, int colonne){
        if(cellules[ligne][colonne].bombe==false && cellules[ligne][colonne].visibilite==false){
            cellules[ligne][colonne].visibilite = true;
            if(nombreBombesVoisines==0){
                if(ligne>0 && colonne>0) demasquerCellulesVoisines(ligne-1, colonne-1);
                if(ligne>0) demasquerCellule(ligne-1, colonne);
                if(ligne>0 && colonne<(largeur-1)) demasquerCellule(ligne-1, colonne+1);
                
                if(colonne>0) demasquerCellule(ligne, colonne-1);
                if(colonne<(largeur-1)) demasquerCellule(ligne, colonne+1);
                
                if(ligne<(hauteur-1) && colonne>0) demasquerCellule(ligne+1, colonne-1);
                if(ligne<(hauteur-1)) demasquerCellule(ligne+1, colonne);
                if(ligne<(hauteur-1) && colonne<(largeur-1)) demasquerCellule(ligne+1, colonne+1);
            }
        }
    }
    
    public int compterBombesVoisines(int ligne, int colonne){
        nombreBombesVoisines=0;
        if(cellules[ligne-1][colonne-1].presenceBombe()) nombreBombesVoisines++;
        if(cellules[ligne-1][colonne].presenceBombe()) nombreBombesVoisines++;
        if(cellules[ligne-1][colonne+1].presenceBombe()) nombreBombesVoisines++;
        
        if(cellules[ligne][colonne-1].presenceBombe()) nombreBombesVoisines++;
        if(cellules[ligne][colonne+1].presenceBombe()) nombreBombesVoisines++;
        
        if(cellules[ligne+1][colonne-1].presenceBombe()) nombreBombesVoisines++;
        if(cellules[ligne+1][colonne].presenceBombe()) nombreBombesVoisines++;
        if(cellules[ligne+1][colonne+1].presenceBombe()) nombreBombesVoisines++;
    
        return nombreBombesVoisines;
    }
}
