import java.util.Scanner;

public class Player {
    Scanner scanner=new Scanner(System.in);
    private int damage,health,money,defaultHealth;
    private String charName,name,locationAwards;
    private Inventory inventory;

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }

    public void selectChar(){

        GameChar[] warriors={new Samurai(),new Archer(),new Knight()};
        System.out.println("------------------------------------------------------");
        for (GameChar worrior: warriors){
            System.out.println("Karakter:"+worrior.getName()
                    +"\t Hasar:"+worrior.getDamage()
                    +"\t Sağlık:"+worrior.getHelath()
                    +"\t Para:"+worrior.getMoney());
        }
        System.out.println("------------------------------------------------------");
        System.out.print("Lütfen yukarıdaki karakterlerden birini seçiniz:");
        int selectChar=scanner.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Seçilen karakter:"+getCharName()
                +" <hasar:"+getDamage()
                +" sağlık:"+getHealth()
                +" para:"+getMoney()+">");
    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHelath());
        this.defaultHealth=health;
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println(
                "Sialhınız:"+this.getInventory().getWeapon().getName()
                +", Zırhınız:"+this.getInventory().getArmor().getName()
                +", Blok:"+this.getInventory().getArmor().getBlock()
                +" <hasar:"+getDamageTotal()
                +" sağlık:"+getHealth()
                +" para:"+getMoney()+">");
    }
    public int getDamageTotal(){
        return damage+this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getLocationAwards() {
        return locationAwards;
    }

    public void setLocationAwards(String locationAwards) {
        this.locationAwards = locationAwards;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
