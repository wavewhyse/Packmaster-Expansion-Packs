package thePackmaster.packs;

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.alchemistpack.*;

import java.util.ArrayList;

public class AlchemistPack extends AbstractCardPack {
    public static final String ID = SpireAnniversary5Mod.makeID(AlchemistPack.class.getSimpleName());
    private static final UIStrings UI_STRINGS = CardCrawlGame.languagePack.getUIString(ID);
    public static final String NAME = UI_STRINGS.TEXT[0];
    public static final String DESC = UI_STRINGS.TEXT[1];
    public static final String AUTHOR = UI_STRINGS.TEXT[2];

    public AlchemistPack() {
        super(ID, NAME, DESC, AUTHOR, new PackSummary(3, 2, 3, 5, 1, PackSummary.Tags.Exhaust));
    }

    @Override
    public ArrayList<String> getCards() {
        ArrayList<String> cards = new ArrayList<>();
        cards.add(AlchemistryImprov.ID);
        cards.add(Anarchy.ID);
        cards.add(BombLauncher.ID);
        cards.add(BottleWill.ID);
        cards.add(Chemistry.ID);
        cards.add(Distill.ID);
        cards.add(ExtraCompartment.ID);
        cards.add(Forge.ID);
        cards.add(TheBigOne.ID);
        cards.add(Unburdened.ID);
        return cards;
    }
}
