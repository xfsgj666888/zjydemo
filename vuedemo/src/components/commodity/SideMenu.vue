<template>
  <el-menu
    class="categories"
    default-active="0"
    @select="handleSelect"
    active-text-color="red">
    <el-menu-item index="0">
      <i class="el-icon-menu"></i>
      <span slot="title">全部</span>
    </el-menu-item>
    <el-menu-item index="1">
      <i class="el-icon-menu"></i>
      <span slot="title">数码</span>
    </el-menu-item>
    <el-menu-item index="2">
      <i class="el-icon-menu"></i>
      <span slot="title">图书</span>
    </el-menu-item>
    <el-menu-item index="3">
      <i class="el-icon-menu"></i>
      <span slot="title">服装</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-menu"></i>
      <span slot="title">电器</span>
    </el-menu-item>
    <el-menu-item index="5">
      <i class="el-icon-menu"></i>
      <span slot="title">其他</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
  export default {
    name: 'SideMenu',
    data () {
      return {
        cid: ''
      }
    },
    methods: {
      handleSelect (key, keyPath) {
        this.cid = key
        this.$emit('indexSelect')
      }
    }
  }
</script>

<style>
  .categories {
    position: fixed;
    margin-left: 0px;
    left: 0px;
    top: 61px;
    width: 150px;
    bottom: 0;
  }
</style>

                