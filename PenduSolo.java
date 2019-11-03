import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PenduSolo
{
    String choixAleatoireMots;
    char lettre;
    char[] motsTableau;
    char[] motsCachésTableau;
    int nombreEssais = 10;
    int nombreRéponse = 0;
    int resteEssais;
    int bonneRéponse;
    List<Character> lettres;

    public void afficher()
    {
        créationPartie();
        débutPartie();
    }
    
    public void créationPartie()
    {
        System.out.println("!! ATTENTION VEUILLEZ OUVRIR LA FENÊTRE DE LA CONSOLE AU MAXIMUM POUR UN MEILLEUR CONFORT DE JEU !!");
        System.out.println("Bienvenue au jeu du Pendu ! Commençons une partie !");
        String[] mots = {"vert","honoraire","collectable","chouette","biplan","ivre","diminue","executeur","air","crypter","sous","global","embrasser","categorie","diseur","bonne","aventure","plume","oite","securite","exact","fauteuil","canard","muscle","minimal","venger","punaise","cage","hebergement","fusible","engloutir","massacre","robotique","expiation","decent","beatement","flash","bougie","imbecile","capacite","solitude","hardiment"};
        int indexMots = new Random().nextInt(mots.length) ;
        choixAleatoireMots = mots[indexMots] ;
        motsTableau = choixAleatoireMots.toCharArray() ;
        String motsCachés = "-".repeat(choixAleatoireMots.length());
        motsCachésTableau = motsCachés.toCharArray();
        System.out.println("Voici le mot à trouvé : "+motsCachés);
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
        for (int i = 0; i < motsTableau.length; i++) 
        {
          if (motsTableau[i] == lettre) 
          {
            motsCachésTableau[i] = motsTableau[i];
            bonneRéponse = nombreRéponse++;
          }    
        }
        System.out.println("Tu as trouvé une lettre ! ");
        System.out.println(motsCachésTableau);
        finPartie();
      }   
      else
      {
        erreur();
        resteEssais = nombreEssais--;
        dessinPendu();
        System.out.println("Tu as faux ! Il te reste : "+(resteEssais-1)+" essais.");
        System.out.println("Rappel du mot à trouver :");
        System.out.println(motsCachésTableau);
        finPartie();
      }
    }

    public boolean trouveLettre(char lettre)
    {
      for (int i = 0; i < motsTableau.length; i++) 
      {
        if (motsTableau[i] == lettre)
        {
          return true;
        } 
      }
      return false;
    }
    
    public void erreur()
    {
        List<Character> lettres = new ArrayList<Character>();
        for (Character l : motsCachésTableau) 
        {
            if (l == lettre)
            {
                lettres.add(l);
                resteEssais = nombreEssais--;
                dessinPendu();
                System.out.println("Attention tu as déjà donné cette lettre ! Il te reste : "+(resteEssais-1)+" essais.");
                System.out.println("Rappel du mot à trouver :");
                System.out.println(motsCachésTableau);
                finPartie();
            }
        }
    }
    
    public void finPartie()
    {
      
      if (bonneRéponse+1 == choixAleatoireMots.length())
      {
        System.out.println("Bravo tu as découvert le mot de l'ordinateur, tu as gagné !");
      }
      else if (nombreEssais == 0)
      {
        System.out.println("Quel échec ! Tu as perdu !");
        System.out.println("Le mot à deviner était : "+choixAleatoireMots);

      }
      else
      {
        débutPartie();
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
      PenduSolo nouveauPendu = new PenduSolo();
      nouveauPendu.afficher();
    }
}