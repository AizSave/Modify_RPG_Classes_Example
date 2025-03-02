package mainfolder.buffs.principal_abilities;

import necesse.engine.modifiers.ModifierValue;
import necesse.entity.mobs.buffs.BuffModifiers;
import rpgclasses.buffs.SimpleClassBuff;

public class TankBuff extends SimpleClassBuff {
    public TankBuff() {
        super(
                new ModifierValue<>(BuffModifiers.ARMOR, 1F),
                new ModifierValue<>(BuffModifiers.SPEED, -0.5F)
        );
    }
}
