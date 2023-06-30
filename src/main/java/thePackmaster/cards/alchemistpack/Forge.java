package thePackmaster.cards.alchemistpack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.potions.BlessingOfTheForge;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Forge extends AbstractAlchemistCard {
    public final static String ID = makeID(Forge.class.getSimpleName());

    public Forge() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 12;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        addToBot(new ObtainPotionAction(new BlessingOfTheForge()));
    }

    @Override
    public void upp() {
        upgradeDamage(6);
    }
}


