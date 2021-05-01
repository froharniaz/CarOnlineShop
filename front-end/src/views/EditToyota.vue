<template>
<div>
  <Navbar/>
     <v-row>
      <v-col cols="12" sm="6" class="mx-auto pink--text" >
        <h1> Edit Toyotas</h1>
      </v-col>
    </v-row>
     <ToyotaForm :ToyotaId="ToyotaId"/>
     
</div>
</template>
 
<script>
import ToyotaForm from "../components/ToyotaForm"
export default {
    components:{
        ToyotaForm:ToyotaForm
    },
    data() {
      return {
        ToyotaId: this.$route.params.id
      }; 
    }
};
</script>

<style>

</style>