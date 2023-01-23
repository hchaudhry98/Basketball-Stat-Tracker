# Basketball-Stat-Tracker
Stat Tracker for Basketball        

 ### How to use - VERSION 1.0   

Enter in each member for each team using either their jersey numbers, names, or both.
Upon entering this info, enter in each play's result in the following format(s):
     
  * <team> <player_identifier> <KEY_WORD> -
  * <team> <player_identifier> <KEY_WORD> <KEY_WORD> ... -
  * <team> <player_identifier> <KEY_WORD> ... <player_identifier> <KEY_WORD> ... (for as many players in that team as you need to specify) -
    
Statistics for the player(s) will only be updated as long as a '-' is present at the end of the play result. The program will not accept a new play result until it finds the '-' at the end of the play result.    
Specify the team at the beginning of the play result to properly update the player(s)'s statistics. Should the team not be specified, the program may break as I have not added any such error handling for this error.     
The <team> token may be either 'black', for the away team, or 'white', for the home team. It has to be either one of those, for I have not added a team naming functionality as of yet.      
      
The KEY_WORDS are as follows:
  * 0p - denotes a missed field goal attempt
  * 2p - denotes a successful field goal attempt inside the 3-point line
  * 3p - denotes a successful field goal attempt outside of the 3-point line
  * assist - denotes a successful assist to a teammate who scores a successful field goal attempt
  * rebound - denotes a succcessful rebound after the opposing or same team's missed field goal attempt
  * block - denotes a successful swat of a shot attempt from the opposing team
  * steal - denotes a successful steal of possession
  * ftm - denotes a successful free throw attempt. This also updates free throws attempted by default
  * fta - denotes an unsuccessful free throw attempt.
  * foul - denotes a foul that a player commits on the opposing team

##### How to see stats - VERSION 1.0

To see the statistics for each player from both teams, simply type in 'finish -', and all stats will be printed for each player.
Beware, as this command terminates the program after printing each player's stats. 
Functionality for 'halftime -' will be added in version 1.1
More bug fixes will be present in 1.1
