# Bhuller-Carta-Senires
Datasal Project
Contains the project

Game Center is a social network where People can play a number of mini games and compete with the highscore of each other.
The program saves and reads the player profiles to a text file. This program efficiently implemented the array list for storing values that require a lot of manipulation and getting elements in the middle of the list, the linked list to store elements which the front is the only thing called in the program, the queue in storing a limited number of data and adjusting when needed, the Stack in changing infix equations to postfix, and the Graph in connecting profiles.. Screenshots will be found below.

The first interface is the Game Center Logo.
![first](https://user-images.githubusercontent.com/30287750/29486782-a4c3a996-8520-11e7-8ed0-fd2d5b0460d9.png)

Once clicked, it will go to the log in page.
The user is required to Log in. if it is a new user the program will create a new profile, and if the name is recognized, it will load the profile of that user.

![second](https://user-images.githubusercontent.com/30287750/29486776-a4822246-8520-11e7-99bf-b453f7d07638.jpg)

After log in the user is free to access the main menu.

![menu](https://user-images.githubusercontent.com/30287750/29486772-a47e48ec-8520-11e7-888e-20e43f0d7373.jpg)

In the main menu the canvas will display the games and the Profile name with the user's friends. Alos found is a text field where the user can type another user's name and add them ass a friend. Another button is the display friend button which when clicked, displays the friend's high scores per game below that of the user's.

![display friend](https://user-images.githubusercontent.com/30287750/29486781-a4c34eba-8520-11e7-8f1e-6875e2e99f63.png)

Also in the main menu is a button labeled NETWORK which when clicked, displays the Adjacency list of all the profiles registerd in the database. This is how we implemented our Graph using arrays.

![adjacency list run](https://user-images.githubusercontent.com/30287750/29486783-a4c42c4a-8520-11e7-91bc-f864b31229c0.png)
![adjacency class](https://user-images.githubusercontent.com/30287750/29486779-a4c13346-8520-11e7-8d68-77bf419033b6.jpg)


Also in the Main menu is a list of the recently played Games which update every time a game is opened. A queue implementation was used here to limit the displayed games to only 4 so that the screen will not be crowded with the names of the games.

![queue for recently played game limited to display 4](https://user-images.githubusercontent.com/30287750/29486775-a4820374-8520-11e7-97f4-dcd590d45d30.jpg)


The program consists of 6 games to choose from

Snake
This is one of the components where we implemented the Array List
in this case the array list stores the body class when it is added every time the snake eats the food.

![snakegame](https://user-images.githubusercontent.com/30287750/29486778-a4c0d888-8520-11e7-8aea-aeae9b8e9f7c.jpg)
![snake array list](https://user-images.githubusercontent.com/30287750/29486777-a482cf02-8520-11e7-9635-bfe3b659a457.jpg)

Datasal Quiz
This is a test of the user's knowledge in data structures and algorithms. This is also where we implemented the linked list to store the questions so that getting them will be efficient.

![quiz game](https://user-images.githubusercontent.com/30287750/29486774-a4819bb4-8520-11e7-8614-2a9cdeee3920.jpg)

![20993293_1941429956144803_69192698_o](https://user-images.githubusercontent.com/30287750/29487180-bb6daf1e-8527-11e7-9af2-d07ed2f5701c.png)

![20952019_1941423536145445_490698777_o](https://user-images.githubusercontent.com/30287750/29487036-9fbc4296-8525-11e7-8fb7-2657e4420f77.png)


Math Quiz
A quiz on math and how a person can perform average difficulty questions. We applied a Stack here since some of the equations needed are computed using an infix to postfix calculator. thus the use of stacks is required.
![20960979_1941438249477307_1946679623_o](https://user-images.githubusercontent.com/30287750/29487361-30491eac-852a-11e7-8420-057305fd3b96.png)
![20961074_1941429596144839_228673717_o](https://user-images.githubusercontent.com/30287750/29487193-122b491a-8528-11e7-9b89-adb0b09fd1d4.png)
![20960841_1941431642811301_1615580143_o](https://user-images.githubusercontent.com/30287750/29487194-15023842-8528-11e7-88c6-cda191fb393d.png)

![20993293_1941429956144803_69192698_o](https://user-images.githubusercontent.com/30287750/29487203-36146870-8528-11e7-9c6d-20d9d845b90b.png)


Pong
The classic game pong made from the breakout game as made in the class
![ponggame](https://user-images.githubusercontent.com/30287750/29486773-a47f9a4e-8520-11e7-8391-0c8e11e4092a.jpg)


Breakout
![breakoutgame](https://user-images.githubusercontent.com/30287750/29486780-a4c2f348-8520-11e7-952c-6f5ca1f8676a.jpg)

and A find image game.

