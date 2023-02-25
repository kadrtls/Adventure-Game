public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean food,water,firewood,chance;

    public Inventory() {
        this.weapon = new Weapon("yumruk",0,0);
        this.armor=new Armor("kalkansız",0,0);
        this.food=false;
        this.water=false;
        this.firewood=false;
        this.chance=false;
    }
    public void awordsWon(String award){
        String[] awards=new String[0];
        if (this.food){
            System.out.println("yemek");
        }
        if (this.firewood){
            System.out.println("odun");
        }
        if (this.water){
            System.out.println("su");
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isChance() {
        return chance;
    }

    public void setChance(boolean chance) {
        this.chance = chance;
    }
}

