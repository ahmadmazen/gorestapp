package in.co.gorest.config;

import in.co.gorest.shared.Constants;
import in.co.gorest.utils.ClientUtils;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
@ComponentScan(basePackages = Constants.BASE_PACKAGE)
public class Config {
    @Bean
    public Retrofit retrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

//    @Bean
//    public BCryptPasswordEncoder  bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }


}
