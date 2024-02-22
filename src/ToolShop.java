public class ToolShop extends NormalLocation {
    public ToolShop(Player player) {
        super(player, "Tool Shop");
    }

    @Override
    public boolean onLocation(){
        System.out.println("###################################################################");
        System.out.println("\nDon't waste my time! What do you want?");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("1 - Weapons");
            System.out.println("2 - Armours");
            System.out.println("3 - Leave from Tool Shop");
            System.out.println("Your selection is : ");
            int selection = input.nextInt();
            while (selection < 1 || selection > 3){
                System.out.println("There isn't such a thing here. Are you blind?");
                selection = input.nextInt();
            }
            switch (selection){
                case 1 :
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                default:
                    System.out.println("Don't mess around, If you don't want to die at the Woods.");
                    showMenu = false;
                    return true;
            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("\n----- Weapons -----\n");
        for(Weapon w : Weapon.weapons()){
            System.out.println(
                            w.getId()+" - "+
                            w.getName()+" | Price : "+
                            w.getPrice()+" | Damage : "+
                            w.getDamage());
        }
        System.out.println("0 : Exit");
    }

    public void buyWeapon(){
        System.out.println("Which weapon would you like to buy?");
        int weaponSelectionID = input.nextInt();
        while (weaponSelectionID < 0 || weaponSelectionID > Weapon.weapons().length){
            System.out.println("There isn't such a thing here. Are you blind?");
            weaponSelectionID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(weaponSelectionID);

        if(selectedWeapon != null){
            if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Not enough coins! Go kill some monsters.");
            }
            else{
                System.out.println("What are you gonna do with "+selectedWeapon.getName()+"?");
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
                System.out.println("*** You've got "+this.getPlayer().getMoney()+" left to spend ***");
                System.out.println("*** Your last weapon was "
                        +this.getPlayer().getInventory().getWeapon().getName()+" ***");
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("*** Now you have "
                        +this.getPlayer().getInventory().getWeapon().getName()+
                        " to use. Don't be shy to make it bloody. ***");
            }
        }
    }

    public void printArmor(){
        System.out.println("\n----- Armors -----\n");
        for(Armor a : Armor.armors()){
            System.out.println(
                    a.getId()+" - "+
                    a.getName()+" | Price : "+
                    a.getPrice()+" | Blocking Rate : "+
                    a.getArmorRate());
        }
        System.out.println("0 : Exit");
    }

    public void buyArmor(){
        System.out.println("\nWhich armor would you like to buy?\n");
        int armorSelectionID = input.nextInt();
        while (armorSelectionID < 0 || armorSelectionID > Armor.armors().length){
            System.out.println("There isn't such a thing here. Are you blind?");
            armorSelectionID = input.nextInt();
        }

        Armor selectedArmor = Armor.getArmorByObjID(armorSelectionID);
        if(selectedArmor != null){
            if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Not enough coins! I told you to don't waste my time!");
            } else {
                System.out.println("*** You bought fine looking "+selectedArmor.getName()+" ***");
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                System.out.println("*** You've got "+this.getPlayer().getMoney()+" left to spend ***");
                System.out.println("*** Your last armor was "+this.getPlayer().getInventory().getWeapon().getName()+".");
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("*** Now you have "
                        +this.getPlayer().getInventory().getArmor().getName()+
                        " to protect yourself ***");
            }
        }
    }
}
