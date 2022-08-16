package io.turntabl.master.controller;
import io.turntabl.master.rest.requests.UserRequest;
import io.turntabl.master.rest.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private List<UserResponse> data = new ArrayList<>();

    @GetMapping("/api/v1/users")
    @Deprecated
    public List<UserResponse> getAllUsers(){
       return data;
    }

    @PostMapping("api/v1/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest request){
        UserResponse response  = new UserResponse();
        BeanUtils.copyProperties(request, response);
        data.add(response);
        return response;
    }

    @DeleteMapping("/api/v1/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAllUsers(){
        data.clear();
        if(data.isEmpty()) return true;
        return false;
    }
}
