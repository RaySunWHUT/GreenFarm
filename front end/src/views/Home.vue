<template>
    <div class="mainstyle">
        <div class="knowmore">
            <!-- <router-link to="./about">
                
            </router-link> -->
            <p>Welcome!</p>
        </div>
    </div>
</template>

<script>
export default {

    

}
</script>


<style lang="less" scoped>

.mainstyle {
    position: absolute;
    top: 0px;
    left: 0px;
    background-image: url(../assets/bg.jpg);
    width: 100%;
    height: 100%;
    background-repeat: no-repeat;
    background-size: cover;
}

.knowmore {

    position: relative;
    top: 400px;
    left: 290px;
    width: 210px;
    text-align: center;
    // background-color: dodgerblue;
    border-radius: 5px;

}

.knowmore p{
    color: white;
    font-size: 35px;
    font-weight: 700;
}
</style>

