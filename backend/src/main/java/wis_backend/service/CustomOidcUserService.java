package wis_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import wis_backend.model.User;
import wis_backend.repo.UserRepo;

@Service
public class CustomOidcUserService extends OidcUserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) {
        OidcUser oidcUser = super.loadUser(userRequest);

        System.out.println("OIDC SERVICE TRIGGERED");

        String email = oidcUser.getEmail();
        String name = oidcUser.getFullName();

        Optional<User> existingUser = userRepo.findByEmail(email);

        if (existingUser.isEmpty()) {
            User user = new User();
            user.setEmail(email);
            user.setUsername(name);
            userRepo.save(user);
            System.out.println("User saved to DB");
        }

        return oidcUser;
    }
}
