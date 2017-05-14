package com.david.conf;

import com.david.model.User;
import com.david.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 03/05/2017.
 */

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User userFromRepository = userRepository.findByUsername(authentication.getName());
        if(userFromRepository != null){
            if(userFromRepository.getPassword().equals(authentication.getCredentials())){
                List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
                grantedAuths.add(new SimpleGrantedAuthority(userFromRepository.getRoles().get(0).getName()));

                return new UsernamePasswordAuthenticationToken(
                        authentication.getName(),
                        authentication.getCredentials(),
                        grantedAuths);
            }else{
                throw new BadCredentialsException("invalid password!");
            }

        }else{
            throw new UsernameNotFoundException("unknown username");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}