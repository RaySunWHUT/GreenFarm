<template>
    <div>
        <body>

<!--头部结束-->
<!--导航结束-->
<div class="container"> 
    <div class="title">产品信息管理</div>         
    <Table border width="1000" :columns="elementCol" :data="proList" @on-row-click="getProId"></Table> 
    <Button class="button-p" type="info" @click="addProInfo">新增农产品信息</Button>
</div>
</body>
    </div>
</template>

<script>

import http from '@/api/http'

export default {

    inject: ['reload'],
    data() {

      return {

        proId: '',    
        
        message: "proList",

        proList: [],

        elementCol: [

        {
          title: '产品编号',
          key: 'proId',
          width: 100,
          align: 'center'
        },

        {
          title: '产品名',
          key: 'proName',
          width: 100,
          align: 'center'
        },

        {
          title: '产地',
          key: 'proAddress',
          width: 150,
          align: 'center'
        },

        {
          title: '产品信息',
          key: 'proIntro',
          align: 'center'
        },

        {
          title: '价格/kg',
          key: 'proPrice',
          width: 100,
          align: 'center'
        },
        {
            title:'状态',
            key:'state',
            width:'100',
            align:'center'
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

                    this.cancel(params);
                  
                  }
                
                }

              }, '删除')

            ])

          }

        }

      ],
            
        }
    
    },


    created() {
    
    },

    mounted() {

      this.listPros();

    },

    methods: {

        getProId(data, index) {

          this.proId = data.proId;

        },

        addProInfo() {
            
            this.$router.push('/addProductInfo');
        
        },

        updatePro() {   // 修改产品



        },

        listPros() {    // 列出产品

          var _this = this;

          http({

                // 假设后台需要的是表单数据这里你就可以更改
                headers: {

                "Content-Type": "application/json;charset=UTF-8",
                "Token": _this.$store.state.token

                },

                method: 'post',

                url: 'http://localhost:8080/business/listPros',

                data: {

                  message: _this.message

                }

              }).then((res) => {

                var info = res.info;
                var code = res.code;

                if (code == 200) {

                    var list = info.proList;

                    for (var i = 0; i < list.length; i++) {

                        _this.proList.push({

                          proId: list[i].proId,
                          proName: list[i].proName,
                          proPrice: list[i].proPrice,
                          proAddress: list[i].proAddress,
                          proIntro: list[i].proIntro,
                          stock: list[i].stock,
                          proImg: list[i].proImg,
                          typeId: list[i].typeId,
                          state: list[i].state

                        });

                    }

                } else if (code == 400) {

                    this.$Message.error('产品信息列出!');

                } else {

                    this.$Message.error('未知错误!');

                }       
              
            })

        },

        show(params) {



        },
        cancel(params) {

        var proId = params.row.proId;

        var _this = this;

        this.$Modal.warning({

              title: '删除产品',
              okText: '删除',
              closable: true,
              content: '您确定要删除这条删除记录吗?',
              onOk:() => {

                  http({

                    // 假设后台需要的是表单数据这里你就可以更改
                    headers: {

                    "Content-Type": "application/json;charset=UTF-8",
                    "Token": _this.$store.state.token

                    },

                    method: 'post',

                    url: 'http://localhost:8080/business/deletePro',

                    data: {

                      proId: proId

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

.container {

    position: relative;
    left: 50%;
    margin-left: -500px;

}

.button-p {

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