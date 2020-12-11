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
        System.out.println(joueur.Nom+" vous avez "+joueur.nombreVies+" points de vie");
        
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
        initialiserPartie();
        Scanner sc = new Scanner(System.in);
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1) Démasquer une cellule");
        System.out.println("2) Placer un drapeau");
        System.out.println("3) Utiliser un kit");
        int choix = sc.nextInt();
        while (choix > 3 || choix < 1) {
            System.out.println("Erreur : Entrer un choix qui existe :");
            choix = sc.nextInt();
        }
        
        if(choix==1){
            System.out.println("Quelle est la ligne de la cellule à démasquer ?");
            int ligne = sc.nextInt();
            System.out.println("Quelle est la colonne de la cellule à démasquer ?");
            int colonne = sc.nextInt();
            grilleJeu.demasquerCellule(ligne, colonne);
        }
        
        if(choix==2){
            System.out.println("Sur quelle ligne voulez vous placer votre drapeau ?");
            int ligne = sc.nextInt();
            System.out.println("Sur quelle colonne voulez vous placer votre drapeau ?");
            int colonne = sc.nextInt();
            grilleJeu.placerDrapeau(ligne, colonne);
        }
        
        if(choix==3 && joueur.nombreKit!=0){
            System.out.println("Sur quelle ligne voulez vous utilisez votre kit ?");
            int ligne = sc.nextInt();
            System.out.println("Sur quelle colonne voulez vous utilisez votre kit ?");
            int colonne = sc.nextInt();
            grilleJeu.activerKit(ligne, colonne);
            joueur.nombreKit--;
        }
        
        if(choix==3 && joueur.nombreKit==0){
            System.out.println("Attention, vous n'avez pas de kit !");
        }
    }
    
   
}
