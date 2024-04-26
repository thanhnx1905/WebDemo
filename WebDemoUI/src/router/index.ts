import { createRouter, createWebHashHistory, createWebHistory } from 'vue-router'

import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Login from '../views/Login.vue'
import Team from '../views/Team.vue'
import Setting from '../views/Setting.vue'
import Contact from '../views/Contact.vue'
//import '../assets/ts/loaduicom.ts'

//https://router.vuejs.org/guide/advanced/navigation-guards.html
const routes = [
    {
        path: '/',
        component: Home,
    },
    {
        path: '/about',
        component: About
    },
    {
        path: '/team',
        component: Team,
        beforeEnter: (to: any, from: any, next: any) => {
            const logged: boolean = sessionStorage.getItem("logged") == "true" ? true : false;
            if (logged) {
                next();
            } else {
                next({ path: '/login' });
            }
        }
    },
    {
        path: '/setting',
        component: Setting
    },
    {
        path: '/contact',
        component: Contact
    },
    {
        path: '/login',
        component: Login
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes,
    
})
export default router

