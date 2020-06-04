package MVCPackage;

import MVCPackage.Controller_pack.Squirrel;

public class Main {
    public static void main(String[] args) {
        Squirrel squirrel = new Squirrel();
        squirrel.begin_server();
    }
}
