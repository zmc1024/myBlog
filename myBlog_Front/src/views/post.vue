<template>
  <div>
    <!-- 头部 -->
    <v-header></v-header>
    
    <!-- 内容 -->
    <article-mark :articleMap = "articleMap"></article-mark>
  </div>
</template>

<script>
import header from '@/components/header'
import article_mark from '@/components/article_mark'
export default {
  data() {
    return {
      articleMap: {}
    }
  },
  components: {
    'v-header': header,
    'article-mark': article_mark
  },
  mounted() {
    let that = this;
    let id = parseInt(that.$route.query.articleid)    // 获取文章id
    let Query = {
      "id": id
    }
    that.$http.post('queryById', Query)
      .then(function (res) {
        // 查询成功
        if(res.status == 200) {
          // console.log(res);
          that.articleMap = res.data[0];
          // console.log(that.articleMap);
        }
      })
      .catch(function (error) {
        console.log(error);
      });
  }
}
</script>

<style>

</style>