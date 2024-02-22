public class SafeHouse extends FriendlyLocation {
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation(){
        System.out.println("###################################################################");
        System.out.println("You're at the Safe House. Your health is restored!");
        return true;
    }
}
