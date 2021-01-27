import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: () => import('../components/Home'),
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'CommodityIndex',
          component: () => import('../components/commodity/CommodityIndex'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/personal',
          name: 'PersonalIndex',
          component: () => import('../components/personal/PersonalIndex'),
          meta: {
            requireAuth: true
          },
          children: [
            {
              path: "/personal/perUpdate",
              name: "PerUpdate",
              component: () => import("../components/personal/PerUpdate")
            },
            {
              path: "/personal/perMore",
              name: "PerMore",
              component: () => import("../components/personal/PerMore")
            }
          ]
        },
        {
          path: '/shopcar',
          name: 'ShopcarIndex',
          component: () => import("../components/shopcar/ShopcarIndex"),
          meta: { 
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('../components/Login')
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('../components/Register')
    }
  ]
})

