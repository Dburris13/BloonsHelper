package com.example.bloonshelper.data;

import java.util.ArrayList;
import java.util.List;

public class MonkeysData {

    public static final Monkey[] DEFAULT_SEARCH_CATEGORY_IMAGES = {
            new Monkey("Dart Monkey", "PRIMARY", 32, 2, 1, false, false, 6, 'Q', "none", "dart_monkey.png", "none", 50),
            new Monkey("Boomerang Monkey", "PRIMARY", 32, 2, 1, false, false, 6, 'Q', "none", "boomerang_monkey.png", "none", 50),
            new Monkey("Bomb Shooter", "PRIMARY", 32, 2, 1, false, false, 6, 'Q', "none", "bomb_shooter.png", "none", 50),
            new Monkey("Tack Shooter", "PRIMARY", 32, 2, 1, false, false, 6, 'Q', "none", "tack_shooter.png", "none", 50),
            new Monkey("Ice Monkey", "PRIMARY", 32, 2, 1, false, false, 6, 'Q', "none", "ice_monkey.png", "none", 50),
            new Monkey("Glue Gunner", "PRIMARY", 32, 2, 1, false, false, 6, 'Q', "none", "glue_monkey.png", "none", 50),
            new Monkey("Sniper Monkey", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "sniper_monkey.png", "none", 50),
            new Monkey("Monkey Sub", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "monkey_sub.png", "none", 50),
            new Monkey("Monkey Buccaneer", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "monkey_buccaneer.png", "none", 50),
            new Monkey("Monkey Ace", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "monkey_ace.png", "none", 50),
            new Monkey( "Heli Pilot", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "heli_pilot.png", "none", 50),
            new Monkey( "Mortar Monkey", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "mortar_monkey.png", "none", 50),
            new Monkey( "Dartling Gunner", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "dartling_gunner.png", "none", 50),
            new Monkey( "Wizard Monkey", "MAGIC", 32, 2, 1, false, false, 6, 'Q', "none", "wizard_monkey.png", "none", 50),
            new Monkey( "Super Monkey", "MAGIC", 32, 2, 1, false, false, 6, 'Q', "none", "super_monkey.png", "none", 50),
            new Monkey( "Ninja Monkey", "MAGIC", 32, 2, 1, false, false, 6, 'Q', "none", "ninja_monkey.png", "none", 50),
            new Monkey( "Alchemist", "MAGIC", 32, 2, 1, false, false, 6, 'Q', "none", "alchemist_monkey.png", "none", 50),
            new Monkey( "Druid", "MAGIC", 32, 2, 1, false, false, 6, 'Q', "none", "druid_monkey.png", "none", 50),
            new Monkey( "Banana Farm", "SUPPORT", 32, 2, 1, false, false, 6, 'Q', "none", "banana_farm.png", "none", 50),
            new Monkey( "Spike Factory", "SUPPORT", 32, 2, 1, false, false, 6, 'Q', "none", "spike_factory.png", "none", 50),
            new Monkey( "Monkey Village", "SUPPORT", 32, 2, 1, false, false, 6, 'Q', "none", "monkey_village.png", "none", 50),
            new Monkey( "Monkey Engineer", "SUPPORT", 32, 2, 1, false, false, 6, 'Q', "none", "engineer_monkey.png", "none", 50)
    };

    public static List<Monkey> populateMonkeysData() {
        List<Monkey> newMonkeyList = new ArrayList<>();
        newMonkeyList.add(new Monkey("Dart Monkey", "PRIMARY", 32, 2, 1, false, false, 6, 'Q', "none", "dart_monkey.png", "none", 0));
        newMonkeyList.add(new Monkey("Boomerang Monkey", "PRIMARY", 43, 4, 1, false, false, 7, 'W', "none", "boomerang_monkey.png", "none", 50));
        newMonkeyList.add(new Monkey("Bomb Shooter", "PRIMARY", 40, 18, 1, false, false, 7, 'E', "none", "bomb_shooter.png", "none", 50));
        newMonkeyList.add(new Monkey("Tack Shooter", "PRIMARY", 23, 1, 1, false, false, 6, 'R', "none", "tack_shooter.png", "none", 50));
        newMonkeyList.add(new Monkey("Ice Monkey", "PRIMARY", 20, 40, 1, false, false, 6, 'T', "none", "ice_monkey.png", "none", 50));
        newMonkeyList.add(new Monkey("Glue Gunner", "PRIMARY", 46, 1, 0, false, false, 6, 'Y', "none", "glue_monkey.png", "none", 50));
        newMonkeyList.add(new Monkey("Sniper Monkey", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "sniper_monkey.png", "none", 50));
        newMonkeyList.add(new Monkey("Monkey Sub", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "monkey_sub.png", "none", 50));
        newMonkeyList.add(new Monkey("Monkey Buccaneer", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "monkey_buccaneer.png", "none", 50));
        newMonkeyList.add(new Monkey("Monkey Ace", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "monkey_ace.png", "none", 50));
        newMonkeyList.add(new Monkey( "Heli Pilot", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "heli_pilot.png", "none", 50));
        newMonkeyList.add(new Monkey( "Mortar Monkey", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "mortar_monkey.png", "none", 50));
        newMonkeyList.add(new Monkey( "Dartling Gunner", "MILITARY", 32, 2, 1, false, false, 6, 'Q', "none", "dartling_gunner.png", "none", 50));
        newMonkeyList.add(new Monkey( "Wizard Monkey", "MAGIC", 32, 2, 1, false, false, 6, 'Q', "none", "wizard_monkey.png", "none", 50));
        newMonkeyList.add(new Monkey( "Super Monkey", "MAGIC", 32, 2, 1, false, false, 6, 'Q', "none", "super_monkey.png", "none", 50));
        newMonkeyList.add(new Monkey( "Ninja Monkey", "MAGIC", 32, 2, 1, false, false, 6, 'Q', "none", "ninja_monkey.png", "none", 50));
        newMonkeyList.add(new Monkey( "Alchemist", "MAGIC", 32, 2, 1, false, false, 6, 'Q', "none", "alchemist_monkey.png", "none", 50));
        newMonkeyList.add(new Monkey( "Druid", "MAGIC", 32, 2, 1, false, false, 6, 'Q', "none", "druid_monkey.png", "none", 50));
        newMonkeyList.add(new Monkey( "Banana Farm", "SUPPORT", 32, 2, 1, false, false, 6, 'Q', "none", "banana_farm.png", "none", 50));
        newMonkeyList.add(new Monkey( "Spike Factory", "SUPPORT", 32, 2, 1, false, false, 6, 'Q', "none", "spike_factory.png", "none", 50));
        newMonkeyList.add(new Monkey( "Monkey Village", "SUPPORT", 32, 2, 1, false, false, 6, 'Q', "none", "monkey_village.png", "none", 50));
        newMonkeyList.add(new Monkey( "Monkey Engineer", "SUPPORT", 32, 2, 1, false, false, 6, 'Q', "none", "engineer_monkey.png", "none", 50));

        return newMonkeyList;
        };
    }