<template>
  <div class="s_all">
    <div class="s_header">
      <div class="interval-one">商品名</div>
      <div class="interval-two">商品信息</div>
      <div class="interval-three">单价</div>
      <div class="interval-four">操作</div>
    </div>
    <div class="s_content">
      <ul v-for="item in shopcarcommodities" :key="item.id" class="s_content_u">
        <li>
          <div class="interval-checkbox">
            <el-checkbox></el-checkbox>
          </div>
          <div class="interval-img">
            <img :src="item.picture" alt="封面" />
          </div>
          <div class="interval-content-one">{{ item.name }}</div>
          <div class="interval-content-two">{{ item.note }}</div>
          <div class="interval-content-three">{{ item.price }}</div>
          <div class="interval-content-four">
            <el-button type="text" @click="deleteShopcar(item.id)"
              >移除购物车</el-button
            >
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
export default {
  name: "ShopcarIndex",
  data() {
    return {
      shopcarcommodities: [],
    };
  },
  mounted: function () {
    this.loadShopcarCommodities();
  },
  methods: {
    loadShopcarCommodities() {
      var _this = this;
      this.$axios.get("/shopcar").then((resp) => {
        if (resp && resp.data.code === 200) {
          _this.shopcarcommodities = resp.data.result;
        }
      });
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    deleteShopcar(id) {
      this.$confirm("确认移除购物车？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$axios
            .post("/shopcar/delete", {
              id: id,
            })
            .then((resp) => {
              this.loadShopcarCommodities();
              if (resp && resp.data.code === 200) {
                this.$emit("deleteShopcar", id);
              }
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消",
          });
        });
    },
  },
};
</script>

<style>
ul {
  list-style: none;
}

.s_content_u {
  width: 1200px;
  overflow: hidden;
}
.s_all {
  width: 1200px;
  margin: 0 auto;
  text-align: center;
}

.s_header {
  width: 1200px;
  overflow: hidden;
  height: 50px;
  margin-left: 312px;
}

.s_content {
  width: 1200px;
  overflow: hidden;
}

.interval-one {
  width: 180px;
  height: 50px;
  line-height: 50px;
  float: left;
}

.interval-two {
  width: 320px;
  height: 50px;
  line-height: 50px;
  float: left;
}
.interval-three {
  width: 150px;
  height: 50px;
  line-height: 50px;
  float: left;
}

.interval-four {
  width: 240px;
  height: 50px;
  line-height: 50px;
  float: left;
}

.interval-checkbox {
  float: left;
  margin: 63px 40px auto;
}

.interval-img {
  float: left;
  width: 168px;
  margin-left: 10px;
}

.interval-img img {
  width: 100%;
}

.interval-content-one {
  float: left;
  font-size: 20px;
  width: 180px;
  margin-top: 60px;
}

.interval-content-two {
  float: left;
  width: 320px;
  text-align: left;
}

.interval-content-three {
  float: left;
  width: 150px;
  margin-top: 60px;
  font-size: 20px;
}

.interval-content-four {
  float: left;
  width: 240px;
  margin-top: 53px;
}
</style>
