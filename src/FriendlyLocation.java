public class FriendlyLocation extends Location{
    public FriendlyLocation(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
