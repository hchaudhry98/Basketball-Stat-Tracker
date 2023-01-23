import java.util.ArrayList;

public class Player{
  private int totalPoints;
  private int assists;
  private int rebounds;
  private int blocks;
  private int steals;
  private int ftm, fta;
  private int fouls;
  private int jerseyNumber;
  private String name;
  ArrayList<Integer> pointTracker = new ArrayList<Integer>();

  public Player(int jerseyNumber){
    this.jerseyNumber = jerseyNumber;
    this.totalPoints = 0;
    this.assists = 0;
    this.rebounds = 0;
    this.blocks = 0;
    this.steals = 0;
    this.ftm = 0;
    this.fta = 0;
  }

  public Player(String name){
    this.name = name;
    this.totalPoints = 0;
    this.assists = 0;
    this.rebounds = 0;
    this.blocks = 0;
    this.steals = 0;
    this.ftm = 0;
    this.fta = 0;
  }

  public Player(int jerseyNumber, String name){
    this.name = name;
    this.jerseyNumber = jerseyNumber;
    this.totalPoints = 0;
    this.assists = 0;
    this.rebounds = 0;
    this.blocks = 0;
    this.steals = 0;
    this.ftm = 0;
    this.fta = 0;
  }

  public int getJerseyNumber(){
    return jerseyNumber;
  }
  public String getName(){
    return name;
  }

  public int getTotalPoints(){
    return totalPoints;
  }
  public void setTotalPoints(int points){
    pointTracker.add(points);
    this.totalPoints += points;
  }

  public int getAssists(){
    return assists;
  }
  public void setAssists(int assist){
    this.assists += assist;
  }

  public int getRebounds(){
    return rebounds;
  }
  public void setRebounds(int rebound){
    this.rebounds += rebound;
  }

  public int getBlocks(){
    return blocks;
  }
  public void setBlocks(int block){
    this.blocks += block;
  }

  public int getSteals(){
    return steals;
  }
  public void setSteals(int steal){
    this.steals += steal;
  }

  public int getFTM(){
    return totalPoints;
  }
  public void setFTM(int ftm){
    setFTA(ftm);
    this.ftm += ftm;
  }

  public int getFTA(){
    return fta;
  }
  public void setFTA(int fta){
    this.fta += fta;
  }

  public int getFouls(){
    return fouls;
  }
  public void setFouls(int foul){
    this.fouls += foul;
  }

  public void playerString(boolean nameFlag, boolean numberFlag, boolean bothFlag){
    if(numberFlag){
      System.out.println(this.jerseyNumber + " stats: ");
      System.out.print("Points: " + this.totalPoints + " - (");
      for(int i = 0; i < this.pointTracker.size(); i++){
        System.out.print(this.pointTracker.get(i) + ", ");
      }
      System.out.println(")\nAssists: " + this.assists);
      System.out.println("Rebounds: " + this.rebounds);
      System.out.println("Blocks: " + this.blocks);
      System.out.println("Steals: " + this.steals);
      System.out.println("Free Throws Made: " + this.ftm + " Free Throws Attempted: " + this.fta);
      System.out.println("Fouls: " + this.fouls);
    } else if(nameFlag){
      System.out.println(this.name + "'s stats: ");
      System.out.print("Points: " + this.totalPoints + " - (");
      for(int i = 0; i < this.pointTracker.size(); i++){
        System.out.print(this.pointTracker.get(i) + ", ");
      }
      System.out.println(")\nAssists: " + this.assists);
      System.out.println("Rebounds: " + this.rebounds);
      System.out.println("Blocks: " + this.blocks);
      System.out.println("Steals: " + this.steals);
      System.out.println("Free Throws Made: " + this.ftm + " Free Throws Attempted: " + this.fta);
      System.out.println("Fouls: " + this.fouls);
    } else if(bothFlag){
      System.out.println(this.jerseyNumber + " " + this.name + "'s stats: ");
      System.out.print("Points: " + this.totalPoints + " - (");
      for(int i = 0; i < this.pointTracker.size(); i++){
        System.out.print(this.pointTracker.get(i) + ", ");
      }
      System.out.println(")\nAssists: " + this.assists);
      System.out.println("Rebounds: " + this.rebounds);
      System.out.println("Blocks: " + this.blocks);
      System.out.println("Steals: " + this.steals);
      System.out.println("Free Throws Made: " + this.ftm + " Free Throws Attempted: " + this.fta);
      System.out.println("Fouls: " + this.fouls);
    }

  }

}
