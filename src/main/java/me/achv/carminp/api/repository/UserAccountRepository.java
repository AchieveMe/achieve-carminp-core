package me.achv.carminp.api.repository;

import me.achv.carminp.api.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by gmagalhaes on 23/11/15.
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "/api/users")
public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    UserAccount findByUsername(final String username);

    UserAccount findByName(final String name);

    UserAccount findByEmail(final String email);

}
