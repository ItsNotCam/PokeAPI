package cam.PokeAPI.db.models;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.sql.*;

import static cam.PokeAPI.util.Util.instantiateModelGenerically;


@JsonRootName(value = "pokemon")
public class PokemonModel {
    private Integer number;
    private String name, sub_name;

    private String iconPath;
    private Integer total, hp, attack, defense, special_attack, special_defense, speed;

    private String species;
    private Float height, weight;

    private Integer catch_rate_num;
    private Float catch_rate_percent;

    private Integer friendship_num;
    private String friendship_extremity;
    private Integer base_exp;
    private String growth_rate;

    private Float gender_male_percent, gender_female_percent;
    private Integer egg_cycles_num, egg_cycles_steps_min, egg_cycles_steps_max;

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

    public PokemonModel(ResultSet rs) throws SQLException {
        instantiateModelGenerically(this, rs);
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
        this.sub_name = subName;

        this.iconPath = iconPath;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.special_attack = specialAttack;
        this.special_defense = specialDefense;
        this.speed = speed;

        this.species = species;
        this.height = height;
        this.weight = weight;

        this.catch_rate_num = catchRateNum;
        this.catch_rate_percent = catchRatePercent;

        this.friendship_num = friendshipNum;
        this.friendship_extremity = friendshipExtremity;
        this.base_exp = baseExp;
        this.growth_rate = growthRate;

        this.gender_male_percent = genderMalePercent;
        this.gender_female_percent = genderFemalePercent;

        this.egg_cycles_num = eggCyclesNum;
        this.egg_cycles_steps_min = eggCyclesStepsMin;
        this.egg_cycles_steps_max = egg_cycles_steps_max;
    }

    @Override
    public String toString() {
        return number + " " + name + " " + sub_name + " " + iconPath + " " + total + " " + hp + " " + attack
            + " " + defense + " " + special_attack + " " + special_defense + " " + speed + " " + species + " "
            + height + " " + weight + " " + catch_rate_num + " " + catch_rate_percent + " " + friendship_num + " "
            + friendship_extremity + " " + base_exp + " " + growth_rate + " " + gender_male_percent + " "
            + gender_female_percent + " " + egg_cycles_num + " " + egg_cycles_steps_min + " " + egg_cycles_steps_max;
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
        return sub_name;
    }

    public void setSub_name(String subName) {
        this.sub_name = subName;
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
        return special_attack;
    }

    public void setSpecial_attack(int specialAttack) {
        this.special_attack = specialAttack;
    }

    public int getSpecialDefense() {
        return special_defense;
    }

    public void setSpecial_defense(int specialDefense) {
        this.special_defense = specialDefense;
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

    public int getCatch_rate_num() {
        return catch_rate_num;
    }

    public void setCatchRateNum(int catchRateNum) {
        this.catch_rate_num = catchRateNum;
    }

    public float getCatch_rate_percent() {
        return catch_rate_percent;
    }

    public void setCatchRatePercent(float catchRatePercent) {
        this.catch_rate_percent = catchRatePercent;
    }

    public int getFriendship_num() {
        return friendship_num;
    }

    public void setFriendshipNum(int friendshipNum) {
        this.friendship_num = friendshipNum;
    }

    public String getFriendship_extremity() {
        return friendship_extremity;
    }

    public void setFriendshipExtremity(String friendshipExtremity) {
        this.friendship_extremity = friendshipExtremity;
    }

    public int getBase_exp() {
        return base_exp;
    }

    public void setBaseExp(int baseExp) {
        this.base_exp = baseExp;
    }

    public String getGrowthRate() {
        return growth_rate;
    }

    public void setGrowthRate(String growth_rate) {
        this.growth_rate = growth_rate;
    }

    public float getGender_male_percent() {
        return gender_male_percent;
    }

    public void setGenderMalePercent(float genderMalePercent) {
        this.gender_male_percent = genderMalePercent;
    }

    public float getGender_female_percent() {
        return gender_female_percent;
    }

    public void setGenderFemalePercent(float genderFemalePercent) {
        this.gender_female_percent = genderFemalePercent;
    }

    public int getEgg_cycles_num() {
        return egg_cycles_num;
    }

    public void setEggCyclesNum(int eggCyclesNum) {
        this.egg_cycles_num = eggCyclesNum;
    }

    public int getEgg_cycles_steps_min() {
        return egg_cycles_steps_min;
    }

    public void setEggCyclesStepsMin(int eggCyclesStepsMin) {
        this.egg_cycles_steps_min = eggCyclesStepsMin;
    }

    public int getEgg_cycles_steps_max() {
        return egg_cycles_steps_max;
    }

    public void setEggCyclesStepsMax(int eggCyclesStepsMax) {
        this.egg_cycles_steps_max = eggCyclesStepsMax;
    }
}
