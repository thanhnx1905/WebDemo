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

// const RefreshMixin = {
//     beforeMount() {
//       window.addEventListener('beforeunload', this.handleRefresh);
//     },
//     beforeUnmount() {
//       window.removeEventListener('beforeunload', this.handleRefresh);
//     },
//     methods: {
//       handleRefresh(event) {
//         // Logic xử lý khi refresh page
//         // Nếu bạn muốn ngăn chặn việc refresh, bạn có thể sử dụng event.preventDefault()
//         // event.preventDefault();
//       }
//     }
//   }
// app.mixin(RefreshMixin);
 app.mount('#app');
