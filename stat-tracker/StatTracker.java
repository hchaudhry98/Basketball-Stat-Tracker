import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class StatTracker{

  public static int findIndexOfPlayer(ArrayList<Player> team, int jersey){
    int index = -1;
    for(int i = 0; i < team.size(); i++){
      if(jersey == team.get(i).getJerseyNumber()){
        index = i;
      }
    }
    return index;
  }

  public static int findIndexOfPlayer(ArrayList<Player> team, String name){
    int index = -1;
    for(int i = 0; i < team.size(); i++){
      if(name.equalsIgnoreCase(team.get(i).getName())){
        index = i;
      }
    }
    return index;
  }

  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    ArrayList<Player> white = new ArrayList<Player>();
    ArrayList<Player> black = new ArrayList<Player>();
    ArrayList<String> tokens = new ArrayList<String>();
    boolean nameFlag = false, numberFlag = false, bothFlag = false, blackFlag = false, whiteFlag = false, caseFlag = false;

    System.out.println("Will you use numbers or names or both?");
    String ans = sc.nextLine();
    if(ans.equals("numbers")){
      numberFlag = true;
      System.out.println("Enter in jersey numbers for white team one by one: (Enter 'finish' when done):");
      ans = sc.nextLine();
      while(!(ans.equals("finish"))){
        Player player = new Player(Integer.parseInt(ans));
        white.add(player);
        ans = sc.nextLine();
      }
      System.out.println("Enter in jersey numbers for black team one by one: (Enter 'finish' when done):");
      ans = sc.nextLine();
      while(!(ans.equals("finish"))){
        Player player = new Player(Integer.parseInt(ans));
        black.add(player);
        ans = sc.nextLine();
      }
    } else if(ans.equals("names")){
      nameFlag = true;
      System.out.println("Enter in the names for white team one by one: (Enter 'finish' when done):");
      ans = sc.nextLine();
      while(!(ans.equals("finish"))){
        Player player = new Player(ans.toLowerCase());
        white.add(player);
        ans = sc.nextLine();
      }
      System.out.println("Enter in the names for black team one by one: (Enter 'finish' when done):");
      ans = sc.nextLine();
      while(!(ans.equals("finish"))){
        Player player = new Player(ans.toLowerCase());
        black.add(player);
        ans = sc.nextLine();
      }
    } else if(ans.equals("both")){
      bothFlag = true;
      System.out.println("Enter in jersey number AND name like so - 23 Jordan. Enter one by one for the white team: (Enter 'finish' when done)");
      ans = sc.nextLine();
      while(!(ans.equals("finish"))){
        Player player = new Player(Integer.parseInt(ans.substring(0, ans.indexOf(' '))), ans.substring(ans.indexOf(' ')+1).toLowerCase());
        white.add(player);
        ans = sc.nextLine();
      }
      System.out.println("Enter in jersey number AND name like so - 23 Jordan. Enter one by one for the black team: (Enter 'finish' when done)");
      ans = sc.nextLine();
      while(!(ans.equals("finish"))){
        Player player = new Player(Integer.parseInt(ans.substring(0, ans.indexOf(' '))), ans.substring(ans.indexOf(' ')+1).toLowerCase());
        black.add(player);
        ans = sc.nextLine();
      }
    } else{
      System.out.println("Expected 'numbers', 'names', or 'both'. Received: " + ans + " - Application Closing..");
      System.exit(0);
    }

    /*System.out.println("white Team: ");
    for(int i = 0; i < white.size(); i++){
      if(nameFlag){
        System.out.print(white.get(i).getName() + " - ");
      } else if(numberFlag){
        System.out.print(white.get(i).getJerseyNumber() + " - ");
      } else if(bothFlag){
        System.out.print(white.get(i).getJerseyNumber() + " " + white.get(i).getName() + " - ");
      }
    }
    System.out.println("\nblack Team: ");
    for(int i = 0; i < black.size(); i++){
      if(nameFlag){
        System.out.print(black.get(i).getName() + " - ");
      } else if(numberFlag){
        System.out.print(black.get(i).getJerseyNumber() + " - ");
      } else if(bothFlag){
        System.out.print(black.get(i).getJerseyNumber() + " " + black.get(i).getName() + " - ");
      }
    }*/

    //MAIN ALGORITHM
    System.out.println("\nTeam Set Up Complete!");
    System.out.println("TO FINISH ENTER 'finish'");
    int jNum = -1;
    while(true){
      System.out.println("Enter in the play result: (MUST END WITH '-')");
      ans = sc.next();
      while(!(ans.equals("-"))){
        tokens.add(ans);
        ans = sc.next();
      }
      if(tokens.get(0).equals("finish")){
        System.out.println("GAME OVER");
        System.out.println("------------- WHITE TEAM ----------------");
        for(int i = 0; i<white.size(); i++){
          white.get(i).playerString(nameFlag, numberFlag, bothFlag);
          System.out.println("--------------------------------------------");
        }
        System.out.println("------------- BLACK TEAM ----------------");
        for(int i = 0; i<black.size(); i++){
          black.get(i).playerString(nameFlag, numberFlag, bothFlag);
          System.out.println("--------------------------------------------");
        }
        System.exit(0);
      }
      if(tokens.get(0).equals("white")){
        whiteFlag = true;
        if(numberFlag || bothFlag){
          jNum = findIndexOfPlayer(white, Integer.parseInt(tokens.get(1)));
        } else if(nameFlag){
          jNum = findIndexOfPlayer(white, tokens.get(1));
        }
        if(jNum == -1){
          System.out.println("No such white player found");
          tokens.clear();
          whiteFlag = false;
          continue;
        }
      } else if(tokens.get(0).equals("black")){
        blackFlag = true;
        if(numberFlag || bothFlag){
          jNum = findIndexOfPlayer(black, Integer.parseInt(tokens.get(1)));
        } else if(nameFlag){
          jNum = findIndexOfPlayer(black, tokens.get(1));
        }
        if(jNum == -1){
          System.out.println("No such black player found");
          tokens.clear();
          blackFlag = false;
          continue;
        }
      }
      for(int i = 2; i<tokens.size();i++){
        if(whiteFlag){
          switch(tokens.get(i)){
            case "assist":
              white.get(jNum).setAssists(1);
              caseFlag = true;
              break;
            case "rebound":
              white.get(jNum).setRebounds(1);
              caseFlag = true;
              break;
            case "block":
              white.get(jNum).setBlocks(1);
              caseFlag = true;
              break;
            case "steal":
              white.get(jNum).setSteals(1);
              caseFlag = true;
              break;
            case "ftm":
              white.get(jNum).setFTM(1);
              caseFlag = true;
              break;
            case "fta":
              white.get(jNum).setFTA(1);
              caseFlag = true;
              break;
            case "foul":
              white.get(jNum).setFouls(1);
              if(white.get(jNum).getFouls() >= 5){
                System.out.println("FOULED OUT");
              }
              caseFlag = true;
              break;
            case "0p":
              white.get(jNum).setTotalPoints(0);
              caseFlag = true;
              break;
            case "2p":
              white.get(jNum).setTotalPoints(2);
              caseFlag = true;
              break;
            case "3p":
              white.get(jNum).setTotalPoints(3);
              caseFlag = true;
              break;
          }
          if(numberFlag || bothFlag){
            if(Character.isDigit(tokens.get(i).charAt(0)) && caseFlag == false){
              jNum = findIndexOfPlayer(white, Integer.parseInt(tokens.get(i)));
            }
          } else if(nameFlag && caseFlag == false){
            jNum = findIndexOfPlayer(white, tokens.get(i));
          }
          caseFlag = false;
        } else if(blackFlag){
          switch(tokens.get(i)){
            case "assist":
              black.get(jNum).setAssists(1);
              caseFlag = true;
              break;
            case "rebound":
              black.get(jNum).setRebounds(1);
              caseFlag = true;
              break;
            case "block":
              black.get(jNum).setBlocks(1);
              caseFlag = true;
              break;
            case "steal":
              black.get(jNum).setSteals(1);
              caseFlag = true;
              break;
            case "ftm":
              black.get(jNum).setFTM(1);
              caseFlag = true;
              break;
            case "fta":
              black.get(jNum).setFTA(1);
              caseFlag = true;
              break;
            case "fouls":
              black.get(jNum).setFouls(1);
              if(black.get(jNum).getFouls() >= 5){
                System.out.println("FOULED OUT");
              }
              caseFlag = true;
              break;
            case "0p":
              black.get(jNum).setTotalPoints(0);
              caseFlag = true;
              break;
            case "2p":
              black.get(jNum).setTotalPoints(2);
              caseFlag = true;
              break;
            case "3p":
              black.get(jNum).setTotalPoints(3);
              caseFlag = true;
              break;
          }
          if(numberFlag || bothFlag){
            if(Character.isDigit(tokens.get(i).charAt(0)) && caseFlag == false){
              jNum = findIndexOfPlayer(black, Integer.parseInt(tokens.get(i)));
            }
          } else if(nameFlag && caseFlag == false){
            jNum = findIndexOfPlayer(black, tokens.get(i));
          }
          caseFlag = false;
        }
      }
      tokens.clear();
      whiteFlag = false;
      blackFlag = false;

    }


  } //end of main

}
