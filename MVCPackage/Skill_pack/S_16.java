package MVCPackage.Skill_pack;

import MVCPackage.Model_pack.Player;
import MVCPackage.Skill;

public class S_16 implements Skill {
    public int get_priority() {return 20;}
    public void cast(Player user, Player enemy, int round){
        user.set_Mana_cost(round,3);
        user.set_Mana_Point_recovery(round,user.get_Mana_Point_recovery(round) + 3);
        for (int i = 1; i <= 6; i++) {
            user.set_Mana_Point_regeneration(round + i,user.get_Mana_Point_regeneration(round + i) + 2);
        }
    }
    public String get_message(String Player_Name) {
        return (Player_Name + " восстанавливает свой запас магических сил");
    }
}