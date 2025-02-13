package br.com.caelum.clines.api.Users;

import br.com.caelum.clines.api.aircraft.AircraftView;
import br.com.caelum.clines.shared.domain.Aircraft;
import br.com.caelum.clines.shared.domain.User;
import br.com.caelum.clines.shared.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserViewMapper implements Mapper<User, UserView> {

    @Override
    public UserView map(User source) {
        return new UserView(source.getId() ,source.getName(), source.getEmail());
    }
}
