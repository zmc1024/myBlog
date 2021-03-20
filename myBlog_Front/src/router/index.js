import Vue from 'vue'
import VueRouter from 'vue-router'
import home from '@/views/home'
import recommended from '@/views/recommended'
import backend from '@/views/backend'
import frontend from '@/views/frontend'
import article from '@/views/article'
import post from '@/views/post'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: home,
    children: [
      {
        path: '/',
        name: 'recommended',
        component: recommended
      },
      {
        path: 'backend',
        name: 'backend',
        component: () => import('@/views/backend'),
        children: [
          {
            path: '/backend/all',
            name: 'all',
            component: () => import('@/views/backend'),
          },
          {
            path: '/backend/Java',
            name: 'Java',
            component: () => import('@/views/backend'),
          },
          {
            path: '/backend/C++',
            name: 'C++',
            component: () => import('@/views/backend'),
          },
          {
            path: '/backend/SpringBoot',
            name: 'SpringBoot',
            component: () => import('@/views/backend'),
          },
          {
            path: '/backend/Go',
            name: 'Go',
            component: () => import('@/views/backend'),
          },
          {
            path: '/backend/Python',
            name: 'Python',
            component: () => import('@/views/backend'),
          },
          {
            path: '/backend/Spring',
            name: 'Spring',
            component: () => import('@/views/backend'),
          },
        ]
      },
      {
        path: 'frontend',
        name: 'frontend',
        component: () => import('@/views/frontend')
      },
    ]
  },
  {
    path: '/article',
    name: 'article',
    component: () => import('@/views/article')
  },
  {
    path: '/post',
    name: 'post',
    component: () => import('@/views/post')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 挂载路由导航守卫
router.beforeEach((to, from, next) => {
  if(to.path == '/') return next();
  // 获取user
  const userFlag = localStorage.getItem("user");    // 取出用户
  if(!userFlag) return next('/');   // 未登录，返回首页
  next();   // 已登录，放行
})

export default router
