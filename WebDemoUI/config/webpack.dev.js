const { merge } = require('webpack-merge');
const common =  require('./webpack.common.js');

module.exports = merge(common, {
    
    // DEV MODE
    mode: 'development',
    devtool: 'inline-source-map',

    //DEV SERVER CONFIG
    devServer: {
        static: './dist',
        open: true,
        hot: true,
        port: 3000
    },

    //dev rule
    module:{
        rules: [
            {
                test: /\.css$/,
                use: ['vue-style-loader', 'css-loader',  'postcss-loader'],
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