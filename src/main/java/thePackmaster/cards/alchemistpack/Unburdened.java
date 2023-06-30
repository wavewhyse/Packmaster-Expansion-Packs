package thePackmaster.cards.alchemistpack;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.potions.PotionSlot;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Unburdened extends AbstractAlchemistCard {
    public final static String ID = makeID(Unburdened.class.getSimpleName());

    public Unburdened() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (AbstractPotion potion : p.potions)
            if (potion instanceof PotionSlot)
                blck();
    }

    @Override
    public void upp() {
        upgradeBlock(1);
    }
}


