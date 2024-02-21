import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String characterClass;
    private Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
    }

    public void selectCharacter(){
        Characters[] characterList= {new Samurai(), new Archer(), new Knight()};

        System.out.println("###################################################################");
        for (Characters characters : characterList){
            System.out.println( "ID : "+characters.getClassID()+
                                "\t\tClass : "+characters.getCharacterClass()+
                                "\t\tDamage : "+characters.getDamage()+
                                "\t\tHealth : "+characters.getHealth()+
                                "\t\tMoney : "+characters.getMoney());
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

    public int getDamage() {
        return damage;
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

    public void playerClass(Characters characters){
        this.setCharacterClass(characters.getCharacterClass());
        this.setDamage(characters.getDamage());
        this.setHealth(characters.getHealth());
        this.setMoney(characters.getMoney());
    }

}
