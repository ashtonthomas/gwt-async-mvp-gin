package io.ashton.async.client.app.place;

import io.ashton.async.shared.SharedConstants;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;


public class AppPlaceHistoryMapper implements PlaceHistoryMapper {

  public Place getPlace(String token){
    System.out.println("getPlace");
    if(token.startsWith(SharedConstants.APP_PLACE_PREFIX_HOME_PREFIX)){
      return new HomePlace(token);
    }else if(token.startsWith(SharedConstants.APP_PLACE_PREFIX_WORK_PREFIX)){
      return new WorkPlace(token);
    }else if(token.startsWith(SharedConstants.APP_PLACE_PREFIX_FRIENDS_PREFIX)){
      return new FriendsPlace(token);
    }else if(token.startsWith(SharedConstants.APP_PLACE_PREFIX_HOBBY_FOOTBALL_PREFIX)){
      return new HobbyFootballPlace(token);
    }else if(token.startsWith(SharedConstants.APP_PLACE_PREFIX_HOBBY_GOLF_PREFIX)){
      return new HobbyGolfPlace(token);
    }
    return null;
  }


  public String getToken(Place place){
    if(place instanceof AppPlace){
      return ((AppPlace) place).getToken();
    }
    // I am choosing to ONLY support AppPlace(s)
    return null;//Ignore this unknown place
  }

}
