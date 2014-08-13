#TextAdventureGame
=================

####Background
I started a new job and was told that something useful to learn would be Java.
Having had no prior programming experience I found Java to be totally confusing and intimidating, and as a result put off learning it.

Recently, having become more familiar with other programming languages, I decided that Java would be useful to further enhance my career. So in order to learn it without becoming overwhelmed or bored I decided to create a very simple game.

####Game Storyline
There is very limited story in this game. It is purely based around the player becoming trapped in a maze and having to escape. They have been put there by some unknown being, seemingly just for their own amusement.

The player has a limited amount of food, with each move taking up one days worth. This means that finding food along the way is a priority. In addition, there are a few items that can be discovered to aid the players journey. Some areas require these items in order to proceed, but the game can be completed having not discovered any.

There are 3 areas to get through. The first being very small, the second slightly larger and more complex, and the last larger still. The last moves away from the grid system to make a mental map nearly impossible to create.
There is a 'blind hound' tracking the player throughout the first two areas, which could strike at any time. In the third area, the player must search for the lost medallion pieces in order to escape through a hidden golden door.


####Building The Game
The game is designed to be played entirely in the console.

Due to me being new to Java, the game has a very simple premise. It is built on a grid with an underlying coordinate system, and you have the options to move North, East, South or West. So moving North for example will increase the y value in the coordinate system by 1, thus changing the area of the grid that you will be in. It started off as a small grid, but then I eventually added a second larger grid and a third area that does not use a grid at all.

The challenge is getting through without dying (through random events) or running out of food. Food is tracked and updated the entire time, along with the number of moves the player has made.

At each new area of the game there will be, in most cases, an event that takes place requiring the player to make a choice or to solve a puzzle. There are also dead ends and areas that cannot be accessed to make the grid feel more like a maze.

Almost the entire game is built using if/else functions, with while loops used to ensure valid choices are made. Boolean values then keep track of which events have been completed. A large amount of the lines of code are simply printing out strings to the console to explain what is happening. 
As the game progresses the challenges become more complex. This is mainly due to me becoming more confident using Java and trying out new things.

The majority of the challenges are based entirely on luck, with random numbers being used to decide outcomes. This meant that I could keep playing the game and be faced with different outcomes each time, despite knowing how it is built. It also makes the game incredibly frustrating to play as you essentially have little control over what happens. The only real skill is trying to learn where each area is in order to avoid the harder challenges next time.


####Finally
In no way do I feel this game is good (although for me I quite enjoy playing through it because it's my own work), but since I put a fair amount of effort into it I wanted to keep it somewhere where it won't get lost and where I can continue to add to it if I choose to.

There are no doubt many bugs still in it throughout, but I have removed the ones that I have come across.

If you feel like trying it, improving it, or even better adding to it, then feel free!



