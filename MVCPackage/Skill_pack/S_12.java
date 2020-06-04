package MVCPackage.Skill_pack;

        import MVCPackage.Model_pack.Player;
        import MVCPackage.Skill;

public class S_12 implements Skill {
    public int get_priority() {return 19;}
    public void cast(Player user, Player enemy, int round){
        user.set_Mana_cost(round,3);
        for (int i = 1; i <= 4; i++)
            enemy.set_Damage_over_time(round + i,enemy.get_Damage_over_time(round + i) + 3);
    }
    public String get_message(String Player_Name) {
        return (Player_Name + " выпускает ядовитый туман, который окутывает противника");
    }
}