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
        if(cellules[ligne][colonne].bombe){
            cellules[ligne][colonne].activerBombe();
            System.out.print("B");
            return true;
        } else if(cellules[ligne][colonne].kitDeminage){
            cellules[ligne][colonne].recupererKit();
            System.out.print("K");
            return true;
        } else if(cellules[ligne][colonne].bombe == false){
            System.out.print("V");
            return true;
        }
        return false;
    }
    
    public boolean demasquerCelluleVoisine(int ligne, int colonne){
       
        return true;
    }
}
