<template>
<div>
<body>
<!--导航 -->
<!--头部结束-->
<!--导航结束-->
<div class="container">
    <div class="title">租赁信息管理</div>
    <Table border width="1000" :columns="elementCol" :data="farmList" @on-row-click="getFarmId"></Table> 
    <div class="button_p"><Button type="primary" @click="addRent()">新增租赁信息</Button></div>
</div>
</body>
</div>

</template>


<script>

import http from '@/api/http'

export default {

    inject:['reload'],

    data() {

        return {

        farmId:'',

        message: "farmList",

        farmList: [], 

        elementCol: [
        {
          title: '农场名',
          key: 'farmName',
          width: 100,
          align: 'center'
        },

        {
          title: '农场规格',
          key: 'farmSize',
          width: 150,
          align: 'center'
        },
        {
          title: '农场描述',
          key: 'farmIntro',
          width: 150,
          align: 'center'
        },
        {
          title: '农场地址',
          key: 'farmAddress',
          align: 'center'
        },

        {
          title: '月租金',
          key: 'farmPrice',
          width: 100,
          align: 'center'
        },
        {
          title: '操作',
          key: 'operate',
          width: 200,
          align: 'center',

          render: (h, params) => {  // params即为Table对象

            return h('div', [

              h('Button', {

                style: {

                  marginRight: '5px',
                  background: 'red',
                  color: 'white'

                },

                on: {

                  click: () => {

                    this.show(params);

                  }

                }

              }, '修改'),

              h('Button', {

                style: {

                  background: 'blue',
                  color: 'white'

                },

                on: {

                  click: () => {

                    this.cancelRent(params);
                  
                  }
                
                }
              }, '删除')

            ])

          }

        }

      ],
            
        }
    },

    mounted() {

        this.listFarms();
    
    },

    methods: {


    getFarmId(data, index) {

        this.farmId = data.farmId;
    },


    addRent() {

        this.$router.push("/addRentInfo");

    },

    show(params) {

    },

    listFarms() {

        var _this = this;

          http({

                // 假设后台需要的是表单数据这里你就可以更改
                headers: {

                "Content-Type": "application/json;charset=UTF-8",
                "Token": _this.$store.state.token

                },

                method: 'post',

                url: 'http://localhost:8080/business/listFarms',

                data: {

                  message: _this.message

                }

              }).then((res) => {

                var info = res.info;
                var code = res.code;

                if (code == 200) {

                    var list = info.farmList;

                    for (var i = 0; i < list.length; i++) {

                        _this.farmList.push({

                          farmId: list[i].farmId,
                          farmName: list[i].farmName,
                          farmSize: list[i].farmSize,
                          farmPrice: list[i].farmPrice,
                          farmAddress: list[i].farmAddress,
                          farmIntro: list[i].farmIntro,
                          farmImg: list[i].farmImg,

                        });

                    }

                } else if (code == 400) {

                    this.$Message.error('租赁信息列出失败!');

                } else {

                    this.$Message.error('未知错误!');

                }       
              
            })

    },

     cancelRent(params) {
        
        var farmId = params.row.farmId;
        
        var _this = this;

        this.$Modal.warning({

            title:'删除租赁信息',
            okText:'删除',
            closable: true,
            content:'您确定要删除这条租赁记录吗?',
            onOk:() => {

                  http({

                    // 假设后台需要的是表单数据这里你就可以更改
                    headers: {

                    "Content-Type": "application/json;charset=UTF-8",
                    "Token": _this.$store.state.token

                    },

                    method: 'post',

                    url: 'http://localhost:8080/business/deleteFarm',

                    data: {

                      farmId: farmId

                    }

                  }).then((res) => {

                    var info = res.info;
                    var code = res.code;

                    if (code == 200) {

                        this.$Message.info('删除成功!');
                        
                        this.reload();  // 刷新界面

                    } else if (code == 400) {

                        this.$Message.error('删除失败!');

                    } else {

                        this.$Message.error('未知错误!');

                    }       
              
            })

          }

        })

      }

    }
}
     

</script>


<style scoped>
/*通用的去ul默认格式*/
.container {

    position: relative;
    left: 50%;
    margin-left: -500px;
    
}


.button_p {

    margin-top: 10px;
    margin-bottom: 20px;

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