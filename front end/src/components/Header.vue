<template>
<div class="row">
	<div class="row_info">
		<div class="col-md-3 img-p">
			<img src="@/assets/glogo.png" @click="jumpIndex()" class="trigger"/>
		</div>
		<!--快捷选项-->
		<div class="col-md-9 top-item">
			<ul class="list-inline pull-right">
				<li>
					<router-link to="/order">
						<span class="fa fa-file-text"></span>&nbsp;订单
					</router-link>
				</li>

				<!-- <li class="li-split">|</li> -->
				<li>
					<!--下列列表按钮 ：管理-->
					<div class="btn-group">
						<button type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
							<span id="top-dropdown-btn">
								<span class="fa fa-gears">
									</span>&nbsp;<div class="manager" @mouseleave="leaveReservation()" @mouseenter="enterReservation()">管理
										<div class="managerment" v-show="showManager">
									<router-link to="./FarmManager">
										<span>农场租赁</span>
									</router-link>

									<router-link to="./sellData">
										<span>信息管理</span>
									</router-link>
									<router-link to="./productManager">
										<span>产品管理</span>
									</router-link>
									</div>
									</div>
								</span>
						</button>

					</div>
				</li>
				<!-- <li class="li-split">|</li> -->
			    
			</ul>
		</div>
			<div class="sea">
				<Input search enter-button placeholder="Enter something..." />
				</div>
				<li class="photo" @mouseleave="leaveinfo()" @mouseenter="enterinfo()"><a href="#"><img :src="imgsrc" alt=""></a>
				<div class="photoinfo" v-show="showphoto">
				<router-link to="./updatePassword">
					<span>修改密码</span>
					</router-link>
				
				<span @click="logout()" class="trigger">退出</span>
				
				</div>
				</li>
		</div>
	</div>
</template>

<script>

import http from '@/api/http'

import storage from '../utils/storage'

export default {

	data () {

		return {
		
			showManager: false,
			showphoto: false,
			message: '',
			imgsrc: require("@/assets/user.jpg"),
		
		}

  },

  methods: {

	jumpIndex() {

		this.$router.push("/index");

	},

	leaveReservation() {
		this.showManager = false;
	},
	enterReservation() {
		this.showManager = true;
	},
	leaveinfo() {
		this.showphoto = false;
	},
	enterinfo() {
		this.showphoto = true;
	},

	logout() {

		var _this = this;

		_this.message = 'logout'

		http({

			// 假设后台需要的是表单数据这里你就可以更改
			headers: {

			"Content-Type": "application/json;charset=UTF-8"
			
			},

			method: 'post',
			url: 'http://localhost:8080/logout',

			data: {

				message: this.message

			},

			responseType: 'json'

		}).then(function (res) {

        var info = res.info;
        var code = res.code;

        if (code == 200) {

          storage.remove('token');

          _this.$router.replace('/')
          _this.$Message.success('退出成功')

        } else if (code == 400) {
          
          _this.$Message.error('遭遇异常！')
       
        } else {
        
          _this.$Message.error('未知错误...')
        
        }

		}).catch(function (err) {

			console.log(err);
          	_this.$Message.error('未知错误...')
		
		});

	}

  },

}
</script>

<style scoped>

.trigger:hover {
    cursor: pointer;
}

/*页眉的内填充*/
.img-p {
	margin-left: 50px;
	width: auto;
}

.row_info{
	background: aliceblue;
	height: 80px;
}

.photoinfo{
	position: absolute;
	z-index: 999;
	left: 0px;
}
.photoinfo span{
	left: -25px;
	text-align: center;
	width: 100px;
	font-size: 20px;
	padding: 5px;
	display: block;
	color: #777777;
	background: #fff;
	position: relative;
}

.btn {
	font-size: 20px;
}

.manager {

	
}

.photo {
	position: absolute;
	display: inline-block;
	width: 50px;
	height: 50px;
	top: 15px;
	right: 50px;
	border-radius: 50%;
}
.photo a{
	width: auto;
}
.photo img{
	width: 50px;
	height: 50px;
	border-radius: 50%;

}


.header {
	padding: 20px 60px;
	background: white;
	position: relative;
	z-index: 999;
}

.managerment {
	position: absolute;
	left: -10px;
}

.managerment span {
	
	position: relative;
	display: block;
	z-index: 999;
	background: #fff;
	padding: 5px;
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
.sea {
    position: relative;
    width: 300px;
    top: 24px;
    left: 750px;
    float: left;
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
.row{
	font-size: 20px;
	padding-bottom: 50px;
}
.top-item{
	position: absolute;
	left: -300px;
	margin-top: 20px;
}
</style>

