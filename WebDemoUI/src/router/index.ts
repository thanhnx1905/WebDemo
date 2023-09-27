import { createRouter, createWebHistory } from 'vue-router'

import Home from '../views/Home.vue'
import About from '../views/About.vue'

const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/about',
        component: About
    },
    // {
    //     path: '/contact',
    //     component: Contact
    // },
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router