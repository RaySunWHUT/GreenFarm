import Vue from 'vue'
import Vuex from 'vuex'
import Storage from '@/utils/storage'

Vue.use(Vuex)

export default new Vuex.Store({

    state: { // 数据保存在state内，在任何组件内通过this.$store.state.XX来读取

        data: {

        },
        token: null,

        user: JSON.parse(Storage.get('User')) || {

            userAccount: null,
            password: null,
        },
        summary: JSON.parse(Storage.get('Object')) || {
            sumId: null,
            title: null,
            content: null,
            confId: null,
            updateTime: null
        },

        sumId: null,
        title: null,
        content: null,
        confId: null,
        updateTime: null


    },

    mutations: { // 用来直接修改state内的数据；在组件内，通过·this.$store.commit(方法名)来执行mutations

        setToken(state, value) {
            state.token = value
        },


        setUserAccount(state, value) {

            state.userAccount = value;

        },

        setPassword(state, value) {

            state.password = value;

        },

        setSummary(state, summary) {
            state.summary = summary;
        },

        setSumId(state, value) {

            state.sumId = value;

        },

        setTitle(state, value) {

            state.title = value;

        },

        setContent(state, value) {

            state.content = value;

        },

        setConfId(state, value) {

            state.confId = value;

        },

        setUpdateTime(state, value) {

            state.updateTime = value;

        },

        saveUser(state, data) {
            state.user = data;
            Storage.set('User', JSON.stringify(state.user));
        },

        // createUser(state, payload) {

        //     state.user.userAccount = payload.userAccount
        //     state.user.password = payload.password

        //     if (state.token === null) { // token失效，status == 0

        //         state.user.status = 0

        //     } else { // token存在, status == 1

        //         state.user.status = 1

        //     }

        // }

    },

    actions: { // 提交的是mutation, 并且可以异步操作
        // action在组件内通过this.$store.dipatch(方法名)来触发
        // 作用：存在业务逻辑

    },

    getters: { // 将各个组件中的computed中的方法提取出来

    },

    modules: { // 用来将store分割到不同模块

    }

})