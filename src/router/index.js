import {createRouter, createWebHistory} from 'vue-router'

// import { defineStore } from 'pinia';



const router=createRouter({
    history: createWebHistory(),
    routes:[
        { path:'/',  redirect:'/signup'},
        { path:'/signup',
          component:() =>import('../views/SignUp.vue')},
        // { path:'/manage',  redirect:'/manage'},
        { path:'/manage',
            name: 'manage',
            component:()=>import('../views/Manage.vue'), children:[
                { path:'home',  name:'home',
                    component:()=>import('../views/Home.vue'),},
                // { path:'Test',  name:'test',  component:()=>import('../views/Test.vue'),},
                { path:'PrimaryTask-lifeeducation',  name:'lifeeducation',
                    component:()=>import('../views/LifeEducation.vue'),},
                { path:'PrimaryTask-resttaker',  name:'resttaker',
                    component:()=>import('../views/RestTaker.vue'),},
                //
                { path:'Adopt-adoptrules',  name:'adoptrules',
                    component:()=>import('../views/AdoptRules.vue'),},
                { path:'Adopt-adopt',  name:'adopt',
                    component:()=>import('../views/Adopt.vue'),},
                { path:'Adopt-oberserve',  name:'oberserve',
                    component:()=>import('../views/Oberserve.vue'),},
                //
                { path:'Volunteerobject',  name:'volunteerobject',
                    component:()=>import('../views/VolunteerObject.vue'),},
                { path:'Volunteer-volunteerapply',  name:'volunteerapply',
                    component:()=>import('../views/VolunteerApply.vue'),},
                { path:'Volunteer-volunteersave',  name:'volunteersave',
                    component:()=>import('../views/VolunteerSave.vue'),},
                //
                { path:'User0Information',  name:'user0information',
                    component:()=>import('../views/User0Information.vue'),},
                { path:'User0Information',  name:'user0information',
                    component:()=>import('../views/User1Information.vue'),},


            ]},


        { path:'/404',  name:'NotFound',  component:()=>import('../views/404.vue')  },
        // { path:'/:pathMatch(.*)', redirect:'/404'}
        // { path:'/', name:'home', component:()=>import('../views/Home.vue')}
    ]
})





export  default router