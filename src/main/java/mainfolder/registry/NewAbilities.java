package mainfolder.registry;

import mainfolder.buffs.abilities.ReduceDamageBuff;
import mainfolder.buffs.principal_abilities.BastionBuff;
import mainfolder.buffs.principal_abilities.TankBuff;
import necesse.engine.modifiers.ModifierValue;
import necesse.entity.mobs.buffs.BuffModifiers;
import rpgclasses.base.Ability;
import rpgclasses.buffs.SimpleClassBuff;
import rpgclasses.registry.AbilityRegistry;

import static necesse.engine.registries.BuffRegistry.registerBuff;

public final class NewAbilities {

    public static void registerCore() {
        registerPrincipalAbilities();
        registerBasicAbilities();
        registerAbilities();
    }

    public static void registerPrincipalAbilities() {
        // Register the "tank" principal ability and its buff
        AbilityRegistry.registerAbility(new Ability("tank", 1, 3));
        registerBuff("tank_0", new TankBuff());

        // Register the "bastion" principal ability, and its buff and charge buff
        AbilityRegistry.registerAbility(new Ability("bastion", 1, 3));
        registerBuff("bastion_0", new BastionBuff());
        registerBuff("bastioncharge_0", new BastionBuff.BastionChargeBuff());
    }

    public static void registerBasicAbilities() {
        // Register the "morehealth" ability with 6 levels and its 6 buffs, one for each level. Each one cost 1 talent point
        AbilityRegistry.registerAbility(new Ability("morehealth", 6, 1));
        registerBuff("morehealth_0", new SimpleClassBuff(new ModifierValue<>(BuffModifiers.MAX_HEALTH_FLAT, 5)));
        registerBuff("morehealth_1", new SimpleClassBuff(new ModifierValue<>(BuffModifiers.MAX_HEALTH_FLAT, 10)));
        registerBuff("morehealth_2", new SimpleClassBuff(new ModifierValue<>(BuffModifiers.MAX_HEALTH_FLAT, 15)));
        registerBuff("morehealth_3", new SimpleClassBuff(new ModifierValue<>(BuffModifiers.MAX_HEALTH_FLAT, 20)));
        registerBuff("morehealth_4", new SimpleClassBuff(new ModifierValue<>(BuffModifiers.MAX_HEALTH_FLAT, 30)));
        registerBuff("morehealth_5", new SimpleClassBuff(new ModifierValue<>(BuffModifiers.MAX_HEALTH_FLAT, 40)));
    }

    public static void registerAbilities() {
        // Register the "fighterability" ability with only 1 level that cost 5 talent points, and its buff
        AbilityRegistry.registerAbility(new Ability("fighterability", 1, 5));
        registerBuff("fighterability_0", new SimpleClassBuff(new ModifierValue<>(BuffModifiers.KNOCKBACK_OUT, 1F)));

        // Register the "reducedamage" ability with 3 levels and its 3 buffs, one for each level and the 3 charge buffs. First and second levels cost 1 Talent Point, the third level cost 2 Talent Points
        AbilityRegistry.registerAbility(new Ability("reducedamage", 3, 1, 1, 2));
        AbilityRegistry.registerBuffs("reducedamage", ReduceDamageBuff.class, 3);
        AbilityRegistry.registerBuffs("reducedamagecharge", ReduceDamageBuff.ReduceDamageChargeBuff.class, 3);

    }
}
