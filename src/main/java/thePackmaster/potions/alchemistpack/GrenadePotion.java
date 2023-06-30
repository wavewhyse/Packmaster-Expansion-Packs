package thePackmaster.potions.alchemistpack;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.vfx.combat.ExplosionSmallEffect;
import thePackmaster.ExpansionPacks;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.packs.AlchemistPack;
import thePackmaster.util.Wiz;

public class GrenadePotion extends AbstractPotion {
    public static final String POTION_ID = SpireAnniversary5Mod.makeID(GrenadePotion.class.getSimpleName());
    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);

    public GrenadePotion() {
        super(potionStrings.NAME,
                POTION_ID,
                ExpansionPacks.Enums.ALCHEMIST_BOMB,
                AbstractPotion.PotionSize.SPHERE,
                AbstractPotion.PotionEffect.NONE,
                Color.BLACK,
                Color.RED,
                Color.BLACK);
    }

    @Override
    public void initializeData() {
        potency = getPotency();

        description = String.format(potionStrings.DESCRIPTIONS[0], potency);

        isThrown = true;
        targetRequired = true;

        tips.clear();
        tips.add(new PowerTip(name, description));
    }

    @Override
    public void use(AbstractCreature target) {
        addToBot(new VFXAction(new ExplosionSmallEffect(target.hb.cX, target.hb.cY), 0.1F));
        DamageInfo info = new DamageInfo(Wiz.adp(), potency, DamageInfo.DamageType.THORNS);
        info.applyEnemyPowersOnly(target);
        addToBot(new DamageAction(target, info, AbstractGameAction.AttackEffect.FIRE));
    }

    @Override
    public AbstractPotion makeCopy() {
        return new GrenadePotion();
    }

    @Override
    public int getPotency(final int ascensionLevel) {
        return 10;
    }
}
