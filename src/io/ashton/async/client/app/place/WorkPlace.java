package io.ashton.async.client.app.place;


public class WorkPlace extends AppPlace{
  String token;

  public WorkPlace(String token){
    this.token = token;
  }

  @Override
  public String getToken() {
    return token;
  }

}
