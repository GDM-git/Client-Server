package MVCPackage.Skill_pack;

import MVCPackage.Model_pack.Player;
import MVCPackage.Skill;

public class S_13 implements Skill {
    public int get_priority() {return 19;}
    public void cast(Player user, Player enemy, int round){
        user.set_Mana_cost(round,3);
        for (int i = 1; i <= 3; i++) {
            enemy.set_Damage_over_time(round + i,enemy.get_Damage_over_time(round + i) + 3);
            user.set_Heal_Point_recovery(round + i,user.get_Heal_Point_recovery(round + i) + 2);
        }
    }
    public String get_message(String Player_Name) {
        return (Player_Name + " читает заклинание высасывающее жизнь из противника себе");
    }
}