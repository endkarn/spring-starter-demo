package com.example.demo.user;

import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<UserDto> userDtoList = new ArrayList<>();


    public UserServiceImpl() {
        userDtoList.add(new UserDto(0L,"firstname","lastname"));
        userDtoList.add(new UserDto(1L,"กานวัด","คนดี"));
        userDtoList.add(new UserDto(2L,"น้องน้ำ","บ้านไกล"));
        userDtoList.add(new UserDto(3L,"ฟลุ้ค","ไม่บอก"));
        userDtoList.add(new UserDto(4L,"สวัสดี","สารคาม"));
    }

    public UserDto getUserDto(Long id){
       return userDtoList.get(id.intValue());
   }

}
