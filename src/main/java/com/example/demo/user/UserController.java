package com.example.demo.user;

import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/karn")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello/{name}")
    public UserDto helloUser(@PathVariable String name){
       UserDto userDto = new UserDto();
       userDto.setFirstname(name);
        return userDto;
    }

    @PostMapping("/hello")
    public UserDto helloUserByRequestBody(@RequestBody UserDto userDto){
        UserDto responseUserDto = new UserDto();
        responseUserDto.setFirstname(userDto.getFirstname()+" "+userDto.getLastname());
        return responseUserDto;
    }

    @GetMapping("/hello/id/{userid}")
    public UserDto helloUser(@PathVariable Long userid){
        UserDto userDto = userService.getUserDto(userid);
        return userDto;
    }

    @PostMapping("/hello/id")
    public UserDto helloUserByRequestBodyId(@RequestBody UserDto userDto){
        UserDto responseUserDto = userService.getUserDto(userDto.getId());
        return responseUserDto;
    }
}
