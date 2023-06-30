package thePackmaster.cards.alchemistpack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.potions.alchemistpack.GrenadePotion;
import thePackmaster.powers.alchemistpack.AnarchyPower;
import thePackmaster.powers.alchemistpack.ChemistryPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Anarchy extends AbstractAlchemistCard {
    public final static String ID = makeID(Anarchy.class.getSimpleName());

    public Anarchy() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new AnarchyPower(p, magicNumber), magicNumber));
        for (int i = 0; i < p.potionSlots + magicNumber; i++) {
            addToBot(new ObtainPotionAction(new GrenadePotion()));
            addToBot(new AbstractGameAction() {
                public void update() { p.adjustPotionPositions(); isDone = true; }
            });
        }
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}


