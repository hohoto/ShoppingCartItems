package ShoppingCart.User.Controller;

import ShoppingCart.User.Model.User;
import ShoppingCart.User.Model.UserDao;
import ShoppingCart.User.View.CreateUserRequest;
import ShoppingCart.User.View.CreateUserResponse;
import ShoppingCart.User.View.ViewUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/CreateUsers")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = new User(createUserRequest.getUsername(), createUserRequest.getPassword());
        User newUser = userDao.save(user);
        ViewUser userView = new ViewUser(newUser.getId(), newUser.getName());
        return new ResponseEntity<>(new CreateUserResponse(), HttpStatus.CREATED);
    }
}
