package mainfolder.classes;

import rpgclasses.base.AbilityRequirements;
import rpgclasses.base.RPGClass;

public class Example extends RPGClass {
    public Example() {
        super("example");

        // Add the principal abilities to the class
        this.addPrincipalAbility("tank", new AbilityRequirements());
        this.addPrincipalAbility("bastion", new AbilityRequirements());

        // Add the basic ability "morehealth" to the clas with 6 levels
        this.addAbilityLevelSet("morehealth", 6, new AbilityRequirements());

        // Add "reducedamage" ability to the class with 3 levels. First level require an affinity of 5, the second one of 8 and the third one of 12
        this.addAbility("reducedamage", 0, (new AbilityRequirements()).setAffinity(5));
        this.addAbility("reducedamage", 1, (new AbilityRequirements()).setAffinity(8));
        this.addAbility("reducedamage", 2, (new AbilityRequirements()).setAffinity(12));
    }
}
