package controller;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheckService extends HealthCheck {

    private final String template;

    public TemplateHealthCheckService(String template) {
        this.template = template;
    }


    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST"))
            return Result.unhealthy("Template doesn't have a name");

        return Result.healthy();
    }
}
