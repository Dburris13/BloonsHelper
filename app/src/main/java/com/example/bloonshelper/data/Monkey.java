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