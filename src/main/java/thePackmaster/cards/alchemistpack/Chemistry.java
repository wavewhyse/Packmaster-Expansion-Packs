package thePackmaster.cards.alchemistpack;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.alchemistpack.ChemistryPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Chemistry extends AbstractAlchemistCard {
    public final static String ID = makeID(Chemistry.class.getSimpleName());

    public Chemistry() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new ChemistryPower(p, magicNumber), magicNumber));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}


