import { createRouter, createWebHashHistory, createWebHistory } from 'vue-router'

import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Login from '../views/Login.vue'
import '../assets/ts/loaduicom.ts'

const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/about',
        component: About
    },
    {
        path: '/login',
        component: Login
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})

export default router