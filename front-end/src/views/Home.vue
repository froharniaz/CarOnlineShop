
<template>
  <div class="home">
    <Navbar/>
     <div>
      <Navbar/>
    <h1>Car Companies</h1>
    <v-container fluid>
    <v-row justify="space-around">
      <v-col cols="4">
      <v-img
           src="..\assets\images (6).jpeg"
          aspect-ratio="1"
        ></v-img>
        <div class="title mb-1">
       BENZ Company
         <br>
       Mercedes-Benz (German: [mɛɐ̯ˈtseːdəsˌbɛnts, -dɛs-]), commonly referred to as Mercedes, is both a German automotive marque and, from late 2019 onwards, a subsidiary – as Mercedes-Benz AG – of Daimler AG.  Mercedes-Benz is known for producing luxury vehicles and commercial vehicles. The headquarters is in Stuttgart, Baden-Württemberg. The name first appeared in 1926 as Daimler-Benz. In 2018, Mercedes-Benz was the largest seller of premium vehicles in the world, having sold 2.31 million passenger cars. 
The company's origins come from Daimler-Motoren-Gesellschaft's 1901 Mercedes and Karl Benz's 1886 Benz Patent-Motorwagen.

         <br>
         <v-btn to="/ShopBenz">More</v-btn>
        </div>
        
      </v-col>
        <v-col cols="4">
      <v-img
           src="..\assets\images (16).jpeg"
          aspect-ratio="1"
        ></v-img>
        <div class="title mb-1">
        TOYOTA Company
         <br>
          The Toyota Motor Corporation (Japanese: , Hepburn: Toyota Jidōsha KK, IPA: [toꜜjota], English: /tɔɪˈoʊtə/, commonly known as Toyota) is a Japanese multinational automotive manufacturer headquartered in Toyota, Aichi, Japan. It was founded by Kiichiro Toyoda and incorporated on August 28, 1937. In 2017, Toyota's corporate structure consisted of 364,445 employees worldwide and, as of December 2019, was the tenth-largest company in the world by revenue. Toyota is the largest automobile manufacturer in the world followed by Volkswagen, based on 2020 unit sales.[5][6]. 
         <br>
         <v-btn to="/ShopToyota">More</v-btn>
        </div>
       
      </v-col>
        <v-col cols="4">
      <v-img
           src="..\assets\images (25).jpeg"
          aspect-ratio="1"
        ></v-img>
        <div class="title mb-1">
         JEEP Company
         <br>
         Jeep is a brand of American automobile and a division of Stellantis. Jeep has been part of Chrysler since 1987, when Chrysler acquired the Jeep brand, along with remaining assets, from its previous owner American Motors Corporation (AMC).  Some of Jeep's vehicles—such as the Grand Cherokee—reach into the luxury SUV segment, a market segment the 1963 Wagoneer is considered to have started. Jeep sold 1.4 million SUVs globally in 2016, up from 500,000 in 2008, two-thirds of which in North America, and was Fiat-Chrysler's best selling brand in the U.S. during the first half of 2017. In the U.S.. 
         <br>
         <v-btn to="/ShopJeep">More</v-btn>
        </div>
        
      </v-col>
      

     
    </v-row>
  </v-container>





        


  </div>
    
    <HelloWorld msg="Welcome to Your Vue.js App" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "Home",
  components: {
    HelloWorld
  }
};
</script>
<style>
    #app {
      margin: auto;
    }
</style>
