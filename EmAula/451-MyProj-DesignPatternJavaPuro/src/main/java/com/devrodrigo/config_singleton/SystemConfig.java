package com.devrodrigo.config_singleton;

public class SystemConfig {
    private final String environment = "PRODUCTION";

    private SystemConfig() {} // Construtor privado... Impede ser criado uma nova instância (new ...)

    private static class InstanceHolder {
        private static final SystemConfig INSTANCE = new SystemConfig();
    }

    public static SystemConfig getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public String getEnvironment() { return environment; }

}
