package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface credentialsConfig extends Config {
    String login();
    String password();
    String remotedriver();
    String baseurl();


}