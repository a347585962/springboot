package com.songlin.springdemo;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by wusonglin on 17/1/27.
 */
//@Configuration 表示为一个配置类
@Configuration
//开启swagger2功能
@EnableSwagger2
public class Swagger2 {

    public Docket createRestApi(){

        return new Docket(DocumentationType.SWAGGER_2)
                //创建一个ApiInfo实例，文档页面信息内容
                .apiInfo(apiInfo())
                .select()
                //控制暴露出去的路径下的实例
                //如果某个接口不想暴露,可以使用以下注解
                //@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
                .apis(RequestHandlerSelectors.basePackage("com.songlin.springdemo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口")
                .contact("吴松霖")
                .version("1.0")
                .description("松霖api")
                .build();
    }

}
