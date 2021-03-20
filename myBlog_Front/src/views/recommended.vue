<template>
  <div class="content">
    <!-- 热门 / 最新 / 榜单 -->
    <nav_Sort></nav_Sort>
    
    <content_item :articleList="articleList"></content_item>
  </div>
</template>

<script>
import nav_Sort from '@/components/nav_Sort'
import content_item from '@/components/content_item'
export default {
  data() {
    return {
      nav_List: [
        {
          sort: 'hot',
          text: '热门'
        },
        {
          sort: 'newest',
          text: '最新'
        },
        {
          sort: 'hottest',
          text: '热榜'
        },
      ],
      articleList: []
    }
  },
  components: {
    'nav_Sort': nav_Sort,
    'content_item': content_item
  },

  // 监听路由路径发生变化
  watch: {
    $route: {
      handler: function(val, oldVal){
        console.log(val);
        let that = this;
        let url = val.path;   // 路径
        let fullPath = val.fullPath;    // 路径+参数
        let sort = fullPath.split("?sort=")[1];     // 截取参数
        let Query = {
          "category": url,
          "sort": sort
        }
        that.$http.post('queryByCS', Query)
          .then(function (res) {
            // 查询成功
            if(res.status == 200) {
              // console.log(res);
              that.articleList = res.data;
              console.log(that.articleList);
            }
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      // 深度观察监听
      deep: true
    }
  },

  // 初次加载页面
  mounted() {
    let that = this;
    // 获取路由路径
    let url = that.$route.path
    let Query = {
      "category": url
    }
    that.$http.post('queryByCategory', Query)
      .then(function (res) {
        // 查询成功
        if(res.status == 200) {
          // console.log(res.data);
          that.articleList = res.data;
          // console.log(that.articleList);
        }
      })
      .catch(function (error) {
        console.log(error);
      });
  }
}
</script>

<style lang = 'less'>
.content {
  width: 50%;
  margin: 0 auto;
  background-color: #fff;
  margin-top: 0.8rem;
}
</style>