package ShoppingCart.Session.Controller;

import ShoppingCart.Session.Model.Session;
import ShoppingCart.Session.Model.SessionManager;
import ShoppingCart.Session.View.LogInRequest;
import ShoppingCart.User.Model.User;
import ShoppingCart.User.Model.UserDao;
import ShoppingCart.User.View.ViewUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
public class SessionController {
    private static final String SESSION_TOKEN = "session_token";
    private static final String USER_ID = "user_id";
    private UserDao userDao;
    private SessionManager sessionsManager;

    public SessionController(UserDao userDao, SessionManager sessionManager) {
        this.userDao = userDao;
        this.sessionsManager = sessionManager;
    }

    /**
     * Login
     */
    @PostMapping("/session")
    public ResponseEntity login(HttpServletResponse response, @RequestBody LogInRequest login) {
        User user = userDao.getByName(login.getUsername());
        if (user == null || !user.getPassword().equals(login.getPassword())) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        // add token
        String token = UUID.randomUUID().toString();
        sessionsManager.getSessions().put(user.getId(), new Session(user.getId(), token));
        // add cookie
        response.addCookie(new Cookie(USER_ID, Long.toString(user.getId())));
        response.addCookie(new Cookie(SESSION_TOKEN, token));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * current user
     */
    @GetMapping("/current")
    public ResponseEntity<ViewUser> current(@CookieValue(name = USER_ID, defaultValue = "0") long userId, @CookieValue(name = SESSION_TOKEN, defaultValue = "") String token) {
        Session session = sessionsManager.getSessions().get(userId);
        //check token
        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        // authority success
        User user = userDao.getById(session.getUserId());
        return new ResponseEntity<>(new ViewUser(user.getId(), user.getName()), HttpStatus.OK);
    }

    /**
     * Logout
     */
    @DeleteMapping("/deleteSession")
    public ResponseEntity logout(@CookieValue(name = USER_ID, defaultValue = "0") long userId, @CookieValue(name = SESSION_TOKEN, defaultValue = "") String token) {
        Session session = sessionsManager.getSessions().get(userId);
        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        // delete Session Information
        sessionsManager.getSessions().remove(userId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}