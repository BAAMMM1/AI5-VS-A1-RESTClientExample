package app.layerDataAccess.configure;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Christian G. on 27.10.2017
 */
@Configuration
public class RestConfigure {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        RestTemplate result = builder.build();
        result.setErrorHandler(new MyErrorHandler());
        return result;
    }

}
