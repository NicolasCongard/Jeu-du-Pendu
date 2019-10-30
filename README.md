![image du Pendu]

# Le jeu du Pendu 
* Par Nicolas Congard
* Projet Java 2 by Simplon.co 
* Octobre 2019

## Description du jeu
Le célèbre jeu du Pendu adapté en console via Java.

## Aspects techniques 
* méthode débutPartie()

Annonce le début de la partie en demandant les noms des joueurs puis en en tirant au hasard lequel doit donner un mot.
Le mot est ensuite transformé en tableau de caractères. Une copie de celui-ci est créé en remplaçant les lettres par des tirets.
La console est alors nettoyé pour ne pas laisser le mot choisi affiché et visible.

* méthode partie()

Demande une lettre au joueur. On appelle la méthode **trouveLettre()** qui permet dans le cas où elle retourne "true" d'afficher la
lettre trouvée à la place du tiret correspondant à son emplacement et d'incrémenter la variable *bonnesRéponses*.
Dans le cas où la valeur est "false" alors la variable *nombreEssais* est décrémenter et appelle dès lors la méthode 
**dessinPendu()**. On vérifie pour chaque trajectoire si la fin du jeu est possible avec la méthode **finPartie()**.

* méthode trouveLettre()

Renvoie un booléen si la lettre donnée est comprise dans le mot.

* méthode finPartie()

Déclare la fin du jeu selon deux conditions. La première annonce la victoire lorsque les variables *bonnesRéponses* et
*mot.length* correspondent. Si *nombreEssais* est à "0" alors la défaite du joueur est annoncée. Si aucune de ces 
conditions n'entrent en compte alors on rappelle la méthode **partie()**.

* méthode dessinPendu()

Affiche le dessin du Pendu pour chaque mauvaise réponse donnée. Elle repose sur la décrémentation de la variable *nombreEssais*.

**A VENIR**
* méthode erreur()
* méthode rejouer()

## Notice d'utilisation
Le jeu du Pendu se joue à deux, de 7 à 77ans, directement dans la console. Chaque joueur donnera son nom puis le rôle de chacun sera
défini par la suite : soit le bourreau soit le paysan. Le premier choisira un mot que le second devra retrouver en donnant
une lettre à chaque tour. Si le paysan déclare une lettre juste alors celle-ci s'affichera, cependant si elle est fausse le dessin du
Pendu commencera. A noter que le paysan ne dispose que de 10 essais ! Attention aussi de ne pas donner deux fois la même lettre,
cela comptera comme une faute. Lorsque ce compteur tombera à 0 et que le Pendu sera totalement
affiché, c'est le bourreau qui gagnera. Le paysan, quant à lui, pourra remporter la partie s'il trouve toutes les lettres du mot !

------
Bonne partie !









