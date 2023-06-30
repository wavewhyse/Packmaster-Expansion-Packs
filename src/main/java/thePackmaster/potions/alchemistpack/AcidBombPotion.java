package thePackmaster.potions.alchemistpack;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import thePackmaster.ExpansionPacks;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.packs.AlchemistPack;
import thePackmaster.util.Wiz;

public class AcidBombPotion extends AbstractPotion {
    public static final String POTION_ID = SpireAnniversary5Mod.makeID(AcidBombPotion.class.getSimpleName());
    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);

    public AcidBombPotion() {
        super(potionStrings.NAME,
                POTION_ID,
                ExpansionPacks.Enums.ALCHEMIST_BOMB,
                PotionSize.FAIRY,
                PotionEffect.OSCILLATE,
                Color.BLUE,
                Color.WHITE,
                Color.YELLOW);
    }

    @Override
    public void initializeData() {
        potency = getPotency();

        description = String.format(potionStrings.DESCRIPTIONS[0], potency, potency/2);

        isThrown = true;
        targetRequired = true;

        tips.clear();
        tips.add(new PowerTip(name, description));
    }

    @Override
    public void use(AbstractCreature target) {
//        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
//            if (!m.isDeadOrEscaped())
//                addToBot(new VFXAction(new ExplosionSmallEffect(m.hb.cX, m.hb.cY), 0.1F));
//        }
//        addToBot(new WaitAction(0.5F));

        for (AbstractMonster m: AbstractDungeon.getMonsters().monsters) {
            if (m.isDeadOrEscaped()) continue;
            DamageInfo damage = new DamageInfo(Wiz.adp(), m == target ? potency : potency / 2, DamageInfo.DamageType.THORNS);
            damage.applyEnemyPowersOnly(m);
            addToBot(new DamageAction(m, damage, AbstractGameAction.AttackEffect.POISON));
        }
    }

    @Override
    public AbstractPotion makeCopy() {
        return new AcidBombPotion();
    }

    @Override
    public int getPotency(final int ascensionLevel) {
        return 20;
    }
}
