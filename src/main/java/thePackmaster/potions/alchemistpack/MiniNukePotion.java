package thePackmaster.potions.alchemistpack;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.vfx.combat.ExplosionSmallEffect;
import thePackmaster.ExpansionPacks;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.packs.AlchemistPack;

public class MiniNukePotion extends AbstractPotion {
    public static final String POTION_ID = SpireAnniversary5Mod.makeID(MiniNukePotion.class.getSimpleName());
    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);

    public MiniNukePotion() {
        super(potionStrings.NAME,
                POTION_ID,
                ExpansionPacks.Enums.ALCHEMIST_BOMB,
                PotionSize.BOTTLE,
                PotionEffect.RAINBOW,
                Color.LIME,
                Color.LIME,
                Color.LIME);
    }

    @Override
    public void initializeData() {
        potency = getPotency();

        description = String.format(potionStrings.DESCRIPTIONS[0], potency, potency/2);

        isThrown = true;

        tips.clear();
        tips.add(new PowerTip(name, description));
    }

    @Override
    public void use(AbstractCreature target) {
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
            if (!m.isDeadOrEscaped())
                addToBot(new VFXAction(new ExplosionSmallEffect(m.hb.cX, m.hb.cY), 0.1F));
        }
        addToBot(new WaitAction(0.5F));

        addToBot(new DamageAllEnemiesAction(null,
                DamageInfo.createDamageMatrix(potency, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.NONE)
        );
    }

    @Override
    public AbstractPotion makeCopy() {
        return new MiniNukePotion();
    }

    @Override
    public int getPotency(final int ascensionLevel) {
        return 30;
    }
}
