import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:'/',
      name: 'home',
      component: () => import('../components/routes/Home.vue')
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../components/routes/About.vue')
    },
    {
      path: '/activities',
      name: 'activities',
      component: () => import('../components/routes/Activities.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../components/routes/Login.vue')
    },
    {
      path: '/auth',
      name: 'authenfication',
      component: () => import('../components/routes/Auth.vue')
    }
  ]
})

export default router
