package MVCPackage.Skill_pack;

import MVCPackage.Model_pack.Player;
import MVCPackage.Skill;

public class S_15 implements Skill {
    public int get_priority() {return 19;}
    public void cast(Player user, Player enemy, int round){
        user.set_Mana_cost(round,3);
        if (user.get_Heal_Point(round) <= 10)
            user.set_Heal_Point_recovery(round,user.get_Heal_Point_recovery(round) + 10);
        else
            user.set_Heal_Point_recovery(round,user.get_Heal_Point_recovery(round) + 7);
    }
    public String get_message(String Player_Name) {
        return (Player_Name + " восстанавливает свой запас здоровья");
    }
}