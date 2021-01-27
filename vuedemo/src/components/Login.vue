<template>
  <body id="poster">
    <el-form class="login-container" label-position="left" label-width="0px">
      <h3 class="login_title">登录</h3>
      <el-form-item>
        <el-input
          type="text"
          v-model="loginForm.username"
          auto-complete="off"
          placeholder="账号"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
          type="password"
          v-model="loginForm.password"
          auto-complete="off"
          placeholder="密码"
        ></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button class="login_button" type="primary" v-on:click="login"
          >登录</el-button
        >
      </el-form-item>
      <el-form-item style="width: 100%">
        <router-link to="register">
          <el-button class="login_zhu" type="text">注册新账号</el-button>
        </router-link>
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        username: "",
        password: "",
      },
      responseResult: [],
    };
  },
  methods: {
    login() {
      var _this = this;
      console.log(this.$store.state);
      this.$axios
        .post("/login", {
          username: this.loginForm.username,
          password: this.loginForm.password,
        })
        .then((successResponse) => {
          if (successResponse.data.code === 200) {
            _this.$store.commit("login", _this.loginForm);
            var path = this.$route.query.redirect;
            this.$router.replace({
              path: path === "/" || path === undefined ? "/index" : path,
            });
          }
        })
        .catch((failResponse) => {});
    },
  },
};
</script>