public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }
    @Override
    boolean onLocation() {
        System.out.println("*Mağzaya hoşgeldiniz");
        boolean showMenu=true;
        while (showMenu){
            System.out.println("-Silahlar");
            System.out.println("-Zırhlar");
            System.out.println("-ÇIKIŞ YAP");
            System.out.print("lütfen yukarıdakilerden birini seçiniz:");
            int selectCase=Location.scanner.nextInt();//ata sınıfdan geldiği için selectCase=scanner.nextInt();bu da yazılabilir
            while (selectCase<1 || selectCase>3){
                System.out.println("Geçersiz sayı girdiniz!tekrar deneyin.");
                selectCase=scanner.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Görüşmek üzere!");

                    showMenu=false;
                    break;
            }
        }
        return true;
    }
    public void printWeapon(){
        System.out.println();
        System.out.println("-----------------------Silahlar------------------------");
        for (Weapon w :Weapon.weapons()){
            System.out.println(w.getName()+" <hasar:"+w.getDamage()+" para:"+w.getPrice());
        }
        System.out.println("4-ÇıKIŞ Yap!");
        System.out.println("-----------------------------------------------");

    }
    public void buyWeapon(){
        System.out.print("yukarıdakilerden birini seçiniz:");
        int selectWeapon=scanner.nextInt();
        while (selectWeapon<1 || selectWeapon>Weapon.weapons().length+1){
            System.out.print("geçersiz bir sayı girdiniz,tekrar deneyin:");
            selectWeapon=scanner.nextInt();
            if (selectWeapon==4){
                break;
            }
        }
        //Weapon selectedWeapon=Weapon.weapons()[selectWeapon].getName();
        if (Weapon.weapons()[selectWeapon-1].getPrice()>this.getPlayer().getMoney()){
            System.out.println("Yetersiz bakiye!");
        }else {
            System.out.println(Weapon.weapons()[selectWeapon-1].getName()+" satıl alındı");
            int balance=this.getPlayer().getMoney()-Weapon.weapons()[selectWeapon-1].getPrice();
            this.getPlayer().setMoney(balance);
            System.out.println("Kalan bakiye:"+ this.getPlayer().getMoney());
            this.getPlayer().getInventory().setWeapon(Weapon.weapons()[selectWeapon-1]);
            System.out.println("Yeni silahınız:"+Weapon.weapons()[selectWeapon-1].getName());
        }
    }

    public void printArmor(){
        System.out.println();
        System.out.println("-----------------------Zırhlar------------------------");
        for (Armor a :Armor.armors()){
            System.out.println(a.getName()+" <hasar:"+a.getBlock()+" para:"+a.getPrice());
        }
        System.out.println("-----------------------------------------------");
    }
    public void buyArmor(){
        System.out.print("yukarıdakilerden birini seçiniz:");
        int selectArmor=scanner.nextInt();
        while (selectArmor<1 || selectArmor>Armor.armors().length){
            System.out.println("geçersiz bir sayı girdiniz");
            selectArmor=scanner.nextInt();
        }
        if (Armor.armors()[selectArmor-1].getPrice()>this.getPlayer().getMoney()){
            System.out.println("Yetersiz bakiye!");
        }else{
            System.out.println(Armor.armors()[selectArmor-1].getName()+" satıl alındı");
            int balance=this.getPlayer().getMoney()-Armor.armors()[selectArmor-1].getPrice();
            this.getPlayer().setMoney(balance);
            System.out.println("Kalan bakiye:"+ this.getPlayer().getMoney());
            this.getPlayer().getInventory().setArmor(Armor.armors()[selectArmor-1]);
            System.out.println("Yeni zırhınız:"+Armor.armors()[selectArmor-1].getName());
        }
    }
}
