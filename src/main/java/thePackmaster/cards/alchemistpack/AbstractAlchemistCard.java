package thePackmaster.cards.alchemistpack;

import thePackmaster.ThePackmaster;
import thePackmaster.cards.AbstractPackmasterCard;

public abstract class AbstractAlchemistCard extends AbstractPackmasterCard
{
    public AbstractAlchemistCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target, CardColor color) {
        super(cardID, cost, type, rarity, target, color, "alchemist");

    }

    public AbstractAlchemistCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target) {
        this (cardID, cost, type, rarity, target, ThePackmaster.Enums.PACKMASTER_RAINBOW);
    }
}
