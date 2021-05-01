<template>
<div>
  <Navbar/>
     <v-row>
      <v-col cols="12" sm="6" class="mx-auto pink--text" >
        <h1> Edit Benzs</h1>
      </v-col>
    </v-row>
     <BenzForm :BenzId="BenzId"/>
     
</div>
</template>
 
<script>
import BenzForm from "../components/BenzForm"
export default {
    components:{
        BenzForm:BenzForm
    },
    data() {
      return {
        BenzId: this.$route.params.id
      }; 
    }
};
</script>

<style>

</style>