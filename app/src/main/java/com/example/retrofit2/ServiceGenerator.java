package com.example.retrofit2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    //this GsonBuilder make null all fields, and is used to customize gson
    private static Gson gson = new GsonBuilder().serializeNulls().create();

    //With a HttpLoggingInterceptor, OkHttp will automatically log incoming and outgoing HTTP requests and
    // responses to Logcat, where we can then see information like the type of request,
    // the fully resolved URL, the content-type, the different HTTP headers,
    // and the payload of the body itself, which contains the actual JSON, form-data etc.
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)); //gson is added to make null not updated fields

    private static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass){
        //we must avoid sharing sensitive data into logcat if we aren't in Debug mode
        if(BuildConfig.DEBUG){
            if(!okHttpClient.interceptors().contains(loggingInterceptor)){
                /*
                okHttpClient.addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();

                        Request newRequest = originalRequest.newBuilder()
                                .header("Interceptor-Header", "xyz")
                                .build();

                        return chain.proceed(newRequest);
                    }
                })
                        .addInterceptor(loggingInterceptor)
                        .build();*/
                okHttpClient.addInterceptor(loggingInterceptor);
                builder.client(okHttpClient.build());
                retrofit = builder.build();
            }
        }

        return retrofit.create(serviceClass);
    }
}
