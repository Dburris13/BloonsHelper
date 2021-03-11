package com.example.bloonshelper.data;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "monkey_base")
public class Monkey {

    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String monkeyName;
    private String monkeyClass;
    private int monkeyRange;
    private int monkeyPierce;
    private int monkeyDamage;
    private boolean monkeyCamoDetect;
    private boolean monkeyLeadPierce;
    private int monkeyFootprint;
    private char monkeyHotkey;
    private String monkeySpecialAbility;
    private String monkeyArt;
    private String monkeyIcon;
    @Embedded(prefix = "buy")
    private Cost monkeyCost;
    private String path1Upgrade;
    private String path2Upgrade;
    private String path3Upgrade;

    public Monkey() {
        this.monkeyName = "Base_Monkey";
        this.monkeyClass = "NONE";
        this.monkeyRange = 0;
        this.monkeyPierce = 0;
        this.monkeyDamage = 0;
        this.monkeyCamoDetect = false;
        this.monkeyLeadPierce = false;
        this.monkeyFootprint = 0;
        this.monkeyHotkey = '0';
        this.monkeySpecialAbility = "none";
        this.monkeyArt = "none";
        this.monkeyIcon = "none";
        this.monkeyCost = new Cost(100, 200, 300, 400);
        this.path1Upgrade = "none";
        this.path2Upgrade = "none";
        this.path3Upgrade = "none";
    }

    public int getColumnCount() {
        return 14;
    }

    public String getColumnHeader(int i) {
        switch(i) {
            case 0: return "Monkey Name";
            case 1: return "Monkey Class";
            case 2: return "Monkey Range";
            case 3: return "Monkey Pierce";
            case 4: return "Monkey Damage";
            case 5: return "Monkey Camo Detection";
            case 6: return "Monkey Lead Pierce";
            case 7: return "Monkey Footprint";
            case 8: return "Monkey Hotkey";
            case 9: return "Monkey Special Ability";
            case 10: return "Monkey Art";
            case 11: return "Monkey Icon";
            case 12: return "Monkey Buy Amount";
            case 13: return "Monkey Sell Amount";
            default: return "null";
        }
    }

    public String getContent(int i, MonkeysData.Difficulty difficulty) {
        switch(i) {
            case 0: return monkeyName;
            case 1: return monkeyClass;
            case 2: return String.valueOf(monkeyRange);
            case 3: return String.valueOf(monkeyPierce);
            case 4: return String.valueOf(monkeyDamage);
            case 5: return String.valueOf(monkeyCamoDetect);
            case 6: return String.valueOf(monkeyLeadPierce);
            case 7: return String.valueOf(monkeyFootprint);
            case 8: return String.valueOf(monkeyHotkey);
            case 9: return monkeySpecialAbility;
            case 10: return monkeyArt;
            case 11: return monkeyIcon;
            case 12: return String.valueOf(monkeyCost.returnCostViaDifficulty(difficulty));
            case 13: return String.valueOf(monkeyCost.returnCostViaDifficulty(difficulty)*.75);
            default: return "null";
        }
    }

    public String getMonkeyName() {
        return monkeyName;
    }

    public String getMonkeyClass() {
        return monkeyClass;
    }

    public String getMonkeyArt() {
        return monkeyArt;
    }

    public void setMonkeyName(String monkeyName) {
        this.monkeyName = monkeyName;
    }

    public void setMonkeyClass(String monkeyClass) {
        this.monkeyClass = monkeyClass;
    }

    public void setMonkeyArt(String monkeyArt) {
        this.monkeyArt = monkeyArt;
    }

    public int getMonkeyRange() {
        return monkeyRange;
    }

    public int getMonkeyPierce() {
        return monkeyPierce;
    }

    public int getMonkeyDamage() {
        return monkeyDamage;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setMonkeyRange(int monkeyRange) {
        this.monkeyRange = monkeyRange;
    }

    public void setMonkeyPierce(int monkeyPierce) {
        this.monkeyPierce = monkeyPierce;
    }

    public void setMonkeyDamage(int monkeyDamage) {
        this.monkeyDamage = monkeyDamage;
    }

    public boolean isMonkeyCamoDetect() {
        return monkeyCamoDetect;
    }

    public void setMonkeyCamoDetect(boolean monkeyCamoDetect) {
        this.monkeyCamoDetect = monkeyCamoDetect;
    }

    public boolean isMonkeyLeadPierce() {
        return monkeyLeadPierce;
    }

    public void setMonkeyLeadPierce(boolean monkeyLeadPierce) {
        this.monkeyLeadPierce = monkeyLeadPierce;
    }

    public int getMonkeyFootprint() {
        return monkeyFootprint;
    }

    public void setMonkeyFootprint(int monkeyFootprint) {
        this.monkeyFootprint = monkeyFootprint;
    }

    public char getMonkeyHotkey() {
        return monkeyHotkey;
    }

    public void setMonkeyHotkey(char monkeyHotkey) {
        this.monkeyHotkey = monkeyHotkey;
    }

    public String getMonkeySpecialAbility() {
        return monkeySpecialAbility;
    }

    public void setMonkeySpecialAbility(String monkeySpecialAbility) {
        this.monkeySpecialAbility = monkeySpecialAbility;
    }

    public String getMonkeyIcon() {
        return monkeyIcon;
    }

    public void setMonkeyIcon(String monkeyIcon) {
        this.monkeyIcon = monkeyIcon;
    }

    public Cost getMonkeyCost() {
        return monkeyCost;
    }

    public void setMonkeyCost(Cost monkeyCost) {
        this.monkeyCost = monkeyCost;
    }

    public void setPath1Upgrade(String path1Upgrade) {
        this.path1Upgrade = path1Upgrade;
    }

    public void setPath2Upgrade(String path2Upgrade) {
        this.path2Upgrade = path2Upgrade;
    }

    public void setPath3Upgrade(String path3Upgrade) {
        this.path3Upgrade = path3Upgrade;
    }

    public Monkey(String monkeyName, String monkeyClass, int monkeyRange, int monkeyPierce, int monkeyDamage, boolean monkeyCamoDetect, boolean monkeyLeadPierce, int monkeyFootprint, char monkeyHotkey, String monkeySpecialAbility, String monkeyArt, String monkeyIcon) {
//        this.uid = uid;
        this.monkeyName = monkeyName;
        this.monkeyClass = monkeyClass;
        this.monkeyRange = monkeyRange;
        this.monkeyPierce = monkeyPierce;
        this.monkeyDamage = monkeyDamage;
        this.monkeyCamoDetect = monkeyCamoDetect;
        this.monkeyLeadPierce = monkeyLeadPierce;
        this.monkeyFootprint = monkeyFootprint;
        this.monkeyHotkey = monkeyHotkey;
        this.monkeySpecialAbility = monkeySpecialAbility;
        this.monkeyArt = monkeyArt;
        this.monkeyIcon = monkeyIcon;
        this.monkeyCost = new Cost(100, 200, 300, 400);
        this.path1Upgrade = "Bigger Bombs";
        this.path2Upgrade = "Faster Reload";
        this.path3Upgrade = "Extra Range";
    }



    public Monkey(String monkeyName, String monkeyClass, int monkeyRange, int monkeyPierce, int monkeyDamage, boolean monkeyCamoDetect, boolean monkeyLeadPierce, int monkeyFootprint, char monkeyHotkey, String monkeySpecialAbility, String monkeyArt, String monkeyIcon, Cost monkeyCost, String path1Upgrade, String path2Upgrade, String path3Upgrade) {
        this.monkeyName = monkeyName;
        this.monkeyClass = monkeyClass;
        this.monkeyRange = monkeyRange;
        this.monkeyPierce = monkeyPierce;
        this.monkeyDamage = monkeyDamage;
        this.monkeyCamoDetect = monkeyCamoDetect;
        this.monkeyLeadPierce = monkeyLeadPierce;
        this.monkeyFootprint = monkeyFootprint;
        this.monkeyHotkey = monkeyHotkey;
        this.monkeySpecialAbility = monkeySpecialAbility;
        this.monkeyArt = monkeyArt;
        this.monkeyIcon = monkeyIcon;
        this.monkeyCost = monkeyCost;
        this.path1Upgrade = path1Upgrade;
        this.path2Upgrade = path2Upgrade;
        this.path3Upgrade = path3Upgrade;
    }

    public String getUpgradePath(int tier) {
        switch (tier) {
            case 1: return path1Upgrade;
            case 2: return path2Upgrade;
            case 3: return path3Upgrade;
            default: return "NULL";
        }
    }

    public String getPath1Upgrade() {
        return path1Upgrade;
    }

    public String getPath2Upgrade() {
        return path2Upgrade;
    }

    public String getPath3Upgrade() {
        return path3Upgrade;
    }
}