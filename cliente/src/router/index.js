import VueRouter from 'vue-router'
import Vue from 'vue'
import Error404 from '../views/ErrorPages/Error404.vue'
import crud from '../views/CrudMovies.vue'

Vue.use(VueRouter)
const routes =[
    //la ruta base 
    {
        path:'/',
        name:'crud',
        component: crud
    },
    {
        path:"/",
        
        component:{
            render(c){
                return c('router-view');
            },
        },
        children:[
            {
                path:'/404',
                name:'404',
                component: Error404 
            },
            {
                path:'*',
                redirect: '/404'
            }
        ]
    }
]
const router = new VueRouter({routes,})
export default router;