package br.com.caelum.clines.api.Users;

import br.com.caelum.clines.shared.domain.User;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

import static br.com.caelum.clines.shared.util.StringNormalizer.normalize;

@Component
public class UserFormMapper implements Mapper<UserForm, User> {
    @Override
    public User map(UserForm source) {
        return new User(normalize(source.getName()), source.getEmail(), source.getPassword());
    }
}
