  <template>
  <div>
     <v-row>
      <v-col cols="12" sm="6" class="mx-auto pink--text" >
        <h1> Add Jeeps</h1>
      </v-col>
    </v-row>
    <JeepForm/>
  </div>
    
  </template>
  
  <script>
    import JeepForm from "../components/JeepForm"
  export default {
      components:{
        JeepForm:JeepForm
      }
  }
  </script>
  
  <style>
  
  </style>