/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megademineur_heraudet_fougeroux;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cheraudet
 */
public class Partie {
    Joueur joueur = new Joueur();
    Grille grilleJeu = new Grille();
    
    public void initialiserPartie(){
        grilleJeu.viderGrille(); //initialisation de la grille
        
        //création du joueur
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer votre pseudo : ");
        joueur.Nom = sc.nextLine();
        System.out.println(joueur.Nom+" vous avez "+joueur.pointVie+" points de vie");
        
        //creation de la grille
        System.out.println("Entrer la taille de la grille souhaitée : ");
        System.out.println("largeur : ");
        int largeur = sc.nextInt();
        System.out.println("hauteur : ");
        int hauteur = sc.nextInt();
        
        //placement des bombes aléatoirement
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int ligneBombe = r.nextInt(largeur);
            int colonneBombe = r.nextInt(hauteur);
            grilleJeu.placerBombe(ligneBombe, colonneBombe);
        }
        //placement des kit aléatoirement
        for (int i = 0; i < 5; i++) {
            int ligneKit = r.nextInt(largeur);
            int colonneKit = r.nextInt(hauteur);
            if(grilleJeu.cellules[ligneKit][colonneKit].presenceKit()==false && grilleJeu.cellules[ligneKit][colonneKit].presenceBombe()==false){
                grilleJeu.placerKit(ligneKit, colonneKit);
            }
        }
        
        grilleJeu.afficherGrilleSurConsole();
    }
    
    public void debuterPartie(){
        
    }
    
    public void activationKit(int i, int j){
        
    }
    
    public void activationBombe(int i, int j){
        
    }
}
