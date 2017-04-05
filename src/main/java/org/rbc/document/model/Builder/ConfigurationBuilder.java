package org.rbc.document.model.Builder;

import org.rbc.document.model.Configuration;

import java.util.Date;

/**
 * Created by lena on 2017-04-04.
 */
public class ConfigurationBuilder {

    private int id;
    private String appCode;
    private String version;
    private String configDoc;
    private Date modifiedDate;

    public ConfigurationBuilder withId(int id){
        this.id = id;
        return this;
    }

    public ConfigurationBuilder withAppCode(String appCode){
        this.appCode = appCode;
        return this;
    }

    public ConfigurationBuilder withVersion(String version){
        this.version = version;
        return this;
    }

    public ConfigurationBuilder withConfigDoc(String configDoc){
        this.configDoc = configDoc;
        return this;
    }

    public ConfigurationBuilder withModifiedDate(Date modifiedDate){
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Configuration build(){
        Configuration config = new Configuration();

        config.setConfigDoc(this.configDoc);
        config.setAppCode(this.appCode);
        config.setVersion(this.version);
        config.setId(this.id);

        return config;
    }
}
