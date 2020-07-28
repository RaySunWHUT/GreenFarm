<template>
<div>
    <body>
		<div class="clearfix"></div>
		<div class="col-md-2" id="indexMenu">
			
			<div id="showIndex">

				<ul class="second-menu">
					
					<li class="second-menu-li">####</li>
					
				</ul>

			</div>
			<div id="showSecond">

				<ul class="third-menu">

				</ul>

			</div>

		</div>
		<div class="col-md-10 carousel-position">
			<div id="myCarousel" class="carousel slide">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
					<li data-target="#myCarousel" data-slide-to="4"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner" align="center">
					<div class="item active">
						<img src="@/assets/pannel/1.jpg">
					</div>
					<div class="item">
						<img src="@/assets/pannel/2.jpg">
					</div>
					<div class="item">
						<img src="@/assets/pannel/3.jpg">
					</div>
					<div class="item">
						<img src="@/assets/pannel/4.jpg">
					</div>
					<div class="item">
						<img src="@/assets/pannel/5.jpg">
					</div>
				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right right-p carousel-control" href="#myCarousel" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<hr/>
		<!--推荐栏目-->
		<div class="pannel_box">
		<div class="col-md-offset-1 col-md-5">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">新到好货</h3>
				</div>
				<div id="newList" class="panel-body panel-item">

					<div class="col-md-12">
						<div class="col-md-7 text-row-2"><a href="product.html">现摘正宗新疆库勒尔香梨，10斤整箱包邮特产</a></div>
						<div class="col-md-2">¥69.8</div>
						<div class="col-md-3"><img src="@/assets/ListImges/5.jpg" width="100%" /></div>
					</div>

					<div class="col-md-12">
						<div class="col-md-7  text-row-2"><a href="product.html">现摘沙瓤自然熟西红柿新鲜蔬菜水果番茄孕妇儿童生吃洋柿子5斤装</a></div>
						<div class="col-md-2">¥16.5</div>
						<div class="col-md-3"><img src="@/assets/ListImges/3.jpg" width="100%" /></div>
					</div>
					<div class="col-md-12">
						<div class="col-md-7 text-row-2"><a href="product.html">锦绣黄桃，新鲜多汁配送顺丰包邮</a></div>
						<div class="col-md-2">¥39.9</div>
						<div class="col-md-3"><img src="@/assets/ListImges/9.jpg" width="100%" /></div>
					</div>
					<div class="col-md-12">
						<div class="col-md-7 text-row-2"><a href="product.html">浦江特产猕猴桃，汁多味甜，绿心奇异果弥猴桃</a></div>
						<div class="col-md-2">¥39.8</div>
						<div class="col-md-3"><img src="@/assets/ListImges/1.jpg" width="100%" /></div>
					</div>

				</div>
			</div>
		</div>
		<div class="col-md-5">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">热销排行</h3>
				</div>
				<div id="hotList" class="panel-body panel-item">

					<div class="col-md-12">
						<div class="col-md-7 text-row-2"><a href="product.html">美国进口车厘子带箱3斤大樱桃 新鲜当季水果应季批发</a></div>
						<div class="col-md-2">¥89..8</div>
						<div class="col-md-3"><img src="@/assets/ListImges/14.jpg/" width="100%" /></div>
					</div>

					<div class="col-md-12">
						<div class="col-md-7 text-row-2"><a href="product.html">现摘正宗新疆库勒尔香梨，10斤整箱包邮特产</a></div>
						<div class="col-md-2">¥69.8</div>
						<div class="col-md-3"><img src="@/assets/ListImges/5.jpg/" width="100%" /></div>
					</div>
					<div class="col-md-12">
						<div class="col-md-7 text-row-2"><a href="product.html">泰国进口山竹带箱6斤 新鲜热带水果孕妇油麻竹5A大果当季批发包邮</a></div>
						<div class="col-md-2">¥49.8</div>
						<div class="col-md-3"><img src="@/assets/ListImges/15.jpg/" width="100%" /></div>
					</div>
					<div class="col-md-12">
						<div class="col-md-7 text-row-2"><a href="product.html">陕西新鲜红富士苹果水果10斤带箱 2019应季延安苹果脆甜整箱包邮</a></div>
						<div class="col-md-2">¥17.8</div>
						<div class="col-md-3"><img src="@/assets/ListImges/12.jpg/" width="100%" /></div>
					</div>
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

/*轮换层大小*/

#myCarousel {
	width: 100%;
}

/*accordion是左侧导航条*/

#accordion {
	min-height: 300px;
}

/*左右两侧的阴影效果*/

.carousel-control.left {
	background-image: none;
	background-color: #666666;
	width: 40px;
	height: 60px;
	margin: 160px 0 0 20px;
	border-radius: 5px;
}

.carousel-control.right {
	background-image: none;
	background-color: #666666;
	width: 40px;
	height: 60px;
	margin: 160px 20px 0 0;
	border-radius: 5px;
}

/*主页一级分类菜单 ul*/

.index-menu {
	width: 100%;
	margin-left: 5%;
	padding: 5px 0;
	background-color: #4288c3;
	color: #ffffff;
	border-radius: 5px;
	font-size: 20px;
}

/*主页一级分类菜单项 li*/

.index-menu li {
	line-height: 150px;
	height: 18px;
	text-align: center;
	cursor: pointer;
}
/*主页二级分类菜单 ul*/

.second-menu {
	background-color: #ffffff;
	color: #4288c3;
}
/*主页二级分类菜单项 li*/

.second-menu li {
	cursor: pointer;
	text-align: center;
}


/*主页三级分类菜单 ul*/

.third-menu {
	background-color: #ffffff;
	color: #666666;
}
/*主页三级分类菜单项 li*/

.third-menu li {
	cursor: pointer;
	text-align: center;
}
/*设置相对位置和绝对位置定位分类div*/

#indexMenu {
	position: static;
}

#showIndex {
	position: absolute;
	display: none;
	min-width: 130px;
	min-height: 50px;
	background-color: #ffffff;
	left: 195px;
	top: 0;
	z-index: 1;
	border: 2px solid #4288c3;
	border-left: none;
}

#showSecond {
	position: absolute;
	display: none;
	min-width: 130px;
	min-height: 50px;
	background-color: #ffffff;
	left: 323px;
	top: 0;
	z-index: 1;
	border: 2px solid #4288c3;
	border-left: none;
}

/*推荐栏目格式*/

.panel-item div {
	padding: 2px 0;
	border-bottom: 1px solid #eeeeee;
}
.carousel-position{
	position: relative;
	margin-left: 155px;
	margin-top: -20px;
}
.left{
	position: absolute;
	left: 0px;
	top: 50px;
}
.carousel-control.right{
	margin-right: 20px;
	top: 60px;
}
.item img{
	width: 1500px;
	height: 500px;
}
.footer_top{
    height: 450px;
    width: 100%;
    background: #fff;
    padding-left: 180px;
}

.pannel_box{
	position: relative;
	height: 650px;
}

</style>



