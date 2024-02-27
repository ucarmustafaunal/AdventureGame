import java.util.Random;

public abstract class EnemyLocation extends Location{
    private Monster monster;
    private String award;
    private int maxMonster;
    public EnemyLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    public Monster getMonster(){
        return monster;
    }

    public void setMonster(Monster monster){
        this.monster = monster;
    }

    public String getAward(){
        return award;
    }

    public void setAward(String award){
        this.award = award;
    }

    public int getMaxMonster(){
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster){
        this.maxMonster = maxMonster;
    }

    public int randomMonsterCount(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public void playerStats(){
        System.out.println("------------");
        System.out.println("Player Stats");
        System.out.println("Health : "+this.getPlayer().getHealth());
        System.out.println("Weapon : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage : "+this.getPlayer().getTotalDamage());
        System.out.println("Armor : "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blocking : "+this.getPlayer().getInventory().getArmor().getArmorRate());
        System.out.println("Money : "+this.getPlayer().getMoney());
    }

    public void monsterStats(int i){
        System.out.println("------------");
        System.out.println(i+". "+this.getMonster().getName()+" Stats");
        System.out.println("Health : "+this.getMonster().getHealth());
        System.out.println("Damage : "+this.getMonster().getDamage());
        System.out.println("Drops : "+this.getMonster().getDrop()+" Coins");
    }

    public void afterHit(){
        System.out.println(this.getPlayer().getName()+"'s Health : "+this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName()+"'s Health : "+this.getMonster().getHealth());
    }

    public boolean combat(int monsterCount){
        int roundCounter = 1;
        for (int i = 1; i <= monsterCount; i++){
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
                System.out.println("*** (A)ttack or (E)scape ***");
                String selectCombat = input.nextLine();
                selectCombat = selectCombat.toUpperCase();
                while(!selectCombat.equals("A") && !selectCombat.equals("E")){
                    System.out.println("*** Quick! Decide! ***");
                    selectCombat = input.nextLine();
                    selectCombat = selectCombat.toUpperCase();
                }
                if(selectCombat.equals("A")){
                    System.out.println("*** Round "+roundCounter+" ***");
                    System.out.println(this.getPlayer().getName()+" hits "+this.getPlayer().getTotalDamage()+" damage to the "+this.getMonster().getName());
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    if (this.getMonster().getHealth() > 0) {
                        int trueDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getArmorRate();
                        if (trueDamage > 0){
                            System.out.println(this.getMonster().getName()+" hits "+this.getMonster().getDamage()+" damage to the "+this.getPlayer().getName());
                            System.out.println(this.getPlayer().getName()+" blocked "+this.getPlayer().getInventory().getArmor().getArmorRate());
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - trueDamage);
                        }
                        else {
                            System.out.println(this.getMonster().getName()+" missed!");
                        }
                        afterHit();
                    }
                }
                roundCounter++;
            }
            if(this.getMonster().getHealth() <= 0){
                System.out.println("*** "+this.getMonster().getName()+" dropped "+this.getMonster().getDrop()+" coins! ***");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getDrop()); //Coin drop after monster slaying
                System.out.println("*** Now you have "+this.getPlayer().getMoney()+" coins ***");
            }
        }
        if (this.getPlayer().getHealth() > 0) {
            if(monsterCount == 1){
                System.out.println("*** You managed to stay alive and killed "+monsterCount+" "+this.getMonster().getName()+" ***");
            }else{
                System.out.println("*** You managed to stay alive and killed "+monsterCount+" "+this.getMonster().getName()+"s ***");
            }
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean onLocation(){
        int monsterCount = randomMonsterCount();
        System.out.println("###################################################################");
        System.out.println("*** You are at the "+this.getName()+" ***");
        if(monsterCount == 1){
            System.out.println("*** Be careful! "+monsterCount+" "+this.getMonster().getName()+" seen here recently ***");
        }else{
            System.out.println("*** Be careful! "+monsterCount+" "+this.getMonster().getName()+"s seen here recently ***");
        }

        System.out.println("*** Will you enter to the "+this.getName()+"? (S)tart Battle or (E)scape ***");
        String battleSelection = input.nextLine();
        battleSelection = battleSelection.toUpperCase();

        while(!battleSelection.equals("S") && !battleSelection.equals("E")){
            System.out.println("*** Quick! Decide! ***");
            battleSelection = input.nextLine();
            battleSelection = battleSelection.toUpperCase();
        }

        if(battleSelection.equals("S") && combat(monsterCount)){
            System.out.println("*** You've slayed all monsters ***");
            return true;
        }

        if(this.getPlayer().getHealth() <= 0) {
            System.out.println("*** You Died! ***");
            return false;
        }
        return true;
    }
}