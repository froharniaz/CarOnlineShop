<template >
  
  <v-bottom-navigation
  class="pa-md-3 mx-lg-auto"
    v-model="value"
    :background-color="color"
    
    dark
    shift
  >
   <v-btn >
      <span class="pa-md-2" ><router-link class="white--text text-decoration-none" to="/">Home</router-link></span>

      <v-icon color="white"> mdi-home</v-icon>
    </v-btn>
    
     <v-btn >
      <span class="pa-md-2" ><router-link class="white--text text-decoration-none" to="/ShopBenz">Shop Benz</router-link></span>

      <v-icon color="white"> mdi-store</v-icon>
    </v-btn>
     <v-btn >
      <span class="pa-md-2" ><router-link class="white--text text-decoration-none" to="/ShopToyota">Shop Toyota</router-link></span>

      <v-icon color="white"> mdi-store</v-icon>
    </v-btn>
     <v-btn >
      <span class="pa-md-2" ><router-link class="white--text text-decoration-none" to="/ShopJeep">Shop Jeep</router-link></span>

      <v-icon color="white"> mdi-store</v-icon>
    </v-btn>
    
    <v-btn >
      <span class="pa-md-2" ><router-link class="white--text text-decoration-none" to="/benz/AddBenz">Add Benz</router-link></span>

      <v-icon color="white"> mdi-checkbox-marked-circle</v-icon>
    </v-btn>
    

    

    <v-btn>
      <span class="pa-md-2" ><router-link  class="white--text text-decoration-none" to="/benz/AllBenzs">Benzs</router-link></span>

      <v-icon color="white">mdi-library</v-icon>
    </v-btn>

    <v-btn>
      <span class="pa-md-2" ><router-link class="white--text text-decoration-none" to="/Toyota/AddToyota">AddToyota</router-link></span>

      <v-icon color="white">mdi-basket</v-icon>
    </v-btn>

    <v-btn>
      <span class="pa-md-2" ><router-link class="white--text text-decoration-none" to="/Toyota/Toyotas">All Toyotas</router-link></span>

      <v-icon color="white">mdi-warehouse</v-icon>
    </v-btn>

    <v-btn>
      <span class="pa-md-2" ><router-link class="white--text text-decoration-none" to="/Jeep/AddJeep">Add Jeep</router-link></span>

      <v-icon color="white">mdi-store</v-icon>
    </v-btn>
     <v-btn>
      <span class="pa-md-2" ><router-link class="white--text text-decoration-none" to="/Jeep/Jeeps"> Jeeps</router-link></span>

      <v-icon color="white">mdi-store</v-icon>
    </v-btn>
    
  
  


  </v-bottom-navigation>

</template>

<script>
export default {
  data: () => ({ value: 1 }),

    computed: {
      color () {
        switch (this.value) {
           case 0: return 'teal darken-3'
          case 1: return 'teal accent-4'
          case 2: return 'teal'
          case 3: return 'teal accent-4'
          case 4: return 'deep-purple lighten-1'
          default: return 'blue-grey'
        }
      },
    },
}
</script>

<style>

</style>

















