package io.ashton.async.client.app.place;

public class HomePlace extends AppPlace {
  String token;

  public HomePlace(String token){
    this.token = token;
  }

  @Override
  public String getToken() {
    return token;
  }

}
