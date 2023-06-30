package thePackmaster.cards.alchemistpack;

import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.EasyXCostAction;
import thePackmaster.potions.alchemistpack.BottledWillPotion;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class BottleWill extends AbstractAlchemistCard {
    public final static String ID = makeID(BottleWill.class.getSimpleName());

    public BottleWill() {
        super(ID, -1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new EasyXCostAction(this, (enrg, params) -> {
            addToTop(new ObtainPotionAction(new BottledWillPotion(enrg + params[0])));
            return true;
        }, upgraded ? 1 : 0));
    }

    @Override
    public void upp() {
    }
}


