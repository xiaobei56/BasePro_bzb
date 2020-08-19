package cn.xiaobei56.mvvmdemo.bean

/**
 * @author XiaoBei
 * @package cn.xiaobei56.mvvmdemo.bean.UserInfo
 * @FileName UserInfo
 * @date 2020/8/17 16:41
 * @description TODO
 *
 */
class UserInfo {
    var name: String? = null
        get() = if (field == null) "" else field
        set(name) {
            field = name ?: ""
        }

    var age:Int?=0
        get() = if (field==0) -1 else field
        set(value){
            field = value
        }
}