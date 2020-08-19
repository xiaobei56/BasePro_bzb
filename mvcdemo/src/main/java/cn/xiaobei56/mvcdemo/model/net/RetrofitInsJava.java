package cn.xiaobei56.mvcdemo.model.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import cn.xiaobei56.mvcdemo.App;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author XiaoBei
 * @package cn.xiaobei56.mvcdemo.model.net.RetrofitInsJava
 * @FileName RetrofitInsJava
 * @date 2020/8/14 13:44
 * @description TODO
 */
class RetrofitInsJava {
    private volatile static RetrofitInsJava instance = null;

    /**
     * 私有构造
     */
    private RetrofitInsJava() {
    }

    /**
     * 单例模式
     */
    public static RetrofitInsJava getInstance() {
        if (instance == null) {
            synchronized (RetrofitInsJava.class) {
                if (instance == null) {
                    instance = new RetrofitInsJava();
                }
            }
        }
        return instance;
    }

    public Retrofit getService(final Context context) {
//        File file=
//        Cache cache=new Cache()
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response originalResponse = chain.proceed(chain.request());
                        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                            HashSet<String> cookies = new HashSet<>();

                            for (String header : originalResponse.headers("Set-Cookie")) {
                                cookies.add(header);
                            }

                            SharedPreferences.Editor config = context.getSharedPreferences("config", Context.MODE_PRIVATE)
                                    .edit();
                            config.putStringSet("cookie", cookies);
                            config.commit();
                        }
                        return originalResponse.priorResponse();
                    }
                })
//                .addNetworkInterceptor()
//                .connectTimeout(10000)
                .retryOnConnectionFailure(false)
//                .cache()
                .build();
        Retrofit retrofit = new Retrofit
                .Builder().baseUrl("http://101.200.177.116:38080/app/mock/16/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}
