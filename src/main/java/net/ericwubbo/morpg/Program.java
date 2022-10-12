package net.ericwubbo.morpg;

public class Program {
    public static void main(String[] args) {
        Being player = new Player("Carl", 50, new Weapon("sword", 6));
        Being orc = new Creature("orc", 20, new Weapon("axe", 3));
        do {
            if (player.isAlive()) player.hit(orc);
            if (orc.isAlive()) orc.hit(player);
        } while (player.isAlive() && orc.isAlive());
        var survivor = player.isAlive() ? player : orc;
        World.message(survivor.getName() + " has been victorious!");
    }
}
