<template>
  <el-container>
    <el-header>
      <h1>暨南大学&nbsp;&nbsp;熙康体检报告管理系统</h1>
      <p>医生：{{ doctor.realName }}</p>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <h4>体检用户查询</h4>
        <el-form label-width="auto">
          <el-form-item label="手机号码">
            <el-input v-model="users.userId" placeholder="手机号码"></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="users.realName" placeholder="姓名"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio-group v-model="users.sex">
              <el-radio label="1" model-value="1">男</el-radio>
              <el-radio label="0" model-value="0">女</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="套餐类型">
            <el-select v-model="users.smId" placeholder="套餐类型">
              <el-option
                v-for="setmeal in setmealArr"
                :key="setmeal.smId"
                :label="setmeal.name"
                :value="setmeal.smId"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="体检日期">
            <el-date-picker
              v-model="users.orderDate"
              type="date"
              placeholder="体检日期"
              style="width: 100%"
              format="YYYY/MM/DD"
              value-format="YYYY-MM-DD"
            ></el-date-picker>
          </el-form-item>
          <el-form-item label="是否归档">
            <el-radio-group v-model="users.state">
              <el-radio border label="1" model-value="1">未归档</el-radio>
              <el-radio border label="2" model-value="2">已归档</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="doSelect">查询</el-button>
            <el-button type="warning" @click="reset">重置</el-button>
          </el-form-item>
        </el-form>
      </el-aside>
      <el-main>
        <el-table :data="ordersList" border style="width: 100%">
          <el-table-column fixed prop="orderId" label="预约编号" >
          </el-table-column>
          <el-table-column prop="userId" label="手机号码" width="120">
          </el-table-column>
          <el-table-column prop="realName" label="真实姓名" width="120">
          </el-table-column>
          <el-table-column prop="sex" label="性别" width="100">

            <template #default="scope">
              {{ scope.row.sex==1?"男":"女" }}
              
            </template>


          </el-table-column>
          <el-table-column prop="sname" label="体检套餐类型" width="150">

          </el-table-column>
          <el-table-column prop="hname" label="体检医院" width="220">
          </el-table-column>
          <el-table-column prop="orderDate" label="体检日期" width="120">
          </el-table-column>
          <el-table-column fixed="right" label="操作" width="150">
            <template #default="scope">
              <el-button
                @click="handleClick(scope.row)"
                type="text"
                size="small"
                >查看体检报告</el-button
              >
              
            </template>
            
          </el-table-column>
        </el-table>
        <el-pagination
  background
  layout="prev, pager, next,total"
  :total="page.total" :page-size="2">
</el-pagination>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import { getSessionStorage } from "@/common";
import { reactive, toRefs } from "vue";
import axios from "axios";
export default {
  setup() {
    const state = reactive({
      doctor: getSessionStorage("jinandaxuedoctor"),
      users: {
        userId: "",
        realName: "",
        sex: '0',
        smId: "",
        orderDate: "",
        state: "1",
        pageSize:2,
        pageNumber:1

      },
      setmealArr: [
        { smId: 4, name: "女士-基础套餐" },
        { smId: 5, name: "女士-肾病检查" },
        { smId: 6, name: "女士-肝病检查" },
      ],
      ordersList:[],
      page:{
        pageNumber:1,
        pageSize:2,
        total:20
      }
    });

    //初始化订单列表数据
    function loadOrdersList(){
        axios
        .post("/api/ordersList",{state:1,sex:0,pageNumber:1,pageSize:2})  //  localhost:8080/login/userId=?&password=?
        .then((response) => {
          // console.log(response.data.data.total) //pageInfo
          state.ordersList=response.data.data.list;
          state.page.pageNumber=response.data.data.pageNum;
          state.page.pageSize=response.data.data.pageSize;
          state.page.total=response.data.data.total;
        })
        .catch(function (error) {
          // 请求失败处理
          console.log(error);
        });

    }

    loadOrdersList();

    return {
      ...toRefs(state),
      loadOrdersList
    };
  },
};
</script>

<style scoped>
.el-header {
  background-color: #b3c0d1;
  color: var(--el-text-color-primary);
  text-align: center;
  line-height: 60px;

  display: flex;
  align-items: center;
  justify-content: space-between;
  color: #1c51a3;
}

.el-header h1 {
  font-size: 22px;
  font-weight: 700;
}
.el-header p {
  font-size: 16px;
}

.el-aside {
  width: 250px;
  height: 700px;
  background-color: #d3dce6;
  box-sizing: border-box;
  padding: 20px;
}
.el-aside h4 {
  color: #555;
  margin-bottom: 20px;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
</style>