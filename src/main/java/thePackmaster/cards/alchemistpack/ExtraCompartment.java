package thePackmaster.cards.alchemistpack;

import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.potions.alchemistpack.GrenadePotion;
import thePackmaster.powers.alchemistpack.ExtraCompartmentPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class ExtraCompartment extends AbstractAlchemistCard {
    public final static String ID = makeID(ExtraCompartment.class.getSimpleName());

    public ExtraCompartment() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = 1;
        ExhaustiveVariable.setBaseValue(this, 2);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new ExtraCompartmentPower(p, magicNumber), magicNumber));
        addToBot(new ObtainPotionAction(new GrenadePotion()));
    }

    @Override
    public void upp() {
        ExhaustiveVariable.upgrade(this, 1);
    }
}


