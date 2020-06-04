package MVCPackage.Controller_pack;

import MVCPackage.Controller;
import MVCPackage.Model_pack.Player;
import MVCPackage.Skill;
import MVCPackage.View_pack.Console;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Properties;

public class Squirrel implements Controller {
    private HashMap<String, Skill> Skills_HashMap = new HashMap<String, Skill>();
    public void begin_single_player() {
        Fabric_skill_add("MVCPackage.Skill_pack.S_11");
//        Fabric_skill_add("MVCPackage.Skill_pack.S_112");
//        Fabric_skill_add("MVCPackage.Skill_pack.S_119");
//        Fabric_skill_add("MVCPackage.Skill_pack.S_124");
        Player player_1 = new Player("Hero");
        Player player_2 = new Player("Monster");
        Console console = new Console();
        String player_1_move, player_2_move;
        int round = 1;
        String message = "";
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("Skills.properties");
            properties.load(in);
            for (; round <= 30; round++) {
                if ((player_1.get_Heal_Point(round) <= 0)||(player_2.get_Heal_Point(round) <= 0)) break;
                while(true) {
                    console.print_message("Введите свой ход:");
                    player_1_move = console.get_in();
                    player_1_move = (String) properties.get(player_1_move);
                    if (player_1_move != null) break;
                }
                if (round % 9 == 0) player_2_move = "MVCPackage.Skill_pack.S_19";
                else player_2_move = "MVCPackage.Skill_pack.S_1" + round % 9;
                message = Processing(player_1, player_2, round, player_1_move, player_2_move);
                console.print_result_round(player_1, player_2, round + 1, message);
            }
            if (round == 31) {
                if (player_1.get_Heal_Point(round) + player_1.get_Mana_Point(round) > player_2.get_Heal_Point(round) + player_2.get_Mana_Point(round)) console.print_result("You Win!");
                if (player_1.get_Heal_Point(round) + player_1.get_Mana_Point(round) < player_2.get_Heal_Point(round) + player_2.get_Mana_Point(round)) console.print_result("You Lose...");
                if (player_1.get_Heal_Point(round) + player_1.get_Mana_Point(round) == player_2.get_Heal_Point(round) + player_2.get_Mana_Point(round)) console.print_result("Draw");
            }
            else {
                if ((player_1.get_Heal_Point(round) <= 0)&&(player_2.get_Heal_Point(round) <= 0)) console.print_result("Draw");
                else {
                    if (player_1.get_Heal_Point(round) <= 0) console.print_result("You Lose...");
                    if (player_2.get_Heal_Point(round) <= 0) console.print_result("You Win!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void begin_two_players() {
        Fabric_skill_add("MVCPackage.Skill_pack.S_11");
//        Fabric_skill_add("MVCPackage.Skill_pack.S_112");
//        Fabric_skill_add("MVCPackage.Skill_pack.S_119");
//        Fabric_skill_add("MVCPackage.Skill_pack.S_124");
        Player player_1 = new Player("Red");
        Player player_2 = new Player("Blue");
        Console console = new Console();
        String player_1_move, player_2_move;
        int round = 1;
        String message = "";
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("Skills.properties");
            properties.load(in);
            for (; round <= 30; round++) {
                if ((player_1.get_Heal_Point(round) <= 0)||(player_2.get_Heal_Point(round) <= 0)) break;
                while(true) {
                    console.print_message("Игрок " + player_1.get_Player_Name() + " введите свой ход:");
                    player_1_move = console.get_in();
                    player_1_move = (String) properties.get(player_1_move);
                    if (player_1_move != null) break;
                }
                while(true) {
                    console.print_message("Игрок " + player_2.get_Player_Name() + " введите свой ход:");
                    player_2_move = console.get_in();
                    player_2_move = (String) properties.get(player_2_move);
                    if (player_2_move != null) break;
                }
                message = Processing(player_1, player_2, round, player_1_move, player_2_move);
                console.print_result_round(player_1, player_2, round + 1, message);
            }
            if (round == 31) {
                if (player_1.get_Heal_Point(round) + player_1.get_Mana_Point(round) > player_2.get_Heal_Point(round) + player_2.get_Mana_Point(round)) console.print_result(player_1.get_Player_Name() + " Win!");
                if (player_1.get_Heal_Point(round) + player_1.get_Mana_Point(round) < player_2.get_Heal_Point(round) + player_2.get_Mana_Point(round)) console.print_result(player_2.get_Player_Name() + " Win!");
                if (player_1.get_Heal_Point(round) + player_1.get_Mana_Point(round) == player_2.get_Heal_Point(round) + player_2.get_Mana_Point(round)) console.print_result("Draw");
            }
            else {
                if ((player_1.get_Heal_Point(round) <= 0)&&(player_2.get_Heal_Point(round) <= 0)) console.print_result("Draw");
                else {
                    if (player_1.get_Heal_Point(round) <= 0) console.print_result(player_2.get_Player_Name() + " Win!");
                    if (player_2.get_Heal_Point(round) <= 0) console.print_result(player_1.get_Player_Name() + " Win!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void begin_server() {
        Fabric_skill_add("MVCPackage.Skill_pack.S_11");
//        Fabric_skill_add("MVCPackage.Skill_pack.S_112");
//        Fabric_skill_add("MVCPackage.Skill_pack.S_119");
//        Fabric_skill_add("MVCPackage.Skill_pack.S_124");
        Player player_1 = new Player("Host");
        Player player_2 = new Player("Guest");
        Console console = new Console();
        String player_1_move, player_2_move;
        int round = 1;
        String message;
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("Skills.properties");
            properties.load(in);
            ServerSocket serverSocket = new ServerSocket(7777);
            console.print_message("Ожидание второго игрока...");
            Socket socket_server = serverSocket.accept();
            InputStream inputStream = socket_server.getInputStream();
            OutputStream outputStream = socket_server.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("Подключение...");
            for (; round <= 30; round++) {
                if ((player_1.get_Heal_Point(round) <= 0)||(player_2.get_Heal_Point(round) <= 0)) {
                    dataOutputStream.writeUTF("break");
                    break;
                }
                else {
                    dataOutputStream.writeUTF("continue");
                }
                dataOutputStream.writeUTF("Ожидание хода противника...");
                console.print_message(player_1.get_Player_Name() + " введите свой ход:");
                while(true) {
                    player_1_move = console.get_in();
                    player_1_move = (String) properties.get(player_1_move);
                    if (player_1_move != null) {
                        dataOutputStream.writeUTF("break");
                        break;
                    }
                    else {
                        dataOutputStream.writeUTF("continue");
                    }
                }
                console.print_message("Ожидание хода противника...");
                dataOutputStream.writeUTF(player_2.get_Player_Name() + " введите свой ход:");
                while(true) {
                    player_2_move = dataInputStream.readUTF();
                    player_2_move = (String) properties.get(player_2_move);
                    if (player_2_move != null) {
                        dataOutputStream.writeUTF("break");
                        break;
                    }
                    else {
                        dataOutputStream.writeUTF("continue");
                    }
                }
                message = Processing(player_1, player_2, round, player_1_move, player_2_move);
                console.print_result_round(player_1, player_2, round + 1, message);
                dataOutputStream.writeUTF(console.result_round(player_1, player_2, round + 1, message));
            }
            if (round == 31) {
                if (player_1.get_Heal_Point(round) + player_1.get_Mana_Point(round) > player_2.get_Heal_Point(round) + player_2.get_Mana_Point(round)) {
                    console.print_result(player_1.get_Player_Name() + " Win!");
                    dataOutputStream.writeUTF(player_1.get_Player_Name() + " Win!");
                }
                if (player_1.get_Heal_Point(round) + player_1.get_Mana_Point(round) < player_2.get_Heal_Point(round) + player_2.get_Mana_Point(round)) {
                    console.print_result(player_2.get_Player_Name() + " Win!");
                    dataOutputStream.writeUTF(player_2.get_Player_Name() + " Win!");
                }
                if (player_1.get_Heal_Point(round) + player_1.get_Mana_Point(round) == player_2.get_Heal_Point(round) + player_2.get_Mana_Point(round)) {
                    console.print_result("Draw");
                    dataOutputStream.writeUTF("Draw");
                }
            }
            else {
                if ((player_1.get_Heal_Point(round) <= 0)&&(player_2.get_Heal_Point(round) <= 0)) {
                    console.print_result("Draw");
                    dataOutputStream.writeUTF("Draw");
                }
                else {
                    if (player_1.get_Heal_Point(round) <= 0) {
                        console.print_result(player_2.get_Player_Name() + " Win!");
                        dataOutputStream.writeUTF(player_2.get_Player_Name() + " Win!");
                    }
                    if (player_2.get_Heal_Point(round) <= 0) {
                        console.print_result(player_1.get_Player_Name() + " Win!");
                        dataOutputStream.writeUTF(player_1.get_Player_Name() + " Win!");
                    }
                }
            }
            dataInputStream.close();
            dataOutputStream.close();
            inputStream.close();
            outputStream.close();
            socket_server.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void begin_client() {
        Console console = new Console();
        int round = 1;
        try {
            Socket socket_client = new Socket("localhost",7777);
            InputStream inputStream = socket_client.getInputStream();
            OutputStream outputStream = socket_client.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            console.print_message(dataInputStream.readUTF());
            for (; round <= 30; round++) {
                if (dataInputStream.readUTF().equals("break")) break;
                console.print_message(dataInputStream.readUTF());
                while (true) {
                    if (dataInputStream.readUTF().equals("break")) break;
                }
                console.print_message(dataInputStream.readUTF());
                while (true) {
                    dataOutputStream.writeUTF(console.get_in());
                    if (dataInputStream.readUTF().equals("break")) break;
                }
                console.print_message(dataInputStream.readUTF());
            }
            console.print_result(dataInputStream.readUTF());
            dataInputStream.close();
            dataOutputStream.close();
            inputStream.close();
            outputStream.close();
            socket_client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String Processing(Player player_1, Player player_2, int round, String player_1_move_in, String player_2_move_in) {
        String message_out;
        int Damage;
        if (Fabric_skill_get_priority(player_1_move_in) >= Fabric_skill_get_priority(player_2_move_in)) {
            Fabric_skill_cast(player_1_move_in, player_1, player_2, round);
            Fabric_skill_cast(player_2_move_in, player_2, player_1, round);
            message_out = Fabric_skill_get_message(player_1_move_in, player_1.get_Player_Name()) + "\n" + Fabric_skill_get_message(player_2_move_in, player_2.get_Player_Name());
        }else {
            Fabric_skill_cast(player_2_move_in, player_2, player_1, round);
            Fabric_skill_cast(player_1_move_in, player_1, player_2, round);
            message_out = Fabric_skill_get_message(player_2_move_in, player_2.get_Player_Name()) + "\n" + Fabric_skill_get_message(player_1_move_in, player_1.get_Player_Name());
        }
        player_1.set_Mana_Point(round + 1, player_1.get_Mana_Point(round) + player_1.get_Mana_Point_regeneration(round) + player_1.get_Mana_Point_recovery(round) - player_1.get_Mana_cost(round) - player_1.get_Mana_Point_loss(round));
        Damage = player_1.get_Armor(round) - player_1.get_Damage(round) - player_1.get_Damage_over_time(round);
        if (Damage > 0) Damage = 0;
        if (player_1.get_Mana_Point(round + 1) < 0) Damage = Damage + 2 * player_1.get_Mana_Point(round + 1);
        player_1.set_Heal_Point(round + 1, player_1.get_Heal_Point(round) + Damage + player_1.get_Heal_Point_recovery(round));
        player_2.set_Mana_Point(round + 1, player_2.get_Mana_Point(round) + player_2.get_Mana_Point_regeneration(round) + player_2.get_Mana_Point_recovery(round) - player_2.get_Mana_cost(round) - player_2.get_Mana_Point_loss(round));
        Damage = player_2.get_Armor(round) - player_2.get_Damage(round) - player_2.get_Damage_over_time(round);
        if (Damage > 0) Damage = 0;
        if (player_2.get_Mana_Point(round + 1) < 0) Damage = Damage + 2 * player_2.get_Mana_Point(round + 1);
        player_2.set_Heal_Point(round + 1, player_2.get_Heal_Point(round) + Damage + player_2.get_Heal_Point_recovery(round));
        if (player_1.get_Heal_Point(round + 1) > player_1.get_Heal_Point_Max()) player_1.set_Heal_Point(round + 1, player_1.get_Heal_Point_Max());
        if (player_1.get_Mana_Point(round + 1) > player_1.get_Mana_Point_Max()) player_1.set_Mana_Point(round + 1, player_1.get_Mana_Point_Max());
        if (player_2.get_Heal_Point(round + 1) > player_2.get_Heal_Point_Max()) player_2.set_Heal_Point(round + 1, player_2.get_Heal_Point_Max());
        if (player_2.get_Mana_Point(round + 1) > player_2.get_Mana_Point_Max()) player_2.set_Mana_Point(round + 1, player_2.get_Mana_Point_Max());
        return message_out;
    }
    private void Fabric_skill_add(String str) {
        try {
            Skill skill = Skills_HashMap.get(str);
            if (skill == null) {
                Class<?> class_operate = Class.forName(str);
                Constructor<?> constructor_operate = class_operate.getConstructor();
                skill = (Skill) constructor_operate.newInstance();
                Skills_HashMap.put(str, skill);
            }
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private void Fabric_skill_cast(String str, Player user, Player enemy, int round) {
        try {
            Skill skill = Skills_HashMap.get(str);
            if (skill == null) {
                Class<?> class_operate = Class.forName(str);
                Constructor<?> constructor_operate = class_operate.getConstructor();
                skill = (Skill) constructor_operate.newInstance();
                Skills_HashMap.put(str, skill);
            }
            skill.cast(user, enemy, round);
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private int Fabric_skill_get_priority(String str) {
        try {
            Skill skill = Skills_HashMap.get(str);
            if (skill == null) {
                Class<?> class_operate = Class.forName(str);
                Constructor<?> constructor_operate = class_operate.getConstructor();
                skill = (Skill) constructor_operate.newInstance();
                Skills_HashMap.put(str, skill);
            }
            return skill.get_priority();
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return -999;
    }
    private String Fabric_skill_get_message(String str, String Player_Name_in) {
        try {
            Skill skill = Skills_HashMap.get(str);
            if (skill == null) {
                Class<?> class_operate = Class.forName(str);
                Constructor<?> constructor_operate = class_operate.getConstructor();
                skill = (Skill) constructor_operate.newInstance();
                Skills_HashMap.put(str, skill);
            }
            return skill.get_message(Player_Name_in);
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "-999";
    }
}