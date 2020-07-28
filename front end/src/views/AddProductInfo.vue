<template>
    <div>
    <div class="container">
    <div class="title">产品信息管理</div>
    <div class="col-md-10	">
        <div class="panel panel-default">
            <div class="panel-body">
                <!--新增收货地址表单开始-->
                <form id="form-create" class="form-horizontal" role="form">
                    <div class="address_content" data-toggle="distpicker">

                        <div class="form-group ">
                            <label class="col-md-2 control-label">产品名称：</label>
                            <div class="col-md-3">
                                <input name="title" type="text" class="form-control" placeholder="请输入产品名"
                                v-model="proName">
                            </div>
                            <label class="col-md-2 control-label"><span class="txtred">*</span>类别：</label>

                            <div class="col-md-3">
                                <Select v-model="checkedType" style="width:200px">
                                    <Option v-for="item in fruitList" :value="item.typeName" :key="item.typeName">{{ item.typeName }}</Option>
                                </Select>
                            </div>

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label"><span class="txtred">*</span>价格：</label>
                        <div class="col-md-3">
                            <input name="price" type="text" class="form-control" placeholder="产品价格/kg"
                            v-model="proPrice">
                        </div>
                        <label class="col-md-2 control-label">库存：</label>
                        <div class="col-md-3">
                            <input name="num" type="text" class="form-control" placeholder="请输入产品库存"
                            v-model="stock">
                        </div>
                    </div>
                    <div class="form-group">    
                        <label class="col-md-2 control-label">产品产地：</label>
                        <div class="col-md-3">
                            <input name="num" type="text" class="form-control" placeholder="请输入产品产地"
                            v-model="proAddress">
                        </div>
                    </div>



                    <div class="form-group">
                        <label class="col-md-2 control-label"><span class="txtred">*</span>产品详情：</label>
                        <div class="col-md-8">
                            <textarea name="sellPoint" class="form-control" rows="3" placeholder="输入产品详细情况"
                            v-model="proIntro"></textarea>
                        </div>
                    </div>



                    <div class="form-group">
                        <label class="col-md-2 control-label"><span class="txtred">*</span>样图（5张）：</label>
                        <div class="col-md-3">
                            <input type="file" id="images" multiple="multiple" accept="image/png, image/jpeg, image/gif, image/jpg">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label">
                            <router-link to="/productManager">返回&nbsp;&nbsp;&nbsp;</router-link></label>
                            <Button type="error" class="button_style" @click="uploadPro">上传</Button>
                            <Button type="primary"  class="button_style" @click="clearAll">重置</Button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
    </div>
</template>


<script>

import http from '@/api/http'

export default {  

    inject:['reload'],
    
    data() {
    
        return {

            checkedType: null,  // 所选商品
            message: "typeList",
            proName: null,
            proIntro: null,
            proPrice: null,
            proAddress: null,
            // typeName: null,
            stock: null,
            proImg: null, 

            fruitList: [],
        
        }
    
    },
    
    mounted() {

        this.getfruitList();

        console.table(this.fruitList);

    },

    methods: {
        getfruitList() {

            var _this = this;

            http({

                // 假设后台需要的是表单数据这里你就可以更改
                headers: {

                "Content-Type": "application/json;charset=UTF-8",
                "Token": _this.$store.state.token

                },

                method: 'post',

                url: 'http://localhost:8080/business/listProType',

                data: {

                    message: _this.message
                    
                },

                responseType: 'json'

            }).then(function (res) {

                console.log(res);

                var code = res.code;
                var info = res.info;

                if (res.code == 200) { 

                    for (var i = 0; i < info.length; i++) {

                        _this.fruitList.push({

                            typeId: info[i].typeId,
                            typeName: info[i].typeName

                        });
                    }
                    
                    // console.log("---------- fruitList1 ----------");
                    // console.table(_this.fruitList);

                    // console.log("----------- star1 ----------------");

                    // console.log(info[0].typeName);

                    // console.log("----------- star2 ----------------");

                    // console.log(_this.fruitList[0].typeName);

                    // console.log("---------- fruitList2 ----------");

                } else {               
                    
                    _this.$Message.error("获取商品种类错误！");
                
                }

            }).catch(function (err) {

                console.log(err);
            
            });


        },

        clearAll() {

            this.proName = null;
            this.proIntro = null;
            this.proPrice = null;
            this.kind = null;
            this.stock = null;
            this.proImg = null;

        },

        uploadPro() {

            if (this.checkedType == null || this.checkedType == '') {

                this.$Message.warning("请选择产品类型！");

            } else if (this.proName == null || this.proPrice == null || this.stock == null || this.proAddress == null || this.proIntro == null) {
                
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
                    url: 'http://localhost:8080/business/savePro',

                    data: {
                        
                        proName: _this.proName,
                        proAddress: _this.proAddress,
                        proPrice: _this.proPrice,
                        proIntro: _this.proIntro,
                        typeName: _this.checkedType,
                        stock: _this.stock,
                        proImg: _this.proImg

                    },

                    responseType: 'json'

                }).then(function (res) {

                    console.log(res);

                    var code = res.code;
                    var info = res.info;

                    if (res.code == 200) {
                    
                        _this.$Message.success("上传成功！");
                        _this.$router.push("/productManager");
                        _this.reload();
                    
                    } else {
                        
                        _this.$Message.error(info);

                    }

                }).catch(function (err) {

                    console.log(err);
                
                });

            }
            
        }
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
    left: 50px;

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
    margin-left: 485px;
    margin-top: -20px;
    margin-bottom: 20px;
    /* letter-spacing: 5px; */

    font-size: 20px;
    font-weight: bold;
}
.button_style{
    margin-left: 20px;
}


</style>