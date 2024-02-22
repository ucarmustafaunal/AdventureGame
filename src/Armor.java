public class Armor {
    private int id;
    private String name;
    private int armorRate;
    private int price;

    public Armor(int id, String name, int armorRate, int price) {
        this.id = id;
        this.name = name;
        this.armorRate = armorRate;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1,"Light Weight Armor", 1, 15);
        armorList[1] = new Armor(2,"Medium Weight Armor", 3, 25);
        armorList[2] = new Armor(3,"Heavy Weight Armor", 5, 40);
        return armorList;
    }

    public static Armor getArmorByObjID(int id){
        for(Armor a : Armor.armors()){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmorRate() {
        return armorRate;
    }

    public void setArmorRate(int armorRate) {
        this.armorRate = armorRate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
