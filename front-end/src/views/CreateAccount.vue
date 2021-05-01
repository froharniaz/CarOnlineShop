<template>
  <div class="signup">
    
   <Navbar/>
   <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      <v-text-field v-model="Username" label="Username" :rules="[required]" hide-details="auto"></v-text-field>
    </v-col>
    </v-row>
    <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      <v-text-field v-model="Email" label="Email" :rules="[required]" hide-details="auto"></v-text-field>
    </v-col>
    </v-row>
      <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      <v-text-field :rules="[required]" type="password" v-model="Password" label="Password"  hide-details="auto"></v-text-field>
    </v-col>
    </v-row>
    
    <v-row>
      <v-col cols="12" sm="6"  class="mx-auto">
      
       <v-btn color="info" @click="resetForm" >Login</v-btn><br>
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
      Username: null,
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
              Username:this.Username,
                Email: this.Email,
                Password: this.Password
            };
            
      const saveAccount= await AccountService.AddAccount(Account);
        console.log(saveAccount);
        this.resetForm();
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
        this.Username= null;
       this.Email = null;
        this.Password=null;
      },
    //  async updateAccount(){
    //     const Account ={
    //       _id : this.AccountId,
    //       Username:this.Username,
    //       Email:this.Email,
    //      Password : this.Password,
    //     };
    //  const response = await  AccountService.updateAccount(Account);
    //  const updingAccount = response.data;
    //  this.$router.dispatch("updateSnackbar",{
    //   snackbar: true,
    //     text: "Account Saved Successfully",
    //     timeout: 3000
    //  });
    //  setTimeout(() =>{
    //      this.$router.push("Account/all");
    //  }, 2000);
    //  console.log(updingAccount);
       
    //   } 

    },
     async created(){
       if(this.AccountId){
          const response = await AccountService.getById(this.AccountId);
          const CreatAccount = response.data;
          this.Username=CreatAccount.Username;
         this.Email = CreatAccount.Email;
          this.Password = CreatAccount.Password;
       }

    }

   
};
</script>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "CreatAccount",
  components: {
    HelloWorld
  }
};
</script>

<style>

</style>

