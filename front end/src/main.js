import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import VueAxios from 'vue-axios'
import Qs from 'qs'
import iView, { TabPane } from 'iview'
import 'iview/dist/styles/iview.css' // 很重要, 必须加

import $ from 'jquery'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'

import BaiduMap from 'vue-baidu-map'

import storage from './utils/storage'

// require('./utils/mock')

Vue.config.productionTip = false

Vue.use(VueAxios, axios)
Vue.use(iView)

Vue.use(BaiduMap, {
    // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
    ak: 'F7TG0pImdhbepUEgGazHQe0lyCLUelqf'
})


// router.beforeEach((to, from, next) => {

//     if (to.fullPath === '/') { // "/"为login路径

//         next()

//     } else {

//         var token = storage.get('token')

//         if (token != null) {

//             next()

//         } else {

//             next('*')

//         }

//     }

// })


new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');