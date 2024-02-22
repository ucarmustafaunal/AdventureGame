import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String characterClass;
    protected Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter(){
        Character[] characterList= {new Samurai(), new Archer(), new Knight()};

        System.out.println("###################################################################");
        for (Character character : characterList){
            System.out.println( "ID : "+ character.getClassID()+
                                "\t\tClass : "+ character.getCharacterClass()+
                                "\t\tDamage : "+ character.getDamage()+
                                "\t\tHealth : "+ character.getHealth()+
                                "\t\tMoney : "+ character.getMoney());
        }
        System.out.println("Select a class to play with.");
        int characterSelection = input.nextInt();

        switch (characterSelection) {
            case 1:
                playerClass(new Samurai());
                break;
            case 2:
                playerClass(new Archer());
                break;
            case 3:
                playerClass(new Knight());
                break;
        }
        System.out.println(this.getCharacterClass()+" selected. Your journey begins with stats listed below :\n"+
                "Damage : "+this.getDamage()+
                "\nHealth : "+this.getHealth()+
                "\nMoney  : "+this.getMoney());
    }

    public void getPlayerStats(){
        System.out.println("Adventure is waiting for you...\n"+
                "\nWeapon : "+this.getInventory().getWeapon().getName()+
                "\nArmor : "+this.getInventory().getArmor().getName()+
                "\nBlocking Rate : "+this.getInventory().getArmor().getArmorRate()+
                "\nDamage : "+this.getDamage()+
                "\nHealth : "+this.getHealth()+
                "\nMoney  : "+this.getMoney());
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public void playerClass(Character character){
        this.setCharacterClass(character.getCharacterClass());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
