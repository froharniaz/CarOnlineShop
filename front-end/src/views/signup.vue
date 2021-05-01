<template>
  <div class="signup">
    
   <Navbar/>
   <!-- CarName -->
    <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      <v-text-field v-model="Email" label="Email" :rules="[required]" hide-details="auto"></v-text-field>
    </v-col>
    </v-row>
    <!--  Engine -->
      <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      <v-text-field :rules="[required]" type="password" v-model="Password" label="Password"  hide-details="auto"></v-text-field>
    </v-col>
    </v-row>
    <!-- Model Year -->
    
    <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      
       <v-btn color="info" @click="resetForm" >Login</v-btn><br>
       <br>
       <v-btn color="info" to="/CreateAccount">Create Account</v-btn>
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
import AccountService from "../api/AccountService"
export default {
  props:["AccountId"],
    data(){
      return{
       Email: null,
        Password :null, 
      };
    },
    computed:{
      text(){
        return this.AccountId ? "Account updated successfully":
         "Account saved successfully"
      }
    },
    methods:{
    async signup(){
        if(this.$refs.form.validate()){
            const Account = {
                Email: this.Email,
                Password: this.Password
            };
            
      const saveAccount= await AccountService.AddAccount(Account);
        console.log(saveAccount);
        // this.resetForm();
        this.$router.dispatch("updateSnackbar", {
            snackbar: true,
            text: "Account Saved Successfully",
            timeout: 3000
        });
        this.$router.dispatch("signup")
        }
        else {
            console.log("Form is not valid");
        }
        
      },
      resetForm(){
       this.Email = null;
        this.Password=null;
      },
     

    },
     async created(){
       if(this.AccountId){
          const response = await AccountService.getById(this.AccountId);
          const Account = response.data;
         this.Email = Account.Email;
          this.Password = Account.Password;
       }

    }

   
};
</script>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "signup",
  components: {
    HelloWorld
  }
};
</script>

<style>

</style>

