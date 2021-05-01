<template>
  <v-app>
      <Navbar/>
    
      <!-- <router-link to="/aughter/AddBook">Add Book</router-link> -->
       <!-- <router-link to="/aughter/AllBooks">Books</router-link> -->
       <!-- <router-link to="/aughter/ByBook">BuyBook</router-link> -->
       <!-- <router-link to="/aughter/Warehouse">Warehouse</router-link> -->
        <!-- <router-link to="/aughter/Shopping-basket">Shopping basket</router-link> -->
    <v-container>
      <router-view> </router-view>
       
    </v-container>
     
    </v-app>
    
</template>
  
<script>
export default {
  name:"App",
  data: ()=>({

  })
};
</script>

<style>

</style>

<script>
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import HelloWorld from "./components/HelloWorld";

export default {
  name: "App",

  components: {
    HelloWorld,
    Navbar:Navbar,
    Footer:Footer
  },

  data: () => ({
    //
  })
};
</script>
