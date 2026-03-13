
<template>
  <div>
    <el-card>
      <el-input style="width: 240px;margin-right: 10px;" v-model="data.name" placeholder="请输入名称"></el-input>
      <el-button type="primary" @click="load">查询</el-button>
      <el-button type="warning" @click="reset">重置</el-button>
    </el-card>
    <el-card>
      <el-button type="primary" @click="handleAdd">新增</el-button>
      <el-button type="warning" @click="handleDeleteBatch">批量删除</el-button>
      <el-button type="info">导入</el-button>
      <el-button type="success">导出</el-button>
    </el-card>

    <el-table :data="data.books" stripe @selection-change="handleSelectionChange">
      <!--      <el-table-column label="ID" prop="id"></el-table-column>-->
      <!--      <el-table-column label="日期" prop="date"></el-table-column>-->
      <!--      <el-table-column label="名称" prop="name"></el-table-column>-->
      <!--      <el-table-column label="地址" prop="address"></el-table-column>-->
      <el-table-column type="selection" width="55px"></el-table-column>
      <el-table-column label="ID" prop="id"></el-table-column>
      <el-table-column label="名称" prop="name"></el-table-column>
      <el-table-column label="价格" prop="price"></el-table-column>
      <el-table-column label="类别" prop="category"></el-table-column>
      <el-table-column label="ISBN" prop="isbn"></el-table-column>
      <el-table-column label="出版时间" prop="time"></el-table-column>
      <el-table-column label="出版社" prop="press"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope" style="width: 120px">
          <el-button type="primary" :icon="Edit" circle @click="handleUpate(scope.row)"/>
          <el-button type="danger" :icon="Delete" circle @click="handleDelete(scope.row)"/>

        </template>
      </el-table-column>
    </el-table>

    <div>

      <el-pagination
          @size-change = "load"
          @current-change = "load"
          v-model:current-page="data.pageNum"
          v-model:page-size="data.pageSize"
          :page-sizes="[5,10,15,20]"
          background
          layout="total, sizes, prev, pager, next, jumper"
          :total="data.total" />
    </div>
    <el-dialog v-model="data.dialogFormVisible" title="图书信息" width="500">
      <el-form :model="data.form">
        <el-form-item label="图书名称" label-width="80px">
          <el-input v-model="data.form.name" autocomplete="off" />
        </el-form-item>

        <el-form-item label="图书价格" label-width="80px">
          <el-input v-model="data.form.price" autocomplete="off" />
        </el-form-item>

        <el-form-item label="图书类别" label-width="80px">
          <el-select v-model="data.form.category" placeholder="请选择图书类别">
            <el-option label="计算机类" value="计算机类" />
            <el-option label="文学类" value="文学类" />
            <el-option label="科技类" value="科技类" />
          </el-select>
        </el-form-item>

        <el-form-item label="出版时间" label-width="80px">
          <el-date-picker v-model="data.form.time"
                          type="date"
                          placeholder="请选择一个日期"
                          style="width: 100%"
          >
          </el-date-picker>
        </el-form-item>

        <el-form-item label="ISAN" label-width="80px">
          <el-input v-model="data.form.isbn" autocomplete="off" />
        </el-form-item>

        <el-form-item label="图书作者" label-width="80px">
          <el-input v-model="data.form.author" autocomplete="off" />
        </el-form-item>

        <el-form-item label="出版社" label-width="80px">
          <el-input v-model="data.form.press" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="save()">保存</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<style scoped>

</style>

<script setup lang="ts">
import {reactive} from "vue";
import request from "@/utils/request";
// import { nextTick } from 'vue';
import {ElMessage, ElMessageBox} from "element-plus";
import {
  Delete,
  Edit,
} from '@element-plus/icons-vue'


const data =reactive({
  name:null,
  // tableData: [
  //   {id: 1, date:'2025-01-01', name: 'Java', address: '新疆'},
  //   {id: 2, date:'2025-01-01', name: 'Java', address: '新疆'},
  //   {id: 3, date:'2025-01-01', name: 'Java', address: '新疆'},
  //   {id: 4, date:'2025-01-01', name: 'Java', address: '新疆'},
  // ],
  pets: [],
  pageNum: 1,
  pageSize: 5,
  total: 0,
  dialogFormVisible: false,
  form: {},
  ids: []
})

//加载板块
const load = () =>{
  request.get('/book/books',{
    params:{
      name: data.name,
      pageNum: data.pageNum,
      pageSize: data.pageSize
    }
  }).then(res => {
    console.log(res);
    data.pets = res.data.records;
    data.total = res.data.total;
    console.log(data.pets);

  })}

load()

//重置板块
const reset = () => {
  data.name = null;
  load();
}

//选择确定板块
const handleAdd = () =>{
  data.dialogFormVisible=true;
  data.form={}//清空数据
}


const save = () =>{
  data.form.id ? update() :add()
}

//添加板块
const add = () => {
  request.post('/book/books',data.form).then(res => {
    if(res.code === '200'){
      console.log(res);
      data.dialogFormVisible = false;
      ElMessage.success('操作成功');
      load();
    }else{
      ElMessage.error(res.msg);
    }

  })
}

//修改板块
const update = () => {
  request.put('/book/books',data.form).then(res => {
    if(res.code === '200'){
      console.log(res);
      data.dialogFormVisible = false;
      ElMessage.success('操作成功');
      load();
    }else{
      ElMessage.error(res.msg);
    }
  })
}

//修改确定
const handleUpate = (row) => {
  data.form = JSON.parse(JSON.stringify(row))//深拷贝一个新的对象用于编辑，不影响对象
  data.dialogFormVisible = true;
}


//删除板块
const handleDelete = (row) => {
  ElMessageBox.confirm('删除数据后无法恢复，确认删除吗？','删除确认',{type: 'warning'}).then(()=>{
    request.delete('/book/books/'+row.id,data.form).then(res => {
      if(res.code === '200'){
        console.log(res);
        data.dialogFormVisible = false;
        ElMessage.success('操作成功');
        load();
      }else{
        ElMessage.error(res.msg);
      }
    })
  }).catch();

}

//处理选择变化---记录选择
const handleSelectionChange = (rows) => {
  data.ids = rows.map( row => row.id)
  console.log(data.ids)

}

//批量删除
const handleDeleteBatch = () => {
  if(data.ids.length === 0){
    ElMessage.warning('请选择数据！')
    return
  }
  ElMessageBox.confirm('删除数据后无法恢复，确认删除吗？','删除确认',{type: 'warning'}).then(()=>{

    request.delete('/book/books',{data: data.ids}).then(res => {
      if(res.code === '200'){
        console.log(res);
        data.dialogFormVisible = false;
        ElMessage.success('操作成功');
        load();
      }else{
        ElMessage.error(res.msg);
      }
    })
  }).catch();
}
</script>
