
# League of OOP - First Stage

Basic implementation for a simple 2D MMO-style game.

League of OOP is a game where 4 types of players move on a 2D board of
different types of terrain and fight if 2 players meet in the same cell
of the board.
 
The types of players are as follows:
1. Knight - Expert in body fighting, has 2 abilities: Execute and Slam
2. Pyromancer - Fire master, has 2 abilities: Fireblast and Ignite
3. Wizard - Superior mental capacity, has 2 abilities: Drain and Deflect
4. Rogue - Sneak-attacker, has 2 abilities: Backstab and Paralysis

The types of terrain are as follows:
1. Land - preffered by Knight, giving him a 15% bonus damage
2. Volcanic -  preffered by Pyromancer, giving him a 25% bonus damage
3. Desert - preffered by Wizard, giving him a 10% damage increase
4. Woods -  preffered by Rogue, giving him the ability to Crit and a 15% bonus
damage

Implemented by: Bianca Ciuche 325CA

## Compile and usage

Compiling the program:
`javac -g main/Main.java`
Running it:
`java main.Main "INPUT_FILE" "OUTPUT_FILE"`

## Flow and Design

Explaining in short terms:

1. Input is read using the GameInputLoader class.
2. Using the input, the map, players and round moves are initialised. Every
player is instantiated in a list of heroes. They also get their own class
based on their type.
3. The game is played:
3.1 Every player takes Damage over Time and is declared dead if his hp drops
below 0 (used in the next rounds).
3.2 Players are moved: their coordinates and location is modified.
3.3 If 2 players are in the same cell, they fight.
3.4 When a player is defeated, the other one gets XP.
3.5 Players level up if necesarry.
4. Output is written in the output file.

> I used Double Dispatch when I had to apply race modifiers, in the following
way: the attacked player accepts the attack, then he calls a function that
computes its damage. The function that accepts the attack is implemented in
each player's class and each ability class has 4 separate functions with the
same name, being different only by the attacked hero's type.

# League of OOP - Second Stage

Basic implementation for a simple 2D MMO-style game.

League of OOP is a game where 4 types of players move on a 2D board of
different types of terrain and fight if 2 players meet in the same cell
of the board. We have now added angels that can help or confuse heroes,
strategies for heroes that need more HP or power and a magician that
observes everything.
 
The types of players are as they were in the first stage. So are the
types of terrain.

The types of angels are as follows:

 1. DamageAngel - increases the damage modifiers.
 2. DarkAngel - decreases HP.
 3. Dracula - decreases the damage modifiers and the HP.
 4. GoodBoy - increases the damage modifiers and the HP.
 5. LevelUpAngel - gives enough XP so that it can level up. It also
 increases the damage modifiers.
 6. LifeGiver - increases the HP.
 7. SmallAngel - increases the damage modifiers and the HP.
 8. Spawner - brings a player back to life.
 9. TheDoomer - Kills a player.
 10. XPAngel -  increases the HP.

Implemented by: Bianca Ciuche 325CA

## Compile and usage

Compiling the program:
`javac -g main/Main.java`
Running it:
`java main.Main "INPUT_FILE" "OUTPUT_FILE"`

## Flow and Design

Explaining in short terms:

1. Input is read using the GameInputLoader class.
2. Using the input, the map, players, round moves and angels are initialised.
Every player is instantiated in a list of heroes. They also get their own class
based on their type. The angels are organised in a similar way.
3. The game is played:
3.1 Every player takes Damage over Time and is declared dead if his hp drops
below 0 (used in the next rounds).
3.2 Players are moved: their coordinates and location is modified.
3.3 If the hero is can move then it can choose one of its own strategy.
3.3 If 2 players are in the same cell, they fight.
3.4 When a player is defeated, the other one gets XP and the magician is
notified.
3.5 Players level up if necesarry.
3.6 The angels are placed, the magician is notified every time an angel is
spawned.
3.7 They help every player that is in the same spot as him, and again, the
magician is notified.
4. Output is written in the output file.

> I used Double Dispatch when I had to apply race modifiers, in the following
way: the attacked player accepts the attack, then he calls a function that
computes its damage. The function that accepts the attack is implemented in
each player's class and each ability class has 4 separate functions with the
same name, being different only by the attacked hero's type.

> I used the Visitor Design Pattern to make angels visit players that are in
the same position as them. 

> I used the Observer Design Pattern to help the magician get all the
information that he needs.
>> I felt like I needed 2 separate classes because I created a pretty generic
interface using the Object class, so I used a AngelsObserver class that is
notified when an angel is spawned and when it helps a hero, and a HeroObserver
class that is notifiend when it increases in level and when a hero kills
another.

## References
-  [First Stage of the Project](http://elf.cs.pub.ro/poo/teme/proiect/etapa1)
    Project description with necessary information
-  [Second Stage of the Project](http://elf.cs.pub.ro/poo/teme/proiect/etapa2)
    Project description with necessary information
-  [Github](https://github.com/biancaandreeac/league-of-oop)
    Bianca Ciuche
    
 
