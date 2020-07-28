<template>
<div>
    <body>
    <!-- 头部结束 -->
    <!-- 导航结束 -->
    <div class="container">

        <div class="col-md-10">
            <div class="panel panel-default">
            <!-- <ul class="nav nav-tabs">
                <li><a href="/updatePassword">修改密码</a></li>
                <li><a href="/sellData">个人资料</a></li>
                <li><a href="address.html">收货管理</a></li>
                <li class="active"><a href="/addRent">租赁管理</a></li>
                <li><a href="/productManager">产品管理</a></li>
            </ul> -->
                <div class="panel-body">
                    <!-- 修改密码表单开始 -->
                    <form class="form-horizontal" role="form" id="form-password">
                        <div class="form-group">
                            <label class="col-md-2 control-label">原密码：</label>
                            <div class="col-md-8">
                                <input name="oldPassword" type="password" class="form-control" placeholder="请输入原密码" v-model="oldPassword">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">新密码：</label>
                            <div class="col-md-8">
                                <input name="newPassword" type="password" class="form-control" placeholder="请输入新密码" v-model="newPassword">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">确认密码：</label>
                            <div class="col-md-8">
                                <input type="password" class="form-control" placeholder="请再次输入新密码" v-model="realPassword">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <Button id="btn-change" type="info" class="btn btn-primary" @click="updatePassword">确认修改</Button>
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

    data() {
        return {

            oldPassword: null,
            newPassword: null,
            realPassword: null,

        }

    },

    methods: {
        updatePassword() {

            if (this.oldPassword == null || this.newPassword == null) {

                this.$Message.warning("密码不能为空！");

            } else if (this.newPassword != this.realPassword) {
                
                this.$Message.warning("两次密码不一致！");

            } else {

                var _this = this;

                http({

					// 假设后台需要的是表单数据这里你就可以更改
					headers: {

                    "Content-Type": "application/json;charset=UTF-8",
                    "Token": _this.$store.state.token
					
					},

					method: 'post',
					url: 'http://localhost:8080/updatePassword',

					data: {
                        
                        userAccount: _this.$store.state.userAccount,
                        oldPassword: this.oldPassword,
                        newPassword: this.newPassword

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

        },
    
    }

}
</script>


<style scoped>

.panel-body {

    position: relative;

    left: 100px;
    
}


.panel-default {

    
    position: relative;

    top: 12px;
    left: 90px;

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

</style>