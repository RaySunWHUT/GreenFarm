<template>
<div class="container">
<div class="title">租赁信息管理</div>
<div class="panel panel-default">
<div class="panel-body">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label class="col-md-2 control-label"><span class="txtred">*</span>农场名：</label>
            <div class="col-md-8">
                <input type="text" class="form-control" placeholder="请输入农场标题" v-model="farmName">
            </div>
        </div>
        <div class="address_content" data-toggle="distpicker">
            <div class="form-group">
                <label class="col-md-2 control-label">农场规格：</label>
                <div class="col-md-3">
                    <input type="text" class="form-control" placeholder="请输入农场规格" v-model="farmSize">
                </div>
                <label class="col-md-2 control-label">农场价格：</label>
                <div class="col-md-3">
                    <input type="text" class="form-control" placeholder="请输入一个月租金"
                    v-model="farmPrice">
                </div>
            </div>
            <div class="form-group ">
                <label class="col-md-2 control-label"><span class="txtred">*</span>农场地址：</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" placeholder="请输入农场地址"
                    v-model="farmAddress">
                </div>
            </div>
        </div>



        <div class="form-group">
            <label class="col-md-2 control-label"><span class="txtred">*</span>详细介绍：</label>
            <div class="col-md-8">
                <textarea class="form-control" rows="3" placeholder="输入农场详细情况"
                v-model="farmIntro"></textarea>
            </div>
        </div>



        <div class="form-group">
            <label class="col-md-2 control-label"><span class="txtred">*</span>上传样图：</label>
            <div class="col-md-3">
                <form class="form-horizontal" role="form">
                    <div class="form-group">

                        <div class="col-md-3">
                            <input type="file">
                        </div>
                    </div>
                </form>
            </div>

            </div>

        <div class="form-group">
            <label class="col-md-2 control-label">
                <router-link to="/farmManager">返回&nbsp;&nbsp;&nbsp;</router-link>
            </label>
            <div class="col-sm-10">
                <Button type="error" class="button_style"  @click="uploadFarmInfo">上传</Button>
                <Button type="primary"  class="button_style" @click="clearAll">重置</Button>
            </div>
        </div>
    </form>
</div>
        </div>
    </div>
</template>

<script>


import http from '@/api/http'

export default {
    
    inject: ['reload'],

    data() {
      
        return {

            farmName: null,
            farmSize: null,
            farmPrice: null,
            farmAddress: null,
            farmIntro: null,
            farmImg: null,

        }

    },

    methods: {

        uploadFarmInfo() {

                if (this.farmName == null || this.farmName == '') {

                    this.$Message.warning("请选择租赁农场名称！");

                } else if (this.farmSize == null || this.farmPrice == null || this.farmIntro == null || this.farmAddress == null) {
                    
                    this.$Message.warning("关键字不能为空！");
                
                } else {
                
                    var _this = this; 

                    http({

                        // 假设后台需要的是表单数据这里你就可以更改
                        headers: {

                        "Content-Type": "application/json;charset=UTF-8",
                        "Token": _this.$store.state.token

                        },

                        method: 'post',

                        url: 'http://localhost:8080/business/saveFarm',

                        data: {
                            
                            farmName: this.farmName,
                            farmSize: this.farmSize,
                            farmIntro: this.farmIntro,
                            farmPrice: this.farmPrice,
                            farmAddress: this.farmAddress,
                            farmImg: this.farmImg

                        },

                        responseType: 'json'

                    }).then(function (res) {

                        console.log(res);

                        var code = res.code;
                        var info = res.info;

                        if (res.code == 200) {
                        
                            _this.$Message.success("上传成功！");
                            _this.$router.push("/farmManager");
                            _this.reload();
                        
                        } else {
                            
                            _this.$Message.error(info);

                        }

                    }).catch(function (err) {

                        console.log(err);
                    
                    });

            }
    
        },

        clearAll() {
        
            this.farmName = null;
            this.farmIntro = null;
            this.farmSize = null;
            this.farmAddress = null;
            this.farmImg = null;
            this.farmPrice = null;

        }

   


        
    }

}
</script>





<style scoped>

.button_style {
    margin-left: 20px;
}


.panel-body {

    position: relative;

    left: 80px;
    
}


.panel-default {
    position: relative;
    width: 1000px;

}


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

.container {

    position: relative;
    left: 50%;
    margin-left: -500px;

}

</style>


