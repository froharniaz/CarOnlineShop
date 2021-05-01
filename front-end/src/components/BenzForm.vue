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
      
       <v-btn v-if="BenzId" color="info" @click="updateBenz" >Update Benz</v-btn>
       <v-btn v-else color="info" @click="AddNewBenz">Save Benz</v-btn>
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

import BenzService from "../api/BenzService"
export default {
  props:["BenzId"],
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
        return this.BenzId ? "Benz update successfully":
         "Benz save successfully"
      }
    },
    methods:{
     async AddNewBenz(){
        const Benz ={
          carname:this.carname,
         engine:this.engine,
          modelYear:this.modelYear,
           kilometer:this.kilometer,
          price:this.price
        };
      const saveBenz= await BenzService.AddBenz(Benz);
        console.log(saveBenz);
           this.snackbar = true;
        this.resetForm();
        
      },
      resetForm(){
        this.carname = null;
        this.engine=null;
        this.modelYear = null;
        this.kilometer = null;
        this.price = null;
      },
     async updateBenz(){
        const Benz ={
          _id:this.BenzId,
            carname:this.carname,
         engine:this.engine,
         modelYear:this.modelYear,
         kilometer:this.kilometer,
          price:this.price
        };
     const response = await  BenzService.updateBenz(Benz);
     const updingBenz = response.data;
     this.snackbar = true
     console.log(updingBenz);

     setTimeout(() => {
        this.$router.push("/benz/AllBenzs");
      }, 1500);
       
      } 

    },
     async created(){
       if(this.BenzId){
          const response = await   BenzService.getById(this.BenzId);
          const Benz = response.data;
          this.carname = Benz.carname;
          this.engine = Benz.engine;
          this.modelYear = Benz.modelYear;
           this.kilometer = Benz.kilometer;
          this.price = Benz.price;
       }
   
    

    }

   
};
</script>

<style>

</style>

