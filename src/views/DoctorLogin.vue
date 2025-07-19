<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>熙康体检APP医生端</span>
    </div>
    
    <el-form label-width="80px">
      <el-form-item label="医生账号">
        <el-input v-model="doctor.docCode"></el-input>
      </el-form-item>
      <el-form-item label="登录密码">
        <el-input v-model="doctor.password"></el-input>
      </el-form-item>
      
      <el-form-item>
        <el-button type="primary" @click="onSubmit">登录</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
import axios from 'axios'
import { reactive, toRefs } from "vue";
import { setSessionStorage,getSessionStorage} from "@/common";
import { useRoute,useRouter } from 'vue-router';
export default {
  setup() {

    const router=useRouter();

    const state = reactive({
      doctor: {
        docCode: "zzj",
        password:"123456"
      },
    });

    function onSubmit(){
         axios
        .post("/api/doctorLogin",state.doctor)  //  localhost:8080/login/userId=?&password=?
        .then((response) => {
            //首先取后端返回数据
            let result=response.data;
            if(result.status==200){
                //登录成功
                //跳转到首页面
                //获取用户信息，把用户信息存入SessionStorage，会话域，方便各个组件共享数据
                // result.data  这个是用户信息
               // sessionStorage.setItem("jinandaxuedoctor",JSON.stringify(result.data));// result.data json对象 存的必须是字符串怎么？
              setSessionStorage("jinandaxuedoctor",result.data);
              alert(result.desc);
               // const user= JSON.parse(sessionStorage.getItem("jinandaxueuser"));
               // alert(result.desc);
                router.push('/ordersList');
            }else{
                alert(result.desc);
                state.doctor.docCode="";
                state.doctor.password="";
            }
        })
        .catch(function (error) {
          // 请求失败处理
          console.log(error);
        });

    }

    return {
        ...toRefs(state),
        onSubmit
    }
  },
};
</script>

<style scoped>
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.box-card {
  width: 480px;
}

.box-card {
  margin: 0 auto;
  margin-top: 150px;
}

.clearfix{
    margin-bottom: 50px;
}
</style>