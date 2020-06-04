package MVCPackage.Skill_pack;

import MVCPackage.Model_pack.Player;
import MVCPackage.Skill;

public class S_18 implements Skill {
    public int get_priority() {return 15;}
    public void cast(Player user, Player enemy, int round){
        user.set_Mana_cost(round,3);
        int i = 0;
        while (round + i != 30) {
            user.set_Mana_Point_loss(round + i,0);
            user.set_Mana_Point_recovery(round + i,0);
            user.set_Heal_Point_recovery(round + i,0);
            user.set_Damage_over_time(round + i,0);
            i++;
        }
    }
    public String get_message(String Player_Name) {
        return (Player_Name + " снимает с себя все эффекты");
    }
}