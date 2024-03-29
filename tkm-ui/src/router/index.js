import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:'/',
      name: 'home',
      component: () => import('../components/routes/HomePage.vue')
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../components/routes/AboutPage.vue')
    },
    {
      path: '/activities',
      name: 'activities',
      component: () => import('../components/routes/ActivitiesList.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../components/routes/LoginPage.vue')
    },
    {
      path: '/auth',
      name: 'authenfication',
      component: () => import('../components/routes/AuthPage.vue')
    }
  ]
})

export default router
