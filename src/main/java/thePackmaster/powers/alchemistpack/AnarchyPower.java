package thePackmaster.powers.alchemistpack;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.potions.PotionSlot;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rewards.RewardItem;
import thePackmaster.actions.alchemistpack.AddPotionSlotAction;
import thePackmaster.powers.AbstractPackmasterPower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class AnarchyPower extends AbstractPackmasterPower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID(AnarchyPower.class.getSimpleName());
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;


    public AnarchyPower(AbstractCreature owner, int amount) {
        super(POWER_ID, NAME, PowerType.BUFF, false, owner, amount);
    }

    @Override
    public void onInitialApplication() {
        addToTop(new AddPotionSlotAction(amount));
    }

    @Override
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        addToTop(new AddPotionSlotAction(stackAmount));
    }

    private void removeSlots() {
        AbstractPlayer p = Wiz.adp();
        p.potionSlots -= amount;
        /*
            A case where arrays starting at 0 SUCKS and IS CONFUSING
            Okay so, this starts at the *last index* of the potions arraylist: size - 1.
            It decrements until it is at the index equal to the *new* size that
            the array SHOULD be. And it removes that, leaving all indices intact
            from 0 through the new size minus 1; which is correct.
            Why the FDUCK is potionSlots not just equal to potions.size() anyway i hate this
            NOTE: none of this comment is relevant anymore but i am keeping it regardless
        */
        if (p.potions.size() > p.potionSlots) {
            for (int i = p.potionSlots; i < p.potions.size(); i++)
                if (!(p.potions.get(i) instanceof PotionSlot)) {
                    RewardItem salvage = new RewardItem(p.potions.get(i));
                    salvage.text += DESCRIPTIONS[2];
                    AbstractDungeon.getCurrRoom().rewards.add(salvage);
                }
            p.potions.subList(p.potionSlots, p.potions.size()).clear();
        }
    }

    @Override
    public void onVictory() {
        removeSlots();
    }

    @Override
    public void onRemove() {
        removeSlots();
    }

    @Override
    public void updateDescription() {
        if (amount == 1)
            description = String.format(DESCRIPTIONS[0], amount);
        else
            description = String.format(DESCRIPTIONS[1], amount);
    }

    @Override
    public AbstractPower makeCopy() {
        return new AnarchyPower(owner, amount);
    }
}




