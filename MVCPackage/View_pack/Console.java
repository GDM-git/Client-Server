package MVCPackage.View_pack;

import MVCPackage.Model_pack.Player;
import MVCPackage.Model_pack.Round;
import MVCPackage.View;

import java.util.Scanner;

public class Console implements View {
    public String get_in() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public void print_message(String message) {
        System.out.println(message);
    }
    public String result_round(Player player_1, Player player_2, int round, String message) {
        String result;
        result = "\nРезультат раунда №" + (round - 1) + "\n";
        result = result + message + "\n";
        result = result + "Игрок " + player_1.get_Player_Name() + ": HP = " + player_1.get_Heal_Point(round) + "(" + (player_1.get_Heal_Point(round) - player_1.get_Heal_Point(round - 1)) + ") ; MP = " + (player_1.get_Mana_Point(round)) + "(" + (player_1.get_Mana_Point(round) - player_1.get_Mana_Point(round - 1)) + ")" + "\n";
        result = result + "Игрок " + player_2.get_Player_Name() + ": HP = " + player_2.get_Heal_Point(round) + "(" + (player_2.get_Heal_Point(round) - player_2.get_Heal_Point(round - 1)) + ") ; MP = " + (player_2.get_Mana_Point(round)) + "(" + (player_2.get_Mana_Point(round) - player_2.get_Mana_Point(round - 1)) + ")" + "\n";
        return result;
    }
    public void print_result_round(Player player_1, Player player_2, int round, String message) {
        System.out.println("\nРезультат раунда №" + (round - 1));
        System.out.println(message);
        System.out.println("Игрок " + player_1.get_Player_Name() + ": HP = " + player_1.get_Heal_Point(round) + "(" + (player_1.get_Heal_Point(round) - player_1.get_Heal_Point(round - 1)) + ") ; MP = " + (player_1.get_Mana_Point(round)) + "(" + (player_1.get_Mana_Point(round) - player_1.get_Mana_Point(round - 1)) + ")");
        System.out.println("Игрок " + player_2.get_Player_Name() + ": HP = " + player_2.get_Heal_Point(round) + "(" + (player_2.get_Heal_Point(round) - player_2.get_Heal_Point(round - 1)) + ") ; MP = " + (player_2.get_Mana_Point(round)) + "(" + (player_2.get_Mana_Point(round) - player_2.get_Mana_Point(round - 1)) + ")" + "\n");
    }
    public void print_result(String str) {
        System.out.println("**************************************************************************");
        System.out.println(str);
        System.out.println("**************************************************************************");
    }
}