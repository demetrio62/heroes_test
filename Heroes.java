class BattleUnit{
    private int hp;
    private String race;
    private String uclassname;
    private String action1;
    private String action2;
    private boolean isbuffed;
    private boolean iscursed;
    private boolean isdead;

    BattleUnit(){
        hp = 100;
        race = "None";
        uclassname = "None";
        isbuffed = false;
        iscursed = false;
        isdead = false;
    }
    BattleUnit(String r){
        hp = 100;
        race = r;
        uclassname = "None";
        isbuffed = false;
        iscursed = false;
        isdead = false;
    }
    BattleUnit(String r, String c){
        hp = 100;
        race = r;
        uclassname = c;
        isbuffed = false;
        iscursed = false;
        isdead = false;
    }

    void setUClassName(String c){
        uclassname = c;
    }
    void show(){
        System.out.print(race + "-" + uclassname + " " + hp + "HP");
        if (isbuffed) System.out.print(" *");
        if (iscursed) System.out.print(" ~");
        System.out.println();
    }
    void getDamaged(int dmg){
        hp-=dmg;
        if (hp <= 0) isdead = true;
    }
}

class Archer extends BattleUnit{
    private String action1name;
    private String action2name;
    private int dmg1;
    private int dmg2;

    Archer(String r){
        super(r);
        switch (r) {
            case "Human":
                setUClassName("Crossbowman");
                dmg1 = 5;
                dmg2 = 3;
                action1name = "Crossbow Shot";
                action2name = "Sword blow";
                break;
            case "Elf":
                setUClassName("Archer");
                dmg1 = 7;
                dmg2 = 3;
                action1name = "Bow Shot";
                action2name = "Sword blow";
                break;
            case "Orc":
                setUClassName("Archer");
                dmg1 = 3;
                dmg2 = 2;
                action1name = "Bow Shot";
                action2name = "Blade strike";
                break;
            case "Undead":
                setUClassName("Hunter");
                dmg1 = 4;
                dmg2 = 2;
                action1name = "Bow Shot";
                action2name = "Sword blow";
                break;
        }

    }

    void show(){
        super.show();
        System.out.println("(Abilities: - " + dmg1 + " HP " + action1name + "; - " + dmg2 + " HP " + action2name + ".)");
    }
}

public class Heroes{
    public static void main (String[] args){
        Archer bu1 = new Archer("Human");
        Archer bu2 = new Archer("Elf");
        Archer bu3 = new Archer("Orc");
        Archer bu4 = new Archer("Undead");

        System.out.println("Let the battle begin!");
        bu1.show();
        System.out.println("&");
        bu2.show();
        System.out.println("VS");
        bu3.show();
        System.out.println("&");
        bu4.show();


    }
}