package mainfolder.registry;

import rpgclasses.base.AbilityRequirements;
import rpgclasses.registry.RPGClassRegistry;

public final class ModifiedRPGClasses {

    public static void init() {
        // Add the "fighterability" ability only at level 1 to the Figther class
        RPGClassRegistry.FIGHTER.addAbility("fighterability", 1, new AbilityRequirements());
    }

}
