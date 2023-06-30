package thePackmaster.actions.alchemistpack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.potions.PotionSlot;
import thePackmaster.util.Wiz;

public class AddPotionSlotAction extends AbstractGameAction {
    public AddPotionSlotAction(int amount) {
        this.amount = amount;
    }

    @Override
    public void update() {
        Wiz.adp().potionSlots += amount;
        for (int i = 0; i < amount; i++) {
            Wiz.adp().potions.add(new PotionSlot(Wiz.adp().potionSlots - 1 - i));
        }
        isDone = true;
    }
}
