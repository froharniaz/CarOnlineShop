  <template>
  <div>
     <v-row>
      <v-col cols="12" sm="6" class="mx-auto pink--text" >
        <h1> Add Benzs</h1>
      </v-col>
    </v-row>
    <BenzForm/>
  </div>
    
  </template>
  
  <script>
    import BenzForm from "../components/BenzForm"
  export default {
      components:{
        BenzForm:BenzForm
      }
  }
  </script>
  
  <style>
  
  </style>