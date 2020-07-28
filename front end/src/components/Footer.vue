<template>
    <div class="footer_container">
        <div class="footer_top">
            <div class="box">
                <div class="box_title">绿色</div>
                <div class="box_inner">我们承诺 绝不含有任何添加剂</div>
                <div class="box_inner">做最放心的绿色产品</div>
            </div>
            <div class="box">
                <div class="box_title">优质</div>
                <div class="box_inner">生态优先 质量过关</div>
                <div class="box_inner">让顾客吃得放心</div>
            </div>
            <div class="box">
                <div class="box_title">便捷</div>
                <div class="box_inner">最快送达到目的地</div>
                <div class="box_inner">买卖好货源 做出好生意</div>
            </div>


        </div>
        <div class="footer_bottom">
        <div class="footer_title">商业合作：+86 17354429242   <span>sunruikk@gmail.com</span></div>
            <div class="footer_inner">
                <span class="boll inner_head"></span>
                <div class="inner_button"><a>使用条款</a></div>
                <div class="inner_button"><a>活动中心</a></div>
                <div class="inner_button"><a>法律声明</a></div>
                <div class="inner_button"><a>加入我们</a></div>
                <span class="boll inner_foot"></span>
            </div>
            <div  class="footer_img">
                <div class="img_box">
                    <img src="@/assets/glogo.png" alt="">
                </div>
                <div class="img_wx" @mouseenter="enter()" @mouseleave="leave()">
                    <div class="wx_container">
                        <img src="@/assets/footer-wx.png" alt="">
                    </div>
                </div>
                <div class="two_img" v-show="flag">
                    <img src="@/assets/wx_img.jpg" alt="">
                </div>
                <div class="footer_word">
                    <div class="word_wo"></div>
                    <span class="word">Copyright2020@WHUT武汉理工大学计算机学院</span>
                </div>
            </div>
        </div>

    </div>
</template>
<script>
export default {
    data() {
        return {
            flag:false
        }
    },
    methods: {
        enter(){
            this.flag = true;
        },
        leave(){
            this.flag = false;
        }
    },
    
}
</script>
<style scoped>
.footer_container{
    width: 100%;
    height: 650px;
    background: #252526;
}
.box{
    float: left;
    height: 250px;
    width: 300px;
    background: #fff;
    margin-left: 100px;
}
.footer_top{
    height: 250px;
    width: 100%;
    background: #fff;
    padding-left: 180px;
}
.box_title{
    margin-top: 45px;
    font-size: 28px;
    color: #42b983;
    width: 100%;
    text-align: center;
}
.box_inner{
    width: 100%;
    text-align: center;
    color: #4f5959;
    margin-top: 20px;
}
.footer_title{
    width: 100%;
    height: 50px;
    line-height: 50px;
    font-size: 20px;
    color: #dcdcdc;
    text-align: center;
    margin-top: 20px;
}
.footer_title span{
    margin-left: 100px;
}
.footer_inner{
    position: relative;
    left: 50%;
    margin-left: -300px;
    width: 600px;
    height: 50px;
    line-height: 50px;
    font-size: 20px;
    color: #dcdcdc;
    background: #2e2e2f;
    text-align: center;
    margin-top: 20px;
}
.inner_button{
    float: left;
    height: 50px;
    width: 100px;
    font-size: 16px;
    background: #2e2e2f;
    margin: 0 12.5px;
    color: #dcdcdc;
}

.boll{
    float: left;
    display: block;
    width: 50px;
    height: 50px;
    background: #2e2e2f;
    border-radius: 50%;
}
.inner_head{
    position: relative;
    left: -25px;
}
.inner_foot{
    position: relative;
    right: -25px;
}
.inner_button a{
    text-decoration:none;
    color: #dcdcdc;
}
.inner_button a:hover{
    color: red;
}
.footer_img{
    position: relative;
    left: 50%;
    margin-left: -200px;
    width: 400px;
    height: 80px;
    line-height: 50px;
    font-size: 20px;
    color: #dcdcdc;
    text-align: center;
    margin-top: 25px;

}

.img_box{
    position:absolute;
    left: 50px;
 
}
.img_wx{
    position: relative;
    width: 40px;
    height: 36px;
    top: 20px;
    left: 250px;
    overflow: hidden;
}
.img_wx:hover .wx_container{
    transform:translateY(35px);
}
.wx_container{
    position: absolute;
    z-index: 999;
    bottom: 0px;
    height: 70px;
    transition: all .5s;
}
.two_img img{
    width: 100px;
    height: 100px;
}
.two_img{
    position: absolute;
    top: 80px;
    left: 220px;
    z-index: 999;
}
.two_img:after{
    width: 0px;
    height: 0px;
    border-width: 8px;
    border-style: solid;
    border-color: transparent transparent #fff transparent;
    position: absolute;
    content: ' ';
    left: 40px;
    top: -16px;
}
.footer_word{
    text-align: center;
    width: 100%;
    height: 50px;
    margin: 50px 0;
}
.word_wo{
    margin-left: -700px;
    left: 50%;
    display: block;
    position: relative;
    height: 1px;
    width: 1400px;
    background-color: #323233;
    margin-top: 100px;
    
}
.word{
    position: relative;
    top: 30px;
    font-size: 16px;
    text-align: center;
}

</style>

