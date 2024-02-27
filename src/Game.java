import java.util.Scanner;

public class Game {
    protected Scanner inputScanner = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Enter a name : ");

        //String playerName = inputScanner.nextLine();
        Player player = new Player("Mustafa");
        System.out.println("###################################################################");
        System.out.println("\n"+player.getName()+"Welcome to this misty island. Your journey begins now.");

        System.out.println("Please select a character to continue...");
        player.selectCharacter();

        Location location = null;
        System.out.println("New adventure beings...");
        while(true){
            System.out.println("###################################################################");
            player.getPlayerStats();
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Locations : ");
            System.out.println("1 - Safe House --> Safe place to stay and restore your health");
            System.out.println("2 - Tool Shop --> You can buy Weapons or Armors");
            System.out.println("3 - Cave --> There are Zombies to kill and Foods to earn");
            System.out.println("4 - Forest --> There are Vampires to kill and Woods to earn");
            System.out.println("5 - River --> There are Bears to kill and Water to earn");
            System.out.println("0 - End the Adventure");
            System.out.println("Select a destination");
            int locationSelection = inputScanner.nextInt();
            switch (locationSelection){
                case 0:
                    location = null;
                    break;
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolShop(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("*** Why are you looking around? ***");
            }
            if (location == null){
                System.out.println("*** You leaving this dark and misty island too early. How miserable are you! ***");
                break;
            }
            if(!location.onLocation()){
                System.out.println("*** Game Ended ***");
                break;
            }
        }
    }
}
