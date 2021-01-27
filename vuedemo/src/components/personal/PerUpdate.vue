<template>
  <div class="per_zb">
    <h1>上传商品</h1>
    <el-form v-model="form" ref="dataForm">
      <el-form-item label="商品名" :label-width="formLabelWidth" prop="name">
        <el-input v-model="form.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="商家名" :label-width="formLabelWidth" prop="seller">
        <el-input v-model="form.seller" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="售价" :label-width="formLabelWidth" prop="price">
        <el-input v-model="form.price" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="分类" :label-width="formLabelWidth" prop="cid">
        <el-select
          v-model="form.category.id"
          placeholder="请选择分类"
          style="width: 100%"
        >
          <el-option label="数码" value="1"></el-option>
          <el-option label="图书" value="2"></el-option>
          <el-option label="服装" value="3"></el-option>
          <el-option label="电器" value="4"></el-option>
          <el-option label="其他" value="5"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="封面" :label-width="formLabelWidth" prop="picture">
        <el-input
          v-model="form.picture"
          autocomplete="off"
          placeholder="图片 URL"
        ></el-input>
        <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
      </el-form-item>
      <el-form-item label="介绍" :label-width="formLabelWidth" prop="note">
        <el-input
          type="textarea"
          v-model="form.note"
          autocomplete="off"
        ></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="clear">取 消</el-button>
      <el-button type="primary" @click="onSubmit">确 定</el-button>
    </div>
  </div>
</template>
<script>
import ImgUpload from "./ImgUpload";
import dayjs from "dayjs";
export default {
  name: "PerUpdate",
  components: { ImgUpload },
  data() {
    return {
      form: {
        id: "",
        name: "",
        seller: "",
        date: "",
        price: "",
        picture: "",
        note: "",
        cid: "",
        category: {
          id: "",
          name: "",
        },
      },
      formLabelWidth: "120px",
    };
  },
  methods: {
    clear() {
      this.$refs.imgUpload.clear();
      this.form = {
        id: "",
        name: "",
        seller: "",
        price: "",
        picture: "",
        note: "",
        category: {
          id: "",
          name: "",
        },
      };
    },
    onSubmit() {
      var date1 = dayjs(new Date().getTime() - 24 * 60 * 60 * 1000).format(
        "YYYY-MM-DD HH:mm:ss"
      );
      this.$axios
        .post("/seller/commodities", {
          id: this.form.id,
          picture: this.form.picture,
          name: this.form.name,
          date: date1,
          seller: this.form.seller,
          price: this.form.price,
          note: this.form.note,
          category: {
            id: this.form.category.id,
            name: this.form.category.name,
          },
        })
        .then((resp) => {
          if (resp && resp.data.code === 200) {
            this.$emit("onSubmit");
          }
        });
    },
    uploadImg() {
      this.form.picture = this.$refs.imgUpload.url;
    },
  },
};
</script>
<style>
.per_zb {
  overflow: hidden;
  width: 700px;
}
</style>