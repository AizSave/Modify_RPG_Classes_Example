package mainfolder.registry;

import mainfolder.classes.Example;
import rpgclasses.base.RPGClass;
import rpgclasses.registry.RPGClassRegistry;

public final class NewRPGClasses {
    public static RPGClass EXAMPLE;

    public static void registerCore() {
        RPGClassRegistry.registerClass(EXAMPLE = new Example());
    }
}
