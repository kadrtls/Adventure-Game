public class GameChar {
    private String name;
    private int damage,helath,money;

    public GameChar(String name, int damage, int helath, int money) {
        this.name = name;
        this.damage = damage;
        this.helath = helath;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHelath() {
        return helath;
    }

    public void setHelath(int helath) {
        this.helath = helath;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
