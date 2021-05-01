<template>
 <div>
     <Navbar/>
      <v-simple-table>
    <template v-slot:default>
      <thead>
        <tr>
          <th class="text-left">Carname</th>
          <th class="text-left">engine</th>
          <th class="text-left">Model Year</th>
           <th class="text-left">kilometer</th>
          <th class="text-left">Price</th>
          <th class="text-left">Action</th>
          
        </tr>
      </thead>
      <tbody>
        <tr v-for="Benz in Benzs" :key="Benz._id"> 
          <td>{{ Benz.carname }}</td>
          <td>{{ Benz.engine}}</td>
          <td>{{ Benz.modelYear}}</td>
           <td>{{ Benz.kilometer}}</td>
          <td>{{ Benz.price}}</td>
          <td>
            <v-btn :to="{ name :'EditBenz', params:{
              id:Benz._id
            }}" small color ="teal accent-3" class="mr-2"> <v-icon dark>
        mdi-pencil
      </v-icon>Edit</v-btn>
            <v-btn small color = "pink accent-2" @click="deleteBenz(Benz._id)" ><v-icon dark>
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
import BenzService from '../api/BenzService';
export default {
    data(){
        return{
            Benzs:[],
            snackbar:false,
            text : "Benz successfully deleteed",
            // cards:[
            //   {src:'https://res.cloudinary.com/landry-bete/image/upload/v1525135352/tajine_mfnbd8.jpg'}
            // ]
        };
    },
    methods :{
      async  deleteBenz(BenzId){
          const conf = confirm("Do you want to delete this benz");
          if(conf){
           const response = await  BenzService.deleteById(BenzId); 
           console.log(response.data);
            this.snackbar = true;
           this.Benzs = this.Benzs.filter(Benz =>{
             return Benz._id  !==BenzId
           })
          }
           
        }
    },
   async mounted(){
       const response= await BenzService.getAllBenzs();
       this.Benzs = response.data;
        
    }
};
</script>

<style>

</style>