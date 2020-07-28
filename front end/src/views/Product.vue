<template>
    <div>
		<!--导航结束-->
		<!--商品信息展示开始-->
		<div class="col-md-offset-1 col-md-10">
			<div class="col-md-6 img-p">

				<div data="1" class="img-big move-img col-md-12">
					<img id="img1-big" src="@/assets/11DELLran7000R1605Ssilvery/1_big.png" width="100%" />
				</div>
				<div data="2" class="img-big move-img col-md-12">
					<img  id="img2-big"  src="@/assets/11DELLran7000R1605Ssilvery/2_big.png" width="100%" />
				</div>
				<div data="3" class="img-big move-img col-md-12">
					<img  id="img3-big" src="@/assets/11DELLran7000R1605Ssilvery/3_big.png" width="100%" />
				</div>
				<div data="4" class="img-big move-img col-md-12">
					<img id="img4-big"  src="@/assets/11DELLran7000R1605Ssilvery/4_big.png" width="100%" />
				</div>
				<div data="5" class="img-big move-img col-md-12">
					<img id="img5-big"  src="@/assets/11DELLran7000R1605Ssilvery/5_big.png" width="100%" />
				</div>

				<div data="1" class="col-md-2 img-small">
					<img id="img1" src="@/assets/11DELLran7000R1605Ssilvery/1.jpg" width="100%" />
				</div>
				<div data="2" class="col-md-2 img-small">
					<img id="img2"  src="@/assets/11DELLran7000R1605Ssilvery/2.jpg" width="100%" />
				</div>
				<div data="3" class="col-md-2 img-small">
					<img id="img3"  src="@/assets/11DELLran7000R1605Ssilvery/3.jpg" width="100%" />
				</div>
				<div data="4" class="col-md-2 img-small">
					<img id="img4"  src="@/assets/11DELLran7000R1605Ssilvery/4.jpg" width="100%" />
				</div>
				<div data="5" class="col-md-2 img-small">
					<img id="img5"  src="@/assets/11DELLran7000R1605Ssilvery/5.jpg" width="100%" />
				</div>

			</div>

			<div class="col-md-6">
				<h3 id="goods-title" class="col-md-12 title-row-1" title="【买1送1】广西百香果包邮新鲜热带当季水果整箱5白香果带箱6斤10">买1送1！广西百香果包邮</h3>
				<h4 class="col-md-12 text-row-1"><small  id="goods-sell-point">各地特产！多买多送！</small></h4>
				<div class="col-md-12 price-bar">
					<small>售价：</small>¥<span id="goods-price">24.8</span>
					<div><small>*退货补运费 *7天无理由退货 *24小时快速退款 </small></div>
				</div>
				<form class="form-inline product-form col-md-12" role="form">
					<div class="col-md-12 form-space">
						<label for="num">数量：</label>
						<input id="numDown" type="button" value="-" class="num-btn" />
						<input id="num" type="text" size="2" readonly="readonly" class="num-text" value="1">
						<input  id="numUp" class="num-btn" type="button" value="+" />
					</div>
					<div class="col-md-12 form-space">
						<h4><small><b>绿色农场</b>发货并提供售后服务,今日下单,明日送达</small></h4>

					</div>
					<div class="col-md-12 form-space">

						<input class="btn btn-primary btn-lg btn-block" type="button" value="立即购买">

					</div>

					<div class="col-md-12 form-space">

						<button  id="btn-add-to-cart"  type="button" class="btn btn-default"><span class="fa fa-cart-plus"></span> 加入购物车</button>

						<button type="button" class="btn btn-default"><span class="fa fa-heart-o"></span> 加入收藏</button>

					</div>
				</form>

			</div>
		</div>
    </div>
</template>

<style scoped>

.img-p{
    position: relative;
    top: 300px;
}
/*商品大图片样式*/
.img-big {
	width: 100%;
	display: none;
	border: 2px solid #aaaaaa;
	border-radius: 3px;
	margin: 0;
	padding: 0;
}
.style_img {
            width:40px;
            height:40px;
            margin-right:10px;
            border-radius:50%;
        }
/*商品小图片的样式*/

.img-small {
	border: 1px solid #dddddd;
	margin: 5px;
	padding: 1px;
	cursor: pointer;
}

/*大图片初始情况只显示一张，可见的样式*/

.big-show {
	display: block;
}
/*会变大的图片的默认样式*/

.move-img {
	background-size: 100%;
	background-position: center;
	background-repeat: no-repeat;
}


/*价格框的小字体样式*/

.price-bar small {
	font-size: 14px;
}

/*价格框的样式*/

.price-bar {
	background: #f0f9ff;
	color: #092f97;
	padding: 8px;
	border: 3px solid #699fd7;
	border-radius: 3px;
	font-size: 30px;
	margin: 5px;
}

/*购买表单的间隔*/

.product-form {
	margin: 10px 0;
}

/*表单行的间隔*/

.form-space {
	margin: 10px 0;
}

/*售后的图标*/

.saled-icon {
	color: #092F97;
	font-size: 25px;
}

/*售后的标题*/

.saled-title {
	color: #092F97;
	font-size: 18px;
}

/*售后的内容*/

.saled-content {
	color: #999999;
	font-size: 12px;
	padding-bottom: 40px;
}

/*数量按钮样式*/

.num-btn {
	width: 30px;
}

.num-text {
	text-align: center;
}

</style>

