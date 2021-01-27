<template>
  <el-menu
    :default-active="'/perUpdate'"
    class="per"
    router
    model="horizontal"
    active-text-color="red"
  >
    <el-menu-item v-for="(item, i) in perList" :key="i" :index="item.name">
      {{ item.navItem }}
    </el-menu-item>
  </el-menu>
</template>
<script>
export default {
  name: "PersonalMenu",
  data() {
    return {
      perList: [
        { name: "/personal/perUpdate", navItem: "上传商品" },
        { name: "/personal/perMore", navItem: "更多" },
      ],
    };
  },
};
</script>
<style>
.per {
  position: fixed;
  margin-left: 0;
  left: 0px;
  top: 61px;
  width: 150px;
  bottom: 0;
}
</style>