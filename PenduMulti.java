import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PenduMulti
{
    String mot;
    char lettre;
    char[] motTableau;
    char[] motCachéTableau;
    int nombreEssais = 10;
    int nombreRéponse = 0;
    int resteEssais;
    int bonneRéponse;
    List<Character> lettres;

    public void afficher()
    {
        créationPartie();
        débutPartie();
        rejouerPartie();
    }
    
    public void créationPartie()
    {
        System.out.println("!! ATTENTION VEUILLEZ OUVRIR LA FENÊTRE DE LA CONSOLE AU MAXIMUM POUR UN MEILLEUR CONFORT DE JEU !!");
        System.out.println("Bienvenue au jeu du Pendu ! Commençons une partie !");
        System.out.println("Joueur 1, comment t'appelles-tu ?");
        Scanner lectureScanner = new Scanner(System.in);
        String joueur1 = lectureScanner.nextLine();
        System.out.println("Joueur 2, comment t'appelles-tu ?");
        Scanner lectureScanner2 = new Scanner(System.in);
        String joueur2 = lectureScanner2.nextLine();
        String nombreDeJoueurs = joueur1 +","+joueur2;
        String[] listeJoueurs = nombreDeJoueurs.split(",");
        Random indexAleatoire = new Random();
        int indexJoueur = indexAleatoire.nextInt(listeJoueurs.length);
        String choixAleatoireJoueur = listeJoueurs[indexJoueur];
        System.out.println("Le joueur qui doit faire deviner le mot est : "+choixAleatoireJoueur);
        System.out.println(choixAleatoireJoueur+", tu dois choisir un mot.");
        Scanner lectureScanner3 = new Scanner(System.in);
        mot = lectureScanner3.nextLine().toLowerCase();
        motTableau= mot.toCharArray();
        String motCaché = "-".repeat(mot.length()); // https://stackoverflow.com/questions/7318359/how-to-replace-all-characters-in-a-java-string-with-stars
        motCachéTableau = motCaché.toCharArray();
        System.out.print("\033[H\033[2J"); // https://stackoverflow.com/questions/2979383/java-clear-the-console
        System.out.flush();
        System.out.println("C'est désormais à ton adversaire de trouver une lettre !");
        System.out.println("Voici le mot à deviner : "+motCaché);
        System.out.println("Tu as : "+nombreEssais+" essais.");
      }
      
    public void débutPartie()
    {
      System.out.println("Choisi une lettre ! ");
      Scanner lectureScanner4 = new Scanner(System.in);
      lettre = lectureScanner4.next(".").toLowerCase().charAt(0); // https://stackoverflow.com/questions/13942701/take-a-char-input-from-the-scanner

      if (trouveLettre(lettre))
      {
        erreur();
        for (int i = 0; i < motTableau.length; i++) 
        {
          if (motTableau[i] == lettre) 
          {
            motCachéTableau[i] = motTableau[i];
            bonneRéponse = nombreRéponse++;
          }    
        }
        System.out.println("Tu as trouvé une lettre ! ");
        System.out.println(motCachéTableau);
        finPartie();
      }   
      else
      {
        erreur();
        resteEssais = nombreEssais--;
        dessinPendu();
        System.out.println("Tu as faux ! Il te reste : "+(resteEssais-1)+" essais.");
        System.out.println("Rappel du mot à trouver :");
        System.out.println(motCachéTableau);
        finPartie();
      }
    }

    public boolean trouveLettre(char lettre)
    {
      for (int i = 0; i < motTableau.length; i++) 
      {
        if (motTableau[i] == lettre)
        {
          return true;
        } 
      }
      return false;
    }
    
    public void erreur()
    {
      List<Character> lettres = new ArrayList<Character>();
      for (Character l : motCachéTableau) 
      {
        if (l == lettre)
        {
          lettres.add(l);
          resteEssais = nombreEssais--;
          dessinPendu();
          System.out.println("Attention tu as déjà donné cette lettre ! Il te reste : "+(resteEssais-1)+" essais.");
          System.out.println("Rappel du mot à trouver :");
          System.out.println(motCachéTableau);
          finPartie();
        }
      }
    }
    
    public void finPartie()
    {
      if (bonneRéponse+1 == mot.length())
      {
        System.out.println("Bravo tu as découvert le mot de ton adversaire, tu as gagné !");
      }
      else if (nombreEssais == 0)
      {
        System.out.println("Quel échec ! Tu as perdu !");
        System.out.println("Le mot à deviner était : "+mot);
      }
      else
      {
        débutPartie();
      }
    } 

    public void rejouerPartie()
    {
      System.out.println("Tapez [YES] pour une nouvelle partie ou [NO] pour quitter le jeu.");
      Scanner lectureScanner5 = new Scanner(System.in);
      String réponse = lectureScanner5.nextLine().toUpperCase();
      if (réponse.equals("YES"))
      {
        nombreEssais = 10;
        afficher();
      }
      else if (réponse.equals("NO"))
      {
        System.out.println("Merci d'avoir joué, à bientôt !");
      }
      else
      {
        System.out.println("Veuillez saisir une réponse valide.");
        rejouerPartie();
      }
    }

    public void dessinPendu()
    {
      switch (nombreEssais)
      {
        case 9:
          System.out.println("___|___");
        break;
        case 8:
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("___|___");  
        break;
        case 7:
          System.out.println("   __________________");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("___|___"); 
        break;
        case 6:
          System.out.println("   __________________");
          System.out.println("   |  /");
          System.out.println("   | /");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("___|___");
        break;
        case 5:
          System.out.println("   __________________");
          System.out.println("   |  /             |");
          System.out.println("   | /");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("___|___");
        break;
        case 4:
          System.out.println("   __________________");
          System.out.println("   |  /             |");
          System.out.println("   | /           [o _ o]");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("   |");
          System.out.println("___|___");
        break;
        case 3:
          System.out.println("   __________________");
          System.out.println("   |  /             |");
          System.out.println("   | /           [o _ o]");
          System.out.println("   |                |");
          System.out.println("   |                |");
          System.out.println("   |                |");
          System.out.println("   |                |");
          System.out.println("   |                |");
          System.out.println("   |");
          System.out.println("___|___");
        break;
        case 2:
          System.out.println("   __________________");
          System.out.println("   |  /             |");
          System.out.println("   | /           [o _ o]");
          System.out.println("   |                |");
          System.out.println("   |             ___|___");
          System.out.println("   |                |");
          System.out.println("   |                |");
          System.out.println("   |                |");
          System.out.println("   |");
          System.out.println("___|___");
        break;
        case 1:
          System.out.println("   __________________");
          System.out.println("   |  /             |");
          System.out.println("   | /           [o _ o]");
          System.out.println("   |                |");
          System.out.println("   |             ___|___");
          System.out.println("   |                |");
          System.out.println("   |                |");
          System.out.println("   |               _|_");
          System.out.println("   |              |   |");
          System.out.println("   |");
          System.out.println("___|___");
        break;
        default:
          System.out.println("   __________________");
          System.out.println("   |  /             |");
          System.out.println("   | /           [o _ o]");
          System.out.println("   |                |");
          System.out.println("   |   RIP !     ___|___");
          System.out.println("   |                |");
          System.out.println("   |                |");
          System.out.println("   |               _|_");
          System.out.println("   |              |   |");
          System.out.println("   |");
          System.out.println("___|___");
      }
    }
        
    public static void main(String[] args) 
    {
      PenduMulti nouveauPendu = new PenduMulti();
      nouveauPendu.afficher();
    }
}