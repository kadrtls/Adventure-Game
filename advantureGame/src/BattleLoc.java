import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    boolean onLocation() {
        int obsNumber=randomObstaxleNumber();
        System.out.println(this.getName()+" geldin");
        System.out.println("Burada "+obsNumber+" tane "+this.getObstacle().getName()+" gözüküyor,dikkat et!");
        System.out.print("<S>avaş ya da <K>aç :");
        String selectCase=scanner.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println("Tüm canavarları yendiniz.");
            String[] award = new String[0];
            for (int i=0;i<=award.length;i++){
                if (award[i]!=this.getAward()){
                    System.out.println("Bölge ödülünüz :"+this.getAward());
                    break;
                }
            }
            return true;
        }
        if (this.getPlayer().getHealth() <= 0){
            this.getPlayer().setHealth(0);
                System.out.println("Öldünüz! :(");
                return false;
        }

        return true;
    }

    public boolean combat(int obsNumber){
        System.out.println("Savaş başlıyor");
        for (int i=1;i <= obsNumber;i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefaultHealt());
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                Random random=new Random();
                int firstAttack=random.nextInt(2);
                if (firstAttack==1){
                    System.out.print("<V>ur ya da <K>aç:");
                    String selectCombat = scanner.nextLine().toUpperCase();
                    if (selectCombat.equals("V")) {
                        System.out.println(this.getPlayer().getName() + " vurdu");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamageTotal());
                        if (this.getObstacle().getHealth()<0){
                            this.getObstacle().setHealth(0);
                        }
                        afterHit();
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println(this.getObstacle().getName() + " size vurdu.");
                            if (this.getObstacle().getName()=="Yılan"){
                                this.getObstacle().setHealth(randomSnakeDamage());
                            }
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                }else {
                    System.out.println(this.getObstacle().getName() + " size vurdu.");
                    if (this.getObstacle().getName()=="Yılan"){
                        this.getObstacle().setHealth(randomSnakeDamage());
                    }
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();
                    if (this.getPlayer().getHealth()>0){
                        System.out.print("<V>ur ya da <K>aç:");
                        String selectCombat = scanner.nextLine().toUpperCase();
                        if (selectCombat.equals("V")) {
                            System.out.println(this.getPlayer().getName() + " vurdu");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamageTotal());
                            if (this.getObstacle().getHealth() < 0) {
                                this.getObstacle().setHealth(0);
                            }
                            afterHit();
                        }
                    }
                }

            }
                    if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                        System.out.println("Düşman alt edildi.");
                        System.out.println(this.getObstacle().getAward()+" para kazandınız.");
                        this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                        System.out.println("Güncel bakiye :"+ this.getPlayer().getMoney());

                    }else{
                    return false;
                }
        }
        return true;
    }
    public void afterHit(){
        System.out.println(this.getPlayer().getName()+" canı:"+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" canı:"+this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("Kahraman değerleri");
        System.out.println("- Silah:"+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("- Zırh:"+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("- Sağlık:"+this.getPlayer().getHealth());
        System.out.println("- Blok:"+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("- Hasar:"+this.getPlayer().getDamageTotal());
        System.out.println("- Para:"+this.getPlayer().getMoney());
        System.out.println("------------------------------------");
    }
    public void obstacleStats(int i){
        System.out.println(i+". "+this.getObstacle().getName()+" değerleri");
        System.out.println("Sağlık:"+this.getObstacle().getHealth());
        System.out.println("Hasar:"+this.getObstacle().getDamage());
        System.out.println("Ödül:"+this.getObstacle().getAward());
        System.out.println("------------------------------------");
    }
    public int randomObstaxleNumber(){
        Random random=new Random();
        return random.nextInt(getMaxObstacle())+1;
    }
    public int randomSnakeDamage(){
        Random random=new Random();
        return random.nextInt(4)+3;
    }

    // düzenle
    public String randomAward(){
        Random random=new Random();
        int awardNum=random.nextInt(100)+1;
        if (awardNum>0 && awardNum<=15){
            int gunNum=random.nextInt(100)+1;
            if (0<gunNum && gunNum<=20){
                System.out.println("tüfek kazanıldı");
            } else if (20<gunNum && gunNum<=50) {
                System.out.println("Kılıç kazanıldı");
            }else {
                System.out.println("Tabanca kazanıldı");
            }
        }else if (15<awardNum && awardNum<=30){
            int armorNum=random.nextInt(100)+1;
            if (0<armorNum && armorNum<=20){
                System.out.println("ağır zırh kazanıldı");
            } else if (20<armorNum && armorNum<=50) {
                System.out.println("orta zırh kazanıldı");
            }else {
                System.out.println("Hafif zırh kazanıldı");
            }
        } else if (30<awardNum && awardNum<=55) {
            int money=random.nextInt(100)+1;
            if (0<money && money<=20){
                System.out.println("10 tl eklendi");
            } else if (20<money && money<=50) {
                System.out.println("5 tl eklendi");
            }else {
                System.out.println("1 tl eklendi");
            }
        }else{
            System.out.println("Bölgeden hiçbir şey çıkmadı :(");
        }
        return null;
    }
    /*public String awardsWon(){
        String[] awards={new Cave(getPlayer()).getAward(),new Forest(getPlayer()).getAward()
                ,new River(getPlayer()).getAward(),new Mine(getPlayer()).getAward()};
        for (String award:awards){
            if (award==new Cave(getPlayer()).getAward()){

            }
        }
    }*/
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
