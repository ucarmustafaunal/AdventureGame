public class Monster {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int drop;
    private int defaultHealth;

    public Monster(int id, String name, int damage, int health, int drop){
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.drop = drop;
        this.defaultHealth = health;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getDrop() {
        return drop;
    }

    public void setDrop(int drop) {
        this.drop = drop;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
