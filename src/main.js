import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/theme-chalk/index.css'
import { getSessionStorage } from './common'


router.beforeEach(function(to,from,next){
    let doctor =getSessionStorage("jinandaxuedoctor");

    if(!(to.path=="/")){
        if(doctor==null){
            //to.path='/login';
            router.push("/");
        }
    }


    next();



})

const app = createApp(App)

app.use(router)

app.use(ElementPlus)

app.mount('#app')
