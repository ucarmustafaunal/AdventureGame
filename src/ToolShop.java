public class ToolShop extends NormalLocation {
    public ToolShop(Player player) {
        super(player, "Tool Shop");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Welcome to the Tool Shop Adventurer!");
        return true;
    }
}
