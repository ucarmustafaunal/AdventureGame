public abstract class Characters {
    private int classID;
    private String characterClass;
    private int damage;
    private int health;
    private int money;

    public Characters(int classID, String characterClass, int damage, int health, int money) {
        this.classID = classID;
        this.characterClass = characterClass;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
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
}
