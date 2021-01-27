<template>
  <el-menu
    :default-active="'/index'"
    router
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="red"
    style="width: 100%; min-width: 500px; top: 0px; position: fixed; left: 0; top: 0; z-index: 10;"
  >
    <el-menu-item v-for="(item, i) in navList" :key="i" :index="item.name">
      {{ item.navItem }}
    </el-menu-item>
    <i
      class="el-icon-switch-button"
      v-on:click="logout"
    ></i>
  </el-menu>
</template>

<script>
export default {
  name: "NavMenu",
  data() {
    return {
      navList: [
        { name: "/index", navItem: "首页" },
        { name: "/shopcar", navItem: "购物车" },
        { name: "/personal", navItem: "个人中心" },
      ],
    };
  },
  methods: {
    logout() {
      var _this = this;
      this.$axios.get("/logout").then((resp) => {
        if (resp.data.code === 200) {
          _this.$store.commit("logout");
          _this.$router.replace("/login");
        }
      });
    },
  },
};
</script>

<style>
.el-icon-switch-button {
  cursor: pointer;
  outline: 0;
  float: right; 
  font-size: 40px; 
  color: #222; 
  padding: 10px;
}
</style>

