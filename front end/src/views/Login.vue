<!-- 登陆界面 -->
<template>
<div>

  		<!--头部-->
		<header class="header">

			<img src="@/assets/glogo.png" alt="" />
			<span class="pull-right"><h3><small>欢迎访问</small><b>生态农场</b></h3></span>

		</header>
		<!--主体-->
  		<div class="container mycontent2 text-left">

			<!--透明层 -->
			<div class="loginDiv">
				<h3 class="enter1">商家登录</h3>
				<hr/>

				<!--表单开始-->
				<form id="form-login" class="form-horizontal fora" role="form">

					<!--用户名-->
					<div class="form-group">
						<label for="username" class="col-md-3 control-label">商家账号：</label>
						<div class="col-md-8">
							<input name="businessName" type="text" class="form-control" id="username"  placeholder="请输入用户名" v-model="userAccount">
						</div>
					</div>

					<!--密码-->
					<div class="form-group">
						<label for="password" class="col-md-3 control-label"> 密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
						<div class="col-md-8">
							<input name="password" type="password" class="form-control" id="password"  placeholder="请输入密码" v-model="password">
						</div>
					</div>

					<!-- 记住我-->
					<div class="form-group">
						<div class="col-md-offset-3 col-md-6">
							<div class="checkbox">
								<label>
									<input type="checkbox" id="auto">自动登录

								</label>

                <!-- <router-link to="/">忘记密码?</router-link> -->

							</div>

						</div>
					</div>

					<!--提交按钮-->
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-8">
							<Button class="btn btn-success" type="success" @click="login">商家登录</Button>

							<span class="pull-right">
								<small>还没有账号?</small>
							<router-link to="./Register">注册</router-link></span>
						</div>

					</div>

				</form>
			</div>

		</div>
</div>
</template>

<script>

import storage from '../utils/storage'

export default {

  name: 'login',

  data () {
    return {

      show: null,
      userAccount: '',
      password: ''

    }
  },

  created: function () {

    var _this = this

    document.onkeydown = function (e) {
      
      let key = window.event.keyCode

      if (key == 13) {

        _this.login()
      
      }
    
    }
  
  },

  methods: {
    
    forgetPassword () {
    
      alert('请联系管理员！');
      this.$router.replace('/register');
    
    },

    login: function () {

      var _this = this

      _this.message = 'login'

      this.axios({

        method: 'post',

        url: 'http://localhost:8080/login',

        headers: {

          'Content-Type': 'application/json;charset=utf-8'

        },

        data: {

          userAccount: _this.userAccount,
          password: _this.password

        },

        responseType: 'json'

      }).then(function (response) {
        
        console.table(response.data);

        var info = response.data.info;

        var code = response.data.code;

        if (code == 200) {

          var token = info;

          // var user = {

          //   'userAccount': _this.userAccount,
          //   'password': _this.password

          // }

          storage.set('token', token);

          _this.$store.commit('setToken', token);

          // storage.set('user', user);

          // _this.$store.commit('createUser', user);

          storage.set('userAccount', _this.userAccount);

          _this.$store.commit('setUserAccount', _this.userAccount);

          storage.set('password', _this.password);

          _this.$store.commit('setPassword', _this.password);

          _this.$router.replace('/index');
          _this.$Message.success('登录成功');

        } else if (code == 400 && info == 'incorrect') {

          _this.$Message.error('用户名或密码输入错误！');

        } else {

          // console.table(response.data);

          _this.$Message.error('用户名或密码输入错误！');

        }

      }).catch(function (error) {

          _this.$Message.error('系统错误！');

      })

    }

  },

  computed: {

  }

}
</script>

<style lang="less" scoped>

.fora {

  position: relative;
  top: -15px;
}

.enter1 {
    position: relative;
    left: 200px;
    top: -5px;
}

/*页眉的内填充*/

.header {
  padding: 20px 60px;
  background: aliceblue;
}


/*顶部选项总体*/

.top-item a {
	color: #777777;
	line-height: 40px;
}


/*顶部选项的li宽*/

.top-item li {
	width: 100px;
	text-align: center;
}


/*顶部选项竖线  |  的宽度*/

.top-item .li-split {
	width: 10px;
}


/*搜索文本框宽度*/

#search {
	width: 300px;
}


/*顶部导航条*/

.top-nav {
	background-color: #F2F2F2;
	height: 50px;
	padding-top: 6px;
	margin-bottom: 20px;
}


/*管理下拉框样式*/

#top-dropdown-btn {
	color: #777777;
}


/*管理下拉框li*/

.top-dropdown-ul li {
	width: 100%;
}


/*
  索引页大背景
  */
.mycontent {
	background-image: url(../assets/bg1.jpg);
	width: 100%;
	height: 561px;
}

.mycontent2 {
	background-image: url(../assets/green.jpg);
	width: 101%;
  height: 571px;
  position: relative;
  top: -18px;
  
}
/*
    索引页半透明层
 * */

.inputDiv {
	height: 371px;
	width: 270px;
	background-color: rgba(255, 255, 255, 0.7);
	float: right;
	margin: 100px 60px 0 0;
	text-align: center;
	color: cadetblue;
	line-height: 40px;
}
/*索引页几个链接按钮*/

.inputDiv a {
	margin: 8px;
	font-size: 16px;
}
/*按钮宽度	*/

.inputDiv .btn {
	width: 90%;
}

/*通用的去ul默认格式*/

ul,
li {
	margin: 0;
	padding: 0;
	list-style: none;
}

body {
	font-family: "微软雅黑", "黑体";
}

.title-row-2 {
	line-height: 30px;
	height: 60px;
	overflow: hidden;
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
}

.title-row-1 {
	line-height: 30px;
	height: 30px;
	overflow: hidden;
	display: -webkit-box;
	-webkit-line-clamp: 1;
	-webkit-box-orient: vertical;
}

.li-row-1 {
	line-height: 25px;
	height: 25px;
	overflow: hidden;
	display: -webkit-box;
	-webkit-line-clamp: 1;
	-webkit-box-orient: vertical;
}

.text-row-3 {
	line-height: 20px;
	height: 60px;
	overflow: hidden;
	display: -webkit-box;
	-webkit-line-clamp: 3;
	-webkit-box-orient: vertical;
}

.text-row-2 {
	line-height: 20px;
	height: 40px;
	overflow: hidden;
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
}

.text-row-1 {
	line-height: 20px;
	height: 20px;
	overflow: hidden;
	display: -webkit-box;
	-webkit-line-clamp: 1;
	-webkit-box-orient: vertical;
}


/*登录页的半透明层的样式*/

.loginDiv {

	height: 280px;
	width: 500px;
	background-color: rgba(255, 255, 255, 0.85);
	float: right;
	margin: 130px 60px 0 0;
	border-radius: 10px;
	color: #666666;
  padding: 8px;
  position: absolute;

  left: 800px;

}


</style>
