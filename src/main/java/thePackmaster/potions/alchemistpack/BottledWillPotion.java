package thePackmaster.potions.alchemistpack;

import basemod.abstracts.CustomSavable;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import thePackmaster.ExpansionPacks;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.packs.AlchemistPack;

public class BottledWillPotion extends AbstractPotion implements CustomSavable<Integer> {
    public static final String POTION_ID = SpireAnniversary5Mod.makeID(BottledWillPotion.class.getSimpleName());
    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);

    private int energy;

    public BottledWillPotion() {
        this(1);
        initializeData();
    }

    public BottledWillPotion(int energy) {
        super(potionStrings.NAME,
                POTION_ID,
                ExpansionPacks.Enums.ALCHEMIST_BOMB,
                PotionSize.BOLT,
                PotionColor.ENERGY);
        this.energy = energy;
        initializeData();
    }

    @Override
    public void initializeData() {
        potency = getPotency();

        description = String.format(potionStrings.DESCRIPTIONS[0], potency);

        isThrown = false;

        tips.clear();
        tips.add(new PowerTip(name, description));
    }

    @Override
    public void use(AbstractCreature target) {
        addToBot(new GainEnergyAction(potency));
    }

    @Override
    public AbstractPotion makeCopy() {
        return new BottledWillPotion(energy);
    }

    @Override
    public int getPotency(final int ascensionLevel) {
        return energy;
    }

    @Override
    public Integer onSave() {
        return energy;
    }

    @Override
    public void onLoad(Integer i) {
        energy = i;
        initializeData();
    }
}
