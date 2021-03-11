package com.example.bloonshelper.data;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "upgrade")
public class Upgrade {

    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String upgradeName;
    private int upgradeTier;
    private int upgradeRange;
    private int upgradePierce;
    private int upgradeDamage;
    private boolean upgradeCamoDetect;
    private boolean upgradeLeadPierce;
    private String upgradeSpecialAbility;
    private String upgradeArt;
    private String upgradeIcon;
    @Embedded(prefix = "upgrade")
    private Cost upgradeCost;
    private String baseMonkey;
    private String upgradeDescription;

    public Upgrade(String upgradeName, int upgradeTier, int upgradeRange, int upgradePierce, int upgradeDamage, boolean upgradeCamoDetect, boolean upgradeLeadPierce, String upgradeSpecialAbility, String upgradeArt, String upgradeIcon, Cost upgradeCost, String baseMonkey, String upgradeDescription) {
        this.upgradeName = upgradeName;
        this.upgradeTier = upgradeTier;
        this.upgradeRange = upgradeRange;
        this.upgradePierce = upgradePierce;
        this.upgradeDamage = upgradeDamage;
        this.upgradeCamoDetect = upgradeCamoDetect;
        this.upgradeLeadPierce = upgradeLeadPierce;
        this.upgradeSpecialAbility = upgradeSpecialAbility;
        this.upgradeArt = upgradeArt;
        this.upgradeIcon = upgradeIcon;
        this.upgradeCost = upgradeCost;
        this.baseMonkey = baseMonkey;
        this.upgradeDescription = upgradeDescription;
    }

    public String getBaseMonkey() {
        return baseMonkey;
    }

    public void setBaseMonkey(String baseMonkey) {
        this.baseMonkey = baseMonkey;
    }

    public int getUid() {
        return uid;
    }

    public String getUpgradeDescription() {
        return upgradeDescription;
    }

    public void setUpgradeDescription(String upgradeDescription) {
        this.upgradeDescription = upgradeDescription;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUpgradeName() {
        return upgradeName;
    }

    public void setUpgradeName(String upgradeName) {
        this.upgradeName = upgradeName;
    }

    public int getUpgradeTier() {
        return upgradeTier;
    }

    public void setUpgradeTier(int upgradeTier) {
        this.upgradeTier = upgradeTier;
    }

    public int getUpgradeRange() {
        return upgradeRange;
    }

    public void setUpgradeRange(int upgradeRange) {
        this.upgradeRange = upgradeRange;
    }

    public int getUpgradePierce() {
        return upgradePierce;
    }

    public void setUpgradePierce(int upgradePierce) {
        this.upgradePierce = upgradePierce;
    }

    public int getUpgradeDamage() {
        return upgradeDamage;
    }

    public void setUpgradeDamage(int upgradeDamage) {
        this.upgradeDamage = upgradeDamage;
    }

    public boolean isUpgradeCamoDetect() {
        return upgradeCamoDetect;
    }

    public void setUpgradeCamoDetect(boolean upgradeCamoDetect) {
        this.upgradeCamoDetect = upgradeCamoDetect;
    }

    public boolean isUpgradeLeadPierce() {
        return upgradeLeadPierce;
    }

    public void setUpgradeLeadPierce(boolean upgradeLeadPierce) {
        this.upgradeLeadPierce = upgradeLeadPierce;
    }

    public String getUpgradeSpecialAbility() {
        return upgradeSpecialAbility;
    }

    public void setUpgradeSpecialAbility(String upgradeSpecialAbility) {
        this.upgradeSpecialAbility = upgradeSpecialAbility;
    }

    public String getUpgradeArt() {
        return upgradeArt;
    }

    public void setUpgradeArt(String upgradeArt) {
        this.upgradeArt = upgradeArt;
    }

    public String getUpgradeIcon() {
        return upgradeIcon;
    }

    public void setUpgradeIcon(String upgradeIcon) {
        this.upgradeIcon = upgradeIcon;
    }

    public Cost getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(Cost upgradeCost) {
        this.upgradeCost = upgradeCost;
    }
}