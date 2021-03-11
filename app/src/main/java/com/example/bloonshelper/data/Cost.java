package com.example.bloonshelper.data;

public class Cost {
    private int easy, medium, hard, impoppable;

    public Cost(int easy, int medium, int hard, int impoppable) {
        this.easy = easy;
        this.medium = medium;
        this.hard = hard;
        this.impoppable = impoppable;
    }

    public int getEasy() {
        return easy;
    }

    public void setEasy(int easy) {
        this.easy = easy;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getHard() {
        return hard;
    }

    public void setHard(int hard) {
        this.hard = hard;
    }

    public int getImpoppable() {
        return impoppable;
    }

    public void setImpoppable(int impoppable) {
        this.impoppable = impoppable;
    }

    public int returnCostViaDifficulty(MonkeysData.Difficulty difficulty) {
        switch (difficulty) {
            case EASY: return getEasy();
            case NORMAL: return getMedium();
            case HARD: return getHard();
            case IMPOPPABLE: return getImpoppable();
            default: return getEasy();
        }
    }

    @Override
    public String toString() {
        return "Cost{" +
                "easy=" + easy +
                ", medium=" + medium +
                ", hard=" + hard +
                ", impoppable=" + impoppable +
                '}';
    }
}
