![](https://zupimages.net/up/19/44/nxs1.jpeg)


* Par Nicolas Congard
* Projet Java 2 by Simplon.co 
* Octobre 2019

## Description du jeu
Le célèbre jeu du Pendu adapté en console via Java.

## Aspects techniques 
* méthode afficher()

> Appelle simplement *choisirMode()*, *partie()* et *rejouer()*.

* méthode choisirMode()

> Propose le choix du mode de jeu : multijoueurs en 1 vs 1 ou individuel contre l'ordinateur. On identifie ce choix avec la 
> classe *Scanner* puis avec un *equals*. Ainsi selon l'option choisie, on oriente soit vers **partieMulti()** ou 
> **partieSolo()**.

* méthode partieMulti()

Annonce le début de la partie en demandant les noms des joueurs grâce *Scanner* puis en tirant au hasard, via un *random*, lequel doit donner un mot. Le mot est ensuite transformé en tableau de caractères. Une copie de celui-ci est créé en remplaçant les lettres par des tirets avec un *repeat*. La console est alors nettoyée (*print.flush()*) pour ne pas laisser le mot choisi affiché et visible.

* méthode partieSolo()

Reprend le principe de la méthode **partieMulti()** mais avec un seul joueur. L'ordinateur a une liste prédéfinie de mots dont un sera tiré au sort (*random*). Pas besoin de nettoyer la console par contre.

* méthode partie()

Demande une lettre au joueur toujours avec *Scanner*. On vérifie la possible existence de cette lettre dans la base de données avec **erreur()**. On appelle ensuite la méthode **trouveLettre()** qui permet dans le cas où elle retourne "true" d'afficher la lettre trouvée à la place du tiret correspondant à son emplacement et d'incrémenter la variable *bonnesRéponses*. On utilise pour cela une boucle *for*. Dans le cas où la valeur est "false" alors la variable *nombreEssais* est décrémenter et appelle dès lors la méthode **dessinPendu()**. On vérifie pour chaque trajectoire si la fin du jeu est possible avec la méthode **finPartie()**.

* méthode trouveLettre()

Elle prend en paramètre la variable *lettre*. On utilise une boucle *for* pour renvoyer un booléen si la lettre donnée est comprise dans le mot.

* méthode finPartie()

Déclare la fin du jeu selon deux conditions. La première annonce la victoire lorsque les variables *bonnesRéponses* et
*mot.length* correspondent. Si *nombreEssais* est à "0" alors la défaite du joueur est annoncée. Si aucune de ces 
conditions n'entrent en compte alors on rappelle la méthode **partie()**.

* méthode dessinPendu()

Affiche le dessin du Pendu pour chaque mauvaise réponse donnée. Elle repose sur la décrémentation de la variable *nombreEssais*.

* méthode erreur()

Essentielle pour corriger un bug qui permet en répetant la même bonne lettre de remporter la partie. On crée une liste *lettres* afin de stocker les lettres déjà trouvées puis on regarde avec *contains* si la liste ne contient pas déjà la lettre. Si c'est le cas, un message s'affiche et décrémente *nombreEssais*.  

* méthode rejouer()

On appelle celle-ci lorsque la méthode **partie()** arrive à son terme. On propose le choix de relancer une partie en tapant "YES" ou non avec "NO" en utilisant toujours un *Scanner*. On compare la variable *réponse* et la réponse attendue avec *equals*.  Dans le premier cas, on rappelle **choisirMode()** dans l'autre le jeu se termine. Si aucune réponse est valide, on affiche un message d'erreur et on relance la méthode.

**A VENIR**
* ...

## Notice d'utilisation
Le jeu du Pendu se joue d'une à deux personnes, de 7 à 77ans, directement dans la console. 

Mode Multijoueurs : Chaque joueur donnera son nom puis le rôle de chacun sera défini par la suite : soit le bourreau soit le paysan. Le premier choisira un mot que le second devra retrouver en donnant une lettre à chaque tour. Si le paysan déclare une lettre juste alors celle-ci s'affichera, cependant si elle est fausse le dessin du Pendu commencera. A noter que le paysan ne dispose que de 10 essais ! Attention aussi de ne pas donner deux fois la même lettre, cela comptera comme une faute. Lorsque ce compteur tombera à 0 et que le Pendu sera totalement affiché, c'est le bourreau qui gagnera. Le paysan, quant à lui, pourra remporter la partie s'il trouve toutes les lettres du mot !

Mode Solo : Le joueur joue contre l'ordinateur qui aura une liste de mots prédifinis et qui sera alors le bourreau.

------
Bonne partie !
