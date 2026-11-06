package domain.service;

import domain.enums.AuthProvider;
import domain.repository.UserRepository;
import domain.entity.User;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String googleId = (String) attributes.get("sub");
        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String picture = (String) attributes.get("picture");

        processUserOAuth(email, name, googleId, picture);
        return oAuth2User;
    }

    private void processUserOAuth(String email, String name, String googleId, String pictureUrl) {
        userRepository.findByEmail(email).ifPresentOrElse(existingUser -> {
            existingUser.setGoogleId(googleId);
            existingUser.setPictureUrl(pictureUrl);
            userRepository.save(existingUser);
        }, () -> {
            User newUser = new User(name, email, googleId, pictureUrl, AuthProvider.GOOGLE);
            userRepository.save(newUser);
        });
    };
};
