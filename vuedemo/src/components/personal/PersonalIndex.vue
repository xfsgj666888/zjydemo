<template>
  <el-container>
    <el-aside style="width: 150px; margin-top: 20px">
      <switch></switch>
      <personal-menu></personal-menu>
    </el-aside>
    <el-main style="display:flex; justify-content:center;">
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
import PersonalMenu from "./PersonalMenu";
export default {
  name: "appPersonal",
  components: {
    PersonalMenu,
  },
};
</script>