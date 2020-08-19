package cn.xiaobei56.mvcdemo.bean

/**
 * @author XiaoBei
 * @package cn.xiaobei56.mvcdemo.bean.TestBean
 * @FileName TestBean
 * @date 2020/8/17 14:19
 * @description TODO
 */
class TestBean {
    var name: String? = null
        get() = if (field == null) "" else field
        set(name) {
            field = name ?: ""
        }
    var age = 0

}