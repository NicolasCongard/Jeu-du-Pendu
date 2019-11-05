![](https://zupimages.net/up/19/44/nxs1.jpeg)


* Par Nicolas Congard
* Projet Java 2 by Simplon.co 
* Octobre 2019

## Description du jeu
Le célèbre jeu du Pendu adapté en console via Java.

## Aspects techniques 
* méthode afficher()

Appelle simplement **créationPartie()**, **débutPartie()** et **rejouerPartie()**.

* méthode créationPartie()

Version multi : annonce le début de la partie en demandant les noms des joueurs grâce *Scanner* puis en tirant au hasard, via un *random*, lequel doit donner un mot. Le mot est ensuite transformé en tableau de caractères. Une copie de celui-ci est créé en remplaçant les lettres par des tirets avec un *repeat*. La console est alors nettoyée (*print.flush()*) pour ne pas laisser le mot choisi affiché et visible.
Version solo : reprend la version multi mais un mot est tiré au hasard dans une liste prédéfinie de l'ordinateur. Pas besoin de nettoyer la console dans ce cas.

* méthode débutPartie()

Demande une lettre au joueur toujours avec *Scanner*. On vérifie la possible existence de cette lettre dans la base de données avec **erreur()**. On appelle ensuite la méthode **trouveLettre()** qui permet dans le cas où elle retourne "true" d'afficher la lettre trouvée à la place du tiret correspondant à son emplacement et d'incrémenter la variable *bonnesRéponses*. On utilise pour cela une boucle *for*. Dans le cas où la valeur est "false" alors la variable *nombreEssais* est décrémenter et appelle dès lors la méthode **dessinPendu()**. On vérifie pour chaque trajectoire si la fin du jeu est possible avec la méthode **finPartie()**.

* méthode trouveLettre()

Elle prend en paramètre la variable *lettre*. On utilise une boucle *for* pour renvoyer un booléen si la lettre donnée est comprise dans le mot.

* méthode finPartie()

Déclare la fin du jeu selon deux conditions. La première annonce la victoire lorsque les variables *bonnesRéponses* et
*mot.length* correspondent. Si *nombreEssais* est à "0" alors la défaite du joueur est annoncée et le mot à trouver est affiché. Si aucune de ces conditions n'entrent en compte alors on rappelle la méthode **débutPartie()**.

* méthode erreur()

Essentielle pour corriger un bug qui permet en répétant la même bonne lettre de remporter la partie. On crée une liste *lettres* afin de stocker les lettres déjà trouvées puis on regarde avec *contains* si la liste ne contient pas déjà la lettre. Si c'est le cas, un message s'affiche et décrémente *nombreEssais*. 

* méthode rejouerPartie()

Demande au joueur s'il veut relancer une partie en tapant "YES" ou non avec "NO". Dans le premier cas, on réinitialise la variable *nombreEssais* à 10 et on rappelle **afficher()**. Dans l'autre, un message de fin s'affiche. Si aucune réponse valide n'est tapée, un message d'erreur est annoncée et relance la méthode.

* méthode dessinPendu()

Affiche le dessin du Pendu pour chaque mauvaise réponse donnée. Elle repose sur la décrémentation de la variable *nombreEssais*. 

## Notice d'utilisation
Le jeu du Pendu se joue d'une à deux personnes, de 7 à 77ans, directement dans la console. 

Mode Multijoueurs : Chaque joueur donnera son nom puis le rôle de chacun sera défini par la suite : soit le bourreau soit le paysan. Le premier choisira un mot que le second devra retrouver en donnant une lettre à chaque tour. Si le paysan déclare une lettre juste alors celle-ci s'affichera, cependant si elle est fausse le dessin du Pendu commencera. A noter que le paysan ne dispose que de 10 essais ! Attention aussi de ne pas donner deux fois la même lettre, cela comptera comme une faute. Lorsque ce compteur tombera à 0 et que le Pendu sera totalement affiché, c'est le bourreau qui gagnera. Le paysan, quant à lui, pourra remporter la partie s'il trouve toutes les lettres du mot !

Mode Solo : Le joueur joue contre l'ordinateur qui aura une liste de mots prédifinis et qui sera alors le bourreau.

## Exemple d'utilisation

| Lettre |   Mot à trouver  | Dessin |       Phrase affichée     | Nombre d' essais : 10 |
|:------:|:----------------:|:------:|:-------------------------:|:---------------------:|
|   `x`  |`------`|![](https://nsa40.casimages.com/img/2019/11/03/mini_191103051728879493.png) |`Tu as faux !`|`Il te reste 9 essais`|
|   `l`  |`--l--l`          |   -    |`Tu as trouvé une lettre !`|           -           |
|   `r`  |`--l--l`|![](https://nsa40.casimages.com/img/2019/11/03/mini_191103053424534311.png) |`Tu as faux !`|`Il te reste 8 essais`|
|   `u`  |`--l--l`|![](https://nsa40.casimages.com/img/2019/11/03/mini_19110305172717326.png) |`Tu as faux !`|`Il te reste 7 essais`|
|   `s`  |`s-l--l`          |   -    |`Tu as trouvé une lettre !`|           -           |
|   `l`  |`s-l--l`|![](https://nsa40.casimages.com/img/2019/11/03/mini_191103051726902739.png) |`Erreur, tu as déjà donné cette lettre !`|`Il te reste 6 essais`| 
|   `b`  |`s-l--l`|![](https://nsa40.casimages.com/img/2019/11/03/mini_191103051727600683.png) |`Tu as faux !`|`Il te reste 5 essais`|
|   `n`  |`s-l--l`|![](https://nsa40.casimages.com/img/2019/11/03/mini_191103051727282969.png) |`Tu as faux !` |`Il te reste 4 essais`|
|   `i`  |`s-l-il`          |   -    |`Tu as trouvé une lettre !`|           -           |
|   `h`  |`s-l-il`|![](https://nsa40.casimages.com/img/2019/11/03/mini_191103051727853691.png) |`Tu as faux !`|`Il te reste 3 essais`|
|   `z`  |`s-l-il`|![](https://nsa40.casimages.com/img/2019/11/03/mini_191103051728107682.png) |`Tu as faux !`|`Il te reste 2 essais`|
|   `q`  |`s-l-il`|![](https://nsa40.casimages.com/img/2019/11/03/mini_191103051728107682.png) |`Tu as faux !`|`Il te reste 1 essais`|
|   `e`  |`s-leil`          |   -    |`Tu as trouvé une lettre !`|           -           |
|   `a`  |`s-leil`|![](https://nsa40.casimages.com/img/2019/11/03/mini_191103051728622617.png) |`Quel échec ! Tu as perdu !`|`Il te reste 0 essais`|

------
Bonne partie !
