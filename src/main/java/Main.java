import configuration.HelloWorldConfiguration;
import controller.HelloWorldService;
import controller.TemplateHealthCheckService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Main extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        HelloWorldService hwService = new HelloWorldService(configuration.getTemplate(), configuration.getDefaultName());
        TemplateHealthCheckService healthCheckService = new TemplateHealthCheckService(configuration.getTemplate());

        environment.healthChecks().register("template", healthCheckService);
        environment.jersey().register(hwService);
    }
}
