package mainfolder.buffs.abilities;

import necesse.engine.modifiers.ModifierValue;
import necesse.entity.mobs.MobWasHitEvent;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.BuffModifiers;
import rpgclasses.buffs.SimpleClassBuff;
import rpgclasses.buffs.SimpleClassChargeBuff;

public class ReduceDamageBuff extends SimpleClassBuff {
    public int abilityLevel;

    public ReduceDamageBuff(int abilityLevel) {
        super();
        this.abilityLevel = abilityLevel;
    }

    public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {
    }


    @Override
    public void onWasHit(ActiveBuff buff, MobWasHitEvent event) {
        if (event != null && !event.wasPrevented && event.damage > 0) {
            buff.owner.buffManager.addBuff(new ActiveBuff("reducedamagecharge_" + this.abilityLevel, buff.owner, 5.0F, null), false);
        }
    }

    public static class ReduceDamageChargeBuff extends SimpleClassChargeBuff {
        public int abilityLevel;

        public ReduceDamageChargeBuff(int abilityLevel) {
            super(new ModifierValue<>(BuffModifiers.INCOMING_DAMAGE_MOD, 0.9F));
            this.abilityLevel = abilityLevel;
        }

        public int getStackSize(ActiveBuff buff) {
            return (int)Math.pow(2.0, this.abilityLevel + 1);
        }
    }
}
