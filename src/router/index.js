import { createRouter, createWebHistory } from 'vue-router'
import DoctorLogin from '@/views/DoctorLogin.vue'
import OrdersList from '@/views/OrdersList.vue'
import OrdersContentView from '@/views/OrdersContentView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: DoctorLogin,
    },
    {
      path: '/ordersList',
      name: 'ordersList',
      component: OrdersList,
    },{
      path: '/ordersContentView',
      name: 'ordersContentView',
      component: OrdersContentView,
    }
  ],
})

export default router
