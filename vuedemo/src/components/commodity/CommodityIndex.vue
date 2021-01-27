<template>
  <el-container style="height: 100%;">
    <el-aside style="width: 150px;">
      <switch></switch>
      <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <commodities class="commodities-area" ref="commoditiesArea"></commodities>
    </el-main>
  </el-container>
</template>

<script>
  import SideMenu from './SideMenu'
  import Commodities from './Commodities'
  export default {
    name: 'AppShop',
    components: {SideMenu, Commodities},
    methods: {
      listByCategory () {
        var _this = this
        var cid = this.$refs.sideMenu.cid
        var url = 'categories/' + cid + '/commodities'
        this.$axios.get(url).then(resp => {
          if (resp && resp.data.code === 200) {
            _this.$refs.commoditiesArea.commodities = resp.data.result
            _this.$refs.commoditiesArea.currentPage = 1
          }
        })
      }
    }
  }
</script>

<style>
  .commodities-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
