package MVCPackage.Skill_pack;

import MVCPackage.Model_pack.Player;
import MVCPackage.Skill;

public class S_17 implements Skill {
    public int get_priority() {return 22;}
    public void cast(Player user, Player enemy, int round){
        user.set_Mana_cost(round,3);
        enemy.set_Mana_Point_loss(round,enemy.get_Mana_Point_loss(round) + 4);
        enemy.set_Mana_Point_regeneration(round,0);
    }
    public String get_message(String Player_Name) {
        return (Player_Name + " выжигает энергию противника");
    }
}