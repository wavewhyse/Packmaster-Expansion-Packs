package thePackmaster.powers.alchemistpack;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.powers.AbstractPower;
import thePackmaster.powers.AbstractPackmasterPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class ChemistryPower extends AbstractPackmasterPower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID(ChemistryPower.class.getSimpleName());
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public ChemistryPower(AbstractCreature owner, int amount) {
        super(POWER_ID,NAME, PowerType.BUFF, false, owner, amount);
    }

    public void onPotionUse(AbstractPotion pot) {
        addToTop(new DrawCardAction(amount));
    }

    @Override
    public AbstractPower makeCopy() {
        return new ChemistryPower(this.owner, this.amount);
    }

    @Override
    public void updateDescription() {
        if (amount == 1)
            description = String.format(DESCRIPTIONS[0], amount);
        else
            description = String.format(DESCRIPTIONS[1], amount);
    }

}




