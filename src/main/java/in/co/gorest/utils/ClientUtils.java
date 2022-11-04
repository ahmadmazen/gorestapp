package in.co.gorest.utils;

import in.co.gorest.client.GorestClient;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Component
public class ClientUtils {
    private static final Logger log = LoggerFactory.getLogger(ClientUtils.class);

    @Autowired
    private Retrofit gorestApiRetrofit;



    public OkHttpClient.Builder createHttpClientBuilder(Interceptor... interceptors) {
        List<Interceptor> interceptorList = null;
        if (interceptors != null && interceptors.length > 0) {
            interceptorList = new ArrayList();
            interceptorList.addAll(Arrays.asList(interceptors));
        }

        return this.createHttpClientBuilder((List)interceptorList);
    }

    public OkHttpClient.Builder createHttpClientBuilder(List<Interceptor> interceptors) {
        log.info("adding interceptors: {} ", Arrays.toString(interceptors.toArray()));
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(20L, TimeUnit.SECONDS).writeTimeout(20L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS);
        if (CollectionUtils.isNotEmpty(interceptors)) {
            Iterator var3 = interceptors.iterator();

            while(var3.hasNext()) {
                Interceptor interceptor = (Interceptor)var3.next();
                httpClient.addInterceptor(interceptor);
            }
        }

        return httpClient;
    }

    private <T> T createClient(Retrofit retrofit, Class<T> clientClass) {
        log.info("creating client {}", clientClass.getName());
        return retrofit.create(clientClass);
    }
    public <T> T createGorestClient(Class<T> clientClass) {
       return this.createClient(this.gorestApiRetrofit, clientClass);
    }
}

