package com.onlineshop.comonlineshop.controllers;

import com.onlineshop.comonlineshop.model.User;
import com.onlineshop.comonlineshop.model.UserRole;
import com.onlineshop.comonlineshop.model.dto.UserDto;
import com.onlineshop.comonlineshop.services.UserService;
import com.onlineshop.comonlineshop.utils.ApiResponse;
import com.onlineshop.comonlineshop.utils.UtilsResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
// ne ajuta sa vedem adresa controllerului , prescurtare care se foloseste atunci cand definim un api ,
//si zice aici este un api de users
@CrossOrigin("http://localhost:4200")
// vei primii requesturi de pe adresa asta asta face crossorigin ex cand te conectezi de pe tel vei primii msg cineva incearca sa se conecteze de pe tel
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllUsers() {
       return UtilsResponse.success("Lista utilizatori", userService.getAllUsers());

    }

    @PostMapping // @Valid activeaza cele 3 adnotari din UserDTO
    public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody UserDto body) { // fara requestBody userul nostru va fi null
        return UtilsResponse.success("Utilizator creat cu succes",
                userService.createUser(body));


        //      body.forEach((key,value) ->{
//          System.out.println(key + ": " + value);
//      });
//
//        User user = new User();
//        user.setName(body.get("name"));
//        user.setEmail(body.get("email"));
//        user.setPassword(body.get("password"));
//        user.setAddress(body.get("address"));
//        user.setPhone(body.get("phone"));
//        user.setRole(UserRole.valueOf(body.get("role")));
//        user.setCommandList(new ArrayList<>());
//        return userService.createUser(user);
    }

    @PutMapping
    public ResponseEntity<ApiResponse> updateUser(@Valid @RequestBody UserDto body) {
        return UtilsResponse.success("Utilizator modificat cu succes",
                userService.updateUser(body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id) { // acest pathvariable spune faptu ca in url nostru pe ultimul / vom avea id ul , ia-l pe acela si mapeaza-l
        userService.deleteUserById(id);
        return UtilsResponse.success("Utilizator sters cu succes");

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable("id") int id) {
        return UtilsResponse.success("Utilizatorul cu Id-ul " + id
                , userService.getUserById(id));
    }

}
