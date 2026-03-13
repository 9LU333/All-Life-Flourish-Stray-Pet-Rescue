<script setup lang="ts">
import { ref } from 'vue'




import image1 from '@/assets/海贼王0.jpg'
import image2 from '@/assets/海贼王1.jpg'
import image3 from '@/assets/海贼王2.jpg'
import image4 from '@/assets/海贼王3.jpg'
import image5 from '@/assets/海贼王4.jpg'

const images = ref([
    image1,
    image2,
    image3,
    image4,
    image5
])





</script>
<template>

      <div style="height: auto">
        <img src="@/assets/航海王0.jpg" alt="" style="width:100%">
      </div>

      <hr style="border: 3px solid black">

  <el-carousel :interval="4000" type="card" height="400px" style="background-color: lightgray; margin-top: 50px; margin-bottom: 50px; width: 100%">
    <el-carousel-item v-for="(image,index) in images" :key="images" style="height: 400px; background-color: #181818; ; opacity: 0.8">
      <img :src="image" class="carouse1-image" alt="carousel image" style="height: 400px;" />
    </el-carousel-item>
  </el-carousel>

  <hr style="border: 3px solid red">



</template>

<style scoped>


.el-carousel__item  {
  display: flex;
  justify-content: center;
  align-items: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
