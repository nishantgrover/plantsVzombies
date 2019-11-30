package sample;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

interface damagable{
    public void damaged(double value);
}
interface attacker{
    public double attack();
}
abstract class Creature{
    public abstract void attack();
    public abstract void damage();
    public abstract ImageView getMyImage();
}
class HitException extends Exception{

}
class PLacePlantException extends Exception{

}
class GraveHereException extends Exception{

}
class DieException extends Exception{

}
class ShovelRemoveException extends Exception{

}
class Player implements Comparable<Player>, Serializable{

    private String username;
    private final int unique_key;
    private double coins;
    private static int age;
    private long zombieskilled;
    private int level;
    private int rank;
    private int XP;
    private final ArrayList<Plant> unlockedPlants;

    public Player(String username, int unique_key, double coins, int age, long zombieskilled, int level, int rank,
                  int xP) {
        super();
        this.username = username;
        this.unique_key = unique_key;
        this.coins = coins;
        this.age = age;
        this.zombieskilled = zombieskilled;
        this.level = level;
        this.rank = rank;
        XP = xP;
        this.unlockedPlants = new ArrayList<Plant>();
    }
    @Override
    public int compareTo(Player p)
    {
        return this.rank - p.rank;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getUnique_key() {
        return unique_key;
    }
    public double getCoins() {
        return coins;
    }
    public long getZombieskilled() {
        return zombieskilled;
    }
    public int getLevel() {
        return level;
    }
    public int getRank() {
        return rank;
    }
    public int getXP() {
        return XP;
    }
    public ArrayList<Plant> getUnlockedPlants() {
        return unlockedPlants;
    }
    public void addCoins(double value) {

    }
    public void addZombieskilled(long value) {

    }
    public void levelUp() {

    }
    public void addXP(int value) {

    }
    public void updateRank() {

    }
    public void setUnlockedPlants(Plant p) {

    }
}

abstract class Plant implements damagable, Serializable{
    private final int myType;
    private double HP;
    private final int waitingTime;
    private final double cost;
    private double maxHP;
    private String name;
    private final int availableAtlevel;
    private final String myAbility;
    public Plant(int availableAtlevel, int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name) {
        super();
        this.myType = myType;
        HP = hP;
        this.waitingTime = waitingTime;
        this.cost = cost;
        this.myAbility = myAbility;
        this.maxHP = maxHP;
        this.name = name;
        this.availableAtlevel=availableAtlevel;
    }

    public int getAvailableAtlevel() {
        return availableAtlevel;
    }

    public double getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMyType() {
        return myType;
    }
    public double getHP() {
        return HP;
    }
    public int getWaitingTime() {
        return waitingTime;
    }
    public double getCost() {
        return cost;
    }
    public String getMyAbility() {
        return myAbility;
    }
    @Override
    public String toString() {
        return "";
    }
    @Override
    public void damaged(double value) {

    }
    abstract public void specialAbility();
}

class Zombie extends Creature implements damagable, Serializable{
    private double HP;
    private final double maxHP;
    private final String toughness;
    private final float speed;
    private int damageAbsorption;
    private final int myGrunt;
    private final double atkpwr;
    private ImageView myImage;
    private static Timeline zombieTimeline;
    private static ArrayList<Zombie> allZombies;
    private double x;
    private double y;
    public Zombie(double hP, double maxHP, String toughness, float speed, int damageAbsorption, int myGrunt,
                  double atkpwr) {
        super();
        zombieTimeline=new Timeline();
        allZombies = new ArrayList<Zombie>();
        HP = hP;
        this.maxHP = maxHP;
        this.toughness = toughness;
        this.speed = speed;
        this.damageAbsorption = damageAbsorption;
        this.myGrunt = myGrunt;
        this.atkpwr = atkpwr;
    }
    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.x = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void resetXY(){
        this.x=myImage.getX();
        this.y=myImage.getY();
    }
    public Zombie() {
        maxHP=100;
        toughness="";
        speed=10;
        myGrunt=0;
        atkpwr=0;
        zombieTimeline=new Timeline();
        allZombies = new ArrayList<Zombie>();
    }
    public static void addZombie(Zombie z){
        allZombies.add(z);
    }
    public Timeline getTimeline(){
        return zombieTimeline;
    }
    @Override
    public void damaged(double value) {

    }
    @Override
    public String toString() {
        return "";
    }
    public void ability(){

    }

    public double getHP() {
        return HP;
    }

    public double getMaxHP() {
        return maxHP;
    }

    public String getToughness() {
        return toughness;
    }

    public float getSpeed() {
        return speed;
    }

    public int getDamageAbsorption() {
        return damageAbsorption;
    }

    public int getMyGrunt() {
        return myGrunt;
    }

    public double getAtkpwr() {
        return atkpwr;
    }
    public void setImage(String url){
        myImage=new ImageView(new Image(url));
    }

    @Override
    public void attack() {

    }

    @Override
    public void damage() {

    }

    public ImageView getMyImage(){
        return myImage;
    }

}

class BasicZombie extends Zombie implements Serializable{

    public BasicZombie(double hP, double maxHP, String toughness, float speed, int damageAbsorption, int myGrunt,
                       double atkpwr) {
        super(hP, maxHP, toughness, speed, damageAbsorption, myGrunt, atkpwr);
        this.setImage("sample/imgs/normal_zombie.gif");
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void ability() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void damage() {

    }

}

class BucketHeadZombie extends Zombie implements Serializable{

    public BucketHeadZombie(double hP, double maxHP, String toughness, float speed, int damageAbsorption, int myGrunt,
                            double atkpwr) {
        super(hP, maxHP, toughness, speed, damageAbsorption, myGrunt, atkpwr);

    }


    private static final long serialVersionUID = 1L;

    @Override
    public void ability() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void damage() {

    }

}
class ConeHeadZombie extends Zombie implements Serializable{

    public ConeHeadZombie(double hP, double maxHP, String toughness, float speed, int damageAbsorption, int myGrunt,
                          double atkpwr) {
        super(hP, maxHP, toughness, speed, damageAbsorption, myGrunt, atkpwr);
        this.setImage("sample/imgs/Conehead_Zombie.gif");
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void ability() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void damage() {

    }

}
class FlagZombie extends Zombie implements Serializable{

    public FlagZombie(double hP, double maxHP, String toughness, float speed, int damageAbsorption, int myGrunt,
                      double atkpwr) {
        super(hP, maxHP, toughness, speed, damageAbsorption, myGrunt, atkpwr);
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void ability() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void damage() {

    }

}
class PoleVaultingZombie extends Zombie implements Serializable{

    public PoleVaultingZombie(double hP, double maxHP, String toughness, float speed, int damageAbsorption, int myGrunt,
                              double atkpwr) {
        super(hP, maxHP, toughness, speed, damageAbsorption, myGrunt, atkpwr);
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void ability() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void damage() {

    }

}

abstract class Shooter extends Plant implements attacker, Serializable{
    private int range;
    private Pea shot;
    private final ArrayList<Pea> shots;

    public Shooter(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name,
                   int range) {
        super(myType, range, hP, waitingTime, cost, myAbility, maxHP, name);
        this.range = range;
        this.shot = new Pea(1);
        this.shots = new ArrayList<Pea>();
    }
    @Override
    public String toString() {
        return "";
    }
    @Override
    public double attack() {
        return 1;
    }
    abstract public void shoot();
    private class Pea implements Cloneable, Serializable{
        private int myType;
        private final double power;
        public Pea(int myType) {
            super();
            this.myType = myType;
            this.power=0;
        }
        public int getMyType() {
            return myType;
        }
        public double getPower() {
            return power;
        }
        @Override
        public Object clone() {
            return myType;

        }
    }
}
class Peashooter extends Shooter implements Serializable{
    private static double cost;
    private static final int availableAtlevel=0;
    private static final String myAbility="";
    public Peashooter(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name,
                      int range) {
        super(myType, hP, waitingTime, cost, myAbility, maxHP, name, range);
    }

    @Override
    public void specialAbility() {

    }

    @Override
    public void shoot() {
        // TODO Auto-generated method stub

    }

    public static String getMyability() {
        return myAbility;
    }

}
class Repeater extends Shooter implements Serializable{
    private static double cost;
    private static final int availableAtlevel=0;
    private static final String myAbility="";
    public Repeater(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name,
                    int range) {
        super(myType, hP, waitingTime, cost, myAbility, maxHP, name, range);
    }

    @Override
    public void specialAbility() {

    }

    @Override
    public void shoot() {
        // TODO Auto-generated method stub

    }

}
class Threepeater extends Shooter implements Serializable{
    private static double cost;
    private static final int availableAtlevel=0;
    private static final String myAbility="";
    public Threepeater(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name,
                       int range) {
        super(myType, hP, waitingTime, cost, myAbility, maxHP, name, range);
    }

    @Override
    public void specialAbility() {

    }

    @Override
    public void shoot() {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "";
    }
}
abstract class Builder extends Plant implements attacker, Serializable{

    public Builder(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name) {
        super(myType, waitingTime, hP, waitingTime, cost, myAbility, maxHP, name);
    }

    @Override
    public String toString() {
        return "";
    }
    @Override
    public void specialAbility() {

    }

}
class Wallnut extends Builder implements Serializable{
    private static double cost;
    private static final int availableAtlevel=0;
    private static final String myAbility="";
    public Wallnut(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name) {
        super(myType, hP, waitingTime, cost, myAbility, maxHP, name);
    }

    @Override
    public double attack() {
        return 0;
    }

}
class Tallnut extends Builder implements Serializable{
    private static double cost;
    private static final int availableAtlevel=0;
    private static final String myAbility="";
    public Tallnut(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name) {
        super(myType, hP, waitingTime, cost, myAbility, maxHP, name);
    }

    @Override
    public double attack() {
        return 0;
    }

}
abstract class SunTokenProducer extends Plant implements attacker, Serializable{

    public SunTokenProducer(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name) {
        super(myType, waitingTime, hP, waitingTime, cost, myAbility, maxHP, name);
    }

    @Override
    public String toString() {
        return "";
    }
    @Override
    public void specialAbility() {

    }

}
class Sunflower extends SunTokenProducer implements Serializable{
    private static double cost;
    private static final int availableAtlevel=0;
    private static final String myAbility="";
    public Sunflower(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name) {
        super(myType, hP, waitingTime, cost, myAbility, maxHP, name);
    }

    @Override
    public double attack() {
        return 0;
    }
}
class Sunshroom extends SunTokenProducer implements Serializable{
    private static double cost;
    private static final int availableAtlevel=0;
    private static final String myAbility="";
    public Sunshroom(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name) {
        super(myType, hP, waitingTime, cost, myAbility, maxHP, name);
    }

    @Override
    public double attack() {
        return 0;
    }
}
abstract class BombPlants extends Plant implements attacker, Serializable{

    public BombPlants(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name) {
        super(myType, waitingTime, hP, waitingTime, cost, myAbility, maxHP, name);
    }

    @Override
    public String toString() {
        return "";
    }
    @Override
    public void specialAbility() {

    }

}
class CherryBomb extends BombPlants implements Serializable{
    private static double cost;
    private static final int availableAtlevel=0;
    private static final String myAbility="";
    public CherryBomb(int myType, double hP, int waitingTime, double cost, String myAbility, double maxHP, String name) {
        super(myType, hP, waitingTime, cost, myAbility, maxHP, name);
    }

    @Override
    public double attack() {
        return 0;
    }
}
class LawnMower implements Serializable{
    private boolean isAvailable;
    private Lane myLane;
    LawnMower(Lane myLane){
        this.isAvailable=true;
        this.myLane=null;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void specialpwr() {

    }

}
class Lane implements Serializable{
    Tile[] tiles;
    LawnMower lane_lawnmower;
    Lane(){
        tiles=new Tile[9];
        lane_lawnmower=new LawnMower(this);
    }
}
class Tile implements Serializable{
    private boolean isAvailable;
    private Plant placed;

    Tile(){
        this.isAvailable=true;
        this.placed=null;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean x) {
        this.isAvailable=x;
    }
}
class Grave extends Tile implements Serializable{
    Grave(){
        super();
        this.setAvailable(false);
    }
}
class Lawn implements Serializable{
    Lane[] lanes;
    Lawn(){
        lanes=new Lane[5];
    }
}
class Shovel implements Serializable{
    public void useShovel() {

    }
}
abstract class CreatureFactory{
    public abstract Creature createCreature(String need);
}
class ZombieFactory extends CreatureFactory{
    private static ZombieFactory Zf = new ZombieFactory();
    private ZombieFactory(){
    }
    public static ZombieFactory getInstance(){
        return Zf;
    }
    @Override
    public Creature createCreature(String need) {
        if(need.equals("1")){
            return new BasicZombie(100,100,"low",1,35,1,15);
        }
        else if(need.equals("2")){
            return new ConeHeadZombie(150,150,"medium",1.5f,30,2,20);
        }
        else if(need.equals("3")){
            return new BucketHeadZombie(200,200,"medium",1.5f,30,3,25);
        }
        else if(need.equals("4")){
            return new FlagZombie(250,250,"high",2f,25,4,30);
        }
        else if(need.equals("5")){
            return new PoleVaultingZombie(250,250,"high",2.5f,25,5,30);
        }
        return null;
    }
}
class SubGame implements Serializable{
    private final int level;
    private final Plant[] plantsSelected;
    private Shovel shovel;
    private int sunPoints;
    private Lawn lawn;
    private String WeatherType;
    private final Zombie[] zombies;
    SubGame(int level) {
        this.plantsSelected=new Plant[6];
        this.level=level;
        this.zombies=new Zombie[4*level];
    }
    public void playGame() {

    }
    public void menu() {

    }
    public void saveGame() {

    }
    public void loadGame() {

    }
}
class Game implements Serializable{
    private ArrayList<SubGame> subgames;
    private int weatherChoice;
    private ArrayList<Player> users;
    private Player CurrentUser;
    private boolean isSaved;
    private SubGame CurrentSubGame;

    private int availableLevels;
    private int volume;
    private static int userKeyHandler;
    public void serialize() {

    }
    public void deserialize() {

    }
    public Game(ArrayList<SubGame> subgames, int weatherChoice, ArrayList<Player> users, Player currentUser,
                boolean isSaved, SubGame currentSubGame) {
        super();
        this.subgames = subgames;
        this.weatherChoice = weatherChoice;
        this.users = users;
        CurrentUser = currentUser;
        this.isSaved = isSaved;
        CurrentSubGame = currentSubGame;
        playGame();
    }
    public void selectLevel() {

    }
    public void playGame() {
        this.selectLevel();
    }
    public void saveGame() {

    }
    public void chooseUser() {

    }
    public void showLeaderboard() {

    }
    public void showAchievements() {

    }
    public void loadGame() {
    }
    public void exitGame() {
    }
    public void Login() {

    }
    public void Register() {

    }
    public void CreateNewUser() {

    }
}
public class backendMain implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static Game g;
    public void serialize() {

    }
    public void deserialize() {

    }
    public static void main(String[] args) {
        g=new Game(null, 0, null, null, false, null);
        g.playGame();
    }
}