import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:'/',
      name: 'home',
      components: {
        default: () => import('../components/routes/HomePage.vue'),
        navbar: () => import('../components/shared/Navbar.vue')
      }
    },
    {
      path: '/about',
      name: 'about',
      components: {
        default: () => import('../components/routes/AboutPage.vue'),
        navbar: () => import('../components/shared/Navbar.vue')
      }
    },
    {
      path: '/map',
      name: 'map',
      components: { 
        default: () => import('../components/routes/MapPage.vue'),
        navbar: () => import('../components/shared/Navbar.vue')
      }
    },
    {
      path: '/activities',
      name: 'activities',
      components: { 
        default: () => import('../components/routes/ActivitiesList.vue'),
        navbar: () => import('../components/shared/Navbar.vue')
      }
    },
    {
      path: '/activities/:id/detail',
      name: 'activity-detail',
      components: {
        default: () => import('../components/routes/ActivityDetail.vue'),
        navbar: () => import('../components/shared/Navbar.vue')
      }
    },
    {
      path: '/login',
      name: 'login',
      components: {
        default: () => import('../components/authentication/LoginPage.vue'),
        navbar: () => import('../components/shared/Navbar.vue')
      }
    },
    {
      path: '/auth',
      name: 'authentication',
      components: {
        default: () => import('../components/authentication/AuthPage.vue'),
        navbar: () => import('../components/shared/Navbar.vue')
      }
    },
    {
      path: '/admin/activities/create',
      name: 'activities-create',
      components: {
        default: () => import('../components/admin/Create.vue'),
        navbar: () => import('../components/shared/NavbarAdmin.vue'),
      },
      meta: { requiresAuth : true }
    },
    {
      path: '/admin/activities/:id/update',
      name: 'activity-update',
      components: {
        default: () => import('../components/admin/Update.vue'),
        navbar: () => import('../components/shared/NavbarAdmin.vue')
      },
      meta: { requiresAuth : true }
    }, 
    {
      path: '/admin/activities',
      name: 'activities-edit',
      components: {
        default: () => import('../components/admin/Edit.vue'),
        navbar: () => import('../components/shared/NavbarAdmin.vue')
      },
      meta: { requiresAuth : true }
    }, 
    {
      path: '/admin/profile',
      name: 'profile-admin',
      component: () => import('../components/user/Profile.vue')
    },
    {
      path:'/user/home',
      name: 'user-home',
      components: {
        default: () => import('../components/routes/HomePage.vue'),
        navbar: () => import('../components/shared/NavbarUser.vue')
      },
      meta: { requiresAuth : true }
    },
    {
      path: '/user/about',
      name: 'user-about',
      components: {
        default: () => import('../components/routes/AboutPage.vue'),
        navbar: () => import('../components/shared/NavbarUser.vue')
      },
      meta: { requiresAuth : true }
    },
    {
      path: '/user/map',
      name: 'user-map',
      components: { 
        default: () => import('../components/routes/MapPage.vue'),
        navbar: () => import('../components/shared/NavbarUser.vue')
      },
      meta: { requiresAuth : true }
    },
    {
      path:'/user/activities',
      name: 'user-activities',
      components: {
        default: () => import('../components/routes/ActivitiesList.vue'),
        navbar: () => import('../components/shared/NavbarUser.vue')
      },
      meta: { requiresAuth : true }
    },
    {
      path: '/user/activities/:id/detail',
      name: 'user-activity-detail',
      components: {
        default: () => import('../components/routes/ActivityDetail.vue'),
        navbar: () => import('../components/shared/NavbarUser.vue')
      },
      meta: { requiresAuth : true }
    },
    {
      path: '/user/activities/:id/favorite',
      name: 'profile-user',
      components: {
        default: () => import('../components/user/Profile.vue'),
        navbar: () => import('../components/shared/NavbarUser.vue')
      },
      meta: { requiresAuth : true }
    },
  ]
});

router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth && localStorage.isAuthenticated == undefined) {
    next("/login")
  } else {
    next();
  }
});

export default router;