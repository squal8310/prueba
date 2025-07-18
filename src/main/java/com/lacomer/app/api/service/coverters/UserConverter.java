package com.lacomer.app.api.service.coverters;

import com.lacomer.app.api.dto.UserUpDateVO;
import com.lacomer.app.api.dto.UserVO;
import com.lacomer.app.api.model.User;

public class UserConverter {

	public static User userDtoToUserEntity(UserVO usrReq) {
		 User user = new User(null,usrReq.getName() , usrReq.getLastNameOne(), usrReq.getLastNameTwo(), usrReq.getMail(), null);
		return user;
	}
	
	public static UserVO userEntityToUserResponse(User user) {
		return new UserVO(user.getId(), user.getName(),user.getLastNameOne(),user.getLastNameTwo(),user.getEmail(), user.getIp());
	}
	
	public static User userUpdateDtoToUserEntity(UserUpDateVO usrReq) {
		 User user = new User(usrReq.getId(),usrReq.getName() , usrReq.getLastNameOne(), usrReq.getLastNameTwo(), usrReq.getMail(), null);
		return user;
	}
	
	public static UserUpDateVO userEntityToUserUpdatedResponse(User user) {
		return new UserUpDateVO(user.getId(), user.getName(),user.getLastNameOne(),user.getLastNameTwo(),user.getEmail(), null);
	}
}
