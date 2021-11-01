package com.dobedkina.autotests.config.hh.ru;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/hh.ru/app.properties"
})
public interface AppConfig extends Config {
    String userEmail();

    String userPassword();

}
