import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '@/views/Login'
import Nav from '@/components/Navigation'


// import ChangePassword from '@/views/ChangePassword'

import Product from '@/views/Product'
import Index from '@/views/Index'
import SellData from '@/views/SellData'
import UpdatePassword from '@/views/UpdatePassword'
import Register from '@/views/Register'
import FarmManager from '@/views/FarmManager'
import ProductManager from '@/views/ProductManager'
import AddProductInfo from '@/views/AddProductInfo'

import AddRentInfo from '@/views/AddRentInfo'

import Order from '@/views/Order';

import Header from '@/components/Header'
import Footer from '@/components/Footer'

Vue.use(VueRouter)

const routes = [

    // {
    //     path: '/login', // path为/, 对应的组件为首页
    //     name: 'login', // 映射的组件
    //     component: Login
    // },
    {
        path: '/',
        name: 'login',
        components: {

            default: Login,
            footer: Footer

        }
    },

    {
        path: '/order',
        name: 'order',
        components: {

            nav: Header,
            default: Order,
            footer: Footer

        }

    },

    {
        path: '/updatePassword',
        name: 'updatePassword',
        components: {

            default: UpdatePassword,
            nav: Header,
            footer: Footer

        }

    },

    {
        path: '/product',
        name: 'product',
        components: {

            default: Product,
            nav: Header,
            footer: Footer

        }

    },

    {
        path: '/addProductInfo',
        name: 'addProductInfo',
        components: {

            default: AddProductInfo,
            nav: Header,
            footer: Footer

        }

    },

    {
        path: '/addRentInfo',
        name: 'addRentInfo',
        components: {

            default: AddRentInfo,
            nav: Header,
            footer: Footer

        }

    },

    {
        path: '/index',
        name: 'index',
        components: {

            default: Index,
            nav: Header,
            footer: Footer

        }

    },

    {
        path: '/sellData',
        name: 'sellData',
        components: {

            default: SellData,
            nav: Header,
            footer: Footer

        }

    },

    {
        path: '/productManager',
        name: 'productManager',
        components: {

            default: ProductManager,
            nav: Header,
            footer: Footer

        }
    },

    {

        path: '/farmManager',
        name: 'farmManager',
        components: {

            default: FarmManager,
            nav: Header,
            footer: Footer

        }

    },

    {
        path: '/register',
        name: 'register',
        components: {

            default: Register,
            footer: Footer

        }
    },

    {
        path: '/main',
        name: 'main',
        components: {

            default: Home,
            nav: Nav

        }
    },

    {
        path: '*', // 访问路径不存在时, 重定向到登录界面
        redirect: '/'
    }

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router