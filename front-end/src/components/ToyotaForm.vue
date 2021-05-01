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
      
       <v-btn v-if="ToyotaId" color="info" @click="updateToyota" >Update Toyota</v-btn>
       <v-btn v-else color="info" @click="AddNewToyota">Save Toyota</v-btn>
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
import ToyotaService from "../api/ToyotaService"
export default {
  props:["ToyotaId"],
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
        return this.ToyotaId ? "Toyota update successfully":
         "Toyota save successfully"
      }
    },
    methods:{
     async AddNewToyota(){
        const Toyota ={
        carname:this.carname,
         engine: this.engine,
          modelYear:this. modelYear,
           kilometer:this.kilometer,
          price :this.price
        };
      const saveToyota= await ToyotaService.AddToyota(Toyota);
        console.log(saveToyota);
           this.snackbar = true;
        this.resetForm();
     //  this.$router.push("/Toyota/Toyotas");
        
      },
      resetForm(){
       this.carname = null;
        this.engine=null;
        this.modelYear = null;
        this.kilometer = null;
        this.price = null;
      },
     async updateToyota(){
        const Toyota ={
          _id : this.ToyotaId,
          carname:this.carname,
         engine : this.engine,
         modelYear:this.modelYear,
         kilometer:this.kilometer,
          price :this.price
        };
     const response = await  ToyotaService.updateToyota(Toyota);
     const updingToyota = response.data;
     this.snackbar = true
     console.log(updingToyota);

       setTimeout(() => {
        this.$router.push("/Toyota/Toyotas");
      }, 1500);
       
      } 

    },
     async created(){
       if(this.ToyotaId){
          const response = await ToyotaService.getById(this.ToyotaId);
          const Toyota = response.data;
         this.carname = Toyota.carname;
          this.engine = Toyota.engine;
          this. modelYear = Toyota. modelYear;
           this. kilometer = Toyota. kilometer;
          this.price = Toyota.price;
       }
   
    

    }

   
};
</script>

<style>

</style>

