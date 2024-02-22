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

        if(battleSelection.equals("S")){
            //Battle Codes here
            System.out.println("Battle will begin!");
        } else {
            System.out.println("*** Wise decision ***");
        }
        return true;
    }
}