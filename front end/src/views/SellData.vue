<template>
<div>
    
<body>
<!--头部结束-->
<!--导航结束-->
<div class="container">
    <div class="title">个人信息管理</div>
    <div class="col-md-10	">
        <div class="panel panel-default">
            <div class="panel-body">
                <!--修改资料表单开始-->
                <form id="form-change-info" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-md-2 control-label">用户账号：</label>
                        <div class="col-md-8">
                            <input id="username" type="text" class="form-control" readonly="readonly" v-model="userAccount">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">电话号码：</label>
                        <div class="col-md-8">
                            <input id="phone" name="phone" type="text" class="form-control" placeholder="请输入电话号码" 
                            v-model="phoneNumber">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">电子邮箱：</label>
                        <div class="col-md-8">
                            <input id="email" name="email" type="text" class="form-control" placeholder="请输入电子邮箱" 
                            v-model="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">性别：</label>
                        <div class="col-md-8">
                            <label class="radio-inline">
                                <input id="gender-male" type="radio" name="gender" value="1" 
                                v-model="checkedValue">男
                            </label>
                            <label class="radio-inline">
                                <input id="gender-female" type="radio" name="gender" value="0"
                                v-model="checkedValue">女
                            </label>
                        </div>
                    </div>

                    <div class="panel-body1">

                        <!--上传头像表单开始-->

                        <form class="form-horizontal" role="form" id="form-upload">
                            <div class="form-group">
                                <label class="col-md-2 control-label">选择头像:</label>
                                <div class="col-md-1">
                                    <img id="img-avatar" src="@/assets/user.jpg" class="img-responsive" />
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-md-offset-2 col-md-4">
                                    <input type="file" name="file" @change="uploadImg">
                                </div>
                            </div>

                            <!-- <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <input id="btn-upload" type="button" class="btn btn-primary" value="上传" />
                                </div>
                            </div> -->

                        </form>

                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <Button type="error"  @click="updateUserInfo">修改</Button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</div>
</template>

<script>

import http from '@/api/http'

export default {

    name: "SellData",

    inject: ['reload'],

    data() {

        return {
            
            message: "oneUser",
            userAccount: this.$store.state.userAccount,
            phoneNumber: null,
            email: null,
            gender: null,
            head: "",
            checkedValue: null,

            imgs: [],

            imgData: {
                
                accept: 'image/gif, image/jpeg, image/png, image/jpg',
            
            }

        }
    },

    methods: {

        uploadImg() {



        },

        getGender() {

            if (this.checkedValue == "0") {

                this.gender = "男";

            } else if (this.checkedValue == "1") {

                this.gender = "女";

            }

        },

        syncUserInfo() {
            
            var _this = this;

                http({

					// 假设后台需要的是表单数据这里你就可以更改
					headers: {

                    "Content-Type": "application/json;charset=UTF-8",
                    "Token": this.$store.state.token
					
					},

					method: 'post',
					url: 'http://localhost:8080/business/listOneUser',

					data: {

                        userAccount: this.userAccount,
                        message: this.message

					},

					responseType: 'json'

				}).then(function (res) {

					console.log(res);

					var code = res.code;
					var info = res.info;

					if (res.code == 200) {
                        
                        _this.phoneNumber = info.phoneNumber;
                        _this.email = info.email;
                        _this.head = info.head;

                        if (info.gender == "男") {

                            _this.checkedValue = "0";

                        }  else if (info.gender == "女") {

                            _this.checkedValue = "1";

                        }

					} else {
						
						_this.$Message.error("未知错误！");

					}

				}).catch(function (err) {

					console.log(err);
				
			    });

        },


        updateUserInfo() {

            this.getGender();
            
            if (this.phoneNumber == null || this.phoneNumber == '') {

                this.$Message.warning("电话号码不能为空！");

            } else {

                var _this = this;

                http({

					// 假设后台需要的是表单数据这里你就可以更改
					headers: {

                    "Content-Type": "application/json;charset=UTF-8",
                    "Token": this.$store.state.token
					
					},

					method: 'post',
					url: 'http://localhost:8080/business/updateUser',

					data: {

						userAccount: this.userAccount,
						phoneNumber: this.phoneNumber,
						email: this.email,
                        gender: this.gender,
                        head: this.head

					},

					responseType: 'json'

				}).then(function (res) {

					console.log(res);

					var code = res.code;
					var info = res.info;

					if (res.code == 200) {
					
                        _this.$Message.success("修改成功！");
                        _this.reload();  // 刷新界面
					
					} else {
						
						_this.$Message.error(info);

					}

				}).catch(function (err) {

					console.log(err);
				
			    });

            }

        }

    },


    mounted() {
        
        this.syncUserInfo();

    },
    
}
</script>

<style scoped>

.container {
    position: relative;
    width: 1000px;
    left: 50%;
    margin-left: -500px;
}


.panel-body {

    position: relative;

    left: 100px;
    
}


.panel-default {

    
    position: relative;

    top: 12px;
    left: 50px;

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


.title {

    color: #667799;
    margin-left: 415px;
    margin-top: -20px;
    margin-bottom: 20px;
    /* letter-spacing: 5px; */

    font-size: 20px;
    font-weight: bold;
    
}
</style>