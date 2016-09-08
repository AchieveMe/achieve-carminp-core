package me.achv.carminp.api.repository;

import me.achv.carminp.api.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by gmagalhaes on 23/11/15.
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    UserAccount findByUsername(@Param("username") final String username);

    UserAccount findByName(@Param("name") final String name);

    UserAccount findByEmail(@Param("email") final String email);

}
