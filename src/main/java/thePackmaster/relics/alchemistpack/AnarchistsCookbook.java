package thePackmaster.relics.alchemistpack;

import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.packs.AlchemistPack;
import thePackmaster.potions.alchemistpack.GrenadePotion;
import thePackmaster.relics.AbstractPackmasterRelic;

public class AnarchistsCookbook extends AbstractPackmasterRelic {
    public static final String ID = SpireAnniversary5Mod.makeID(AnarchistsCookbook.class.getSimpleName());

    public AnarchistsCookbook() {
        super(ID, RelicTier.COMMON, LandingSound.FLAT, AlchemistPack.ID);
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public void atBattleStart() {
        addToBot(new ObtainPotionAction(new GrenadePotion()));
    }
}
