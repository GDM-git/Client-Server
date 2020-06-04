package MVCPackage;

import MVCPackage.Model_pack.Player;

public interface Skill {
    int get_priority();
    void cast(Player user, Player enemy, int round);
    String get_message(String Player_Name);
}