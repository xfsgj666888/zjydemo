<template>
  <div style="width: 1500px">
    <div>
      <el-row>
        <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
      </el-row>
    </div>
    <div>
      <ul v-for="(item, index) in commodities" :key="item.id" class="content">
        <li class="box">
          <div class="header">
            <img :src="item.picture" alt="封面" />
            <div class="top">
              <h1>{{ item.name }}</h1>
              <p>{{ item.note }}</p>
            </div>
          </div>
          <div class="footer">
            <p style="float: left">¥{{ item.price }}</p>
            <el-button
              style="float: right; width: 108px"
              @click="upToshopcar(index)"
              >加入购物车</el-button
            >
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import SearchBar from "./SearchBar";
import dayjs from "dayjs";
export default {
  name: "Commodities",
  components: {
    SearchBar,
  },
  data() {
    return {
      commodities: [],
    };
  },
  mounted: function () {
    this.loadCommodities();
  },
  methods: {
    loadCommodities() {
      var _this = this;
      this.$axios.get("/commodities").then((resp) => {
        if (resp && resp.data.code === 200) {
          _this.commodities = resp.data.result;
        }
      });
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    searchResult() {
      var _this = this;
      this.$axios
        .get("/search?keywords=" + this.$refs.searchBar.keywords, {})
        .then((resp) => {
          if (resp && resp.data.code === 200) {
            _this.commodities = resp.data.result;
          }
        });
    },
    upToshopcar(index) {
      var date1 = dayjs(new Date().getTime() - 24 * 60 * 60 * 1000).format(
        "YYYY-MM-DD HH:mm:ss"
      );
      this.$confirm('是否加入购物车','提示',{
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios
        .post("/shopcar/add", {
          picture: this.commodities[index].picture,
          name: this.commodities[index].name,
          price: this.commodities[index].price,
          seller: this.commodities[index].seller,
          note: this.commodities[index].note,
          date: date1,
        })
        .then((resp) => {
          if (resp && resp.data.code === 200) {
            this.$emit("upToshopcar", index);
          }
        });
      })
    },
  },
};
</script>

<style>
ul {
  list-style: none;
}
/* 
.picture {
  width: 100%;
  height: 100%;
  margin-bottom: 6px;
  overflow: hidden;
  cursor: pointer;
}

img {
  width: 290px;
  height: 220px;
}

.name {
  font-size: 20px;
  text-align: left;
}

.seller {
  color: #333;
  width: 102px;
  font-size: 13px;
  margin-bottom: 6px;
  text-align: left;
}

.switch {
  display: flex;
  position: absolute;
  left: 780px;
  top: 25px;
} */

.content {
  width: 1500px;
  overflow: hidden;
}

.box {
  width: 320px;
  background-color: white;
  border-top: 3%;
  border-bottom-left-radius: 3%;
  border-bottom-right-radius: 1.5%;
  box-shadow: 0px 1px 0px #e3e3e3;
  text-align: center;
  margin-bottom: 50px;
  margin-right: 30px;
  float: left;
}

.header {
  position: relative;
  color: white;
}

.header img {
  width: 100%;
  vertical-align: top;
  border-top-right-radius: 3%;
  border-top-left-radius: 3%;
}

.top {
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
  position: absolute;
  left: 0;
  top: 0;
  transition: all 0.2s linear;
  opacity: 0;
}
.box:hover .top {
  opacity: 1;
}
.top h1 {
  padding-top: 20%;
}
.top p {
  font-size: 1rem;
}

.footer {
  color: #696969;
  font-size: 18px;
}

.footer p {
  padding-left: 18px;
  margin: 0px;
  padding-top: 11px;
}
</style>

