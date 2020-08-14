package cn.xiaobei56.mvcdemo;


import android.app.Application;
import android.content.Context;

/**
 * @author XiaoBei
 * @package cn.xiaobei56.mvcdemo.App
 * @FileName App
 * @date 2020/8/14 16:13
 * @description TODO
 */
public class App extends Application {
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
