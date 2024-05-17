package cam.PokeAPI.db.models;
import java.sql.*;

import static cam.PokeAPI.util.Util.instantiateGenerically;


public class PokemonModel {
    private Integer number;
    private String name, subName;

    private String iconPath;
    private Integer total, hp, attack, defense, specialAttack, specialDefense, speed;

    private String species;
    private Float height, weight;

    private Integer catchRateNum;
    private Float catchRatePercent;

    private Integer friendshipNum, baseExp;
    private String friendshipExtremity, growthRate;

    private Float genderMalePercent, genderFemalePercent;
    private Integer eggCyclesNum, eggCyclesStepsMin, eggCyclesStepsMax;

    enum ColumnIndex {
        NUMBER(1),
        NAME(2),
        SUB_NAME(3),

        ICON_PATH(4),

        TOTAL(5),
        HP(6),
        ATTACK(7),
        DEFENSE(8),
        SPECIAL_ATTACK(9),
        SPECIAL_DEFENSE(10),
        SPEED(11),

        SPECIES(12),
        HEIGHT(13),
        WEIGHT(14),

        CATCH_RATE_NUM(15),
        CATCH_RATE_PERCENT(16),

        FRIENDSHIP_NUM(17),
        FRIENDSHIP_EXTREMITY(18),
        BASE_EXP(19),

        GROWTH_RATE(20),
        GENDER_MALE_PERCENT(21),
        GENDER_FEMALE_PERCENT(22),
        EGG_CYCLES_NUM(23),
        EGG_CYCLES_STEPS_MIN(24),
        EGG_CYCLES_STEPS_MAX(25);

        private final int value;

        ColumnIndex(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public PokemonModel(ResultSet rs) throws SQLException, IllegalAccessException {
        instantiateGenerically(this, rs);
        return;
//        this.number = rs.getInt(ColumnIndex.NUMBER.getValue());
//        this.name = rs.getString(ColumnIndex.NAME.getValue());
//        this.subName = rs.getString(ColumnIndex.SUB_NAME.getValue());
//
//        this.iconPath = rs.getString(ColumnIndex.ICON_PATH.getValue());
//        this.total = rs.getInt(ColumnIndex.TOTAL.getValue());
//        this.hp = rs.getInt(ColumnIndex.HP.getValue());
//        this.attack = rs.getInt(ColumnIndex.ATTACK.getValue());
//        this.defense = rs.getInt(ColumnIndex.DEFENSE.getValue());
//        this.specialAttack = rs.getInt(ColumnIndex.SPECIAL_ATTACK.getValue());
//        this.specialDefense = rs.getInt(ColumnIndex.SPECIAL_DEFENSE.getValue());
//        this.speed = rs.getInt(ColumnIndex.SPEED.getValue());
//
//        this.species = rs.getString(ColumnIndex.SPECIES.getValue());
//        this.height = rs.getFloat(ColumnIndex.HEIGHT.getValue());
//        this.weight = rs.getFloat(ColumnIndex.WEIGHT.getValue());
//
//        this.catchRateNum = rs.getInt(ColumnIndex.CATCH_RATE_NUM.getValue());
//        this.catchRatePercent = rs.getFloat(ColumnIndex.CATCH_RATE_PERCENT.getValue());
//
//        this.friendshipNum = rs.getInt(ColumnIndex.FRIENDSHIP_NUM.getValue());
//        this.friendshipExtremity = rs.getString(ColumnIndex.FRIENDSHIP_EXTREMITY.getValue());
//        this.baseExp = rs.getInt(ColumnIndex.BASE_EXP.getValue());
//        this.growthRate = rs.getString(ColumnIndex.GROWTH_RATE.getValue());
//
//        this.genderMalePercent = rs.getFloat(ColumnIndex.GENDER_MALE_PERCENT.getValue());
//        this.genderFemalePercent = rs.getFloat(ColumnIndex.GENDER_FEMALE_PERCENT.getValue());
//
//        this.eggCyclesNum = rs.getInt(ColumnIndex.EGG_CYCLES_NUM.getValue());
//        this.eggCyclesStepsMin = rs.getInt(ColumnIndex.EGG_CYCLES_STEPS_MIN.getValue());
//        this.eggCyclesStepsMax = rs.getInt(ColumnIndex.EGG_CYCLES_STEPS_MAX.getValue());
    }

    public PokemonModel(int number, String name, String subName, String iconPath, int total, int hp, int attack,
                        int defense, int specialAttack, int specialDefense, int speed, String species, float height,
                        float weight, int catchRateNum, float catchRatePercent, int friendshipNum,
                        String friendshipExtremity, int baseExp, String growthRate, float genderMalePercent,
                        float genderFemalePercent, int eggCyclesNum, int eggCyclesStepsMin, int egg_cycles_steps_max)
    {
        this.number = number;
        this.name = name;
        this.subName = subName;

        this.iconPath = iconPath;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;

        this.species = species;
        this.height = height;
        this.weight = weight;

        this.catchRateNum = catchRateNum;
        this.catchRatePercent = catchRatePercent;

        this.friendshipNum = friendshipNum;
        this.friendshipExtremity = friendshipExtremity;
        this.baseExp = baseExp;
        this.growthRate = growthRate;

        this.genderMalePercent = genderMalePercent;
        this.genderFemalePercent = genderFemalePercent;

        this.eggCyclesNum = eggCyclesNum;
        this.eggCyclesStepsMin = eggCyclesStepsMin;
        this.eggCyclesStepsMax = egg_cycles_steps_max;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getCatchRateNum() {
        return catchRateNum;
    }

    public void setCatchRateNum(int catchRateNum) {
        this.catchRateNum = catchRateNum;
    }

    public float getCatchRatePercent() {
        return catchRatePercent;
    }

    public void setCatchRatePercent(float catchRatePercent) {
        this.catchRatePercent = catchRatePercent;
    }

    public int getFriendshipNum() {
        return friendshipNum;
    }

    public void setFriendshipNum(int friendshipNum) {
        this.friendshipNum = friendshipNum;
    }

    public String getFriendshipExtremity() {
        return friendshipExtremity;
    }

    public void setFriendshipExtremity(String friendshipExtremity) {
        this.friendshipExtremity = friendshipExtremity;
    }

    public int getBaseExp() {
        return baseExp;
    }

    public void setBaseExp(int baseExp) {
        this.baseExp = baseExp;
    }

    public String getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(String growthRate) {
        this.growthRate = growthRate;
    }

    public float getGenderMalePercent() {
        return genderMalePercent;
    }

    public void setGenderMalePercent(float genderMalePercent) {
        this.genderMalePercent = genderMalePercent;
    }

    public float getGenderFemalePercent() {
        return genderFemalePercent;
    }

    public void setGenderFemalePercent(float genderFemalePercent) {
        this.genderFemalePercent = genderFemalePercent;
    }

    public int getEggCyclesNum() {
        return eggCyclesNum;
    }

    public void setEggCyclesNum(int eggCyclesNum) {
        this.eggCyclesNum = eggCyclesNum;
    }

    public int getEggCyclesStepsMin() {
        return eggCyclesStepsMin;
    }

    public void setEggCyclesStepsMin(int eggCyclesStepsMin) {
        this.eggCyclesStepsMin = eggCyclesStepsMin;
    }

    public int getEggCyclesStepsMax() {
        return eggCyclesStepsMax;
    }

    public void setEggCyclesStepsMax(int eggCyclesStepsMax) {
        this.eggCyclesStepsMax = eggCyclesStepsMax;
    }
}