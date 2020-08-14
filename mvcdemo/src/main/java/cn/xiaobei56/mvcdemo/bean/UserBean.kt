package cn.xiaobei56.mvcdemo.bean

/**
 * @author XiaoBei
 * @package cn.xiaobei56.mvcdemo.bean.UserBean
 * @FileName UserBean
 * @date 2020/8/14 13:30
 * @description TODO
 */
class UserBean {
    var uName: String? = null
    var uAge = 0
    var uHabit: String? = null

    constructor() : this("小明", 12, "吃")
    constructor(
        uName: String, uAge: Int, uHabit: String
    ) {
        this.uName = uName
        this.uAge = uAge
        this.uHabit = uHabit
    }
}