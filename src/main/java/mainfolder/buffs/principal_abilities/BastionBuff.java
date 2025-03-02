package mainfolder.buffs.principal_abilities;

import necesse.engine.modifiers.ModifierValue;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.BuffModifiers;
import rpgclasses.RPG_Classes;
import rpgclasses.buffs.DodgeClassBuff;
import rpgclasses.buffs.SimpleClassBuff;
import rpgclasses.buffs.SimpleClassChargeBuff;

public class BastionBuff extends SimpleClassBuff implements DodgeClassBuff {
    public BastionBuff() {
        super(
                new ModifierValue<>(RPG_Classes.DODGE_CHANCE, 0.4F),
                new ModifierValue<>(BuffModifiers.SPEED, -0.5F)
        );
    }

    public void onDodge(ActiveBuff buff) {
        buff.owner.buffManager.addBuff(new ActiveBuff("bastioncharge", buff.owner, 10.0F, null), true);
    }

    public static class BastionChargeBuff extends SimpleClassChargeBuff {

        public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {
            super.init(buff, eventSubscriber);
            buff.setModifier(BuffModifiers.SPEED, 0.5F);
        }
    }
}
