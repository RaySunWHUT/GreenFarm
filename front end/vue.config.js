const webpack = require('webpack')

module.exports = {

    runtimeCompiler: true,

    devServer: {

        port: 8081 // 此处修改你想要的端口号，

    },

    configureWebpack: {

        plugins: [

            new webpack.ProvidePlugin({

                $: 'jquery',

                jQuery: 'jquery',

                'window.jQuery': 'jquery',

                Popper: ['popper.js', 'default']

            })

        ]

    }

}