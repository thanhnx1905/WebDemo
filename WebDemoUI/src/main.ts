import {createApp} from 'vue';
import App from './App.vue';
import './static/global.scss';
import './static/tailwind.css'
import router from './router';
//import Sidebar from './components/Sidebar.vue'

const app = createApp(App);
app.use(router);
//app.component("sidebar-component", Sidebar)
app.mount('#app');
