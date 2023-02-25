public class Armor {
    private String name;
    private int block,price;

    public Armor(String name, int block, int price) {
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList=new Armor[3];
        armorList[0]=new Armor("hafif zırh",1,15);
        armorList[1]=new Armor("Orta zırh",3,25);
        armorList[2]=new Armor("Ağır zırh",5,40);
        return armorList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
