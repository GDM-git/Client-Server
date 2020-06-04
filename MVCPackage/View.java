package MVCPackage;

import MVCPackage.Model_pack.Player;

public interface View {
    String get_in();
    void print_message(String message);
    String result_round(Player player_1, Player player_2, int round, String message);
    void print_result_round(Player player_1, Player player_2, int round, String message);
    void print_result(String str);
}
