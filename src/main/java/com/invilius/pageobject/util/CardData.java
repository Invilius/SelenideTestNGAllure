package com.invilius.pageobject.util;


import io.qameta.allure.Step;

public class CardData {
    private String cardName;
    private String cardDescription;

    public CardData(String cardName, String cardDescription) {
        this.cardDescription=cardDescription;
        this.cardName=cardName;
    }

    @Step
    public String getCardName() {
        return this.cardName;
    }

    @Step
    public String getCardDescription() {
        return this.cardDescription;
    }



}
