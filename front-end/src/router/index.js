import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Shop from "../views/Shop.vue";
import Benzs from "../views/Benzs.vue";
import ShopBenz from "../views/ShopBenz.vue";
import EditBenz from "../views/EditBenz.vue";
import AddToyota from "../views/AddToyota.vue";
import Toyotas from "../views/Toyotas";
import EditToyota from "../views/EditToyota.vue";
import AddJeep from "../views/AddJeep.vue";
import Jeeps from "../views/Jeeps.vue";
import EditJeep from "../views/EditJeep.vue";
import ShopToyota from "../views/ShopToyota.vue";
import ShopJeep from "../views/ShopJeep.vue";
import signup from "../views/signup.vue";
import CreateAccount from "../views/CreateAccount";









Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/Shop",
    name: "Shop",
    component: Shop
  },

  {
    path: "/ShopBenz",
    name: "ShopBenz",
    component: ShopBenz
  },
  {
    path: "/benz/AddBenz",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AddBenz.vue")
  },
  {
    path: "/benz/AllBenzs",
    name: "Benzs",
    component: Benzs
  },
  
  {
    path: "/benz/:id/edit",
    name: "EditBenz",
    component: EditBenz
  },
  {
    path: "/Toyota/AddToyota",
    name: "AddToyota",
    component: AddToyota
    
  },
  {
    path: "/Toyota/Toyotas",
    name: "Toyotas",
    component: Toyotas
    
  },
  {
    path: "/signup",
    name: "signup",
    component: signup
    
  },
  {
    path: "/CreateAccount",
    name: "CreateAccount",
    component: CreateAccount
    
  },
  {
    path: "/ShopJeep",
    name: "ShopJeep",
    component: ShopJeep
  },
  




  
  {
    path : "/ShopToyota",
    name :"ShopToyota",
    component :ShopToyota
  },
  {
    path: "/Toyota/:id/edit",
    name: "EditToyota",
    component: EditToyota
  },
  {
    path: "/Jeep/AddJeep",
    name: "AddJeep",
    component: AddJeep
    
  },
  {
    path: "/Jeep/Jeeps",
    name: "Jeeps",
    component: Jeeps
    
  },
  {
    path: "/Jeep/:id/edit",
    name: "EditJeep",
    component: EditJeep
  }
 
  
  
  
 

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
