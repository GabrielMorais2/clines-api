package br.com.caelum.clines.api.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserView {

    private Long id;
    private String name;
    private String email;

}
