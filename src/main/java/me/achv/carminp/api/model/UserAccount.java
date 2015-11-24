package me.achv.carminp.api.model;

import net.sf.oval.constraint.NotNull;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by gmagalhaes on 23/11/15.
 */
@Document
public final class UserAccount extends AbstractModel {

    @NotNull
    private String name, username;

    @Field("email")
    @Indexed(unique = true)
    private String email;

    public UserAccount(String name, String username, String email) {
        this.name =  name;
        this.username = username;
        this.email = email;
    }

    protected UserAccount () {}

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
