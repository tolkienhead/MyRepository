import org.example.junitdmdev.User;
import org.example.junitdmdev.UserService;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    private UserService userService;
    private static final User IVAN = User.of(1,"Ivan", "123");
    private static final User PETR =  User.of(2,"Petr","111");

    @BeforeAll
    static void prepareAll(){
        System.out.println("Before All");
    }

    @BeforeEach
    void prepare(){
        System.out.println("Before Each");
        userService = new UserService();
    }

    @Test
    void usersEmptyIfNoUserAdded() {
        var users = userService.getAll();
        assertTrue(users.isEmpty());
    }

    @Test
    void userSizeIfUserAdded(){
        userService.add(IVAN);
        userService.add(PETR);
        List<User> users = userService.getAll();
        assertThat(users).hasSize(2);
    }

    @Test
    void loginSuccessIfUserExists(){
        userService.add(IVAN);
        Optional<User> maybeUser = userService.login(IVAN.getUsername(), IVAN.getPassword());
        assertThat(maybeUser).isPresent();
        maybeUser.ifPresent(user -> assertThat(user).isEqualTo(IVAN));
    }

    @Test
    void loginFailedIfPasswordIsNotCorrect(){
        userService.add(IVAN);
        Optional<User> maybeUser = userService.login(IVAN.getUsername(), "lalala");
        assertTrue(maybeUser.isEmpty());
    }

    @Test
    void loginFailedIfUserDoesNotExists(){
        Optional<User> maybeUser = userService.login(IVAN.getUsername(), IVAN.getPassword());
        assertTrue(maybeUser.isEmpty());
    }

    @AfterEach
    void deleteDate(){
        System.out.println("After Each");
    }

    @AfterAll
    static void deleteDateAll(){
        System.out.println("After All");
    }
}
