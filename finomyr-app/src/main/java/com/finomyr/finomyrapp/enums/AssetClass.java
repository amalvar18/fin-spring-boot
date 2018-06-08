package com.finomyr.finomyrapp.enums;

public enum AssetClass {

    EQUITY("Equity"),

    DEBT("Debt"),

    CORPORATE_DEPOSIT("Corporate Deposit"),

    REAL_ESTATE("Real Estate"),

    COMMODITY("Commodity");

    private String assetClassPhrase;

    private AssetClass(String assetClassPhrase) {
        this.assetClassPhrase = assetClassPhrase;
    }

    public String getAssetClassPhrase() {
        return this.assetClassPhrase;
    }

    /*public void setAssetClassPhrase(String assetClassPhrase) {
        this.assetClassPhrase = assetClassPhrase;
    }*/
}
