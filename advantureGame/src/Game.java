import java.util.Scanner;

public class Game {
    private Scanner scanner=new Scanner(System.in);
    private String award;

    public void start(){
        System.out.println("*Macera oyununa hoşgeldiniz!");
        System.out.print("Lütfen bir kullnaıcı adı giriniz:");
        //String playerName=scanner.nextLine();
        Player player=new Player("PHONEİX");
        System.out.println("oyuna hoşgeldin "+player.getName());
        System.out.println("Burada seçimlerine dikkat etmelisin!");
        player.selectChar();
        Location location=null;
        while (true){
            player.printInfo();
                System.out.println("-------------------Bölgeler--------------------------");
                System.out.println("0-Oyundan çık");
                System.out.println("1-Güvenli bölge");
                System.out.println("2-Mağaza");
                System.out.println("3-Mağara , Ödül:yemek");
                System.out.println("4-Orman , Ödül:odun");
                System.out.println("5-Nehir , Ödül:su");
                System.out.println("6-Maden , Ödül:Şans");
                System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz:");
                int selectLoc=scanner.nextInt();
                switch (selectLoc){
                    case 0:
                        location=null;
                        break;
                    case 1:
                        location=new SafeHouse(player);
                        break;
                    case 2:
                        location=new ToolStore(player);
                        break;
                    case 3:
                        location=new Cave(player);
                        break;
                    case 4:
                        location=new Forest(player);
                        break;
                    case 5:
                        location=new River(player);
                        break;
                    case 6:
                        location=new Mine(player);
                        break;
                    default:
                        System.out.println("lütfen geçerli bir bölge girin!");
                }
                if (location== null){
                    System.out.println("Oyun kapatılıyor.");
                    break;
                }
                if(!location.onLocation())
                {
                    System.out.println("GAME OVER!");
                    break;
                }
        }
        //player.selectLoc();
    }
    public String awardsWon(){
        String[] awards=new String[0];
        return null;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
