<template>
<div>
  <Navbar/>
     <v-row>
      <v-col cols="12" sm="6" class="mx-auto pink--text" >
        <h1> Edit Jeeps</h1>
      </v-col>
    </v-row>
     <JeepForm :JeepId="JeepId"/>
     
</div>
</template>
 
<script>
import JeepForm from "../components/JeepForm"
export default {
    components:{
        JeepForm:JeepForm
    },
    data() {
      return {
        JeepId: this.$route.params.id
      }; 
    }
};
</script>

<style>

</style>