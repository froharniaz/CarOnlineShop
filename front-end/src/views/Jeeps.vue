<template>
 <div>
     <Navbar/>
      <v-simple-table>
    <template v-slot:default>
      <thead>
        <tr>
           <th class="text-left">carname</th>
          <th class="text-left">engine</th>
          <th class="text-left">Model Year</th>
           <th class="text-left">kilometer</th>
          <th class="text-left">Price</th>
           <th class="text-left">Action</th>
          
        </tr>
      </thead>
      <tbody>
        <tr v-for="Jeep in Jeeps" :key="Jeep._id"> 
          <td>{{ Jeep.carname }}</td>
          <td>{{ Jeep.engine}}</td>
          <td>{{ Jeep.modelYear}}</td>
           <td>{{ Jeep.kilometer}}</td>
          <td>{{ Jeep.price}}</td>
         
          <td>
            <v-btn :to="{ name :'EditJeep', params:{
              id:Jeep._id
            }}" small color ="teal accent-3" class="mr-2"> <v-icon dark>
        mdi-pencil
      </v-icon>Edit</v-btn>
            <v-btn small color = "pink accent-2" @click="deleteJeep(Jeep._id)" ><v-icon dark>
        mdi-delete
      </v-icon> Delete</v-btn>
            
            
          </td> 
        </tr>
      </tbody>
    </template>
  </v-simple-table>
 
  
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
import JeepService from '../api/JeepService';
export default {
    data(){
        return{
            Jeeps:[],
            snackbar:false,
            text : "Jeep successfully deleteed",
           
        };
    },
    methods :{
      async  deleteJeep(JeepId){
          const conf = confirm("Do you want to delete this Jeep");
          if(conf){
           const response = await  JeepService.deleteById(JeepId); 
           console.log(response.data);
            this.snackbar = true;
           this.Jeeps = this.Jeeps.filter(Jeep =>{
             return Jeep._id  !==JeepId
           })
          }
           
        }
    },
   async mounted(){
       const response= await JeepService.getAllJeeps();
       this.Jeeps = response.data;
        
    }
};
</script>

<style>

</style>