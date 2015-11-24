package me.achv.carminp.api.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.After;
import org.junit.Before;

/**
 * Created by gmagalhaes on 23/11/15.
 */
public abstract class AbstractEmbeddedMongo {

    private static final MongodStarter starter = MongodStarter.getDefaultInstance();

    private MongodExecutable mongodExe;
    private MongodProcess mongod;
    private MongoClient mongo;

    @Before
    public void setUp() throws Exception {
        mongodExe = starter.prepare(new MongodConfigBuilder()
        .version(Version.Main.DEVELOPMENT)
        .net(new Net(12345, Network.localhostIsIPv6()))
        .build());

        mongod = mongodExe.start();

        mongo = new MongoClient("localhost", 12345);
    }

    @After
    public void tearDown() {
        mongod.stop();
        mongodExe.stop();
    }

    public Mongo getMongo() {
        return mongo;
    }
}
