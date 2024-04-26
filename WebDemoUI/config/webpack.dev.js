const { merge } = require('webpack-merge');
const common = require('./webpack.common.js');

module.exports = merge(common, {

    // DEV MODE
    mode: 'development',
    devtool: 'inline-source-map',

    //DEV SERVER CONFIG
    devServer: {
        static: './dist',
        open: true,
        hot: true,
        port: 3000,
        headers: {
            "Access-Control-Allow-Origin": "http://localhost:3000",
            "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, PATCH, OPTIONS",
            "Access-Control-Allow-Headers": "X-Requested-With, content-type, Authorization"
        },
        host: '0.0.0.0',
        client: {
            overlay: false,
        },
        watchFiles: ['src/**/*', 'dist/**/*'],
        historyApiFallback: true,
        //openPage: '/nts.uk.mobile.web/ccg/007/b',
        // proxy: {
        //     context: ['/DDDServer/*'], // Replace with your API context path if applicable
        //     target: 'http://localhost:8080', // Replace with your API server URL if different
        //     secure: false,
        //     changeOrigin: true,
        //     rewrite: function (ctx) {
        //         ctx.req.url = ctx.req.url.replace('/DDDServer', '/DDDServer/webapi'); // Replace '/api' with your API context path if different
        //     }
        // }
    },

    //dev rule
    module: {
        rules: [
            {
                test: /\.css$/,
                use: ['vue-style-loader', 'css-loader', 'postcss-loader'],
            },

            {
                test: /\.scss$/,
                use: [
                    'vue-style-loader',
                    'css-loader',
                    'sass-loader',
                    'postcss-loader',
                ],
            },

        ],
    },
})