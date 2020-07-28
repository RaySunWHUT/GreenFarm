<template>
<div>

<body>
<!--头部-->
<header class="header">

    <img src="@/assets/glogo.png" alt="" />
    <span class="pull-right"><h3><small>欢迎访问</small><b>绿色生态农场</b></h3></span>

</header>
<!--主体-->
<div class="container mycontent2 text-left">
    
    <!--透明层 -->
    <div class="regDiv">
        <h3 class="enter1">商家入驻</h3>
        <hr />

        <!--表单开始-->
        <form  id="form-reg" class="form-horizontal" role="form">
            <!--用户名-->

            <div class="form-group">
                <label  class="col-md-3 control-label">商家账号：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control"  placeholder="请输入用户名" name="businessName" v-model="userAccount">
                </div>
            </div>

            <!--密码-->
            <div class="form-group">
                <label class="col-md-3 control-label"> 密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                <div class="col-md-8">
                    <input type="password" class="form-control"  placeholder="请输入密码" name="password" v-model="password">
                </div>
            </div>

            <!--确认密码-->
            <div class="form-group">
                <label  class="col-md-3 control-label"> 确认密码：</label>
                <div class="col-md-8">
                    <input type="password" class="form-control"  placeholder="请再次输入密码" v-model="repeatPassword">
                </div>
            </div>

            <!--用户名-->
            <div class="form-group">
                <label  class="col-md-3 control-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control"  placeholder="请输入邮箱" name="email" v-model="email">
                </div>
            </div>

            <!--用户名-->
            <div class="form-group">
                <label  class="col-md-3 control-label">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control"  placeholder="请输入电话号码" name="phone" v-model="phoneNumber">
                </div>
            </div>

            <!--用户名-->
            <div class="form-group">
                <label  class="col-md-3 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
                <div class="col-md-8">
					<label class="radio-inline">
						<input type="radio" name="gender" value="0" v-model="checkedValue">男
					</label>
					<label class="radio-inline">
						<input type="radio" name="gender" value="1" v-model="checkedValue">女
					</label>
                </div>
            </div>

            <!-- <div class="form-group">
                <label  class="col-md-3 control-label"> 选择文件：</label>

                <form>
                <div class="col-md-4">
                        <input type="file" name="theLicense">
                </div>
                </form>
            </div> -->

            
            <!--提交按钮-->
            <div class="form-group">
                <label class="col-md-3 control-label"></label>
                <div class="col-md-8">
                
					<Button class="btn rter" type="primary" @click="register">立即注册</Button>

                    <span class="pull-right"><small>已经有账号?</small>

                    <router-link to="/">登录</router-link></span>
                
                </div>
            </div>

        </form>
    </div>

</div>
	
	</body>
</div>
</template>

<script>

import http from '@/api/http'
export default {

    data() {

		return {
			
			userAccount: null,
			password: null,
			repeatPassword: null,
			phoneNumber: null,
			email: null,
			gender: null,
			checkedValue: null,
			// list: [ {value: '男'}, {value: '女'} ]


		}
	},

	methods: {

		getGender() {

			if (this.checkedValue == "0") {
				
				this.gender = "男";
			
			} else if (this.checkedValue == "1") {
				
				this.gender = "女";
			
			}

		},
		register() {

			this.getGender();

			var _this = this; 

			console.log("this.password: " + this.password);

			if (this.userAccount == null || this.password == null || this.repeatPassword == null || this.password == '') {

				this.$Message.warning("用户名或密码不能为空!");

			} else if (this.password != this.repeatPassword) {

				this.$Message.warning("两次密码输入不一致!");

			} else if (this.phoneNumber == null) {

				this.$Message.warning("电话号码不能为空!");
				
			}else if (this.checkedValue == null) {

				this.$Message.warning("请选择性别！");

			} else {

				http({

					// 假设后台需要的是表单数据这里你就可以更改
					headers: {

					"Content-Type": "application/json;charset=UTF-8"
					
					},

					method: 'post',
					url: 'http://localhost:8080/register',

					data: {

						userAccount: this.userAccount,
						password: this.password,
						phoneNumber: this.phoneNumber,
						email: this.email,
						gender: this.gender

					},

					responseType: 'json'

				}).then(function (res) {

					console.log(res);

					var code = res.code;
					var info = res.info;

					if (res.code == 200) {
					
						_this.$Message.success("注册成功！");
						_this.$router.push("/");
					
					} else {
						
						_this.$Message.error(info);

					}

				}).catch(function (err) {

					console.log(err);
				
				});

			}

		}

	},


}
</script>


<style lang="less" scoped>

.enter1 {
    position: relative;
    left: 200px;
    top: -5px;
}

/*页眉的内填充*/

.header {
	padding: 20px 60px;
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
	width: 100%;
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



/*注册页半透明框的样式*/
.regDiv{
	height: 460px;
	width: 500px;
	background-color: rgba(255,255,255,0.85);
	float: right;
	margin: 80px 60px 0 0;
	border-radius: 10px;
	color: #666666;
    padding: 8px;
    position: absolute;
    left: 800px;
}

 /*图标加大 颜色*/
 
 .rights .fa {
 	font-size: 30px;
 	color: #667799;
 }
 /*图片小间距*/
 
 img {
 	margin: 1px;
 }
 /*超链接样式*/
 
 .callus a {
 	font-size: 12px;
 	text-decoration: none;
 	color: #666666;
 }
 /*底部填充高*/
 
 .bottom {
 	margin: 10px;
 }
 /*权益整行的颜色和填充*/
 
 .rights {
 	width: 100%;
 	padding: 50px;
 	background-color: #F2F2F2;
 }
 /*联系我们那一整行的填充*/
 
 .beforeBottom {
 	padding-top: 30px;
 }

</style>