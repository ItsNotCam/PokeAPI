package cam.PokeAPI.models;
import java.sql.*;

enum ModelIndex {
    NUMBER(0),
    NAME(1),
    SUB_NAME(2),
    ICON_PATH(3),
    TOTAL(4),
    HP(5),
    ATTACK(6),
    DEFENSE(7),
    SPECIAL_ATTACK(8),
    SPECIAL_DEFENSE(9),
    SPEED(10),
    SPECIES(11),
    HEIGHT(12),
    WEIGHT(13),
    CATCH_RATE_NUM(14),
    CATCH_RATE_PERCENT(15),
    FRIENDSHIP_NUM(16),
    FRIENDSHIP_EXTREMITY(17),
    BASE_EXP(18),
    GROWTH_RATE(19),
    GENDER_MALE_PERCENT(20),
    GENDER_FEMALE_PERCENT(21),
    EGG_CYCLES_NUM(22),
    EGG_CYCLES_STEPS_MIN(23),
    EGG_CYCLES_STEPS_MAX(24);

    private final int value;

    ModelIndex(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

public class PokemonModel {
    private int number;
    private String name, subName;

    private String iconPath;
    private int total, hp, attack, defense, specialAttack, specialDefense, speed;

    private String species;
    private float height, weight;

    private int catchRateNum;
    private float catchRatePercent;

    private int friendshipNum, baseExp;
    private String friendshipExtremity, growthRate;

    private float genderMalePercent, genderFemalePercent;
    private int eggCyclesNum, eggCyclesStepsMin, eggCyclesStepsMax;

    public PokemonModel(ResultSet rs) throws SQLException {
        this.number = rs.getInt(ModelIndex.NUMBER.getValue());
        this.name = rs.getString(ModelIndex.NAME.getValue());
        this.subName = rs.getString(ModelIndex.SUB_NAME.getValue());

        this.iconPath = rs.getString(ModelIndex.ICON_PATH.getValue());
        this.total = rs.getInt(ModelIndex.TOTAL.getValue());
        this.hp = rs.getInt(ModelIndex.HP.getValue());
        this.attack = rs.getInt(ModelIndex.ATTACK.getValue());
        this.defense = rs.getInt(ModelIndex.DEFENSE.getValue());
        this.specialAttack = rs.getInt(ModelIndex.SPECIAL_ATTACK.getValue());
        this.specialDefense = rs.getInt(ModelIndex.SPECIAL_DEFENSE.getValue());
        this.speed = rs.getInt(ModelIndex.SPEED.getValue());

        this.species = rs.getString(ModelIndex.SPECIES.getValue());
        this.height = rs.getFloat(ModelIndex.HEIGHT.getValue());
        this.weight = rs.getFloat(ModelIndex.WEIGHT.getValue());

        this.catchRateNum = rs.getInt(ModelIndex.CATCH_RATE_NUM.getValue());
        this.catchRatePercent = rs.getFloat(ModelIndex.CATCH_RATE_PERCENT.getValue());

        this.friendshipNum = rs.getInt(ModelIndex.FRIENDSHIP_NUM.getValue());
        this.friendshipExtremity = rs.getString(ModelIndex.FRIENDSHIP_EXTREMITY.getValue());
        this.baseExp = rs.getInt(ModelIndex.BASE_EXP.getValue());
        this.growthRate = rs.getString(ModelIndex.GROWTH_RATE.getValue());

        this.genderMalePercent = rs.getFloat(ModelIndex.GENDER_MALE_PERCENT.getValue());
        this.genderFemalePercent = rs.getFloat(ModelIndex.GENDER_FEMALE_PERCENT.getValue());

        this.eggCyclesNum = rs.getInt(ModelIndex.EGG_CYCLES_NUM.getValue());
        this.eggCyclesStepsMin = rs.getInt(ModelIndex.EGG_CYCLES_STEPS_MIN.getValue());
        this.eggCyclesStepsMax = rs.getInt(ModelIndex.EGG_CYCLES_STEPS_MAX.getValue());
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
