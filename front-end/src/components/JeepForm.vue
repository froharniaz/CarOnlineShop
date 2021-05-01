<template>
  <div class="about">
    
   <Navbar/>
  <!-- CarName -->
    <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      <!-- <v-text-field label="Outlined" outlined></v-text-field> -->
      <v-text-field v-model="carname" label="Car Name" :rules="rules" hide-details="auto"></v-text-field>
    </v-col>
    </v-row>
    <!--  Engine -->
      <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      <!-- <v-text-field label="Outlined" outlined></v-text-field> -->
      <v-text-field v-model="engine" label="Engine" :rules="rules" hide-details="auto"></v-text-field>
    </v-col>
    </v-row>
    <!-- Model Year -->
    <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      <!-- <v-text-field label="Outlined" outlined></v-text-field> -->
      <v-text-field v-model="modelYear" label="Model Year" :rules="rules" hide-details="auto"></v-text-field>
    </v-col>
    </v-row>
    <!-- Kilometer -->
    <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      <!-- <v-text-field label="Outlined" outlined></v-text-field> -->
      <v-text-field v-model="kilometer" label="Kilometer" :rules="rules" hide-details="auto"></v-text-field>
    </v-col>
    </v-row>
    <!-- Price -->
    <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      <!-- <v-text-field label="Outlined" outlined></v-text-field> -->
      <v-text-field v-model="price" label="Price" :rules="rules" hide-details="auto"></v-text-field>
    </v-col>
    </v-row>
    
    <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      
       <v-btn v-if="JeepId" color="info" @click="updateJeep" >Update Jeep</v-btn>
       <v-btn v-else color="info" @click="AddNewJeep">Save Pen</v-btn>
    </v-col>
    </v-row>
    <div class="text-center ma-2">
    
    <v-snackbar
      right
      v-model="snackbar"
    >
      {{ text }}

      <template v-slot:action="{ attrs }">
        <v-btn
          color="white"
          text
          v-bind="attrs"
          @click="snackbar = false"
        >
          Close
        </v-btn>
      </template>
    </v-snackbar>
  </div>
   

  </div> 
</template>


<script>
import JeepService from "../api/JeepService"
export default {
  props:["JeepId"],
    data(){
      return{
        carname : null,
        engine:null,
        modelYear:null,
        kilometer:null,
        price : null,
         snackbar:false,
         
           
      };
    },
    computed:{
      text(){
        return this.JeepId ? "Jeep update successfully":
         "Jeep save successfully"
      }
    },
    methods:{
     async AddNewJeep(){
        const Jeep ={
         carname:this.carname,
         engine: this.engine,
          modelYear:this. modelYear,
           kilometer:this.kilometer,
          price :this.price
        };
      const saveJeep= await JeepService.AddJeep(Jeep);
        console.log(saveJeep);
           this.snackbar = true;
        this.resetForm();
       this.$router.push("/Jeep/Jeeps");
        
      },
      resetForm(){
       this.carname = null;
        this.engine=null;
        this.modelYear = null;
        this.kilometer = null;
        this.price = null;
      },
     async updateJeep(){
        const Jeep ={
          _id : this.JeepId,
            carname:this.carname,
         engine : this.engine,
         modelYear:this.modelYear,
         kilometer:this.kilometer,
          price :this.price
        };
     const response = await  JeepService.updateJeep(Jeep);
     const updingJeep = response.data;
     this.snackbar = true
     console.log(updingJeep);

      setTimeout(() => {
        this.$router.push("/Jeep/Jeeps");
      }, 1500);
     
       
      } 

    },
     async created(){
       if(this.JeepId){
          const response = await JeepService.getById(this.JeepId);
          const Jeep = response.data;
         this.carname = Jeep.carname;
          this.engine = Jeep.engine;
          this. modelYear = Jeep. modelYear;
           this. kilometer = Jeep. kilometer;
          this.price = Jeep.price;
       }
   }

   
};
</script>

<style>

</style>

