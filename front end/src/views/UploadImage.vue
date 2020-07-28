<template>
<div>
<body>
<div class="container">
	<div class="col-md-2">
		<!--左侧导航开始-->
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<!--主选项：资料修改-->
					<p class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">资料修改</a>
					</p>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse in">
					<div class="panel-body">
						<div><a href="password.html">修改密码</a></div>
						<div><a href="sellerdata.html">个人资料</a></div>
						<div><a href="upload.html"><b>上传头像</b></a></div>
						<div><a href="address.html">收货管理</a></div>
						<div><a href="addRent.html">租赁管理</a></div>
						<div><a href="productManager.html">产品管理</a></div>
					</div>
				</div>
			</div>
		</div>
		<!--左侧导航结束-->
	</div>
	<div class="col-md-10	">
		<div class="panel panel-default">
			<ul class="nav nav-tabs">
				<li><a href="password.html">修改密码</a></li>
				<li><a href="sellerdata.html">个人资料</a></li>
				<li class="active"><a href="#">上传头像</a></li>
				<li><a href="address.html">收货管理</a></li>
				<li><a href="addRent.html">租赁管理</a></li>
				<li><a href="productManager.html">产品管理</a></li>
			</ul>
			<div class="panel-body">
				<!--上传头像表单开始-->
				<form class="form-horizontal" role="form" id="form-upload">
					<div class="form-group">
						<label class="col-md-2 control-label">选择头像:</label>
						<div class="col-md-1">
							<img id="img-avatar" src="@/assets//user.jpg" class="img-responsive" />
						</div>
						<div class="clearfix"></div>
						<div class="col-md-offset-2 col-md-4">
							<input type="file" name="file">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input id="btn-upload" type="button" class="btn btn-primary" value="上传" />
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
export default {
    
}
</script>

<style scoped>

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
