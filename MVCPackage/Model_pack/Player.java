package MVCPackage.Model_pack;

import MVCPackage.Model;

import java.util.HashMap;

public class Player implements Model {
    private String Player_Name;
    private int Heal_Point_Max = 30;
    private int Mana_Point_Max = Heal_Point_Max + 10;
    private HashMap<Integer, Round> Round_HashMap = new HashMap<Integer, Round>();
    private HashMap<String, Integer> Skills_HashMap = new HashMap<String, Integer>();
    public Player(String Player_Name_in) {
        Player_Name = Player_Name_in;
        for (int i = 0; i <= 40; i++) {
            Round_HashMap.put(i, new Round(1, 2, 0, 0));
        }
//        Skills_HashMap.put("S_11", 1);
//        Skills_HashMap.put("S_112", 1);
//        Skills_HashMap.put("S_119", 1);
//        Skills_HashMap.put("S_124", 1);
    }
    public String get_Player_Name() {return Player_Name;}
    public HashMap<String, Integer> get_Skills_HashMap() {return Skills_HashMap;}
    public int get_Heal_Point_Max() {return Heal_Point_Max;}
    public int get_Mana_Point_Max() {return Mana_Point_Max;}
    public void set_Skills_HashMap(HashMap<String, Integer> Skills_HashMap_in) {Skills_HashMap = Skills_HashMap_in;}
    public void set_Heal_Point_Max(int Heal_Point_Max_in) {Heal_Point_Max = Heal_Point_Max_in;}
    public void set_Mana_Point_Max(int Mana_Point_Max_in) {Mana_Point_Max = Mana_Point_Max_in;}
    public int get_Heal_Point(int round) {return Round_HashMap.get(round).get_Heal_Point();}
    public int get_Mana_Point(int round) {return Round_HashMap.get(round).get_Mana_Point();}
    public int get_Mana_Point_regeneration(int round) {return Round_HashMap.get(round).get_Mana_Point_regeneration();}
    public int get_Advent_1(int round) {return Round_HashMap.get(round).get_Advent_1();}
    public int get_Advent_2(int round) {return Round_HashMap.get(round).get_Advent_2();}
    public int get_Advent_3(int round) {return Round_HashMap.get(round).get_Advent_3();}
    public int get_Damage(int round) {return Round_HashMap.get(round).get_Damage();}
    public int get_Damage_over_time(int round) {return Round_HashMap.get(round).get_Damage_over_time();}
    public int get_Heal_Point_recovery(int round) {return Round_HashMap.get(round).get_Heal_Point_recovery();}
    public int get_Mana_Point_recovery(int round) {return Round_HashMap.get(round).get_Mana_Point_recovery();}
    public int get_Mana_Point_loss(int round) {return Round_HashMap.get(round).get_Mana_Point_loss();}
    public int get_Mana_cost(int round) {return Round_HashMap.get(round).get_Mana_cost();}
    public int get_Armor(int round) {return Round_HashMap.get(round).get_Armor();}
    public void set_Heal_Point(int round, int Heal_Point_in) {Round_HashMap.get(round).set_Heal_Point(Heal_Point_in);}
    public void set_Mana_Point(int round, int Mana_Point_in) {Round_HashMap.get(round).set_Mana_Point(Mana_Point_in);}
    public void set_Mana_Point_regeneration(int round, int Mana_Point_regeneration_in) {Round_HashMap.get(round).set_Mana_Point_regeneration(Mana_Point_regeneration_in);}
    public void set_Advent_1(int round, int Advent_1_in) {Round_HashMap.get(round).set_Advent_1(Advent_1_in);}
    public void set_Advent_2(int round, int Advent_2_in) {Round_HashMap.get(round).set_Advent_2(Advent_2_in);}
    public void set_Advent_3(int round, int Advent_3_in) {Round_HashMap.get(round).set_Advent_3(Advent_3_in);}
    public void set_Damage(int round, int Damage_in) {Round_HashMap.get(round).set_Damage(Damage_in);}
    public void set_Damage_over_time(int round, int Damage_over_time_in) {Round_HashMap.get(round).set_Damage_over_time(Damage_over_time_in);}
    public void set_Heal_Point_recovery(int round, int Heal_Point_recovery_in) {Round_HashMap.get(round).set_Heal_Point_recovery(Heal_Point_recovery_in);}
    public void set_Mana_Point_recovery(int round, int Mana_Point_recovery_in) {Round_HashMap.get(round).set_Mana_Point_recovery(Mana_Point_recovery_in);}
    public void set_Mana_Point_loss(int round, int Mana_Point_loss_in) {Round_HashMap.get(round).set_Mana_Point_loss(Mana_Point_loss_in);}
    public void set_Mana_cost(int round, int Mana_cost_in) {Round_HashMap.get(round).set_Mana_cost(Mana_cost_in);}
    public void set_Armor(int round, int Armor_in) {Round_HashMap.get(round).set_Armor(Armor_in);}
}