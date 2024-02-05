package net.ericwubbo.morpg.creature;

import net.ericwubbo.morpg.Being;
import net.ericwubbo.morpg.Weapon;

public abstract class Creature extends Being {
    protected boolean isGroupMember = false;

    public abstract String getSpecies();

    public Creature(String species, int hitPoints, Weapon weapon) {
        super(species, hitPoints, weapon);
        if (!Character.isLowerCase(species.charAt(0)))
            throw new IllegalArgumentException("The species of a creature should start with a lowercase letter!");
    }

    public void setGroupMember(boolean newStatus) {
        isGroupMember = newStatus;
    }

    public String getName() {
        return isGroupMember ? getIndefiniteName() : getDefiniteName();
    }

    protected boolean isNamed() {
        return name.split(" ").length == 2;
    }

    // returns 'John' or 'the orc'
    @Override
    public String getDefiniteName() {
        if (isNamed()) return name; // a player, like John, will not be named 'the John'
        return "the " + name;
    }

    // returns 'John' or 'an orc'
    @Override
    public String getIndefiniteName() {
        if (isNamed()) return name; // a player, like John, will not be named 'a John'
        String article = "aeiou".contains(name.substring(0, 1)) ? "an" : "a";
        return article + " " + name;
    }
}
