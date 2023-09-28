const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const {VueLoaderPlugin } = require('vue-loader');
//UTILS
const __base = path.resolve(__dirname, '..')
const __src = path.resolve(__base, 'src');

module.exports = {

    //ENTRYPOINT
    entry: {
        app: path.resolve(__src, 'main.ts'),
    },

    //GENERAL PLUGINS
    plugins: [
        new HtmlWebpackPlugin({
            title: 'Vue Sample',
            favicon: path.resolve(__src, 'static', 'favicon.ico'),
            template: path.resolve(__src, 'templates', 'index.html'),
        }),
        new VueLoaderPlugin(),
    ],

    //GEN MODULE
    module: {
        //typescript
        rules: [
            {
                test: /\.vue$/,
                loader: 'vue-loader',
            },

            {
                test: /\.ts$/,
                loader: 'ts-loader',
                exclude: /node_modules/,
                options: {
                    appendTsSuffixTo : [/\.vue$/],
                },
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                  loader: "babel-loader",
                },
              },
            {
                test: /\.png$/,
                type: 'asset/resource',
            },

        ],
    },
    //ENPOINT
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__base, 'dist'),
        clean: true,
    },

    resolve: {
        alias: {
        '@': path.resolve(__dirname, "./src/"),
        },
        extensions: [".*", '.tsx',".ts", ".js", ".vue", ".json"],
      },
}

