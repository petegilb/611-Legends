Peter Gilbert
April 2021
Legends: Monsters and Heroes

Included Classes:
Armor.java = Armor class that extends RPGItem and contains stats for a piece of Armor
Board.java = Base board class to be extended
BoardGame.java = BoardGame class that extends Game -> meant for use with boardgames
Creature.java = Base creature class that has hp, lvl, etc. for a living thing in an rpg -> to be extended
Dragon.java = Dragon class that extends Monster -> a type of Monster in Legends -> also implements MonsterCreator
Exoskeleton.java = Exoskeleton class that extends Monster -> a type of Monster in Legends -> also implements MonsterCreator
Game.java = Base game class for running any kind of game
Hero.java = Hero extends Creature and contains many helper methods for Heroes in Legends
HeroCreator.java = interface for creating heroes
HeroFactory.java = Factory for creating heroes
Launcher.java = Basic Launcher class with no other purpose but launching the game
LegBoard.java = the board for Legends extends RPGBoard and is meant to contain and generate tiles for Legends
Legends.java = the main class for Legends -> extends RPGGame and contains the game logic
LegTile.java = Base tile for Legends -> extends RPGTile and has a tileIcon for the map
MarketTile.java = tile for the Markets in legends -> extends LegTile
Monster.java = class for Monsters in Legends/Rpgs and extends Creature - contains many helper methods for monsters
MonsterCreator.java = interface for creating monsters
MonsterFactory.java = factory for creating monsters
MonsterParty.java = a party of monsters aka a group of monsters that the Heroes fight against
Paladin.java = a type of Hero (extends Hero) and has its own attributes that it is talented in
Potion.java = a type of RPGItem and contains helper methods when using a potion
RPGBoard.java = the board for a RPG game -> extends BoardGame
RPGGame.java = the game for a RPG game -> extends Game
RPGItem.java = an item for an RPG Game -> extends 
RPGParty.java = group of Heroes for an RPGGame
RPGTile.java = tile for a RPGGame -> extends Tile
Sorcerer.java = a type of Hero (extends Hero) and has its own attributes that it is talented in
Spell.java = a type of item that is used for attacking in Legends extends RPGItem
Spells.java = an enum class to specify what type of spell a spell is
Spirit.java = Spirit class that extends Monster -> a type of Monster in Legends
Tile.java = base Tile class for usage in board games
WallTile.java = a type of tile in an RPG game that extends RPGTile and is not walkable
Warrior.java = a type of Hero (extends Hero) and has its own attributes that it is talented in
Weapon.java = a type of RPGItem that buffs a hero's attack extends RPGItem
WildTile.java = a type of tile in an RPG game that is walkable and has a chance for battles to occur

Other Files:
Armory.txt
Dragons.txt
Exoskeletons.txt
FireSpells.txt
IceSpells.txt
LightningSpells.txt
Paladins.txt
Potions.txt
ReadMe.txt (this file)
Sorcerers.txt
Spirits.txt
Warriors.txt
Weaponry.txt


To compile the program: please compile everything in the folder using javac, the name of the folder, and *.java

To run the program:
run the launcher with: "java Launcher" and follow the on screen instructions

Some info:
Default controls and filepaths can be changed in the final variables in their respective files.
Default controls:
Move up: "W"
Move left "A"
Move down: "S"
Move right "D"
show Info "I"
quit game "Q"
manage inventory "E"
show map "M"

Game run continuously until the hero party dies or the player quits. Monsters and Heroes are generated from the files.
Monster levels are balanced to the highest level hero. Monsters and Heroes with the same names can be chosen.

Heroes are revived to 50%hp if some of the party survives.

The rest of the calculations are as outlined in the design specifications.