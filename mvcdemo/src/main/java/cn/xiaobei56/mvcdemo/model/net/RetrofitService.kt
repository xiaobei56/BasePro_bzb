package cn.xiaobei56.mvcdemo.model.net

import cn.xiaobei56.mvcdemo.bean.UserBean
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author XiaoBei
 * @package cn.xiaobei56.mvcdemo.model.net.Service
 * @FileName Service
 * @date 2020/8/14 13:21
 * @description TODO
 */
internal interface RetrofitService {
    @GET("userinfo/list")
    fun getUserInfo(
        @Query("type") type: String?,
        @Query("sign") sign: String?
    ): Observable<UserBean?>?
}