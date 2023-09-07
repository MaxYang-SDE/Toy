package constants;

import utils.ApplicationProperties;

public enum URL {
    LOGIN("auth/login"),
    CREATE_USER("admin/saveSystemUser"),
    MANAGER_USER("admin/viewSystemUsers"),
    DASHBOARD("dashboard/index");

    private final String url;
    URL(String path) {
        this.url = ApplicationProperties.get("base_url") + path;
    }
    public String toString() {
        return url;
    }
}
