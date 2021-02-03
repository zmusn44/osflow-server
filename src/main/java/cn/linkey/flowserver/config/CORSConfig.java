package cn.linkey.flowserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * 全局CORS配置类
 *
 * @author alibao Y , walkwithdream@163.com
 * <p>createTime 2021-02-03 13:23 </p>
 * @version v1.0
 */
@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Value("${cors.Access-Control-Allow-Origin}")
    private String allowedOrigins;

    @Value("${cors.Access-Control-Allow-Headers}")
    private String allowedHeaders;

    @Value("${cors.Access-Control-Allow-Methods}")
    private String[] allowedMethods;

    @Value("${cors.Access-Control-Max-Age}")
    private int maxAge;

    @Value("${cors.Access-Control-Allow-Credentials}")
    private Boolean allowCredentials;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")                      // 允许跨域访问的路径
                .allowedOrigins(allowedOrigins)                    // 允许跨域访问的源
                .allowedHeaders(allowedHeaders)                    // 允许请求头参数
                .allowedMethods(allowedMethods)                    // 允许请求方法
                .maxAge(maxAge)                                    // 预检间隔时间
                .allowCredentials(allowCredentials);               // 是否发送cookie

    }
}
