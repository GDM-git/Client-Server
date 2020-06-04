package MVCPackage.Model_pack;

import java.util.ArrayList;

public class Round {
    private int Heal_Point = 30;
    private int Mana_Point = 30;
    private int Mana_Point_regeneration = 0;
    private int Advent_1 = 0, Advent_2 = 0, Advent_3 = 0;
    private int Damage = 0;
    private int Damage_over_time = 0;
    private int Heal_Point_recovery = 0;
    private int Mana_Point_recovery = 0;
    private int Mana_Point_loss = 0;
    private int Mana_cost = 0;
    private int Armor = 0;
    Round(int Mana_Point_regeneration_in, int Advent_1_in, int Advent_2_in, int Advent_3_in) {
        Mana_Point_regeneration = Mana_Point_regeneration_in;
        Advent_1 = Advent_1_in;
        Advent_2 = Advent_2_in;
        Advent_3 = Advent_3_in;
    }
    public int get_Heal_Point() {return Heal_Point;}
    public int get_Mana_Point() {return Mana_Point;}
    public int get_Mana_Point_regeneration() {return Mana_Point_regeneration;}
    public int get_Advent_1() {return Advent_1;}
    public int get_Advent_2() {return Advent_2;}
    public int get_Advent_3() {return Advent_3;}
    public int get_Damage() {return Damage;}
    public int get_Damage_over_time() {return Damage_over_time;}
    public int get_Heal_Point_recovery() {return Heal_Point_recovery;}
    public int get_Mana_Point_recovery() {return Mana_Point_recovery;}
    public int get_Mana_Point_loss() {return Mana_Point_loss;}
    public int get_Mana_cost() {return Mana_cost;}
    public int get_Armor() {return Armor;}
    public void set_Heal_Point(int Heal_Point_in) {Heal_Point = Heal_Point_in;}
    public void set_Mana_Point(int Mana_Point_in) {Mana_Point = Mana_Point_in;}
    public void set_Mana_Point_regeneration(int Mana_Point_regeneration_in) {Mana_Point_regeneration = Mana_Point_regeneration_in;}
    public void set_Advent_1(int Advent_1_in) {Advent_1 = Advent_1_in;}
    public void set_Advent_2(int Advent_2_in) {Advent_2 = Advent_2_in;}
    public void set_Advent_3(int Advent_3_in) {Advent_3 = Advent_3_in;}
    public void set_Damage(int Damage_in) {Damage = Damage_in;}
    public void set_Damage_over_time(int Damage_over_time_in) {Damage_over_time = Damage_over_time_in;}
    public void set_Heal_Point_recovery(int Heal_Point_recovery_in) {Heal_Point_recovery = Heal_Point_recovery_in;}
    public void set_Mana_Point_recovery(int Mana_Point_recovery_in) {Mana_Point_recovery = Mana_Point_recovery_in;}
    public void set_Mana_Point_loss(int Mana_Point_loss_in) {Mana_Point_loss = Mana_Point_loss_in;}
    public void set_Mana_cost(int Mana_cost_in) {Mana_cost = Mana_cost_in;}
    public void set_Armor(int Armor_in) {Armor = Armor_in;}
}
