<template>
  <div class="back">
    <!-- 标签 -->
    <nav_Tag :tag_List = "tag_List"></nav_Tag>

    <div class="content">
      <!-- 热门 / 最新 / 榜单 -->
      <nav_Sort></nav_Sort>
    </div>
  </div>
</template>

<script>
import nav_Sort from '@/components/nav_Sort'
import nav_Tag from '@/components/nav_Tag'
export default {
  data() {
    return {
      tag_List: [
        {
          id: 0,
          to: '/all',
          text: '全部'
        },
        {
          id: 1,
          to: '/Java',
          text: 'Java'
        },
        {
          id: 2,
          to: '/C++',
          text: 'C++'
        },
        {
          id: 3,
          to: '/SpringBoot',
          text: 'Spring Boot'
        },
        {
          id: 4,
          to: '/Go',
          text: 'Go'
        },
        {
          id: 5,
          to: '/Python',
          text: 'Python'
        },
        {
          id: 6,
          to: '/Spring',
          text: 'Spring'
        },
        {
          id: 7,
          to: '/MySQL',
          text: 'MySQL'
        },
        {
          id: 8,
          to: '/Redis',
          text: 'Redis'
        },
        {
          id: 9,
          to: '/数据库',
          text: '数据库'
        },
        {
          id: 10,
          to: '/算法',
          text: '算法'
        },
        {
          id: 11,
          to: '/Linux',
          text: 'Linux'
        },
      ]
    }
  },
  components: {
    'nav_Sort': nav_Sort,
    'nav_Tag': nav_Tag
  },
  // 监听路由发生变化
  watch: {
    $route: {
      handler: function(val, oldVal){
        console.log(val);
        
      },
      // 深度观察监听
      deep: true
    }
  },

  // 初次加载页面
  created() {
    console.log(window.location.href);    // 完整url
    console.log(this.$route.path);        // 路由路径
    console.log(this.$route.params);      // 路由路径参数
    console.log(this.$route.query);       // 路由查询参数
  }
}
</script>

<style lang = 'less' scoped>
.back {
  width: 65%;
  margin: 0 auto;
}
.content {
  width: 80%;
  background-color: #fff;
  margin-top: 1rem;
}
</style>