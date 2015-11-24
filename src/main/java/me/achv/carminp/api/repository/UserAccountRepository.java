package me.achv.carminp.api.repository;

import me.achv.carminp.api.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by gmagalhaes on 23/11/15.
 */
public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    public UserAccount findByUsername(final String username);

    public UserAccount findByName(final String name);

    public UserAccount findByEmail(final String email);

}
