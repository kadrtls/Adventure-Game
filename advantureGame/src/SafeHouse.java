public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
    }
    @Override
     boolean onLocation() {
        System.out.println("Güvenli eve hoşgeldiniz!");
        System.out.println("Canınız yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        return true;
    }
}
