import {createApp} from 'vue';
import App from './App.vue';
import './static/global.scss';
import './static/tailwind.css'
import router from './router';
import store from './components/common/vuex/Store';
//import Sidebar from './components/Sidebar.vue'

const app = createApp(App);
app.use(router);
app.use(store);
//app.component("sidebar-component", Sidebar)
app.mount('#app');
