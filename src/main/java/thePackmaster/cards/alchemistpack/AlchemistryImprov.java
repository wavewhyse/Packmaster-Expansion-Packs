package thePackmaster.cards.alchemistpack;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.potions.alchemistpack.AcidBombPotion;
import thePackmaster.powers.alchemistpack.ExtraCompartmentPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class AlchemistryImprov extends AbstractAlchemistCard {
    public final static String ID = makeID(AlchemistryImprov.class.getSimpleName());

    public AlchemistryImprov() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (upgraded)
            addToBot(new ApplyPowerAction(p, p, new ExtraCompartmentPower(p, 1), 1));
        addToBot(new ObtainPotionAction(new AcidBombPotion()));
    }

    @Override
    public void upp() {
        rawDescription = cardStrings.UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}


