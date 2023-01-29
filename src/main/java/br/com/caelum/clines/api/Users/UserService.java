package br.com.caelum.clines.api.Users;

import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserViewMapper viewMapper;
    private final UserFormMapper formMapper;

    public List<UserView> findAll() {
        return repository.findAll().stream().map(viewMapper::map).collect(toList());
    }

    public UserView showUserBy(Long id) {

        var user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot find user"));

        return viewMapper.map(user);
    }

    public Long createUserBy(UserForm form) {
        repository.findByEmail(form.getEmail()).ifPresent(User -> {
            throw new ResourceAlreadyExistsException("Email already exists");
        });

        var user = formMapper.map(form);

        repository.save(user);

        return user.getId();
    }
}
