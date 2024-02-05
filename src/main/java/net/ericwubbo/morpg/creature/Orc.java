package net.ericwubbo.morpg.creature;

import net.ericwubbo.morpg.Being;
import net.ericwubbo.morpg.Weapon;
import net.ericwubbo.morpg.World;

public class Orc extends Creature {
    int maxHitPoints;
    private static final String species = "orc";

    public Orc(String name) {
        super(name, 20, new Weapon("axe", 3));
    }

    public Orc() {
        this(species);
        maxHitPoints = hitPoints;
    }

    public Orc(int number) {
        this(species + " " + number);
        maxHitPoints = hitPoints;
    }

    public static Orc create(int number) {
        if (number == 0) return new Orc();
        else return new Orc(number);
    }

    private boolean isEnraged() {
        return hitPoints <= maxHitPoints * 0.3;
    }

    @Override
    protected int getDamage() {
        int damage = super.getDamage();
        if (isEnraged()) damage *= 2;
        return damage;
    }

    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public String getDefiniteName() {
        String enragedText = isEnraged() ? "enraged " : "";
        if (isNamed()) return enragedText + name;
        return "the " + enragedText + "orc";
    }

    @Override
    public String getIndefiniteName() {
        String enragedText = isEnraged() ? "enraged " : "";
        if (isNamed()) return enragedText + name;
        return "an " + enragedText + "orc";
    }

    @Override
    protected void updateStatus(int damage, Being enemy) {
        boolean startsEnraged = isEnraged();
        String preEnrageName = getName();
        hitPoints -= damage;

        World.message(preEnrageName + " gets hit by " + enemy.getName() + " and drops to " + hitPoints + " hit points!");
        boolean endsEnraged = isEnraged();
        if (startsEnraged != endsEnraged) World.message(preEnrageName + " enrages!");
    }
}
