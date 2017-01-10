package com.upraiselabs.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class ConfigAccessor {

  private static final String RUN_ON_ENV_PROP = "upraiselabs.runOnEnv";
  private static final String CONFIG_PATH = "/runOnEnv/";
  private static final String CONFIR_EXT = ".properties";

  public static String getConfig(String propName) throws IOException {

    Properties systemProps = System.getProperties();
    String runOnEnvFile = systemProps.getProperty(RUN_ON_ENV_PROP);
    InputStream input = null;

    // load a properties file from class path, inside static method
    input = ConfigAccessor.class.getClassLoader().getResourceAsStream(
        CONFIG_PATH.concat(runOnEnvFile).concat(CONFIR_EXT));
    if (input == null) {
      System.out
          .println(Class.class.getName() + ":" + new FileNotFoundException());
      return null;
    }

    Properties prop = new Properties();
    prop.load(input);
    input.close();

    return prop.getProperty(propName);
  }
}
