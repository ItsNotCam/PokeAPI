package cam.PokeAPI.db.models;

public class MessageModel {
  String message;

  public MessageModel(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
