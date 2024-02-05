package net.ericwubbo.morpg.creature;

import net.ericwubbo.morpg.Weapon;

public class Zombie extends Creature {
    private static final String species = "zombie";

    public Zombie() {
        super(species, 30, new Weapon("hands", 2));
    }

    public Zombie(String name) {
        super(name, 30, new Weapon("hands", 2));
    }

    public static Zombie create(int number) {
        if (number == 0) return new Zombie();
        return new Zombie(species + " " + number);
    }

    @Override
    public String getSpecies() {
        return species;
    }
}
