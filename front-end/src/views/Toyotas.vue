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
        <tr v-for="Toyota in Toyotas" :key="Toyota._id"> 
         <td>{{ Toyota.carname }}</td>
          <td>{{ Toyota.engine}}</td>
          <td>{{ Toyota.modelYear}}</td>
           <td>{{ Toyota.kilometer}}</td>
          <td>{{ Toyota.price}}</td>
         
          <td>
            <v-btn :to="{ name :'EditToyota', params:{
              id:Toyota._id
            }}" small color ="teal accent-3" class="mr-2"> <v-icon dark>
        mdi-pencil
      </v-icon>Edit</v-btn>
            <v-btn small color = "pink accent-2" @click="deleteToyota(Toyota._id)" ><v-icon dark>
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
import ToyotaService from '../api/ToyotaService';
export default {
    data(){
        return{
            Toyotas:[],
            snackbar:false,
            text : "Toyota successfully deleteed",
            // cards:[
            //   {src:'https://res.cloudinary.com/landry-bete/image/upload/v1525135352/tajine_mfnbd8.jpg'}
            // ]
        };
    },
    methods :{
      async  deleteToyota(ToyotaId){
          const conf = confirm("Do you want to delete this Toyota");
          if(conf){
           const response = await  ToyotaService.deleteById(ToyotaId); 
           console.log(response.data);
            this.snackbar = true;
           this.Toyotas = this.Toyotas.filter(Toyota =>{
             return Toyota._id  !==ToyotaId
           })
          }
           
        }
    },
   async mounted(){
       const response= await ToyotaService.getAllToyotas();
       this.Toyotas = response.data;
        
    }
};
</script>

<style>

</style>