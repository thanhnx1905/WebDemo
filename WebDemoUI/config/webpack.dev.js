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
        }
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