<!-- 导航栏 -->
<template>
    <div class="allHeader">
        <div class="logo">
            <img src="../assets/WHUTlogo.png" @click="jump">
        </div>

        <div class="home">
            <router-link to="./uploadImage">
                <span>首页</span>
            </router-link>
        </div>

        <div class="reservation" @mouseleave="leaveReservation()" @mouseenter="enterReservation()">
            <a href="javascript:void(0)">
                <span>会议中心</span>
            </a>

            <div v-show="showReservation">
                <router-link to="./addRent">
                    <span>网络预订</span>
                </router-link>

                <router-link to="./updatePassword">
                    <span>会议管理</span>
                </router-link>
            </div>
        </div>

        <div class="data" @mouseleave="leaveData()" @mouseenter="enterData()">
            <a href="javascript:void(0)">
                <span>服务中心</span>
            </a>

            <div v-show="showData">

                <!-- 数据上传接口 -->
                <router-link to="./productManager">
                    <span>纪要管理</span>
                </router-link>

                <!-- 数据下载接口 -->
                <router-link to="./sellData">
                    <span>用户通知</span>
                </router-link>
            </div>
        </div>

        <div class="sea">
            <Input search enter-button placeholder="Enter something..." />
        </div>

        <div class="center" @mouseleave="leaveCenter()" @mouseenter="enterCenter()">
            <a href="javascript:void(0)">
                <img class="person" src="../assets/personal.png">
            </a>

            <div v-show="showCenter">
                <router-link to="./updatePassword">
                    <span>修改密码</span>
                </router-link>

                <span @click="logout()" class="trigger">退出</span>

            </div>
        </div>
    </div>
</template>

<script>

import storage from '../utils/storage'

export default {

  data () {
    
    return {

      showReservation: false,
      showData: false,
      showCenter: false,
	  message: ''

    }

  },

  methods: {

    jump () {

        this.$router.push('/index')

    },

    logout () {
        
      var _this = this

      _this.message = 'logout'

      this.axios({

        method: 'post',

        url: 'http://localhost:8080/logout',

        headers: {

          'Content-Type': 'application/json;charset=utf-8'

        },

        data: {

          message: _this.message

        },

        responseType: 'json'

      }).then(function (response) {

        var info = response.data.info
        var code = response.data.code

        if (code == 200) {

        //   window.localStorage.removeItem('token');
          //   window.localStorage.removeItem('user');

          storage.remove('token');
        //   storage.remove('user')

          _this.$router.replace('/login')
          _this.$Message.success('退出成功')

        } else if (code == 400) {
          
          _this.$Message.error('遭遇异常！')
       
        } else {
        
          _this.$Message.error('未知错误...')
        
        }
      
      }).catch(function (error) {
      
          _this.$Message.error('系统错误！')
      
      })
    
    },

    enterReservation () {
        this.showReservation = true  
    },

    leaveReservation () {
        this.showReservation = false
    },

    enterData () {
        this.showData = true
    },

    leaveData () {
        this.showData = false
    },

    enterCenter () {
        this.showCenter = true
    },

    leaveCenter () {
        this.showCenter = false
    }

  },

  computed: {

  },

  mounted () {

  }

}
</script>

<style lang="less" scoped>

.allHeader {
    
    z-index: 11;
    position: absolute;
    top: 0px;
    left: 0px;
    width: 100%;
    height: 73px;
    // background-color: #4169E1;
}

.logo img {

    cursor: pointer;
    position: relative;
    left: 10px;
    top: 10px;
    height: 60px;
    float: left;
}

span {
    font-size: 24px;
    letter-spacing: 2px;
    color: white;
}

.home {
    position: relative;
    left: 165px;
    top: 27px;
    float: left;
}

.reservation {
    position: relative;
    top: 27px;
    float: left;
    left: 205px;
}

.reservation div {
    position: absolute;
    left: -10px;
    width: 120px;
    text-align: center;
    background-color: whitesmoke;
    border-radius: 5px;
    transition: all 400ms;
    animation: demo 400ms linear;
}

.reservation div span {
    color: black;
}

//滑动显示
@keyframes demo {
    0%{
        transform: translateY(-5px);
    }
    100%{
        transform: translateY(0px);
    }
}

.data {
    position: relative;
    top: 27px;
    float: left;
    left: 265px;
}

.data div {
    position: absolute;
    left: -10px;
    width: 120px;
    text-align: center;
    background-color: whitesmoke;
    border-radius: 5px;
    transition: all 400ms;
    animation: demo 400ms linear;
}

.data div span {
    color: black;
}

.sea {
    position: relative;
    width: 300px;
    top: 30px;
    left: 510px;
    float: left;
}

.update {
    position: absolute;
    left: 82%;
    margin-top: -40px;
}

.logout {
    position: absolute;
    left: 92%;
    margin-top: -40px;
}

.center {
    position: relative;
    top: 30px;
    float: left;
    left: 670px;
}

.center div {
    position: absolute;
    left: -30px;
    width: 90px;
    text-align: center;
    background-color: whitesmoke;
    border-radius: 5px;
    transition: all 400ms;
    animation: demo 400ms linear;
}

.center div span {
    font-size: 18px;
    color: black;
}

.person {
    width: 34px;
}

.trigger:hover {
    cursor: pointer;
}

</style>
