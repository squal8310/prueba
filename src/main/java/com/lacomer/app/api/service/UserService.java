package com.lacomer.app.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lacomer.app.api.dto.Response;
import com.lacomer.app.api.dto.UserUpDateVO;
import com.lacomer.app.api.dto.UserVO;
import com.lacomer.app.api.dto.out.ResponseDataDto;
import com.lacomer.app.api.facades.DirectionsFacade;
import com.lacomer.app.api.model.User;
import com.lacomer.app.api.repository.UserRepository;
import com.lacomer.app.api.service.coverters.UserConverter;

import lombok.RequiredArgsConstructor;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final DirectionsFacade directionPhysical;
    
    @Autowired
    public UserService(UserRepository userRepository, DirectionsFacade directionPhysical) {
		this.userRepository = userRepository;
		this.directionPhysical = directionPhysical;
	}

    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public ResponseDataDto create(UserVO userVO) {
    	Response directionPhysical = this.directionPhysical.getDirectionByName();
    	User userDtoToUserEntity = UserConverter.userDtoToUserEntity(userVO);
    	userDtoToUserEntity.setIp(directionPhysical.getIp());
       UserVO userResponseVO = UserConverter.userEntityToUserResponse(this.userRepository.save(userDtoToUserEntity));
        return new ResponseDataDto(200, "Usuario Creado", userResponseVO);
    }

    @Transactional
    public ResponseDataDto getAllUsers(){
    	List<UserVO> usersList = this.userRepository.findAll().stream().map(UserConverter::userEntityToUserResponse).collect(Collectors.toList());
        return new ResponseDataDto(200, "Lista de usuarios", usersList);
    }

	public ResponseDataDto getUserByIs(Long userId) {
		UserVO userResponse = UserConverter.userEntityToUserResponse(this.userRepository.findById(userId).orElse(new User()));
	  return new ResponseDataDto(200, "Lista de usuarios", userResponse);
	}

	public ResponseDataDto update(UserUpDateVO userUpdateVo) {
		Response directionPhysical = this.directionPhysical.getDirectionByName();
		User userDtoToUserEntity = UserConverter.userUpdateDtoToUserEntity(userUpdateVo);
    	userDtoToUserEntity.setIp(directionPhysical.getIp());
		 UserUpDateVO userResponseVO = UserConverter.userEntityToUserUpdatedResponse(this.userRepository.save(userDtoToUserEntity));
	     return new ResponseDataDto(200, "Usuario Actualizado", userResponseVO);
	}

	public ResponseDataDto delUserByIs(Long userId) {
		Optional<User> userToDelete = this.userRepository.findById(userId);
		this.userRepository.delete(userToDelete.get());
		return new ResponseDataDto(200, "Usuario borrado", "");
	}

} 