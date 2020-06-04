package MVCPackage.Skill_pack;

import MVCPackage.Model_pack.Player;
import MVCPackage.Skill;

public class S_19 implements Skill {
    public int get_priority() {return 19;}
    public void cast(Player user, Player enemy, int round){
        user.set_Mana_cost(round,3);
        enemy.set_Damage_over_time(round,enemy.get_Damage_over_time(round) + 7);
    }
    public String get_message(String Player_Name) {
        return (Player_Name + " вызывает яростный порыв ветра в сторону врага");
    }
}