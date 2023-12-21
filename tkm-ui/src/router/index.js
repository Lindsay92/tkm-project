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
      path: '/map',
      name: 'map',
      component: () => import('../components/routes/MapPage.vue')
    },
    {
      path: '/activities',
      name: 'activities',
      component: () => import('../components/routes/ActivitiesList.vue')
    },
    {
      path: '/activities/:id/detail',
      name: 'activity-detail',
      component: () => import('../components/routes/ActivityDetail.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../components/authentication/LoginPage.vue')
    },
    {
      path: '/auth',
      name: 'authenfication',
      component: () => import('../components/authentication/AuthPage.vue')
    },
    {
      path: '/admin/activities/create',
      name: 'activities-create',
      component: () => import('../components/admin/Create.vue')
    },
    {
      path: '/admin/activities/:id/update',
      name: 'activity-update',
      component: () => import('../components/admin/Update.vue')
    }, 
    {
      path: '/admin/activities',
      name: 'activities-edit',
      component: () => import('../components/admin/Edit.vue')
    }, 
    {
      path: '/profile',
      name: 'profile-user',
      component: () => import('../components/user/Profile.vue')
    }
  ]
})

export default router
