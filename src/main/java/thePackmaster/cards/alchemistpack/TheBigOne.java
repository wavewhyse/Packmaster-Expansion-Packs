package thePackmaster.cards.alchemistpack;

import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.potions.alchemistpack.MiniNukePotion;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class TheBigOne extends AbstractAlchemistCard {
    public final static String ID = makeID(TheBigOne.class.getSimpleName());

    public TheBigOne() {
        super(ID, 3, CardType.SKILL, CardRarity.RARE, CardTarget.NONE);
        exhaust = true;
        isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ObtainPotionAction(new MiniNukePotion()));
    }

    @Override
    public void upp() {
        isEthereal = false;
        rawDescription = cardStrings.UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}


