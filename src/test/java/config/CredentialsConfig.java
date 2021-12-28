package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:credential.properties"})
public interface CredentialsConfig extends Config {
    String browserStackUser();

    String browserStackKey();

    String browserStackAppURL();

    String selenoidUser();

    String selenoidPass();
}
