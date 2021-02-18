package com.example.bloonshelper.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "monkey_base")
public class Monkey {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "monkey_name")
    public String monkeyName;

    @ColumnInfo(name = "monkey_class")
    public String monkeyClass;

    @ColumnInfo(name = "monkey_range")
    public int monkeyRange;

    @ColumnInfo(name = "monkey_pierce")
    public int monkeyPierce;

    @ColumnInfo(name = "monkey_damage")
    public int monkeyDamage;

    @ColumnInfo(name = "monkey_camo_detect")
    public boolean monkeyCamoDetect;

    @ColumnInfo(name = "monkey_lead_pierce")
    public boolean monkeyLeadPierce;

    @ColumnInfo(name = "monkey_footprint")
    public int monkeyFootprint;

    @ColumnInfo(name = "monkey_hotkey")
    public char monkeyHotkey;

    @ColumnInfo(name = "monkey_special_ability")
    public String monkeySpecialAbility;

    @ColumnInfo(name = "monkey_art")
    public String monkeyArt;

    @ColumnInfo(name = "monkey_icon")
    public String monkeyIcon;

    @ColumnInfo(name = "monkey_sell_amount")
    public int monkeySellAmount;

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
        this.monkeySellAmount = 0;
    }

    public int getColumnCount() {
        return 13;
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
            case 12: return "Monkey Sell Amount";
            default: return "null";
        }
    }

    public String getContent(int i) {
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
            case 12: return String.valueOf(monkeySellAmount);
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

    public Monkey(String monkeyName, String monkeyClass, int monkeyRange, int monkeyPierce, int monkeyDamage, boolean monkeyCamoDetect, boolean monkeyLeadPierce, int monkeyFootprint, char monkeyHotkey, String monkeySpecialAbility, String monkeyArt, String monkeyIcon, int monkeySellAmount) {
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
        this.monkeySellAmount = monkeySellAmount;
    }


}