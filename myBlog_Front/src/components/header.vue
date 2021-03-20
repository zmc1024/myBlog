<template>
  <div id="head-content">
    <!-- 头部 -->
    <div id="head">
      <div class="left">
        <img class="logo" src="../images/logo.png" alt="">
        <span class="blog">Blog</span>
        <span>
          <router-link id="r-link" :to="item.to" v-for="item in to_link" :key="item.id">{{item.text}}</router-link>
        </span>
      </div>
      <div class="right">
        <el-input
          class="input"
          size="medium"
          placeholder="搜索"
          suffix-icon="el-icon-search"
          v-model="input">
        </el-input>
        <el-button class="write-button" @click="writeArticle" size="medium" type="primary">写文章</el-button>
        <el-button v-if="!isLogin" class="signIn" @click="dialogFormVisible = true" size="medium" plain>登录</el-button>
        <el-dropdown v-else>
            <img class="avatar" src="../images/avatar.jpg" alt="">
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="1">修改密码</el-dropdown-item>
              <el-dropdown-item command="2">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
      </div>
    </div>

    <!-- 登录 / 注册 -->
    <el-dialog center custom-class="up-dialog" :title="title" :width="formWidth" :visible.sync="dialogFormVisible">
      <el-form ref="loginFormRef" :rules="loginRules" :model="loginForm">
        <el-form-item prop="username" label="用户名:" :label-width="formLabelWidth">
          <el-input type="text" placeholder="请输入用户名" v-model="loginForm.username" ></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码:" :label-width="formLabelWidth">
          <el-input type="password" placeholder="请输入密码" v-model="loginForm.password" show-password></el-input>
        </el-form-item>
      </el-form>
      <button class="signUp-button" @click="onLogin">{{ buttonText }}</button>
      <div v-if="tag" class="signIn">还未有账号？<a class="toA" href="#" @click="toSignIn">点击注册</a></div>
      <div v-else class="signIn">已有账号？<a class="toA" href="#" @click="toSignIn">点击登录</a></div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      to_link: [
        {
          id: 0,
          to: '/',
          text: '首页'
        },
        {
          id: 1,
          to: '/reading',
          text: '阅读'
        },
        {
          id: 2,
          to: '/play',
          text: '活动'
        },
      ],
      input: '',
      dialogFormVisible: false,
      loginForm: {
        username: '',
        password: ''
      },
      formWidth: '25%',
      formLabelWidth: '6rem',

      tag: true,   // 登录状态
      title: '手机号登录',
      buttonText: '登 录',
      isLogin: false,

      loginRules: {   // 表单规则
        username: [
          { required: true, message: "请输入手机号", trigger: "blur" },
          { pattern: /^1[3|5|7|8|9]\d{9}$/, message: '请输入正确的号码格式', trigger: 'blur' }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 3, max: 9, message: "密码为 6~9 位", trigger: "blur" }
        ]
      }
    }
  },

  methods: {
    // 写文章
    writeArticle() {
      if(!this.isLogin) {
        this.$message.success("请先登录 ~ ");
      } else {
        this.$router.push({path: '/article'});
      }
    },

    // 登录
    onLogin () {
      this.$refs.loginFormRef.validate(async valid => {   // 验证属性
        if( !valid ) return
        if(this.tag) {  // 点击登录
          let loginForm = {
            "username": this.loginForm.username,
            "password": this.$md5(this.loginForm.password)
          }
          const res = await this.$http.post("login", loginForm);  // 访问后台
          // console.log(res);
          if(res.data.flag === 200) {
            this.$message.success("登录成功 ~ ");
            console.log(res.data.user);
            localStorage.setItem("user", res.data.user);
            localStorage.setItem("username", res.data.user.username);
            this.isLogin = true
            this.dialogFormVisible = false;
          } else {
            this.$message.error("用户名或密码错误！请重试 ~ ")
          }
        } else {    // 点击注册
          let loginForm = {
            "username": this.loginForm.username,
            "password": this.$md5(this.loginForm.password)
          }
          const res = await this.$http.post("register", loginForm);
          // console.log(res);
          if(res.status === 200) {
            this.$message.success("注册成功，请登录 ~ ");
            setTimeout(() => {
              this.title = '手机号登录';
              this.buttonText = '登 录';
              this.tag = !this.tag
            }, 1000)
          }
        }
      })
    },
   
    // 切换登录 / 注册
    toSignIn() {
      if(this.tag) {  // 注册
        this.title = '手机号注册';
        this.buttonText = '注 册';
        this.tag = !this.tag
      } else {
        this.title = '手机号登录';
        this.buttonText = '登 录';
        this.tag = !this.tag
      }
    },
  },

  mounted() {
    const token = localStorage.getItem("user");
    // console.log(token);
    if(token) {
      this.isLogin = true
    }
  }
}
</script>

<style lang="less">
.divider {
  margin: 0 !important;
}
#head-content {
  width: 100%;
  background-color: #fff;
  border-bottom: 1px solid #F1F1F1;
}
#head {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 68%;
  margin: 0 auto;
  background-color: #fff;
  height: 5rem;
  box-sizing: border-box;
}
.left, .right {
  display: flex;
  align-items: center;
  justify-content: center;
}
.logo {
  width: 40px;
  height: 40px;
}
.avatar {
  width: 30px;
  height: 30px;
  margin-left: 1rem;
}
.blog {
  color: #4f4f4f;
  font-size: 24px;
  margin-left: 10px;
}

#r-link {
  text-decoration: none;
  font-size: 1.4rem;
  padding-left: 30px;
  color: #797E83;
}
#r-link:first-child {
  color: #007FFF;
}
#r-link:hover {
  color: #007FFF;
}
.router-link-exact-active {
  color: #007FFF;
}

.input {
  margin-right: 20px;
}

.up-dialog {
  width: 26.5rem !important;
  top: 8rem;
}
.el-form-item {
  margin-bottom: 14px;
}
.signUp-button {
  position: relative;
  width: 50%;
  height: 38px;
  background: #007FFF;
  color: #fff;
  border: none;
  left: 26%;
}
.signUp-button:focus {
  outline: 0;
}
.signIn {
  text-align: center;
  margin-top: 15px;
  font-size: 14px;
}
.toA {
  padding-left: 0 !important;
}
</style>