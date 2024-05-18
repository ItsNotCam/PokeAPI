package cam.PokeAPI.api.objects;

public class PokemonElementEffectivenessObject {
  String effect_name;
  Float effect_value;

  public PokemonElementEffectivenessObject(String effectName, float effectValue) {
    this.effect_name = effectName;
    this.effect_value = effectValue;
  }

  public String getEffect_name() {
    return effect_name;
  }

  public void setEffect_name(String effect_name) {
    this.effect_name = effect_name;
  }

  public Float getEffect_value() {
    return effect_value;
  }

  public void setEffect_value(Float effect_value) {
    this.effect_value = effect_value;
  }
}
