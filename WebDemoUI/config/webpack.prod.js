const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const CssMinimizerPlugin = require('css-minimizer-webpack-plugin');
const {merge} = require('webpack-merge');
const common = require('./webpack.common.js');
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const autoprefixer = require("autoprefixer");

module.exports = merge(common, {
    // PRODUCTION MODE
    mode: 'production',
    devtool: false,

    // PROD PLUGINS
    plugins: [
        new MiniCssExtractPlugin(),
        new CleanWebpackPlugin(),
        new MiniCssExtractPlugin({
            filename:"bundle.css",
        }),
    ],

    // PROD RULES
    module: {
        rules: [
            // CSS FILES
            {
                test: /\.css$/,
                use:[MiniCssExtractPlugin.loader, 'css-loader'],
            },
            {
                test: /\.scss$/,
                use: [
                  "style-loader",
                  MiniCssExtractPlugin.loader,
                  "css-loader",
                  "sass-loader",
                ],
              },
        ],
    },

    // OPTS
    optimization: {
        minimize: true,
        minimizer: [
            '...',
            new CssMinimizerPlugin(),
        ],
    },
});