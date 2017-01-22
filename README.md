# springboot
######开始学习SpringBoot
SpringBoot ＋ mybatis
####利用IDE创建一个maven-webapp
- 添加依赖

```

	    <parent>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-parent</artifactId>
			<version>1.3.0.M2</version>
		</parent>
		
		<!-- 添加依赖 -->
	    <dependencies>
	    
	    	<!-- mybatis -->
	        <dependency>
				<groupId>org.mybatis.spring.boot</groupId>
				<artifactId>mybatis-spring-boot-starter</artifactId>
				<version>1.1.1</version>
			</dependency>
			
			<!-- springboot -->
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-test</artifactId>
				<scope>test</scope>
			</dependency>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-web</artifactId>
				<version>1.3.5.RELEASE</version>
			</dependency>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-thymeleaf</artifactId>
				<version>1.3.5.RELEASE</version>
			</dependency>
	        <!-- ... -->
	        
	        <!-- 修改代码后自动生效，Reload Java classes without restarting the container -->
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-devtools</artifactId>
			</dependency>
	
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-tx</artifactId>
				<version>4.1.5.RELEASE</version>
			</dependency>
			<!-- mysql -->
			<dependency>
				<groupId>mysql</groupId>
				<artifactId>mysql-connector-java</artifactId>
				<version>5.1.21</version>
			</dependency>
			
	    </dependencies>

```
- 创建启动类

```
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	
	@EnableAutoConfiguration
	@SpringBootApplication
	public class Application {
	
		public static void main(String[] args) {
			SpringApplication.run(Application.class,args);
		}
		
	}

```
- 创建一个Controller 

```
	@Controller
	public class HellowWorldController {
		
		@RequestMapping("/hello")
		public String sayHello(){
			
			System.out.println("sayHello");
			return "sayHello";
		}
		
	}

```

####现在就可以run Application

就是这么简单，run Application 
在浏览器输入  http://localhost:8080/hello 


