package lut.software.gavinoblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("lut.software.gavinoblog.mapper")
//@EnableCaching
public class GavinoBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(GavinoBlogApplication.class, args);
    }

}
