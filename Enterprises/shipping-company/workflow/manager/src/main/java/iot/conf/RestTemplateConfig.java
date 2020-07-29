package iot.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ConditionalOnClass(value = {RestTemplate.class, HttpClient.class})
public class RestTemplateConfig {
    private ClientHttpRequestFactory createFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(10000);
        requestFactory.setConnectTimeout(10000);
        return requestFactory;
    }

    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestTemplate getRestTemplate() {
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
//        messageConverters.add(new FormHttpMessageConverter());
//        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
//        messageConverters.add(new MappingJackson2HttpMessageConverter());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(createFactory());
        return restTemplate;
    }

}
