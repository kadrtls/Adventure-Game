import java.util.Random;

public class Obstacle {
    private String name;
    private int damage,health,award,defaultHealt,randomDmg;

    public Obstacle(String name, int damage, int health,int award) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defaultHealt=health;
        this.award=award;
    }

    public int randomDamage(){
        Random random=new Random();
        return random.nextInt(getRandomDmg())+3;
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
        if (health<0){
            health = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getDefaultHealt() {
        return defaultHealt;
    }

    public void setDefaultHealt(int defaultHealt) {
        this.defaultHealt = defaultHealt;
    }

    public int getRandomDmg() {
        return randomDmg;
    }

    public void setRandomDmg(int randomDmg) {
        this.randomDmg = randomDmg;
    }
}
