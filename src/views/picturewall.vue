<script setup>
import { computed, ref } from 'vue'


</script>

<template>




  <div class="a">
  <el-timeline style="max-width: 600px; margin-top: 0px;">
    <el-timeline-item timestamp="2018/4/12" placement="top">
      <el-card>
        <h4>Update Github template</h4>
        <p>Tom committed 2018/4/12 20:46</p>
        <div class="b" style="border: 3px solid bisque"><img src="@/assets/海贼王0.jpg" alt="9"></div>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="2018/4/3" placement="top">
      <el-card>
        <h4>Update Github template</h4>
        <p>Tom committed 2018/4/3 20:46</p>
        <div class="b" style="border: 3px solid bisque"><img src="@/assets/海贼王1.jpg" alt="8"></div>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="2018/4/2" placement="top">
      <el-card>
        <h4>Update Github template</h4>
        <p>Tom committed 2018/4/2 20:46</p>
        <div class="b" style="border: 3px solid bisque"><img src="@/assets/海贼王2.jpg" alt="7"></div>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="2018/4/2" placement="top">
      <el-card>
        <h4>Update Github template</h4>
        <p>Tom committed 2018/4/2 20:46</p>
        <div class="b" style="border: 3px solid bisque"><img src="@/assets/海贼王3.jpg" alt="6"></div>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="2018/4/2" placement="top">
      <el-card>
        <h4>Update Github template</h4>
        <p>Tom committed 2018/4/2 20:46</p>
        <div class="b" style="border: 3px solid bisque"><img src="@/assets/海贼王4.jpg" alt="5"></div>
      </el-card>
    </el-timeline-item>
    <el-timeline-item timestamp="2018/4/2" placement="top">
      <el-card>
        <h4>Update Github template</h4>
        <p>Tom committed 2018/4/2 20:46</p>
        <div class="b" style="border: 3px solid bisque"><img src="@/assets/海贼王5.jpg" alt="4"></div>
      </el-card>
    </el-timeline-item>
  </el-timeline>
  </div>

</template>

<style scoped>




*{

}
body{
  display: flex;
  justify-content: center;
  margin-top: 0;
}
.a{
  margin-top: 0px;
  width: auto;
  height: auto;
  position: relative;
  top: 200px;
  overflow: hidden;
  display: flex;
  justify-content: center;
  flex-direction: column;
}
.b{
  transition: .7s;
  overflow: hidden;
}
.b:hover{
  flex-shrink: 0;
}
img{
  width: 100%;
  border-radius: 20px;
}
</style>