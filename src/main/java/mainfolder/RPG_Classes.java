package mainfolder;

import mainfolder.registry.ModifiedRPGClasses;
import mainfolder.registry.NewAbilities;
import mainfolder.registry.NewRPGClasses;
import necesse.engine.modLoader.annotations.ModEntry;


@ModEntry
public class RPG_Classes {

    public void init() {
        NewAbilities.registerCore();
        NewRPGClasses.registerCore();
        ModifiedRPGClasses.init();
    }

}
