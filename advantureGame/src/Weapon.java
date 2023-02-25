public class Weapon {
    private String name;
    private int damage,price;

    public Weapon(String name, int damage, int price) {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }
    public static Weapon[] weapons(){
        Weapon[] weaponList=new Weapon[3];
        weaponList[0]=new Weapon("Tabanca",3,35);
        weaponList[1]=new Weapon("Kılıç",2,25);
        weaponList[2]=new Weapon("Tüfek",7,45);
        return weaponList;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
