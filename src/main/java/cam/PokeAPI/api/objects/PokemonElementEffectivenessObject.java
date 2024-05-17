package cam.PokeAPI.api.objects;

public class PokemonElementEffectivenessObject {
  String effect_name;
  Integer effect_value;

  public PokemonElementEffectivenessObject(String effectName, int effectValue) {
    this.effect_name = effectName;
    this.effect_value = effectValue;
  }

  public String getEffect_name() {
    return effect_name;
  }

  public void setEffect_name(String effect_name) {
    this.effect_name = effect_name;
  }

  public Integer getEffect_value() {
    return effect_value;
  }

  public void setEffect_value(Integer effect_value) {
    this.effect_value = effect_value;
  }
}
