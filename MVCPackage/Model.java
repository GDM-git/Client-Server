package MVCPackage;

import java.util.HashMap;

public interface Model {
    String get_Player_Name();
    HashMap<String, Integer> get_Skills_HashMap();
    int get_Heal_Point_Max();
    int get_Mana_Point_Max();
    void set_Skills_HashMap(HashMap<String, Integer> Skills_HashMap_in);
    void set_Heal_Point_Max(int Heal_Point_Max_in);
    void set_Mana_Point_Max(int Mana_Point_Max_in);
    int get_Heal_Point(int round);
    int get_Mana_Point(int round);
    int get_Mana_Point_regeneration(int round);
    int get_Advent_1(int round);
    int get_Advent_2(int round);
    int get_Advent_3(int round);
    int get_Damage(int round);
    int get_Damage_over_time(int round);
    int get_Heal_Point_recovery(int round);
    int get_Mana_Point_recovery(int round);
    int get_Mana_Point_loss(int round);
    int get_Mana_cost(int round);
    int get_Armor(int round);
    void set_Heal_Point(int round, int Heal_Point_in);
    void set_Mana_Point(int round, int Mana_Point_in);
    void set_Mana_Point_regeneration(int round, int Mana_Point_regeneration_in);
    void set_Advent_1(int round, int Advent_1_in);
    void set_Advent_2(int round, int Advent_2_in);
    void set_Advent_3(int round, int Advent_3_in);
    void set_Damage(int round, int Damage_in);
    void set_Damage_over_time(int round, int Damage_over_time_in);
    void set_Heal_Point_recovery(int round, int Heal_Point_recovery_in);
    void set_Mana_Point_recovery(int round, int Mana_Point_recovery_in);
    void set_Mana_Point_loss(int round, int Mana_Point_loss_in);
    void set_Mana_cost(int round, int Mana_cost_in);
    void set_Armor(int round, int Armor_in);
}
