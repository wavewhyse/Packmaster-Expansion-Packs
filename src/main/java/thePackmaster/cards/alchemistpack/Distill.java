package thePackmaster.cards.alchemistpack;

import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.EasyXCostAction;
import thePackmaster.actions.HandSelectAction;
import thePackmaster.potions.alchemistpack.DistilledCardPotion;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Distill extends AbstractAlchemistCard {
    public final static String ID = makeID(Distill.class.getSimpleName());

    public Distill() {
        super(ID, -1, CardType.SKILL, CardRarity.RARE, CardTarget.NONE);
        exhaust = true;
        isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new EasyXCostAction(this, (enrg, params) -> {
            addToTop(new HandSelectAction(1, card -> card.costForTurn <= enrg + params[0] && card.cost != -2 && card.cost != -1, cardList -> {
                AbstractCard c = cardList.get(0);
                addToTop(new ObtainPotionAction(new DistilledCardPotion(c.makeSameInstanceOf())));
                p.hand.moveToExhaustPile(c);
            }, cardStrings.EXTENDED_DESCRIPTION[0]));
            return true;
        }, upgraded? 0 : -1));
    }

    @Override
    public void upp() {
//        rawDescription = cardStrings.UPGRADE_DESCRIPTION;
//        initializeDescription();
    }
}


