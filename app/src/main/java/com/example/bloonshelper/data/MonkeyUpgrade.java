package com.example.bloonshelper.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "monkey_upgrade")
public class MonkeyUpgrade {

    private enum Tier { TIER1, TIER2, TIER3, TIER4, TIER5 }

    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "upgrade_name")
    public String upgradeName;

    @ColumnInfo(name = "upgrade_name")
    public Tier upgradeTier;

    @ColumnInfo(name = "upgrade_range_increase")
    public int upgradeRange;

    @ColumnInfo(name = "upgrade_pierce_increase")
    public int upgradePierce;

    @ColumnInfo(name = "upgrade_damage_increase")
    public int upgradeDamage;

    @ColumnInfo(name = "upgrade_camo_detect")
    public boolean upgradeCamoDetect;

    @ColumnInfo(name = "upgrade_lead_pierce")
    public boolean upgradeLeadPierce;

    @ColumnInfo(name = "upgrade_footprint_increase")
    public boolean upgradeFootprint;

    @ColumnInfo(name = "upgrade_cost_increase")
    public MonkeyCost upgradeCostIncrease;

    @ColumnInfo(name = "upgrade_special_ability")
    public boolean upgradeSpecialAbility;

    @ColumnInfo(name = "upgrade_art")
    public String upgradeArt;

    @ColumnInfo(name = "upgrade_icon")
    public String upgradeIcon;

    @ColumnInfo(name = "upgrade_sell_amount_increase")
    public boolean upgradeSellAmount;
}