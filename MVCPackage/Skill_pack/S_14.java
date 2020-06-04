package MVCPackage.Skill_pack;

        import MVCPackage.Model_pack.Player;
        import MVCPackage.Skill;

public class S_14 implements Skill {
    public int get_priority() {return 18;}
    public void cast(Player user, Player enemy, int round){
        user.set_Mana_cost(round,3);
        for (int i = 0; i < 4; i++) {
            user.set_Armor(round + i,user.get_Armor(round + i) + 3);
        }
    }
    public String get_message(String Player_Name) {
        return (Player_Name + " призывает магическую броню");
    }
}