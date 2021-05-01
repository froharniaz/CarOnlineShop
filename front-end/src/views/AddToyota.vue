  <template>
  <div>
     <v-row>
      <v-col cols="12" sm="6" class="mx-auto pink--text" >
        <h1> Add Toyotas</h1>
      </v-col>
    </v-row>
    <ToyotaForm/>
  </div>
    
  </template>
  
  <script>
    import ToyotaForm from "../components/ToyotaForm"
  export default {
      components:{
        ToyotaForm:ToyotaForm
      }
  }
  </script>
  
  <style>
  
  </style>