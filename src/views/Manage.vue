<script setup lang="ts">
import {reactive, ref} from "vue"
import router from "@/router/index"
import {Search} from '@element-plus/icons-vue'
import { useRoute } from "vue-router";
import request from "@/utils/request"





const isCollapse = ref(false)
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

//动态路由进行参数传递
// import { useRoute } from 'vue-router'
// const route = useRoute()
// console.log(route.params.id);

//query查询传递参数
const route = useRoute();
console.log(route.query.id)
const username = route.query.id


</script>

<template>
  <!--头部开始-->
  <div style="height: 60px; background-color: cornflowerblue; display: flex; position: sticky; align-items: center; top: 0; z-index: 999;" >

    <div>
      <el-radio-group v-model="isCollapse" style=" width: 200px">
        <el-radio-button :value="true" >关</el-radio-button>
        <el-radio-button :value="false" >开</el-radio-button>
      </el-radio-group>
    </div>

    <div style="flex: 1; width: 400px; align-items: center">
    <div style="font-size: 15px;color: white">
      流浪之驿-——-万物生宠物综合救助与援助计划
    </div>
    </div>



    <div style="width: 150px; display: flex;align-items: center; padding-right: 10px">

      <el-dropdown placement="bottom">
        <el-button style="width:50px; height: 50px; border: 3px solid black; border-radius: 100%">

          <a href="/manage/User0Information">
          <img src="@/assets/touxiang.png" alt="头像" style="width: 40px; height: 40px;">
            </a>
        </el-button>

        <template #dropdown>
          <el-dropdown-menu style="width: 200px; height: 400px">
            <el-dropdown-item  style="color: black; margin-left: 5px; margin-top: 0;">昵称:{{username}}</el-dropdown-item>
            <el-dropdown-item>The Action 2st</el-dropdown-item>
            <el-dropdown-item>The Action 3st</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>


      <span></span>
    </div>
  </div>
  <!--  头部结束-->
  <!--  主体开始-->

  <div style="display: flex; ">
    <!--  主体左侧导航区域开始-->
    <div style="width: auto;height: 500px; border-right: 5px solid black; min-height: calc(100vh - 60px); position: sticky; top: 60px" >
      <el-menu
          :default-active="router.currentRoute.value.path"

          background-color="white"
          text-color="black"
          style="border: 0;"
          class="el-menu-vertical-demo"
          router
          :collapse="isCollapse"
          @open="handleOpen"
          @close="handleClose"

      >
        <el-menu-item index="/manage/home">
          <el-icon><House /></el-icon>
          <template #title>首页</template>
        </el-menu-item>

        <el-sub-menu index="1">
          <template #title>
            <el-icon><UserFilled /></el-icon>
            <span>主要任务</span>
          </template>

          <el-menu-item index="/manage/PrimaryTask-lifeeducation">生命教育</el-menu-item>
          <el-menu-item index="/manage/PrimaryTask-resttaker">流浪驿站</el-menu-item>
        </el-sub-menu>


        <hr>


        <el-sub-menu index="2">
          <template #title>
            <el-icon><Memo /></el-icon>
            <span>宠物领养</span>
          </template>

          <el-menu-item index="Adopt-adoptrules">领养流程</el-menu-item>
          <el-menu-item index="Adopt-adopt">待领养</el-menu-item>
          <el-menu-item index="Adopt-oberserve">投喂</el-menu-item>
        </el-sub-menu>

        <hr>

        <el-sub-menu index="3">
          <template #title>
            <el-icon><StarFilled /></el-icon>
            <span>万物生志愿</span>
          </template>

          <el-menu-item index="Volunteer-volunteerobject">志愿者类型</el-menu-item>
          <el-menu-item index="Volunteer-volunteerapply">志愿者申请</el-menu-item>
          <el-menu-item index="Volunteer-volunteersave">志愿者求助</el-menu-item>
        </el-sub-menu>

        <hr>

        <el-sub-menu >
          <template #title>
            <el-icon><Lock /></el-icon>
            <span>个人信息</span>
          </template>

          <el-menu-item index="/manage/User0Information">个人信息</el-menu-item>

        </el-sub-menu>




        <hr>


        <el-sub-menu index="4">
          <template #title>
            <el-icon><BellFilled /></el-icon>
            <span>关于我们</span>
          </template>

          <el-menu-item index="">关于我们</el-menu-item>
        </el-sub-menu>
      </el-menu>




    </div>
    <!--    主体左侧导航区域结束-->



    <div
         style="flex: 1; height: auto; box-shadow: var(--el-border-color-light) 0px 0px 10px; position: relative"
    >
      <el-splitter>
        <el-splitter-panel size="70%" style="border-right: 5px solid black">
          <!--    主体右侧数据区域开始-->
          <!--       搜索框与搜索按钮-->
          <div style="margin-left: 100px">
            <el-input

                style="width: 600px; padding-left: 20px; padding-right: 20px "
                size="large"
                placeholder="Please Input"

            />

            <el-button
                type="danger"
                :icon="Search"
                round>搜索</el-button>

          </div>







           <RouterView>
            </RouterView>

          <!--  主体右侧数据区域结束-->
        </el-splitter-panel>
        <el-splitter-panel :min="200" style="border-left: 5px solid black">
          <div>
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
          </div>
        </el-splitter-panel>
      </el-splitter>
    </div>

    <!--    主体右侧数据区域开始-->
<!--    <div style="flex: 0.8; width: 0; background-color: aliceblue; padding: 10px ">-->
<!--      <RouterView> </RouterView>-->
<!--    </div>-->
    <!--  主体右侧数据区域结束-->
    <!--  </div>-->

    <!--    主题最右侧瀑布流设计-->
<!--    <div style="flex: 0.2; width: 0;  border-radius: 5px">-->
<!--      <RouterView>-->
<!--      <RouterView></RouterView>-->
<!--      </RouterView>-->
<!--    </div>-->
    <!--  主体结束-->



  </div>

  <!--  <div>-->
  <!--    父级页面，可以嵌套其他的子路由页面-->
  <!--  </div>-->
  <!--  <div style="width:50%; background-color: azure; padding: 30px; border: 2px solid #ccc; margin: 30px auto">-->
  <!--    <RouterView> </RouterView>-->
  <!--  </div>-->
</template>

<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
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